package com.eazybytes.accounts.services;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface IAccountService {

    /**
     *
     * @param customerDTO - CustomerDTO object
     * @return the new account details
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobileNumber
     * @return account details based on a given mobile number
     */
    CustomerDTO fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDTO
     * @return boolean indicating if the update of account details is successful or not
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobileNumber
     * @return boolean indicating if the delete of account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
