<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="list.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
<c:import url="headerNav.jsp" />

<div class="container-fluid">
	<h1 class="text-primary">
	TEST
<%-- 			<spring:message code="home.welcome.user" /> --%>
	</h1>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead class="thead-light">
				<tr>
					<th><spring:message code="entities.user.lastname" /></th>
					<th><spring:message code="entities.user.email" /></th>
					<th><spring:message code="entities.user.role" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.lastName}</td>
							<td>${user.email}</td> 
							<td>${user.role}</td>
							<button class="btn btn-primary mb-3"><spring:message code="commons.forms.disable" /></button>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
</div>


















		<c:import url="footerNav.jsp" />
</body>
</html>