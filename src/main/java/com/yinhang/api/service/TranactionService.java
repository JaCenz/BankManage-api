package com.yinhang.api.service;

import com.yinhang.api.entity.Transaction;

import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 23:03
 */
public interface TranactionService {

    Transaction createTransaction(String username, String cardNumber, double amount, int type);

    List getTransaction(String username);

    Transaction getTransactionById(String id);
}
