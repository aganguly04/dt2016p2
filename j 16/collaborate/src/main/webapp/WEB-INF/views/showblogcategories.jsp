<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<c:url var="editImgUrl" value="/resources/imgages/edit.png" />
<c:url var="deleteImgUrl" value="/resources/imgages/delete.png" />
<c:url var="addUrl" value="/addblogcategory" />
<table style="border: 2px solid; width: 100%; text-align:center">
<thead>

<tr>
<th>Id</th>
<th>Name</th>


</tr>
</thead>
<tbody style="background:#ccc">
<c:forEach items="${blogCategoryList}" var="bc"> 
<tr>
<td><c:out value="${bc.categoryId}" /></td>
<td><c:out value="${bc.categoryName}" /></td>
<td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>
<c:url var="addBlog" value="/addblog?id=${bc.categoryId}" />
<td><a href="${addBlog}">Add Blog</a></td>
<td></td>
<td></td>
</tr>
</tbody> 
</c:forEach>                
</table>
<p><a href="${addUrl}">Create new author-entry</a></p>



</body>
</html>