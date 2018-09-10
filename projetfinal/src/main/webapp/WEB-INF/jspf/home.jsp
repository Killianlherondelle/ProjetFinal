<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="home.title" /></title>
<c:import url="commonsHead.jsp" />
<style>body, html {
    height: 100%;
/*     background-color: #343a40!important; */
}

.bg { 
    /* The image used */
    background-image: url("<c:url value="/static/images/bg.jpg" />");

    /* Full height */
    height: 70%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>
</head>
<body>
<c:import url="headerNav.jsp" />


<div class="bg">
	<c:import url="role.jsp" />
	<div class="container-fluid">
		<h1 class="text-primary">
			<spring:message code="home.title" /> 
		</h1>
	</div>
</div>

















</body>
</html>