package com.example.LotteryTest.excel;


import com.example.LotteryTest.entity.Student;
import com.example.LotteryTest.service.ExcelService;
import com.example.LotteryTest.utils.DbUtil;

import java.util.List;


/** 
 * Description: 导入Excel表
 * @author @zhangyuge
 * date 2020年2月2日
 * @version 1.0 
 */
public class ExcelImport {
    public static void main(String[] args) {//C:\\Users\\14056\\Desktop\\cs杂货铺\\彩票系统\\Student3.xls
        //得到表格中所有的数据
        List<Student> listExcel= ExcelService.getAllByExcel("C:\\Users\\14056\\Desktop\\cs杂货铺\\彩票系统\\Student3.xls");
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllByDb();*/
        
        DbUtil db=new DbUtil();
        
        for (Student list : listExcel) {
            int id=list.getId();
            System.out.println("id"+id);
            if (!ExcelService.isExist(id)) {
                //不存在就添加
                String sql="insert into studentdata (name,sno,sex) values(?,?,?)";
                String[] str=new String[]{list.getName(),list.getSno(),list.getSex()+""};
                db.AddU(sql, str);
            }else {
                //存在就更新
                String sql="update studentdata set name=?,sno=?,sex=? where id=?";
                String[] str=new String[]{list.getName(),list.getSno(),list.getSex()};
                db.AddU(sql, str);
            }
            System.out.println("数据导入成功");
        }
    }
}
