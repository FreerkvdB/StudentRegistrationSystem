<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Create Account</title>

    <link rel="stylesheet" href="css/style.css">

</head>


<body>


<div class="container">


<h1>Create Account</h1>


<form action="RegisterServlet" method="post">


<label>
Username:
</label>

<input 
    type="text" 
    name="username"
    required>


<br>


<label>
Password:
</label>

<input 
    type="password" 
    name="password"
    required>


<br>


<label>
Confirm Password:
</label>

<input 
    type="password"
    name="confirmPassword"
    required>


<br>


<button type="submit">
    Register
</button>


</form>


<p>
Already have an account?
<a href="index.jsp">
Login
</a>
</p>


</div>


</body>

</html>