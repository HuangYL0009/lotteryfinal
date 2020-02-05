package com.example.LotteryTest.entity;

public class Student {
    private int id;
    private String sno;
    private String name;
    private String sex;
    public Student(){ super();}
    public Student(int id,String sno,String name,String sex){
        super();
        this.id=id;
        this.sno=sno;
        this.name=name;
        this.sex=sex;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getSno() {
        return sno;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    @Override
    public String toString(){
        return "Student [id=" + id + ", name=" + name + ", sno=" + sno + "sex:"+ sex + "]";
    }

}
