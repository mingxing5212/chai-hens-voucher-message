<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="status" required="true" rtexprvalue="true" %>
<c:choose>
  <c:when test="${status eq 0}">
    <button type="button" class="btn blue btn-sm btnEdit"><i class="fa fa-edit"></i> 编辑</button>
    <button type="button" class="btn yellow btn-sm btnPublish"><i class="fa fa-briefcase"></i> 投放市场</button>
    <button type="button" class="btn purple btn-sm btnRemove"><i class="fa fa-times-circle"></i> 移除列表</button>
  </c:when>
  <c:when test="${status eq 1}">
    <button type="button" class="btn red btn-sm btnWithdraw"><i class="fa fa-recycle"></i> 立即撤回</button>
  </c:when>
  <c:when test="${status eq 2}">
    <button type="button" class="btn red btn-sm btnWithdraw"><i class="fa fa-recycle"></i> 撤回</button>
  </c:when>
  <c:when test="${status eq 3}">
    <button type="button" class="btn purple btn-sm btnRemove"><i class="fa fa-times-circle"></i> 删除</button>
  </c:when>
  <c:otherwise></c:otherwise>
</c:choose>