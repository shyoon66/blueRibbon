<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/staticImport.jsp" %>

<jsp:include page="../common/header.jsp" />

<body>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			공지사항
			<!-- <small>Subheading</small> -->
		</h1>

		<!--       <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Portfolio 1</li>
      </ol> -->

		<hr>

		<c:choose>
			<c:when test="${fn:length(list) > 0}">
				<c:forEach items="${list}" var="notice">
					<div class="row">
	<!-- 					<div class="col-md-7">
							<a href="#"> <img class="img-fluid rounded mb-3 mb-md-0"
								src="http://placehold.it/700x300" alt="">
							</a>
						</div> -->
						<div class="col-md-12">
							<h3>${notice.title}</h3>
							<p>${notice.contents}</p>
<!-- 							<a class="btn btn-primary" href="#">View Project <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a> -->
						</div>
					</div>
					<!-- /.row -->
	
					<hr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				공지사항이 없습니다.
			</c:otherwise>
		</c:choose>

				<!-- Pagination -->
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2017</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>