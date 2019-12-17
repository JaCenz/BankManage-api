package com.yinhang.api.controller;

import com.yinhang.api.core.Result;
import com.yinhang.api.core.ResultGenerator;
import com.yinhang.api.service.impl.LogTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JaCen
 *
 * @date 2019/12/17 12:14
 */
@RestController
@RequestMapping("log")
public class LogTableController {

    @Autowired
    private LogTableService logTableService;

    /**
     * 获取所有记录
     */
    @GetMapping("")
    public Result getAllLog(){
        return ResultGenerator.success(logTableService.getAllLogTable(),"success");
    }
}
