<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<c:url var="urlBlueRibbonPhotoList"		value="/multimedia/blueRibbonPhotoList" />
<c:url var="urlBlueRibbonPhotoView"		value="/multimedia/blueRibbonPhotoView" />

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
<script src="../js/multimedia/blueRibbonPhotoList.js"></script>

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
				<h4 class="mt-4 mb-3">
					학원사진
				</h4>
			</div>
			<hr>
 			<div class="row">
 				<c:choose>
					<c:when test="${fn:length(view.list) > 0}">
						<c:forEach var="multimedia" items="${view.list}" varStatus="status">
							<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
								<div class="card h-100">
									<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
									<div class="card-body">
										<h4 class="card-title">
											<a href="#">${multimedia.title}</a>
										</h4>
										<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<hr>
							학원사진이 없습니다.
						<hr>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- <hr> -->
			<div style="margin-top: 40px;">
				<a href="#" id="insertBtn" class="btn btn-primary btn-sm" style="float: right;">글쓰기</a>		
	 			<div class="row justify-content-center align-items-center" style="margin-bottom: 20px;">
	 				<div class="col-2">		
						<select id="search" name="search" class="form-control form-control-sm">
				 			<option value="title">제목</option>
				 			<option value="contents">내용</option>
				 			<option value="">제목+내용</option>
						</select>
					</div>
					<div class="col-sm-4">
	                	<input type="text" id="search_contents" class="form-control form-control-sm" value=""/>
	                </div>
	                <div>
	                	<span>
	                		<a href="#" id="searchBtn" class="btn btn-secondary btn-sm">검색</a>
	                	</span>
	              	</div>
				</div>
			</div>
			
			<!-- Pagination -->
			<ul class="pagination justify-content-center page-font">
				<li id="previous" class="page-item"><a class="page-link" href="#" aria-label="Previous"><span class="page-font" aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
			
				<c:forEach var="i" begin="${view.startPage}" step="1" end="${view.endPage}">
					<li class="page-item"><a class="page-link pagenum" href="${urlBlueRibbonPhotoList}?page=${i - 1}&size=${view.pageSize}&sort=createDt,desc"><span class="page-font" aria-hidden="true">${i}</span></a></li>
				</c:forEach>
				
				<li id="next" class="page-item"><a class="page-link" href="#" aria-label="Next"><span class="page-font" aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
			</ul>
		</div>
		<!-- /.container -->
	</div>
</body>
<jsp:include page="../common/footer.jsp" />