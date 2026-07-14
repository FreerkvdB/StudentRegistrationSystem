package com.student.dao;

import com.student.model.Course;
import com.student.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    
    public boolean addCourse(Course course){
        System.out.println("Inside addCourse DAO");
        
        String sql = "INSERT INTO courses(course_code, course_name, credits) VALUES (?,?,?) ";
        
        try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            System.out.println("Database connection: " + con);
            
            ps.setString(1, course.getCourseCode());
            ps.setString(2, course.getCourseName());
            ps.setInt(3, course.getCredit());
            
            int rows = ps.executeUpdate();
            
            System.out.println("Rows inserted: " + rows);
            
            return rows > 0;
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public List<Course> getAllCourses(){
        
        List<Course> courses = new ArrayList<>();
        
        String sql = "SELECT * FROM courses ORDER BY course_id";
        
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                Course c = new Course();
                
               c.setCourseId(
                    rs.getInt("course_id")
                );


                c.setCourseCode(
                    rs.getString("course_code")
                );


                c.setCourseName(
                    rs.getString("course_name")
                );


                c.setCredit(
                    rs.getInt("credits")
                );
                
                courses.add(c);
            }
        }catch(SQLException e){

            e.printStackTrace();

        }
        
        return courses;
    }
}
