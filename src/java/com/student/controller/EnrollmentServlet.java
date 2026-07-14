package com.student.controller;

import com.student.dao.EnrollmentDAO;
import com.student.dao.StudentDAO;
import com.student.dao.CourseDAO;
import com.student.model.Enrollment;
import com.student.model.Course;
import com.student.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/EnrollmentServlet")
public class EnrollmentServlet extends HttpServlet {

    private EnrollmentDAO enrollmentDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    
    @Override
    public void init(){
        enrollmentDAO = new EnrollmentDAO();
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        List<Student> students = studentDAO.getAllStudents();
        List<Course> courses = courseDAO.getAllCourses();
        List<Enrollment> enrollments = enrollmentDAO.getAllEnrollments();
        
        request.setAttribute("students", students);
        request.setAttribute("courses", courses);
        request.setAttribute("enrollments", enrollments);
        
        request.getRequestDispatcher("enrollment.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        
        Enrollment enrollment = new Enrollment();
        
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);
        
        enrollmentDAO.addEnrollment(enrollment);
        response.sendRedirect("EnrollmentServlet");
    }
}
