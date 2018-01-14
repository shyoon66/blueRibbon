<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlNoticeList" 		value="/notice/list" />
<c:url var="urlNoticeView" 		value="/notice/view" />

<jsp:include page="../common/header.jsp" />

<link href="../css/sticky-footer-navbar.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../js/login/login.js"></script>

<body>
	<!-- Page Content -->
	<div id="wrap">
		<div id="main" class="container">
			<!-- Page Heading/Breadcrumbs -->
			<h2 class="mt-4 mb-3">
				로그인
			</h2>
			<hr/>
			<a id="kakao-login-btn" href="https://kauth.kakao.com/oauth/authorize?client_id=099903da7a7fee19ad2e33d79a52e614&redirect_uri=http://localhost:8080/login/kakaologin&response_type=code"><img src="../image/login/kakao_account_login_btn_medium_narrow.png"/></a>
		</div>
	</div>
	<!-- /.container -->
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>