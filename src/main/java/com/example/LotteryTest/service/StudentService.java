package com.example.LotteryTest.service;


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
