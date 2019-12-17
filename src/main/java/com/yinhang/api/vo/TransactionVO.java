package com.yinhang.api.vo;

import com.yinhang.api.entity.Card;
import com.yinhang.api.entity.Transaction;
import com.yinhang.api.util.DateUtils;

/**
 * Created by JaCen
 *
 * @date 2019/12/16 21:40
 */
public class TransactionVO {
    private String transactionId;

    private String username;

    private String cardNumber;

    private double amount;

    private String type;

    private String createDate;

    private double cardBalance;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public static TransactionVO fromCardTransactionToThis(Card card, Transaction transaction){
        if(card == null || transaction == null)
            return null;
        TransactionVO transactionVO = new TransactionVO();
        transactionVO.setTransactionId(transaction.getId());
        transactionVO.setUsername(transaction.getUsername());
        transactionVO.setCardNumber(transaction.getCardNumber());
        transactionVO.setAmount(transaction.getAmount().doubleValue());
        transactionVO.setCreateDate(DateUtils.formatDate(transaction.getCreateTime()));
        transactionVO.setCardBalance(card.getCardBalance().doubleValue());
        if(transaction.getType() == 0)
            transactionVO.setType("存款");
        else if(transaction.getType() == 1)
            transactionVO.setType("取款");

        return transactionVO;
    }
}
