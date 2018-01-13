<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlNoticeList" value="/notice/list" />

<jsp:include page="../common/header.jsp" />

<style>
	.right {
		float: right;
	}
</style>

<link href="../css/sticky-footer-navbar.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../js/notice/noticeView.js"></script>

<body>
	<input type="hidden" id="noticeId" name="noticeId" value="${param.noticeId}" />
	<input type="hidden" id="page" name="page" value="${param.page}" />
	<input type="hidden" id="pageSize" name="pageSize" value="${param.size}" />

	<!-- Page Content -->
	<div id="wrap">
		<div id="main" class="container">
			<!-- Page Heading/Breadcrumbs -->
			<h2 class="mt-4 mb-3">
				공지사항
			</h2>
			<hr>
			<div class="row">
				<div class="form-group form-group-sm col-sm-4">
                	<div class="row">
						<label for="userId" class="col-sm-3 col-form-label">글쓴이</label>
						<div class="col-sm-6">
							<input type="text" id="userId" name="userId" class="form-control" value="${view.userId}" readonly="readonly"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group form-group-sm col-sm-12">
                	<div class="row">
						<label for="userId" class="col-sm-1 col-form-label">제목</label>
						<div class="col-sm-11">
							<input type="text" id="title" name="title" class="form-control" value="${view.title}" readonly="readonly"/>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">${view.contents}</div>
			</div>
			<hr>	 		
			<div class="text-right">
				<a href="#" id="updateBtn" class="btn btn-primary btn-sm">수정</a>
				<a href="#" id="deleteBtn" class="btn btn-primary btn-sm">삭제</a>
				<a href="#" id="listBtn" class="btn btn-primary btn-sm">목록</a>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<jsp:include page="../common/footer.jsp" />
</body>
</html>