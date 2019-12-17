package com.yinhang.api.service;

import com.yinhang.api.entity.Card;

import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 22:51
 */
public interface CardService {
    Card createCard(String number, String password, String Username);

    List getAllCard(String username);

    Card getCard(String number);

    boolean deleteCard(String number);

    Card updateCard(Card card);
}
