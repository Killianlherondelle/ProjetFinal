<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.user.customer.create.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
<c:import url="headerNav.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary"><spring:message code="entities.user.customer.create.title" /></h1>
			<form:form action="create" method="POST" modelAttribute="user">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
				<div class="form-row">
					<spring:message code="commons.formats.email" var="emailPattern" />
					<div class="form-group col">
						<form:label path="email"><spring:message code="entities.user.email" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<div class="input-group">
							<div class="input-group-prepend">
						        <div class="input-group-text"><spring:message code="commons.symbols.email" /></div>
						     </div>
							<form:input path="email" maxlength="255" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" placeHolder="${emailPattern}" />
							<form:errors element="div" path="email" cssClass="invalid-feedback" />
						</div>
					</div>
					<div class="form-group col">
						<form:label path="password"><spring:message code="entities.user.password" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:password path="password" maxlength="100" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="password" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="firmId"><spring:message code="entities.user.listfirm" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="firmId" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:option value="0"><spring:message code="commons.forms.select" /></form:option>
							<form:options items="${firms}" itemValue="id" itemLabel="name" />
						</form:select>
						<form:errors element="div" path="firmId" cssClass="invalid-feedback" />
					</div>
				</div>
				<div class="form-row">
				<div class="form-group col">
						<form:label path="firstName"><spring:message code="entities.user.firstname" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="firstName" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="firstName" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="lastName"><spring:message code="entities.user.lastname" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="lastName" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="lastName" cssClass="invalid-feedback" />
					</div>
					</div>
				<button type="reset" class="btn btn-primary mb-3"><spring:message code="commons.forms.reset" /></button>
				<form:button class="btn btn-primary mb-3"><spring:message code="commons.forms.save" /></form:button>
			</form:form>
		</section>
	</div>
	<c:import url="footerNav.jsp" />
</body>
</html>