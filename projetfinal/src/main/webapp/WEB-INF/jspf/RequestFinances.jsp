<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<div class="container">
<div class="container-fluid">
		<section>
			<h1 class="text-primary"></h1>
			<form:form action="create" method="POST" modelAttribute="finance">
				<div class="form-row">
					<div class="form-group col">

					<div class="form-group col">
						<form:label path="currency.id"><spring:message code="entities.currency.type" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="currency.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:option value="0"><spring:message code="commons.forms.select" /></form:option>
							<form:options items="${currencies}" itemValue="id" itemLabel="name" />
						</form:select>
						<form:errors element="div" path="currency.id" cssClass="invalid-feedback" />
					</div>
					
					<div class="form-group col">
						<form:label path="financeType.id"><spring:message code="entities.financeTypes.type" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="financeType.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:option value="0"><spring:message code="commons.forms.select" /></form:option>
							<form:options items="${financeTypes}" itemValue="id" itemLabel="name" />
						</form:select>
						<form:errors element="div" path="financeType.id" cssClass="invalid-feedback" />
					</div>
	</div>
</div>
</form:form>
</section>
</div>
</div>
	
	
<c:import url="footerNav.jsp" />
</body>
</html>