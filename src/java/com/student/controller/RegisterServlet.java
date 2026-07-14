package com.student.controller;


import com.student.dao.UserDAO;
import com.student.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {


@Override
protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {



    String username =
            request.getParameter("username");


    String password =
            request.getParameter("password");


    User user =
            new User(username,password);



    UserDAO dao =
            new UserDAO();


    boolean result =
            dao.registerUser(user);



    if(result){

        response.sendRedirect("index.jsp");

    }
    else{

        response.sendRedirect("register.jsp");

    }


}

}