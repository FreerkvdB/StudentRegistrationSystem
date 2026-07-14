<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.student.model.User" %>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <%
            User user = (User) session.getAttribute("user");
            
            if(user == null){
                response.sendRedirect("index.jsp");
            }
        %>
        
        <h1>Welcome, <%= user.getUsername() %>!</h1>
        
        <h2>Student Registration Dashboard</h2>
        
        <hr>
        
        <div>
            <h3>Quick Actions</h3>
            
            <a href="StudentServlet">
               Manage Students
            </a>
            <br><br>
            <a href="CourseServlet">
                Manage Courses
            </a>
            <br><br>
            <a href="EnrollmentServlet">
                Manage Enrollments
            </a>
            <br><br>
            <a href="LogoutServlet">
                Logout
            </a>
        </div>
    </div>

</body>
</html>