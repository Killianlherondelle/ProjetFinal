<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<span id="TOP"></span>


		<sec:authorize access ="hasRole('ROLE_ADMIN')">
		 <h5>Bonjour Admin</h5>
		</sec:authorize>
		<sec:authorize access ="hasRole('ROLE_USER')">
		 <h5>Bonjour User</h5>
		</sec:authorize>
		<sec:authorize access ="hasRole('ROLE_PO')">
		 <h5>Bonjour Product Owner</h5>
		</sec:authorize>
		<sec:authorize access ="hasRole('ROLE_BANKER')">
		 <h5>Bonjour Banquier</h5>
		</sec:authorize>
		<sec:authorize access ="hasRole('ROLE_CUSTOMER')">
		 <h5>Bonjour Entreprise</h5>
		</sec:authorize>
