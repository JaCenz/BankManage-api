package com.yinhang.api.controller;

import com.yinhang.api.core.Result;
import com.yinhang.api.core.ResultGenerator;
import com.yinhang.api.entity.Card;
import com.yinhang.api.entity.User;
import com.yinhang.api.service.CardService;
import com.yinhang.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 23:40
 */
@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private UserService userService;

    @PostMapping("")
    public Result createCard(@RequestParam(value = "number")String number,@RequestParam(value = "password")String password,
                             @RequestParam(value = "username")String username){
        Card card = cardService.createCard(number,password,username);
        return ResultGenerator.success(card,"success");
    }

    /**
     * 获得某用户所有的银行卡
     */
    @GetMapping("/all")
    public Result getAllCard(@RequestParam(value = "username")String username){
        User user = userService.getUserByUsername(username);
        if(user == null)
            return ResultGenerator.fail("无用户");
        List<Card> cardList = cardService.getAllCard(username);
        return ResultGenerator.success(cardList,"success");
    }

    @GetMapping("")
    public Result getCard(@RequestParam(value = "number")String number){
        Card card = cardService.getCard(number);
        if (card == null)
            return ResultGenerator.fail("无卡");
        else
            return ResultGenerator.success(card,"success");
    }

    /**
     * 存储过程
     */
    @GetMapping("/procedure")
    public Result procedureMethod(@RequestParam(value = "username")String username){
        String data = cardService.getCardNumberByUsername(username);
        return ResultGenerator.success(data);
    }
}
