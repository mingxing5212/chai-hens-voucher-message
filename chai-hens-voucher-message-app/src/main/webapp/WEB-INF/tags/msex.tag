<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="sex" required="true" rtexprvalue="true" %>
<c:choose>
  <c:when test="${sex eq 0}">未知</c:when>
  <c:when test="${sex eq 1}">男</c:when>
  <c:when test="${sex eq 2}">女</c:when>
  <c:otherwise></c:otherwise>
</c:choose>