package com.eazybytes.accounts.services.client;

import com.eazybytes.accounts.dto.LoanDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient {
    @Override
    public ResponseEntity<LoanDto> fetchLoanDetail(String correlationId, String mobileNumber) {
        return null;
    }
}
