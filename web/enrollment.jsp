<%@page import="com.student.model.Course"%>
<%@page import="com.student.model.Student"%>
<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Enrollment" %>

<!DOCTYPE html>
<html>
<head>
    <title>Enrollment</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <h2>Enrollment</h2>
    <a href="dashboard.jsp">
        Back to Dashboard
    </a>
    
    <br><br>
    
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");

        List<Course> courses =(List<Course>) request.getAttribute("courses");
    %>
    
    <form action="EnrollmentServlet" method="post">
        <select name="studentId">
            <%
                for(Student s : students){
            %>
            <option value ="<%=s.getStudentId()%>">
                <%=s.getStudentNumber()%> -
                <%=s.getFirstName()%>
                <%=s.getLastName()%>
            </option>
               <%  
                }
               %>
        </select>
        
         <select name="courseId">
            <%
                for(Course c : courses){
            %>
            <option value ="<%=c.getCourseId()%>">
                <%=c.getCourseCode()%> -
                <%=c.getCourseName()%>
            </option>
               <%  
                }
               %>
        </select>
        
        
        <button type="submit">
            Add Enrollment
        </button>
    
    </form>
    
    <hr>
    <h3>Current Enrollment</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Student Number</th>
            <th>Course</th>
        </tr>
        
        <%
            List<Enrollment> enrollments =
                    (List<Enrollment>)request.getAttribute("enrollments");
            if(enrollments != null){
                for(Enrollment e : enrollments){
        %>
        
        <tr>
            <td>
                <%=e.getEnrollmentId()%>
            </td>
            
            <td>
                <%=e.getStudentNumber()%>
            </td>
            
            <td>
                <%=e.getCourseName()%>
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
