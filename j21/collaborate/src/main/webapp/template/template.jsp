
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta name="viewport" content="width-device-width">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/styles.css" rel="stylesheet">
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery-2.2.3.min.js"></script>

</head>

<body>
	
	<div class="menu">
		<tiles:insertAttribute name="menu" />
	</div>
	<div class="body">
		<tiles:insertAttribute name="body" />
	</div>
	
</body>
</html>
