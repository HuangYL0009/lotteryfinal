package com.example.LotteryTest.controller;

import com.example.LotteryTest.entity.Student;
import com.example.LotteryTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    /*
    @RequestMapping(value = "/add")
    public String add(@RequestParam("sno") String sno,
                      @RequestParam("name") String name,
                      @RequestParam("tele") String tele){
        if (StringUtils.isEmpty(sno)) return "学号不能为空";
        if (StringUtils.isEmpty(name)) return "姓名不能为空";
        if (StringUtils.isEmpty(tele)) return "手机号不能为空";
        Student student=new Student(sno, name, tele);
        String res=studentService.addstu(student.getSno(),student.getName(),student.getTele());
        if (res.equals("添加成功")) return "添加成功";
        else return res;

    }*/
    @ResponseBody
    @RequestMapping(value = "/")
    public String lottery(Model model){
        try {
            Student luckydog = studentService.lottery();
            //return luckydog;
            model.addAttribute("text" , luckydog);
            return "本次抽奖的幸运儿是:学号为"+luckydog.getSno()+"的"+luckydog.getName()+"同学！";
        }catch (Exception e){
            /*System.err.println("error!");
            e.printStackTrace();
            return null;*/
            return "Error!"+e.getStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/queryAllUser"})
    public List<Map<String,Object>> queryAllStudents(){
        return studentService.queryAllStudents();
    }

}
