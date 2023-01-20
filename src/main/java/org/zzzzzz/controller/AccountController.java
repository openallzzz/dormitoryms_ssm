package org.zzzzzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zzzzzz.dto.AccountDto;
import org.zzzzzz.form.AccountForm;
import org.zzzzzz.service.AccountService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ModelAndView login(AccountForm accountForm, HttpSession session) {
        AccountDto accountDto = accountService.login(accountForm);
        ModelAndView modelAndView = new ModelAndView();
        switch (accountDto.getCode()) {
            case -1 :
                modelAndView.setViewName("login");
                modelAndView.addObject("usernameError", "用户名不存在");
                break;
            case -2 :
                modelAndView.setViewName("login");
                modelAndView.addObject("passwordError", "密码错误");
                break;
            case 0 :
                modelAndView.setViewName("systemadmin");
                session.setAttribute("systemAdmin", accountDto.getAdmin());
                break;
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

}
