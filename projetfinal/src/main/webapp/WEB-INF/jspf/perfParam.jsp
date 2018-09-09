<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.perf.param.create.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
<c:import url="headerNav.jsp" />
<c:import url="role.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary"><spring:message code="entities.perf.param.create.title" /></h1>
			<form:form action="update" method="POST" modelAttribute="perf">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
				
					
					<div class="form-row">
					
					<div class="form-group col">
						<form:label path="parameterA"><spring:message code="entities.perf.param.a" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="parameterA" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="parameterA" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="parameterB"><spring:message code="entities.perf.param.b" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:input path="parameterB" maxlength="50" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="parameterB" cssClass="invalid-feedback" />
					</div>
				</div>

				
				<button type="reset" class="btn btn-primary mb-3"><spring:message code="commons.forms.reset" /></button>
				<form:button class="btn btn-primary mb-3"><spring:message code="commons.forms.save" /></form:button>
			</form:form>
		</section>
	</div>

</body>
</html>