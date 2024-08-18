package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.entity.Loan;

public interface ILoanService {
    public void createLoan(String mobileNumber);
    public LoanDto fetchLoan(String mobileNumber);
    public boolean updateLoan(LoanDto loanDto);
    public boolean deleteLoan(String mobileNumber);
}
