package com.example.firebasetask;

public class Users {

    String name,dept,reg_No,cGPA,email;

    public Users() {
    }

    public Users(String name, String dept, String cGPA, String email) {
        this.name = name;
        this.dept = dept;
        this.reg_No = reg_No;
        this.cGPA = cGPA;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }



    public String getcGPA() {
        return cGPA;
    }

    public String getEmail() {
        return email;
    }
}
