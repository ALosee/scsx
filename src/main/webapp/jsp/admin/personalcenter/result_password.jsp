<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>" method="post">
   <c:if test="${error_info eq 'true'}">
           修改密码成功！
   </c:if>
   <a href="<%=request.getContextPath() %>/admin_logout">请重新登录！</a>
   <c:if test="${error_info eq 'false'}">
            修改密码失败！
   </c:if>
   
</form>
</body>
</html>
