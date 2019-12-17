package com.yinhang.api.service;

import com.yinhang.api.entity.Loan;

import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 22:54
 */
public interface LoanService {

    Loan createLoan(String username,String cardNumber,double amount);

    List getLoan(String username, String cardNumber);

    Loan getLoanById(String id);
}
