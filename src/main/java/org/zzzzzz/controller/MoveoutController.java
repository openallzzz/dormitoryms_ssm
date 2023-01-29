package org.zzzzzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zzzzzz.service.StudentService;

@Controller
@RequestMapping("/moveout")
public class MoveoutController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list", this.studentService.moveoutList());
        return modelAndView;
    }

}
