package com.codingshuttle.cachingApp.services;

import com.codingshuttle.cachingApp.entities.Employee;
import com.codingshuttle.cachingApp.entities.SalaryAccount;

public interface SalaryAccountService {
    void createAccount(Employee employee);

    SalaryAccount incrementBalance(Long accountId);
}
