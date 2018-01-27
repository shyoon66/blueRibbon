<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlNoticeList" value="/notice/list" />

<jsp:include page="../common/header.jsp" />

<link href="../css/sticky-footer-navbar.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- include summernote css/js-->
<link href="../summernote/summernote-bs4.css" rel="stylesheet">
<script src="../summernote/summernote-bs4.js"></script>
<script src="../summernote/lang/summernote-ko-KR.js"></script>

<script src="../js/notice/noticeInsert.js"></script>

<body>
	<%-- <input type="hidden" id="page" name="page" value="${view.page}" /> --%>

	<!-- Page Content -->
	<div id="wrap">
		<div id="main" class="container">
			<!-- Page Heading/Breadcrumbs -->
			<h3 class="mt-4 mb-3">
				공지사항
			</h3>
			<hr>		
			<div class="row">
				<div class="form-group form-group-sm col-sm-4">
					<div class="row">
						<label for="userId" class="col-sm-3 col-form-label">글쓴이</label>
						<div class="col-sm-6">
							<input type="text" id="userId" name="userId" class="form-control form-control-sm" value="${user.nickname}" readonly="readonly"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group form-group-sm col-sm-12">
					<div class="row">
						<label for="userId" class="col-sm-1 col-form-label">제목</label>
						<div class="col-sm-11">
							<input type="text" id="title" name="title" class="form-control" value=""/>
						</div>
					</div>
				</div>
				<hr>
				<div class="col-md-12">
					<div id="summernote"></div>
				</div>
			</div>
			<div class="text-right" style="margin-bottom: 20px; margin-top: 20px;">
				<a href="#" id="insertBtn" class="btn btn-primary">등록</a>
			</div>
		</div>
	</div>
	<!-- /.container -->

	<jsp:include page="../common/footer.jsp" />
</body>
</html>