package com.student.model;

public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private int credits;
    
    //empty constructor
    public Course(){
    }
    
    //Paramiterised constructer
    public Course(String courseCode, String courseName, int credits){
        
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }
    
    //constructer with ID
    public Course(int courseId, String courseCode, String courseName, int credits){
        
        this.courseId = courseId;
         this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }
    
    public int getCourseId(){
        return courseId;
    }
    
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    
        public String getCourseCode(){
        return courseCode;
    }

    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }


    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }


    public int getCredit(){
        return credits;
    }

    public void setCredit(int credit){
        this.credits = credit;
    }
}
