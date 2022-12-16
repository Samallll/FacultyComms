package com.example.facultycomms;

public class Staff {

    private String staff_name;
    private String email_id;
    private int staff_id;
    private String mobile;
    private String degree;
    private String user_name;
    private String password;

    //Constructors

    public Staff(String staff_name, String email_id, String mobile, String degree, String user_name, String password, int staff_id) {
        this.staff_name = staff_name;
        this.email_id = email_id;
        this.mobile = mobile;
        this.degree = degree;
        this.user_name = user_name;
        this.password = password;
        this.staff_id = staff_id;
    }

    public Staff(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    //Getters and Setters

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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
}
