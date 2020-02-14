package com.example.LotteryTest.dao;

import com.example.LotteryTest.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface StudentDao {
    void add(@Param("sno") String sno,@Param("name") String name,@Param("sex") String sex);
    List<Map<String,Object>> queryAllStudents();
    Student lottery(int num);
}
