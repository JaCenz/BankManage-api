package com.yinhang.api.service.impl;

import com.yinhang.api.entity.Card;
import com.yinhang.api.entity.CardExample;
import com.yinhang.api.mapper.CardMapper;
import com.yinhang.api.mapper.UserPMapper;
import com.yinhang.api.service.CardService;
import com.yinhang.api.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 23:05
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private UserPMapper userPMapper;

    @Override
    public Card createCard(String number, String password, String Username) {
        Card card = new Card();
        String id = RandomUtils.string("card-id","this is card id");
        card.setId(id);
        card.setCardNumber(number);
        card.setPassword(password);
        card.setUsername(Username);
        card.setCardBalance(new BigDecimal(0));
        cardMapper.insertSelective(card);

        return cardMapper.selectByPrimaryKey(id);
    }

    @Override
    public List getAllCard(String username) {
        CardExample example = new CardExample();
        CardExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Card> cards = cardMapper.selectByExample(example);
        return cards.size() > 0 ? cards : null;
    }

    @Override
    public Card getCard(String number) {
        CardExample example = new CardExample();
        CardExample.Criteria criteria = example.createCriteria();
        criteria.andCardNumberEqualTo(number);
        List<Card> cards = cardMapper.selectByExample(example);
        return cards.size() > 0 ? cards.get(0) : null;
    }

    @Override
    public boolean deleteCard(String number) {
        Card card = getCard(number);
        if(card == null)
            return false;
        CardExample example = new CardExample();
        CardExample.Criteria criteria = example.createCriteria();
        criteria.andCardNumberEqualTo(number);
        cardMapper.deleteByExample(example);
        return true;
    }

    @Override
    public Card updateCard(Card card) {
        CardExample example = new CardExample();
        CardExample.Criteria criteria = example.createCriteria();

        criteria.andCardNumberEqualTo(card.getCardNumber());
        cardMapper.updateByExampleSelective(card,example);
        return getCard(card.getCardNumber());
    }

    @Override
    public String getCardNumberByUsername(String username) {
        Map<String,String> data = new HashMap<>();
        data.put("username",username);
        userPMapper.getCardByUsername(data);
        return data.get("cardNumber");
    }
}
