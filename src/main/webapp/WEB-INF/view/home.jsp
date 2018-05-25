<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<title>HOME page</title>


</head>
<body>
	<h2>HOME PAGE</h2>
	<hr>


	<p>welcome to company home page- yaaaaaaa- sislkfafdasd- not soup!</p>
	
	<hr>
	<!-- Display username and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Roles: <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	<security:authorize access="hasRole('God')">
	<p><a href="${pageContext.request.contextPath}/leader">MEETING</a></p>
	
	</security:authorize>
	
	
	<security:authorize access="hasRole('Admin')">
	<a href="${pageContext.request.contextPath}/admin">admin MEETING</a>
	</security:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout" 
		       method="POST">
		<input type="submit" value="Logout"/>
	</form:form>


</body>







</html>