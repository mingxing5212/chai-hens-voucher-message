<%--
  Created by IntelliJ IDEA.
  User: limingxing
  Date: 21/2/16
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layouts/fragment/taglib.jsp"%>
<html>
<head>
  <title>微信粉丝</title>
  <link href="${metronicPath}/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
  <link href="${metronicPath}/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
  <link href="${metronicPath}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
  <link href="${metronicPath}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
  <link href="${ctx}/resources/css/member.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="page-bar">
  <ul class="page-breadcrumb">
    <li>
      <a href="/">首页</a>
      <i class="fa fa-circle"></i>
    </li>
    <li>
      <span>微信粉丝</span>
    </li>
  </ul>
  <div class="page-toolbar">
    <div id="dashboard-report-range" class="pull-right tooltips btn btn-sm" data-container="body" data-placement="bottom" data-original-title="Change dashboard date range">
      <i class="icon-calendar"></i>&nbsp;
      <span class="thin uppercase hidden-xs">January 22, 2016 - February 20, 2016</span>&nbsp;
      <i class="fa fa-angle-down"></i>
    </div>
  </div>
</div>
<h3 class="page-title"> 微信粉丝
  <small>关注微信公众号后会出现在列表中.</small>
</h3>
<div class="row">
  <div class="col-md-12">
    <div class="portlet box green">
      <div class="portlet-title">
        <div class="caption">
          <i class="fa fa-user"></i>粉丝列表 </div>
        <div class="tools">
          <a href="javascript:;" class="collapse" data-original-title="" title="收缩"> </a>
          <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title="设置查询条件"> </a>
          <a href="javascript:;" class="reload" data-original-title="" title="刷新"> </a>
          <a href="" class="fullscreen" data-original-title="" title="全屏"> </a>
        </div>
      </div>
      <div class="portlet-body">
        <div class="table-toolbar">
          <div class="row">
            <div class="col-md-6">
                <button id="btnCreateVoucher" class="btn red">
                  <i class="fa fa-money"></i> 群发代金券
                </button>
                <button id="btnSendMessage" class="btn blue">
                  <i class="fa fa-wechat"></i> 群发文章
                </button>
              <button type="button" class="btn dark"><i class="fa fa-remove"></i> 拉入黑名单</button>
              <button type="button" class="btn purple"><i class="fa fa-tags"></i> 打标签</button>
              </div>
            <div class="col-md-6">
              <div class="btn-group pull-right">
                <button class="btn green  btn-outline dropdown-toggle" data-toggle="dropdown">工具
                  <i class="fa fa-angle-down"></i>
                </button>
                <ul class="dropdown-menu pull-right">
                  <li>
                    <a href="javascript:;">
                      <i class="fa fa-print"></i> 打印 </a>
                  </li>
                  <li>
                    <a href="javascript:;">
                      <i class="fa fa-file-pdf-o"></i> 另存为 PDF </a>
                  </li>
                  <li>
                    <a href="javascript:;">
                      <i class="fa fa-file-excel-o"></i> 导出为 Excel </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="dataTables_wrapper no-footer fans">
        <table class="table table-bordered table-striped table-condensed flip-content table-hover table-scrollable" id="fans">
          <thead>
          <tr>
            <th>
              <input type="checkbox" value="" class="all-fan"/>
            </th>
            <th>
              昵称
            </th>
            <th style="width: 50px;">
              性别
            </th>
            <th>
              头像
            </th>
            <th>
              关注时间
            </th>
            <th>
              状态
            </th>
            <th>
              是否是会员
            </th>
            <th style="width: 280px;">
              操作
            </th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="fan" items="${seed.result}">
            <tr openId="${fan.openid}" nickname="${fan.nickname}" headurl="${fan.headimgurl}">
              <td><input type="checkbox" value="" class="fanbox"/></td>
              <td>${fan.nickname}</td>
              <td><mx:msex sex="${fan.sex}"/></td>
              <td><img class=".user_info .avatar img" src="${fan.headimgurl}"/></td>
              <td>${fan.subscribe_time}</td>
              <td>已关注</td>
              <td>否</td>
              <td>
                <div class="clearfix util-btn-margin-bottom-5">
                <button type="button" class="btn green-meadow"><i class="fa fa-plus"></i> 赠送代金券</button>
                <button type="button" class="btn blue"><i class="fa fa-wechat"></i> 发送消息</button>
                </div>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      </div>
    </div>
  </div>
</div>

<script src="${metronicPath}/assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript"></script>
<script src="${metronicPath}/assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript"></script>
</body>
</html>
