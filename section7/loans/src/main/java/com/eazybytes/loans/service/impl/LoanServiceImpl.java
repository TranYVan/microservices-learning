package com.eazybytes.loans.service.impl;

import com.eazybytes.loans.constant.LoanConstants;
import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.entity.Loan;
import com.eazybytes.loans.exception.LoanAlreadyExistedException;
import com.eazybytes.loans.exception.ResourceNotFoundException;
import com.eazybytes.loans.mapper.LoanMapper;
import com.eazybytes.loans.repository.ILoanRepository;
import com.eazybytes.loans.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {
    private ILoanRepository iLoanRepository;


    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> optionalLoan = iLoanRepository.findByMobileNumber(mobileNumber);
        if (optionalLoan.isPresent()) {
            throw new LoanAlreadyExistedException("Loan already registered with given mobile number "+ mobileNumber);
        }
        iLoanRepository.save(createNewLoan(mobileNumber));
    }
    private Loan createNewLoan(String mobileNumber) {
        Loan newLoan = new Loan();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }
    @Override
    public LoanDto fetchLoan(String mobileNumber) {
        System.out.println(mobileNumber);
        Loan loan = iLoanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "loanId", mobileNumber)
        );
        return LoanMapper.mapToLoanDto(loan, new LoanDto());
    }

    @Override
    public boolean updateLoan(LoanDto loanDto) {
        Loan loan = iLoanRepository.findByLoanNumber(loanDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "loanNumber", loanDto.getLoanNumber())
        );
        loan = LoanMapper.mapToLoan(loanDto, loan);
        System.out.println(loan);
        iLoanRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loan loan = iLoanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "loanId", mobileNumber)
        );
        iLoanRepository.deleteById(loan.getLoanId());
        return true;
    }
}
