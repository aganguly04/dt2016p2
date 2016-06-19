<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="body">





<center>

<div style="color: teal;font-size: 30px">Add User</div>
<br><br>
<c:url var="register" value="register"/>
<form:form id="registerUser"  modelAttribute="users" commandName="users" method="post" action="${register}" enctype="multipart/form-data">
<table width="400px" height="150px">
<tr>
<td><form:label path="userName">User Name    </form:label></td>
<td><form:input  path="userName"  id="name"/></td>
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

