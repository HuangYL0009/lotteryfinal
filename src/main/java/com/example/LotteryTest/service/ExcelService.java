package com.example.LotteryTest.service;


import com.example.LotteryTest.entity.Student;
import com.example.LotteryTest.utils.DbUtil;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ExcelService {
	 
     //查询student表中所有的数据
    public static List<Student> getAllByDb(){
        List<Student> list=new ArrayList<Student>();
        try {
            DbUtil db=new DbUtil();
            String sql="select * from studentdata";
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String sno=rs.getString("sno");
                String sex=rs.getString("sex");
                list.add(new Student(id, name, sno,sex));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    //查询指定目录中电子表格中所有的数据
     
    public static List<Student> getAllByExcel(String file){
        List<Student> list=new ArrayList<Student>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Sheet1");
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                	
                    // 第一个是列数j，第二个是行数i
                    // String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String id = "0";
                    String name=rs.getCell(j++, i).getContents();
                    String sno=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    
                    
                    System.out.println("id:"+id+" name:"+name+" sno:"+sno+" sex:"+sex);
                    list.add(new Student(Integer.parseInt(id), name, sno, sex));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * 通过Id判断是否存在
     * @param id
     * @return
     */
    public static boolean isExist(int id){
        try {
            DbUtil db=new DbUtil();
            ResultSet rs=db.Search("select * from studentdata where id=?", new String[]{id+""});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    /*public static void main(String[] args) {
        List<Student> all=getAllByDb();
        for (Student stu: all) {
            System.out.println(stu.toString());
        }
        
        System.out.println(isExist(1));
        
    }*/
    
}
