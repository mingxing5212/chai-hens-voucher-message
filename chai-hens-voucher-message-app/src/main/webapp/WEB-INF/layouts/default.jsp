<%@ include file="/WEB-INF/layouts/fragment/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 田园铁锅 | <sitemesh:write property='title'/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link rel="shortcut icon" href="${ctx }/resources/favicon.ico" />

<%@ include file="/WEB-INF/layouts/fragment/common-css.jsp"%>
<%@ include file="/WEB-INF/layouts/fragment/common-js.jsp"%>
<sitemesh:write property='head'/>
</head>

<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
	<!-- HEADER LAYOUT -->
	<%@ include file="/WEB-INF/layouts/header/header.jsp"%>

	<div class="clearfix"> </div>
     <!-- CONTENT LAYOUT -->
	<div class="page-container">
		<%@ include file="/WEB-INF/layouts/sidebar/sidebar.jsp"%>
		<div class="page-content-wrapper">
			<div class="page-content" style="min-height:1112px">
				<sitemesh:write property='body'/>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/layouts/footer/footer.jsp"%>
</body>
</html>