package com.example.LotteryTest.service;


import com.example.LotteryTest.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {
    String addstu(String sno, String name, String sex);
    String excelImport(String path);
    Student lottery();
    List<Map<String,Object>> queryAllStudents();

}
