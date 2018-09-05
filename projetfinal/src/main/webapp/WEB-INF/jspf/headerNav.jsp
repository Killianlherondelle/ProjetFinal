<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<span id="TOP"></span>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">SodiBank</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      	<li class="nav-item"><a class="nav-link" href="<c:url value="/security/login" />"><spring:message code="login.title" /></a></li>
    </li>
    <li class="nav-item">
      <li class="nav-item"><a class="nav-link" href="<c:url value="/users/toCreate" />"><spring:message code="entities.user.create.title" /></a></li>
    </li>
    <li class="nav-item">
      <li class="nav-item"><a class="nav-link" href="<c:url value="/usercust/toCreate" />"><spring:message code="entities.user.customer.create.title" /></a></li>
    </li>
  </ul>
</nav>