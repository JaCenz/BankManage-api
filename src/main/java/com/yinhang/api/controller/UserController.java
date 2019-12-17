package com.yinhang.api.controller;

import com.yinhang.api.core.Result;
import com.yinhang.api.core.ResultGenerator;
import com.yinhang.api.entity.Card;
import com.yinhang.api.entity.User;
import com.yinhang.api.service.CardService;
import com.yinhang.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 23:32
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CardService cardService;

    @GetMapping("/login")
    public Result loginMethod(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password){
        User user = userService.getUserByUsernameAndPassword(username,password);
        if(user == null)
            return ResultGenerator.fail("用户名或密码错误");
        List<Card> cardList = cardService.getAllCard(username);
        if(cardList == null){
            return ResultGenerator.fail("无信用卡");
        }else
            return ResultGenerator.success(cardList,"success");
    }

}
