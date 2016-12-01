<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getprogram.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <c:forEach items="${requestScope.playbillsmon}" var="playbill" varStatus="status">
      <p>${playbill.day} ${playbill.channelname} ${playbill.start_time} ${playbill.program}</p>
      
     
      

      </c:forEach>
            <c:forEach items="${requestScope.playbillstue}" var="playbill" varStatus="status">
      <p>${playbill.day} ${playbill.channelname} ${playbill.start_time} ${playbill.program}</p>
      
     
      

      </c:forEach>
            <c:forEach items="${requestScope.playbillswed}" var="playbill" varStatus="status">
      <p>${playbill.day} ${playbill.channelname} ${playbill.start_time} ${playbill.program}</p>
      
     
      

      </c:forEach>
            <c:forEach items="${requestScope.playbillsthu}" var="playbill" varStatus="status">
      <p>${playbill.day} ${playbill.channelname} ${playbill.start_time} ${playbill.program}</p>
      
     
      

      </c:forEach>
            <c:forEach items="${requestScope.playbillsfri}" var="playbill" varStatus="status">
      <p>${playbill.day} ${playbill.channelname} ${playbill.start_time} ${playbill.program}</p>
      
     
      

      </c:forEach>
            <c:forEach items="${requestScope.playbillssat}" var="playbill" varStatus="status">
      <p>${playbill.day} ${playbill.channelname} ${playbill.start_time} ${playbill.program}</p>
      
     
      

      </c:forEach>
            <c:forEach items="${requestScope.playbillssun}" var="playbill" varStatus="status">
      <p>${playbill.day} ${playbill.channelname} ${playbill.start_time} ${playbill.program}</p>
      
     
      

      </c:forEach>
      
      
  </body>
</html>
