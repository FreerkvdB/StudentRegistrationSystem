<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>

<!DOCTYPE html>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <h2>Students</h2>
    <a href="dashboard.jsp">
        Back to Dashboard
    </a>
    
    <br><br>
    
    <form action="StudentServlet" method="post">
        First Name:
        <input type="text" name="firstName">
        <br>
        Last Name:
        <input type="text" name="lastName">
        <br>
        Email:
        <input type="email" name="email">
        <br>
        Phone:
        <input type="text" name="phone">
        <br>
        <button type="submit">
            Add Student
        </button>
    
    </form>
    
    <hr>
    <h3>Current Students</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        
        <%
            List<Student> students =
                    (List<Student>)request.getAttribute("students");
            if(students != null){
                for(Student s : students){
        %>
        
        <tr>
            <td>
                <%=s.getStudentId()%>
            </td>
            
            <td>
                <%=s.getFirstName()%>
                <%=s.getLastName()%>
            </td>
            
            <td>
                <%=s.getEmail()%>
            </td>
            
            <td>
                <%=s.getPhone()%>
            </td>
        </tr>
        <%
            }
}
        %>
    </table>
    
    </form>

</body>
</html>