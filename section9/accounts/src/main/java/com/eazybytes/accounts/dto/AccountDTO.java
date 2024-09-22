package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountDTO {

    @Schema(
            description = "Account Number of NavyT account", example = "3454433243"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    @NotEmpty(message = "Account Number cannot be null or empty")
    private Long accountNumber;

    @Schema(
            description = "Account type of NavyT account", example = "Savings"
    )
    @NotEmpty(message = "Account Type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "NavyT branch address", example = "123 NewYork"
    )
    @NotEmpty(message = "BranchAddress cannot be null or empty")
    private String branchAddress;
}
