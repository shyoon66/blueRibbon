<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlNoticeList" value="/notice/list" />

<jsp:include page="../common/header.jsp" />

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../js/notice/noticeView.js"></script>

<body>
	<input type="hidden" id="noticeId" name="noticeId" value="${param.noticeId}" />
	<input type="hidden" id="page" name="page" value="${param.page}" />
	<input type="hidden" id="pageSize" name="pageSize" value="${param.size}" />

	<!-- Page Content -->
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<h2 class="mt-4 mb-3">
			공지사항
		</h2>
		<hr>	
		<div class="row">
			<div class="col-md-12">
				글쓴이: <input type="text" id="userId" name="userId" value="${view.userId}" readonly="readonly"/>
			</div>
			<div class="col-md-12">
				제목: <input type="text" id="title" name="title" value="${view.title}" readonly="readonly"/>
			</div>
			<hr>
			<div class="col-md-12">
				<%-- <textarea rows="15" cols="150" readonly="readonly">${view.contents}</textarea> --%>
				<div>${view.contents}</div>
			</div>
		</div>
		<div class="row">
			<a href="#" id="updateBtn" class="btn btn-primary">수정</a>
			<a href="#" id="deleteBtn" class="btn btn-primary">삭제</a>
			<a href="#" id="listBtn" class="btn btn-primary">목록</a>
		</div>
	</div>
	<!-- /.container -->

	<jsp:include page="../common/footer.jsp" />
</body>
</html>