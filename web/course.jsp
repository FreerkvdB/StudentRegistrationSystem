<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Course" %>

<!DOCTYPE html>
<html>
<head>
    <title>Courses</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <h2>Course</h2>
    <a href="dashboard.jsp">
        Back to Dashboard
    </a>
    
    <br><br>
    
    <form action="CourseServlet" method="post">
        Course Code
        <input type="text" name="courseCode">
        <br>
        Course Name:
        <input type="text" name="courseName">
        <br>
        Credit:
        <input type="number" name="credits">
        <br>
        <button type="submit">
            Add Course
        </button>
    
    </form>
    
    <hr>
    <h3>Current Courses</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Code</th>
            <th>Name</th>
            <th>Credit</th>
        </tr>
        
        <%
            List<Course> courses =
                    (List<Course>)request.getAttribute("courses");
            if(courses != null){
                for(Course c : courses){
        %>
        
        <tr>
            <td>
                <%=c.getCourseId()%>
            </td>
            
            <td>
                <%=c.getCourseCode()%>
            </td>
            
            <td>
                <%=c.getCourseName()%>
            </td>
                
            <td>
                <%=c.getCredit()%>
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