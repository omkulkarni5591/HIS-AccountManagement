<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/app.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h1>Create Account</h1>
	<form:form action="userAccountReg" method="post" modelAttribute="userAccount">
		<table>
			<tr>
				<th>First Name</th>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><form:input path="lastName" />
			</tr>
			<tr>
				<th>Email</th>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
			  <th>Gender</th>
			  <td>
			  Male:<form:radiobutton path="gender" value="M" id="gender"/>
			  Female:<form:radiobutton path="gender" value="F" id="gender"/>
			  </td>
			</tr>
			<tr>
			<th>Role:</th>
			   <td> <form:select path="userRoleId">
			        <form:option value="">--Select--</form:option>
			        <form:options items="${rolesMap}"></form:options>
			     </form:select>
			   </td>
			</tr>
	          <tr>
			<td>
			   <input type="submit" value="Create"/>
			</td>
			</tr>
		</table>
	</form:form>
	          
</body>
</html>