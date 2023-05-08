package com.example.firebasetask;

public class Users {

    String name,dept,reg_No,cGPA,email;

    public Users() {
    }

    public Users(String name, String dept,String reg_No, String cGPA, String email) {
        this.name = name;
        this.dept = dept;
        this.reg_No = reg_No;
        this.cGPA = cGPA;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setReg_No(String reg_No) {
        this.reg_No = reg_No;
    }

    public void setcGPA(String cGPA) {
        this.cGPA = cGPA;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }


    public String getReg_No() {
        return reg_No;
    }

    public String getcGPA() {
        return cGPA;
    }

    public String getEmail() {
        return email;
    }
}
