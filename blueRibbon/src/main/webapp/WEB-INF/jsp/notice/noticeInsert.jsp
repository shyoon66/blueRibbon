<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlNoticeList" value="/notice/list" />

<jsp:include page="../common/header.jsp" />

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
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<h2 class="mt-4 mb-3">
			공지사항
		</h2>
		<hr>	
		<div class="row">
			<div class="col-md-12">
				글쓴이: <input type="text" id="userId" name="userId" value="admin" readonly="readonly"/>
			</div>
			<div class="col-md-12">
				제목: <input type="text" id="title" name="title" value=""/>
			</div>
			<hr>
			<div class="col-md-12">
				<div id="summernote">Hello Summernote</div>
			</div>
		</div>
		<div class="row">
			<a href="#" id="insertBtn" class="btn btn-primary">등록</a>
		</div>
	</div>
	<!-- /.container -->

	<jsp:include page="../common/footer.jsp" />
</body>
</html>