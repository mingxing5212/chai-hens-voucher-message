<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="status" required="true" rtexprvalue="true" %>
<c:choose>
  <c:when test="${status eq 0}"><span class="label label-sm label-primary"> 新建 </span></c:when>
  <c:when test="${status eq 1}"><span class="label label-xs label-warning"> 待发布 </span></c:when>
  <c:when test="${status eq 2}"><span class="label label-xs label-success"> 已发布 </span></c:when>
  <c:when test="${status eq 3}"><span class="label label-xs label-danger"> 已撤回 </span></c:when>
  <c:otherwise><span class="label label-xs label-default"> 删除 </span></c:otherwise>
</c:choose>