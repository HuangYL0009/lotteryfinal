package com.example.LotteryTest.entity;

public class Student {
    private String sno;
    private String name;
    private String sex;
    public Student(){
        super();
    }
    public Student(String sno,String name,String sex){
        this.sno = sno;
        this.name = name;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSno() {
        return sno;
    }

    public String getSex() {
        return sex;
    }
}
