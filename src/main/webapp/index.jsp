<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Covid Tracker</title>
</head>
<body bgcolor="silver"">
<h1>Corona Virus Tracker</h1>
<h2>This application list the current number of cases reported across the globe.</h2>
<div style="float: left"><b>State</b></div>
<div style="float: right"><b>Total Confirmed Cases</b></div>
<div style="margin: 0 auto; width: 100px;"><b>Country</b></div>
<br>
<br>

<c:forEach items="${allStats}" var="allStats"> 
<hr color="blue">   
<div style="float: left"><c:out value="${allStats.state}"/></div>
<div style="margin: 0 auto; width: 100px;"><c:out value="${allStats.country}"/></div>
<div style="float: right"><c:out value="${allStats.confirmedCase}"/></div>
<br>
<hr color="blue">
</c:forEach>


</body>
</html>