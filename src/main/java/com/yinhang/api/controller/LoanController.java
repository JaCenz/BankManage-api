package com.yinhang.api.controller;

import com.yinhang.api.core.Result;
import com.yinhang.api.core.ResultGenerator;
import com.yinhang.api.entity.Loan;
import com.yinhang.api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JaCen
 *
 * @date 2019/12/15 23:55
 */
@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    /**
     * 根据username,cardNumber获取贷款信息
     */
    @GetMapping("/all")
    public Result getAllLoans(@RequestParam(value = "username")String username,@RequestParam(value = "cardNumber")String cardNumber){
        List<Loan> loanList = loanService.getLoan(username,cardNumber);
        if(loanList == null)
            return ResultGenerator.fail("该用户无贷款");
        return ResultGenerator.success(loanList,"success");
    }

    @GetMapping("")
    public Result getLoan(@RequestParam(value = "id")String id){
        Loan loan = loanService.getLoanById(id);
        if(loan == null)
            return ResultGenerator.fail("查询不到贷款");
        return ResultGenerator.success(loan,"success");
    }

    @PostMapping("")
    public Result createLoan(@RequestParam(value = "username")String username,
                             @RequestParam(value = "cardNumber")String cardNumber,@RequestParam(value = "amount")double amount){
        Loan loan = loanService.createLoan(username,cardNumber,amount);
        if(loan == null)
            return ResultGenerator.fail("创建失败");
        return ResultGenerator.success(loan,"success");
    }

}
