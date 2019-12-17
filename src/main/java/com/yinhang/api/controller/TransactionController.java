package com.yinhang.api.controller;

import com.yinhang.api.core.Result;
import com.yinhang.api.core.ResultGenerator;
import com.yinhang.api.entity.Card;
import com.yinhang.api.entity.Transaction;
import com.yinhang.api.service.CardService;
import com.yinhang.api.service.TranactionService;
import com.yinhang.api.vo.TransactionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/16 19:54
 */
@RestController
@RequestMapping("transaction")
public class TransactionController {

    //存款
    public static final int TRANSACTION_DEPOSIT = 0;

    //取款
    public static final int TRANSACTION_WITHDRAW = 1;

    @Autowired
    private TranactionService transactionService;

    @Autowired
    private CardService cardService;

    @PostMapping("")
    public Result createTransaction(@RequestParam(value = "username")String username,@RequestParam(value = "cardNumber")String cardNumber,
                                    @RequestParam(value = "amount")double amount,@RequestParam(value = "type")int type){
        Transaction transaction = transactionService.createTransaction(username, cardNumber, amount, type);
        if(transaction == null)
            return ResultGenerator.fail("创建失败");
        Card card = cardService.getCard(cardNumber);
        if(card == null)
            return ResultGenerator.success(transaction,"success");
        else {
            TransactionVO transactionVO = TransactionVO.fromCardTransactionToThis(card,transaction);
            return ResultGenerator.success(transactionVO,"success");
        }
    }

    @GetMapping("/all")
    public Result getAllTs(@RequestParam(value = "username")String username){
        List<Transaction> transactions = transactionService.getTransaction(username);
        if(transactions == null)
            return ResultGenerator.fail("无存取款历史操作");

        List<TransactionVO> transactionVOS = new ArrayList<>();
        TransactionVO transactionVO;
        for(Transaction transaction : transactions){
            Card card = cardService.getCard(transaction.getCardNumber());
            transactionVO = TransactionVO.fromCardTransactionToThis(card,transaction);
            transactionVOS.add(transactionVO);
        }
        return ResultGenerator.success(transactionVOS,"success");
    }

    @GetMapping("")
    public Result getT(@RequestParam(value = "id")String id){
        Transaction transaction = transactionService.getTransactionById(id);
        if(transaction == null)
            return ResultGenerator.fail("无该记录");
        return ResultGenerator.success(transaction,"success");
    }
}
