<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
 
    
   
     
     <h3>Login</h3>
   <div class="container" >
   <div style="border: 2px solid; width: 50%; text-align: center">
  <div class="row">
    <div class="col-xs-12">  
    <div class="table-responsive">
     <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
       
   <h3>Enter user name and password:</h3>  
     
   <form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" 

method='POST'>
      <table >
         <tr>
            <td>User  Name:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
  
  </div>
  </div>
  </div>
  </div>
  </div>
</tiles:putAttribute>
</tiles:insertDefinition>
