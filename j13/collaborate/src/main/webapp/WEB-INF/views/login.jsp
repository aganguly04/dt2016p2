<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="resources/css/styles.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<title>Login</title>
</head>
<body>
 <jsp:include page="menu.jsp" />
    
    
   
     
     <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
       
     
   
   <div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">

A</button>
          <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
   
  
   <form class="form col-md-12 center-block" name='f' 

action="${pageContext.request.contextPath}/j_spring_security_check" 

method='POST'>
            <div class="form-group">
            <input type='text' name='username' value=''  class="form-control input-lg" 

placeholder="User Name">
	</div>
            <div class="form-group">
         
         

            <input type='password' name='password' class="form-control input-lg" 

placeholder="Password"/>
         	</div>
            <div class="form-group">

         
            <input name="submit" type="submit" value="submit" class="btn btn-primary 

btn-lg btn-block"/>
         
      <span class="pull-right"><a href="#">Register</a></span><span><a href="#">Need 

help?</a></span>
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
		  </div>	
      </div>
  </div>
  </div>
</div>
<!-- script references -->
		<script src="resources/js/jquery-2.2.3.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>