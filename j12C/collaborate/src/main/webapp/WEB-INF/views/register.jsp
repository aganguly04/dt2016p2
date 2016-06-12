<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/bootstrap.css" rel="stylesheet">
	   <script type="text/javascript"   src="resources/js/bootstrap.js"></script>
	   <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>

</head>
<body>
    

<%@include file="menu.jsp" %>

<center>

<div style="color: teal;font-size: 30px">Add User</div>
<br><br>
<c:url var="register" value="register"/>
<form:form id="registerUser"  modelAttribute="users" commandName="users" method="post" action="${register}" enctype="multipart/form-data">
<table width="400px" height="150px">
<tr>
<td><form:label path="userName">User Name    </form:label></td>
<td><form:input  path="userName"/></td>
<td align="left"><form:errors path="userName" cssClass="error"/></td>
</tr>
<tr>
<td><form:label path="userPassword">Password    </form:label></td>
<td><form:password  path="userPassword" id="txtPassword" /></td>
<td align="left"><form:errors path="userPassword" cssClass="error"/></td>
</tr>
<tr>
 <td>
 Confirm Password:
 </td>
 <td>
<input type="password" id="txtConfirmPassword" />
 </td>
 </tr>



<tr>
<td><form:label path="userEmail">Email</form:label></td>
<td><form:input  path="userEmail"/></td>
<td align="left"><form:errors path="userEmail" cssClass="error"/></td>
</tr>   

<tr>
<td><form:label path="userPhone">Phone</form:label></td>
<td><form:input  path="userPhone"/></td>

</tr>   

<tr>
<td><form:hidden path="userPhoto"/></td>

</tr>   
<tr>
<td><form:label path="userHobby">Hobby</form:label></td>
<td><form:input  path="userHobby"/></td>

</tr>
<tr>
<td><form:label path="userAddress">Address</form:label></td>
<td><form:input  path="userAddress"/></td>

</tr>

<tr>
<td><form:label path="userLoction">Location</form:label></td>
<td><form:input  path="userLoction"/></td>

</tr>

<tr>
<td>Upload Picture</td>
<td><input type="file" name="file"/></td>

</tr>


<tr>
<td>

<input type="submit"  id="btnSubmit"  value="Add"  name="action" />
<input type="submit" value="Cancel" name="action"/>

</td></tr>
</table>



</form:form>
<br>

</center>
<script type="text/javascript" src="resources/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btnSubmit").click(function () {
                var password = $("#txtPassword").val();
                var confirmPassword = $("#txtConfirmPassword").val();
                if (password != confirmPassword) {
                    alert("Passwords do not match.");
                    return false;
                }
                return true;
            });
        });
    </script>

</body>
</html>

