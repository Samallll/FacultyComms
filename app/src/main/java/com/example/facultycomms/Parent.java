package com.example.facultycomms;

public class Parent {

    private String student_name;
    private int roll_number;
    private String email_id;
    private String mobile;
    private String degree;
    private String parent_name;
    private String user_name;
    private String password;

    /* Constructors */

    public Parent(String student_name, String email_id, String mobile, String degree, String parent_name, String user_name, String password, int roll_number) {
        this.student_name = student_name;
        this.email_id = email_id;
        this.mobile = mobile;
        this.degree = degree;
        this.parent_name = parent_name;
        this.user_name = user_name;
        this.password = password;
        this.roll_number=roll_number;
    }

    public Parent(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    //Getters and Setters

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoll_number() {
        return roll_number;
    }

    public void getRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

}
