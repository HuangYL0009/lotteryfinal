package com.example.LotteryTest.controller;

import com.example.LotteryTest.entity.Student;
import com.example.LotteryTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/hello"})
public class HelloController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = {"/springboot"})
    public String Success(Model model){
        try {
            Student luckydog = studentService.lottery();
            //return luckydog;
            model.addAttribute("msg","本次的幸运儿是:"+luckydog.getSno()+luckydog.getName());
            return "本次的幸运儿是:"+luckydog.getSno()+luckydog.getName();
        }catch (Exception e){
            /*System.err.println("error!");
            e.printStackTrace();
            return null;*/
            return "Error!"+e.getStackTrace();
        }
    }
}
