<!DOCTYPE html>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
  <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
  <spring:url value="/resources/js" var="js"/>
  <spring:url value="/resources/jquery" var="jq"/>
  <spring:url value="/resources/css" var="css"/>
  <spring:url value="/resources/images" var="img"/>
  
  
  <script type="text/javascript" src="${jq}/jquery.dataTables.js"></script> 
  <link href="${css}/dataTables.bootstrap.css">
 
 
 
 
 <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  .abtus{padding:0.5cm;}
  
  body{
	background-image: url("resources/images/bgimage2.jpg");
 
}
  </style>
</head>
<body>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>




<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PetLove</a>
    </div>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Breed <span class="caret"></span></a>
        <ul class="dropdown-menu">
        
        <c:forEach items="${catlist}" var="category">
        <li><a href="${contextPath}/cat/${category.id}/products">${category.categoryName}</a></li>
        </c:forEach>
        </ul>
      </li>
      <li><a href="#">Accessories</a></li>
      <li><a href="contactus">Contact Us</a>
      <li><a href="aboutus">About Us</a>
      
          </ul>
    <ul class="nav navbar-nav navbar-right">
    <security:authorize access="isAnonymous()">
      <li><a href="reg"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </security:authorize>
      <security:authorize access="isAuthenticated()">
      <li><a href="">${cartcount}cart</a></li>
      <li><a href="${contextPath}/logout"><span class="glyphicon glyphicon-log-in" ></span> Logout</a></li>
      </security:authorize>
    </ul>
    
  </div>
</nav>
  
