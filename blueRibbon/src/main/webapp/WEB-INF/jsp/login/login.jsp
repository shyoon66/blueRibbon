<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlNoticeList" 		value="/notice/list" />
<c:url var="urlNoticeView" 		value="/notice/view" />

<jsp:include page="../common/header.jsp" />

<style>

</style>

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../js/login/login.js"></script>

<!-- kakao api -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<body>
	<!-- Page Content -->
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<h2 class="mt-4 mb-3">
			로그인
		</h2>
		<hr/>
		
		<a id="kakao-login-btn"></a>
		<a href="http://alpha-developers.kakao.com/logout"></a>
		
		<script type='text/javascript'>
			//<![CDATA[
			// 사용할 앱의 JavaScript 키를 설정해 주세요.
			Kakao.init('6d42238fa7a33751e6a4e196e84f2d7d');
			// 카카오 로그인 버튼을 생성합니다.
			Kakao.Auth.createLoginButton({
				container : '#kakao-login-btn',
				success : function(authObj) {
					Kakao.API.request({
						url: '/v1/user/me',
						success: function(res) {
 							var url = '/purple/main/insertUserProc';
							var params = {
								id : res.id,
								nick_name : res.properties.nickname,
								url : res.properties.thumbnail_image
							};
							
							$.post(url, params, function(data) {
								location.href = '/purple/main/main';
							});
						}
					});
				},
				fail : function(err) {
					alert(JSON.stringify(err));
				}
			});
			//]]>
		</script>
	</div>
	<!-- /.container -->
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>