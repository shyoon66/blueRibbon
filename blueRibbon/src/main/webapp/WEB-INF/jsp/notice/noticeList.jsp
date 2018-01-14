<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlNoticeList" 		value="/notice/list" />
<c:url var="urlNoticeView" 		value="/notice/view" />

<jsp:include page="../common/header.jsp" />

<link href="../vendor/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
<link href="../css/sticky-footer-navbar.css" rel="stylesheet">

<style>
	.cursor {
		cursor: default;
	}
	.notice-title {
		color: black;
	}
</style>

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../js/notice/noticeList.js"></script>

<body>
	<input type="hidden" id="page" name="page" value="${view.page}" />
	<input type="hidden" id="pageSize" name="pageSize" value="${view.pageSize}" />
	<input type="hidden" id="divNum" name="divNum" value="${view.divNum}" />
	<input type="hidden" id="startPage" name="startPage" value="${view.startPage}" />
	<input type="hidden" id="endPage" name="endPage" value="${view.endPage}" />
	<input type="hidden" id="firstPage" name="firstPage" value="1" />
	<input type="hidden" id="totalPages" name="totalPages" value="${view.totalPages}" />

	<!-- Page Content -->
	<div id="wrap">
		<div id="main" class="container">
			<div>
				<!-- Page Heading/Breadcrumbs -->
				<h2 class="mt-4 mb-3">
					공지사항
				</h2>
			</div>
 			<div>
				<div class="col-sm-12">
					<c:choose>
						<c:when test="${fn:length(view.list) > 0}">		
							<table class="table table-sm table-hover">
								<thead>
									<tr class="row">
										<th class="text-center col-sm-1">#</th>
										<th class="text-center col-sm-7">제목</th>
										<th class="text-center col-sm-2">작성자</th>
										<th class="text-center col-sm-2">작성일</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="notice" items="${view.list}" varStatus="status">
									<tr class="row">
										<td class="text-center col-sm-1"><span class="text-muted">${((view.page + 1) * view.pageSize) - (view.pageSize - status.index) + 1}</span></td>
										<td class="col-sm-7"><a href="${urlNoticeView}?noticeId=${notice.noticeId}&page=${view.page}&size=${view.pageSize}&sort=createDt,desc" class="notice-title"><span class="text-muted">${notice.title}</span></a></td>
										<td class="text-center col-sm-2"><span class="text-muted">${notice.userId}</span></td>
										<td class="text-center col-sm-2"><span class="text-muted">${notice.createDt}</span></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</c:when>
						<c:otherwise>
							<span class="text-muted">공지사항이 없습니다.</span>
						</c:otherwise>
					</c:choose>
 				</div>
			</div>
			<hr>
			<a href="#" id="insertBtn" class="btn btn-primary btn-sm" style="float: right;">글쓰기</a>
					
 			<div class="row justify-content-center align-items-center" style="margin-bottom: 20px;">
 				<div class="col-2">		
					<select id="search" name="search" class="form-control form-control-sm">
		 			<option value="title">제목</option>
		 			<option value="contents">내용</option>
		 			<option value="">제목+내용</option>
					</select>
				</div>
 				<div class="col-4">
					<input type="text" id="search_contents" name="search_contents" class="form-control form-control-sm"/>
				</div>
				<div class="col-sm-1">
					<a href="#" id="searchBtn" class="btn btn-primary btn-sm" style="float: right;">검색</a>
				</div>
			</div>
			
			<!-- Pagination -->
			<ul class="pagination justify-content-center">
				<li id="previous" class="page-item"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
			
				<c:forEach var="i" begin="${view.startPage}" step="1" end="${view.endPage}">
					<li class="page-item"><a class="page-link pagenum" href="${urlNoticeList}?page=${i - 1}&size=${view.pageSize}&sort=createDt,desc">${i}</a></li>
				</c:forEach>
				
				<li id="next" class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
			</ul>
		</div>
		<!-- /.container -->
	</div>
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>