package com.student.model;


public class Student {

    private int studentId;
    private String studentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    // Empty constructor
    public Student(){

    }


    // Constructor without ID (for inserting)
    public Student(String studentNumber,String firstName, String lastName, String email, String phone){

        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;

    }


    // Constructor with ID (for retrieving from database)
    public Student(int studentId, String studentNumber, String firstName, String lastName, String email, String phone){

        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;

    }


    public String getStudentNumber() {
    return studentNumber;
}

    public void setStudentNumber(String studentNumber) {
    this.studentNumber = studentNumber;
}
    public int getStudentId(){
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }


    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }


    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}