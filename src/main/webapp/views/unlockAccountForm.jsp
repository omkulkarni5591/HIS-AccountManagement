<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
  function validatePwds(){

      var newPwd=$('#newPwd'.val())
      var confirmPwd=$('#confirmPwd').val();
      if(newPwd!=confirmPwd){
          $('#errId').text('new password and confirm password shoulb be same');
          return false;
          }
      return true;
	  }
</script>
</head>
<body>
   <h1>Unlock account Here</h1>
   <form:form action="unlockUserAcc" modelAttribute="unlockAcc" method="post">
     <font color='red'><span id="errId"></span></font>
     
     <table>
        <tr>
           <td>Your Email</td>
           <td>${email}</td>
        </tr>
        <tr>
          <td>Enter Temporary Password</td>
          <td><form:password path="tempPwd"/>
        </tr>
        <tr>
          <td>Enter new Password</td>
          <td><form:password path="newPwd"/></td>
          </tr>
          <tr>
          <td>confirm new password</td>
          <td><form:password path="confirmPwd"/></td>
          </tr>
          <tr>
          <td><input type="submit" value="Unlock"
              onclick="javascript:return validatePwds()"/></td>
           </tr>
     </table>
   </form:form>
</body>
</html>