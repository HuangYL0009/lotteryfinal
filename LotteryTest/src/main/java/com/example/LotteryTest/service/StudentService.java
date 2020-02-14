package com.example.LotteryTest.service;


import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.example.LotteryTest.dao.StudentDao;
import com.example.LotteryTest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    public String addstu(String sno,String name,String sex){
        try {
            studentDao.add(sno,name,sex);
        }catch (Exception e){
            return "添加失败!"+e.getStackTrace();
        }
        return "添加成功";
    }

    public String excelImport(String path){
        List<Student> sheetDatas = EasyExcel.read(path)
                .head(Student.class)
                .sheet(0)
                .doReadSync();
        int count = 0;
        try{
            for (Student student: sheetDatas
            ) {
                //System.out.println(JSON.toJSONString(student));
                addstu(student.getSno(),student.getName(),student.getSex());
                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "导入失败";
        }
        return count+"项数据导入成功";

    }

    public Student lottery(){
        int size=queryAllStudents().size();
        SecureRandom sr=new SecureRandom();
        //Random r=new Random();
        int num = sr.nextInt(size)+1;
        return studentDao.lottery(num);
    }
    public List<Map<String,Object>> queryAllStudents(){
        return studentDao.queryAllStudents();
    }

}
