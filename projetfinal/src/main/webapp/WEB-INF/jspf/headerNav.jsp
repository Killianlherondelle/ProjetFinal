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
    
    <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PO')">
    <li class="nav-item">
      <li class="nav-item"><a class="nav-link" href="<c:url value="/usercust/toCreate" />"><spring:message code="entities.user.customer.create.title" /></a></li>
    </li>
   
       <li class="nav-item">
      	<li class="nav-item"><a class="nav-link" href="<c:url value="/usercollab/toCreate" />"><spring:message code="entities.user.collab.create.title" /></a></li>
    </li>
    
    <li class="nav-item">
      	<li class="nav-item"><a class="nav-link" href="<c:url value="/list/list" />"><spring:message code="list.title" /></a></li>
    </li>
    <li class="nav-item">
      	<li class="nav-item"><a class="nav-link" href="<c:url value="/listpo/list" />"><spring:message code="entities.finance.list.po.title.short" /></a></li>
    </li>
     <li class="nav-item">
      <li class="nav-item"><a class="nav-link" href="<c:url value="/perf/toUpdate" />"><spring:message code="entities.perf.param.create.title.short" /></a></li>
    </li>
    
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_BANKER')">
     <li class="nav-item">
      	<li class="nav-item"><a class="nav-link" href="<c:url value="/listba/list" />"><spring:message code="entities.finance.list.po.title.short" /></a></li>
    </li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
       <li class="nav-item">
      	<li class="nav-item"><a class="nav-link" href="<c:url value="/finances/toCreate" />"><spring:message code="finances.title" /></a></li>
    </li>
    </sec:authorize>
       <sec:authorize access="isAuthenticated()">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<sec:authentication property="principal.user.firstName" />
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			
			<a class="dropdown-item" href="<c:url value="/logout" />"><spring:message code="commons.nav.settings.logout" /></a>
        </div>
      </li>
      </sec:authorize>
  </ul>
</nav>