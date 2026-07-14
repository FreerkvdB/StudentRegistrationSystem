package com.student.dao;

import com.student.model.Enrollment;
import com.student.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnrollmentDAO {
    
    public boolean addEnrollment(Enrollment enrollment){
        System.out.println("Inside addEnrollment DAO");
        
        String sql = "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";
        
        try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            
            System.out.println("Database connection: " + con);
            
           ps.setInt(1, enrollment.getStudentId());
           ps.setInt(2, enrollment.getCourseId());

            int rows = ps.executeUpdate();
            
            System.out.println("Rows inserted: " + rows );
            
            return rows > 0;
        }catch(SQLException e){

        e.printStackTrace();
        }
        return false;
    }
    
    public List<Enrollment> getAllEnrollments(){
        
        List<Enrollment> enrollments = new ArrayList<>();
        
        String sql = "SELECT e.enrollment_id, s.student_number, c.course_name " +
                     "FROM enrollments e " +
                     "JOIN students s ON e.student_id = s.student_id " +
                     "JOIN courses c ON e.course_id = c.course_id " +
                     "ORDER BY e.enrollment_id";
        
           try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
               
               while(rs.next()){
                   
                   Enrollment e = new Enrollment();
                   
                   e.setEnrollmentId(
                           rs.getInt("enrollment_id")
                   );
                  
                   e.setStudentNumber(
                           rs.getString("student_number")
                  );
                  
                   e.setCourseName(
                           rs.getString("course_name")
                   );
                  
                   enrollments.add(e);
                   
               }
           }catch(SQLException e){

            e.printStackTrace();

        }


        return enrollments;
    }
}
