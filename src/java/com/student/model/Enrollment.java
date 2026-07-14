package com.student.model;


public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private String studentNumber;
    private String courseName;


    
    public Enrollment(){
        
    }
    
    public Enrollment(int enrollmentId, String studentNumber, String courseName){
        this.enrollmentId = enrollmentId;
        this.studentNumber = studentNumber;
        this.courseName = courseName;
    }
    
    public int getEnrollmentId(){
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId){
        this.enrollmentId = enrollmentId;
    }
    
     public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    
    public String getStudentNumber() {
    return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
    this.studentNumber = studentNumber;
    }

    public String getCourseName() {
    return courseName;
    }

    public void setCourseName(String courseName) {
    this.courseName = courseName;
    }
}
