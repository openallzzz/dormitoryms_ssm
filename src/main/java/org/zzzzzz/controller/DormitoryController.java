package org.zzzzzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zzzzzz.entity.Dormitory;
import org.zzzzzz.entity.Student;
import org.zzzzzz.service.BuildingService;
import org.zzzzzz.service.DormitoryService;
import org.zzzzzz.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dormitorymanager");
        modelAndView.addObject("list", this.dormitoryService.list());
        modelAndView.addObject("buildingList", this.buildingService.list());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dormitorymanager");
        modelAndView.addObject("list", this.dormitoryService.search(key, value));
        modelAndView.addObject("buildingList", this.buildingService.list());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Dormitory dormitory) {
        this.dormitoryService.save(dormitory);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/update")
    public String update(Dormitory dormitory) {
        this.dormitoryService.update(dormitory);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/delete")
    public String delete(Integer id) {
        this.dormitoryService.delete(id);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/findByBuildingId")
    @ResponseBody
    public List findByBuildingId(Integer buildingId) {
        List<Dormitory> dormitoryList = this.dormitoryService.findByBuildingId(buildingId);// json数据需要添加依赖
        List list = new ArrayList();
        if(dormitoryList.size() > 0) {
            List<Student> studentList = studentService.findByDormitory(dormitoryList.get(0).getId());
            list.add(dormitoryList);
            if(studentList.size() > 0) {
                list.add(studentList);
            } else {
                list.add(new ArrayList<>());
            }
        } else {
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
        }
        return list;
    }

}
