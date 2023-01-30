package org.zzzzzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zzzzzz.service.AbsentService;

@Controller
@RequestMapping("/absent")
public class AbsentController {

    @Autowired
    private AbsentService absentService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("absentrecord");
        modelAndView.addObject("list", this.absentService.list());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("absentrecord");
        modelAndView.addObject("list", this.absentService.search(key, value));
        return modelAndView;
    }

}
