package com.yinhang.api.service.impl;

import com.yinhang.api.entity.Loan;
import com.yinhang.api.entity.LoanExample;
import com.yinhang.api.mapper.LoanMapper;
import com.yinhang.api.service.CardService;
import com.yinhang.api.service.LoanService;
import com.yinhang.api.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 23:22
 */
@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanMapper loanMapper;

    @Override
    public Loan createLoan(String username, String cardNumber, double amount) {
        String id = RandomUtils.string("loan-id","this is loan id");
        Loan loan = new Loan();
        loan.setId(id);
        loan.setAmount(new BigDecimal(amount));
        loan.setUsername(username);
        loan.setCardNumber(cardNumber);
        loan.setCreateTime(new Date());
        loanMapper.insertSelective(loan);
        return loanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List getLoan(String username, String cardNumber) {
        LoanExample example = new LoanExample();
        LoanExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andCardNumberEqualTo(cardNumber);

        List<Loan> loans = loanMapper.selectByExample(example);

        return loans.size() > 0 ? loans : null;
    }

    @Override
    public Loan getLoanById(String id) {
        LoanExample example = new LoanExample();
        LoanExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);

        List<Loan> loans = loanMapper.selectByExample(example);

        return loans.size() > 0 ? loans.get(0) : null;
    }
}
