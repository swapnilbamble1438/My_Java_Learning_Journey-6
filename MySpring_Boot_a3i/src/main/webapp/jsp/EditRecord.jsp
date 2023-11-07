<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Update" >
Employee Id <input type=text name="t1" value="${eid}" readonly="readonly" 
/><br/>
Employee Name <input type=text name="t2" value="${ename}"/><br/>
Employee Salary <input type="number" name="t3" value="${esalary}" /><br/>
<button type=submit>Update Record</button>
</form>
</body>
</html>