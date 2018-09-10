<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale.language}">
<head>
<title><spring:message code="entities.user.collab.create.title" /></title>
<c:import url="commonsHead.jsp" />
</head>
<body>
<c:import url="headerNav.jsp" />
<c:import url="role.jsp" />
	<div class="container-fluid">
		<section>
			<h1 class="text-primary"><spring:message code="entities.user.collab.create.title" /></h1>
			<form:form action="create" method="POST" modelAttribute="user">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
					<c:if test="${success}">
			 		<div class="alert alert-success alert-dismissible fade show">
    				<button type="button" class="close" data-dismiss="alert">&times;</button>
    				<strong>succès!</strong> Le Collaborateur a bien été créé
  					</div>
  					</c:if>
			
				<div class="form-row">
					
					<div class="form-group col">
						<form:label path="collabId"><spring:message code="entities.user.listcollab" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="collabId" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:option value="0"><spring:message code="commons.forms.select" /></form:option>
							<form:options items="${emails}" itemValue="id" itemLabel="label" />
						</form:select>

						<form:errors element="div" path="collabId" cssClass="invalid-feedback" />
					</div>
					
					<div class="form-group col">
						<form:label path="password"><spring:message code="entities.user.password" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:password path="password" maxlength="100" cssClass="form-control" cssErrorClass="form-control is-invalid" autocomplete="off" />
						<form:errors element="div" path="password" cssClass="invalid-feedback" />
					</div>
					<div class="form-group col">
						<form:label path="role"><spring:message code="entities.user.role" /><span class="text-danger"><spring:message code="commons.symbols.required" /></span></form:label>
						<form:select path="role" cssClass="form-control" cssErrorClass="form-control is-invalid">
							<form:options items="${roles}" itemValue="name" itemLabel="name" />
						</form:select>
						<form:errors element="div" path="role" cssClass="invalid-feedback" />
					</div>
				</div>
				
				<button type="reset" class="btn btn-primary mb-3"><spring:message code="commons.forms.reset" /></button>
				<form:button class="btn btn-primary mb-3"><spring:message code="commons.forms.save" /></form:button>
			</form:form>
		</section>
	</div>

</body>
</html>