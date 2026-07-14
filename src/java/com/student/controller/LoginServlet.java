package com.student.controller;


import com.student.dao.UserDAO;
import com.student.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


@Override
protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {


    String username =
            request.getParameter("username");


    String password =
            request.getParameter("password");



    UserDAO dao =
            new UserDAO();



    User user =
            dao.login(username,password);



    if(user != null){


        HttpSession session =
                request.getSession();


        session.setAttribute(
                "user",
                user
        );


        response.sendRedirect(
                "dashboard.jsp"
        );


    }
    else{


        response.sendRedirect(
                "index.jsp"
        );

    }


}

}