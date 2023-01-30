package org.zzzzzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zzzzzz.entity.Moveout;
import org.zzzzzz.service.MoveoutService;
import org.zzzzzz.service.StudentService;

@Controller
@RequestMapping("/moveout")
public class MoveoutController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MoveoutService moveoutService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list", this.studentService.moveoutList());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list", this.studentService.searchForMoveoutList(key, value));
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(Moveout moveout) {
        this.studentService.moveout(moveout);
        return "redirect:/moveout/list";
    }

    @GetMapping("/record")
    public ModelAndView recored() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        modelAndView.addObject("list", this.moveoutService.list());
        return modelAndView;
    }

    @PostMapping("/recordSearch")
    public ModelAndView recoredSearch(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        modelAndView.addObject("list", this.moveoutService.search(key, value));
        return modelAndView;
    }

}
