<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlNoticeList" 		value="/notice/list" />
<c:url var="urlNoticeView" 		value="/notice/view" />

<jsp:include page="../common/header.jsp" />

<style>
	.cursor {
		cursor: default;
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
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<h2 class="mt-4 mb-3">
			공지사항
		</h2>
		<hr>
		
		<div class="row">
			<div class="col-md-12">
				<c:choose>
					<c:when test="${fn:length(view.list) > 0}">
						<div class="container table-responsive">
							<table class="table table-sm table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="notice" items="${view.list}" varStatus="status">
									<tr>
										<td>${((view.page + 1) * view.pageSize) - (view.pageSize - status.index) + 1}</td>
										<td><a href="${urlNoticeView}?noticeId=${notice.noticeId}&page=${view.page}&size=${view.pageSize}&sort=createDt,desc">${notice.title}</a></td>
										<td>${notice.userId}</td>
										<td>${notice.createDt}</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</c:when>
 					<c:otherwise>
						공지사항이 없습니다.
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<hr>

		<!-- Pagination -->
		<ul class="pagination justify-content-center">
			<li id="previous" class="page-item"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
		
			<c:forEach var="i" begin="${view.startPage}" step="1" end="${view.endPage}">
				<li class="page-item"><a class="page-link pagenum" href="${urlNoticeList}?page=${i - 1}&size=${view.pageSize}&sort=createDt,desc">${i}</a></li>
			</c:forEach>
			
			<li id="next" class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
		</ul>
		
		<div class="row">
			<a href="#" id="insertBtn" class="btn btn-primary">글쓰기</a>
		</div>
	</div>
	<!-- /.container -->
	
	<jsp:include page="../common/footer.jsp" />
</body>
</html>