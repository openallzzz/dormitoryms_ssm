package org.zzzzzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zzzzzz.entity.Building;
import org.zzzzzz.entity.Dormitory;
import org.zzzzzz.entity.Student;
import org.zzzzzz.service.AbsentService;
import org.zzzzzz.service.BuildingService;
import org.zzzzzz.service.DormitoryService;
import org.zzzzzz.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/absent")
public class AbsentController {

    @Autowired
    private AbsentService absentService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private DormitoryService dormitoryService;

    @Autowired
    private StudentService studentService;

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

    @GetMapping("/init")
    public ModelAndView init() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("absentregister");
        List<Building> buildingList = this.buildingService.list();
        modelAndView.addObject("buildingList", buildingList);
        List<Dormitory> dormitoryList = this.dormitoryService.findByBuildingId(buildingList.get(0).getId());
        modelAndView.addObject("dormitoryList", dormitoryList);
        List<Student> studentList = this.studentService.findByDormitory(dormitoryList.get(0).getId());
        modelAndView.addObject("studentList", studentList);
        return modelAndView;
    }

}
