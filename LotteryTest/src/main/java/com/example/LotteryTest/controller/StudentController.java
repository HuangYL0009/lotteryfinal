package com.example.LotteryTest.controller;

import com.example.LotteryTest.entity.Student;
import com.example.LotteryTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/add")
    public String add(@RequestParam("sno") String sno,
                      @RequestParam("name") String name,
                      @RequestParam("sex") String sex){
        if (StringUtils.isEmpty(sno)) return "学号不能为空";
        if (StringUtils.isEmpty(name)) return "姓名不能为空";
        if (StringUtils.isEmpty(sex)) return "性别不能为空";
        Student student=new Student(sno, name, sex);
        String res=studentService.addstu(student.getSno(),student.getName(),student.getSex());
        if (res.equals("添加成功")) return "添加成功";
        else return res;
    }

    @RequestMapping(value = "/")
    public String lottery(){
        try {
            Student luckydog = studentService.lottery();
            return "本次的幸运儿是:"+luckydog.getSno()+luckydog.getName();
        }catch (Exception e){
            return "Error!"+e.getStackTrace();
        }
    }

    @RequestMapping(value = "/import")
    public String excelImport(@RequestParam("Path") String Path){
        String res = studentService.excelImport(Path);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = {"/queryAllUser"})
    public List<Map<String,Object>> queryAllStudents(){
        return studentService.queryAllStudents();
    }

}
