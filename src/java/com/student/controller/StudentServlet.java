package com.student.controller;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {


    private StudentDAO studentDAO;


    @Override
    public void init(){

        studentDAO = new StudentDAO();

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        List<Student> students = studentDAO.getAllStudents();

    request.setAttribute("students", students);

    request.getRequestDispatcher("student.jsp")
            .forward(request, response);

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");


        Student student = new Student();


        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setPhone(phone);


        studentDAO.addStudent(student);
        response.sendRedirect("StudentServlet");

    }

}