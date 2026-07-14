<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Registration System</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>Student Registration System</h1>

    <h2>Login</h2>

    <form action="LoginServlet" method="post">

        <label>Username:</label>
        <input type="text" name="username" required>

        <br>

        <label>Password:</label>
        <input type="password" name="password" required>

        <br>

        <button type="submit">
            Login
        </button>

    </form>


    <p>
        Don't have an account?
        <a href="register.jsp">
            Register here
        </a>
    </p>

</div>

</body>
</html>
