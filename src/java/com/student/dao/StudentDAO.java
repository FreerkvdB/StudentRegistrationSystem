package com.student.dao;


import com.student.model.Student;
import com.student.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class StudentDAO {



  public boolean addStudent(Student student){

    System.out.println("Inside addStudent DAO");

    String sql =
    "INSERT INTO students(first_name,last_name,email,phone) VALUES (?,?,?,?)";


    try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {


        System.out.println("Database connection: " + con);

        ps.setString(1, student.getFirstName());
        ps.setString(2, student.getLastName());
        ps.setString(3, student.getEmail());
        ps.setString(4, student.getPhone());


        int rows = ps.executeUpdate();

        System.out.println("Rows inserted: " + rows);

        return rows > 0;


    } catch(SQLException e){

        e.printStackTrace();

    }

    return false;
}




    public List<Student> getAllStudents(){


        List<Student> students = new ArrayList<>();


        String sql =
        "SELECT * FROM students ORDER BY student_id";


        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){


            while(rs.next()){


                Student s = new Student();


                s.setStudentId(
                    rs.getInt("student_id")
                );
                
                s.setStudentNumber(
                        rs.getString("student_number")
                );


                s.setFirstName(
                    rs.getString("first_name")
                );


                s.setLastName(
                    rs.getString("last_name")
                );


                s.setEmail(
                    rs.getString("email")
                );
                students.add(s);

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return students;

    }


}