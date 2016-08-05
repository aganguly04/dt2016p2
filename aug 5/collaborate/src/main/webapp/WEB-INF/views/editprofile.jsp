<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="body">





<center>

<div style="color: teal;font-size: 30px">Edit Profile</div>
<br><br>
<c:url var="saveprofile" value="saveprofile"/>
<form:form id="editUser"  modelAttribute="user" commandName="user" method="post" action="${saveprofile}" enctype="multipart/form-data">
<table width="400px" height="150px">
<tr>
<td><form:label path="userId">User Id    </form:label></td>
<td><form:input  path="userId"     readonly="true"  /></td>

</tr>
<tr>
<td><form:label path="userName">User Name    </form:label></td>
<td><form:input  path="userName"  id="name"  readonly="true" /></td>

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
<td><form:hidden path="userPassword"/></td>
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

<input type="submit"  id="btnSubmit"  value="Edit"  name="action" />
<input type="submit" value="Cancel" name="action"/>

</td></tr>
</table>



</form:form>
<br>

</center>
<script type="text/javascript" src="resources/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript">
    
    
    $(document).ready(function() {
        // check name availability on focus lost
        $('#name').blur(function() {
            checkAvailability();
        });
    });


    function checkAvailability() {
        $.getJSON("/checkavailability", { name: $('#name').val() }, function(availability) {
            if (availability.available) {
                fieldValidated("name", { valid : true });
            } else {
                fieldValidated("name", { valid : false,
                    message : $('#name').val() + " is not available, try " + availability.suggestions });
            }
        });
    }

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

</tiles:putAttribute>
</tiles:insertDefinition>

