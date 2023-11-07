<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="70%" cellpadding="2"> 
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Employee Salary</th>
</tr> 
 <c:forEach var="Employee" items="${xyz}"> 
 <tr> 
 <td>${Employee.eid}</td> 
 <td>${Employee.ename}</td> 
 <td>${Employee.esalary}</td>
 </tr> 
 </c:forEach> 
 </table> 
</body>
</html>