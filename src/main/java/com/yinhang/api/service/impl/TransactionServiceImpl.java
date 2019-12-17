package com.yinhang.api.service.impl;

import com.yinhang.api.entity.Card;
import com.yinhang.api.entity.Transaction;
import com.yinhang.api.entity.TransactionExample;
import com.yinhang.api.mapper.TransactionMapper;
import com.yinhang.api.service.CardService;
import com.yinhang.api.service.TranactionService;
import com.yinhang.api.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 23:26
 */
@Service
public class TransactionServiceImpl implements TranactionService {
    //存款
    public static final int TRANSACTION_DEPOSIT = 0;

    //取款
    public static final int TRANSACTION_WITHDRAW = 1;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private CardService cardService;

    @Override
    public Transaction createTransaction(String username, String cardNumber, double amount, int type) {
        String id = RandomUtils.string("transaction-id","this is transaction id");
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setUsername(username);
        transaction.setCardNumber(cardNumber);
        transaction.setAmount(new BigDecimal(amount));
        transaction.setType(type);
        transaction.setCreateTime(new Date());
        transactionMapper.insertSelective(transaction);

        //修改银行卡
        Card card = cardService.getCard(cardNumber);
        if(type == TRANSACTION_DEPOSIT)
            card.setCardBalance(card.getCardBalance().add(new BigDecimal(amount)));
        else if(type == TRANSACTION_WITHDRAW)
            card.setCardBalance(card.getCardBalance().subtract(new BigDecimal(amount)));
        cardService.updateCard(card);
        return transactionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List getTransaction(String username) {
        TransactionExample example = new TransactionExample();
        TransactionExample.Criteria  criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);
        List<Transaction> transactions = transactionMapper.selectByExample(example);
        return transactions.size() > 0 ? transactions : null;
    }

    @Override
    public Transaction getTransactionById(String id) {

        return transactionMapper.selectByPrimaryKey(id);
    }
}
