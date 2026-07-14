package com.student.controller;

import com.student.dao.CourseDAO;
import com.student.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
    
    private CourseDAO courseDAO;
    
    @Override
    public void init(){
        courseDAO = new CourseDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        List<Course> courses = courseDAO.getAllCourses();
        
        request.setAttribute("courses", courses);
        
        request.getRequestDispatcher("course.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        int credits = Integer.parseInt(request.getParameter("credits"));
        
        Course course = new Course();
        
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setCredit(credits);
        
        courseDAO.addCourse(course);
        response.sendRedirect("CourseServlet");
    }

}



