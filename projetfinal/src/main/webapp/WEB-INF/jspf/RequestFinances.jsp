<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="list.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
<c:import url="headerNav.jsp" />

<div class="container-fluid">
		<section>
			<h1 class="text-primary"></h1>
			<form:form action="create" method="POST" modelAttribute="finance">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					
					
					
						<div class="form-group col">
						<form:label path="code"><spring:message code="entities.finance.code" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
							<form:input path="code" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off"/>
							<form:errors element="div" path="code" cssClass="invalid-feedback" />
						</div>
					<div class="form-group col">
					<form:label path="amount"><spring:message code="entities.finance.amount" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<div class="input-group">
						<div class="input-group-prepend">
					        	<div class="input-group-text"><spring:message code="commons.symbols.euro" /></div>
					        </div>
							<form:input path="amount" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" lang="fr"  />
							<form:errors element="div" path="amount" cssClass="invalid-feedback" />
						</div></div>

					<div class="form-group col">
						<form:label path="currency.id"><spring:message code="entities.finance.currency" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="currency.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:option value="0"><spring:message code="commons.forms.select" /></form:option>
							<form:options items="${currencies}" itemValue="id" itemLabel="name" />
						</form:select>
						<form:errors element="div" path="currency.id" cssClass="invalid-feedback" />
					</div>
					
					<div class="form-group col">
						<form:label path="financeType.id"><spring:message code="entities.finance.type" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="financeType.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:option value="0"><spring:message code="commons.forms.select" /></form:option>
							<form:options items="${financeTypes}" itemValue="id" itemLabel="name" />
						</form:select>
						<form:errors element="div" path="financeType.id" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
					<form:label path="monthDuration"><spring:message code="entities.finance.monthDuration" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<div class="input-group">
							<form:input path="monthDuration" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" lang="fr"  />
							<form:errors element="div" path="monthDuration" cssClass="invalid-feedback" />
					</div></div>
						
					<div class="form-group col">
						<form:label path="startDate"><spring:message code="entities.finance.startDate" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="startDate" maxlength="10" placeHolder="${datePattern}" cssClass="form-control datepicker" cssErrorClass="form-control datepicker is-invalid" autocomplete="off" lang="fr" />
						<form:errors element="div" path="startDate" cssClass="invalid-feedback" />
					</div>
				
				<button type="reset" class="btn btn-primary mb-3"><spring:message code="commons.forms.reset" /></button>
				<form:button class="btn btn-primary mb-3"><spring:message code="commons.forms.save" /></form:button>
			</form:form>
		</section>
		</div>
	<c:import url="footerNav.jsp" />
</body>
</html>