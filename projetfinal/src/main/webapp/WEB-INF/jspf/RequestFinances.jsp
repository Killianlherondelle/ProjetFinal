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

  <form action="/action_page.php">
    <div class="form-group">
      <label for="usr">amount:</label>
      <input type="text" class="form-control" id="usr" name="username">
    </div>
    <div class="form-group">
      <label for="pwd">startDate:</label>
      <input type="password" class="form-control" id="pwd" name="password">
    </div>
     <div class="form-group">
      <label for="pwd">monthDuration:</label>
      <input type="password" class="form-control" id="pwd" name="password">
    </div>
     <div class="form-group">
      <label for="pwd">country:</label>
      <input type="password" class="form-control" id="pwd" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

	
	
	
	
<c:import url="footerNav.jsp" />
</body>
</html>