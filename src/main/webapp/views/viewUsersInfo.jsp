<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script>
	$(document).ready(function() {
		$('#userTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>
<script>
  function deleteConfirm(){
	        var txt;
             var r= confirm("are you sure, you want to delete?");
             if(r==true){
                txt="you pressed OK";
                 }else{
                  txt="you preessed cancel!!";
                  event.preventDefault();
                 }
	  }
</script>
</head>
<body>
 
  
	<table border="1" id="userTbl">
		<thead>
			<th>S.No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${userAccount}"
			              var="userAcc"
			              varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${userAcc.firstName}</td>
					<td>${userAcc.emailId}</td>
					<td>
					     <a href="editUser?userId=${userAcc.userId}">Edit</a>
					   |  <a href="deleteUser?userId=${userAcc.userId}" onclick="deleteConfirm()">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>