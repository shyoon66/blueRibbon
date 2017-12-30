<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/staticImport.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>수빅블루리본어학원</title>

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/modern-business.css" rel="stylesheet">
    
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../js/common/header.js"></script>
  </head>
  <body>
  	<input type="hidden" id="login_type" name="login_type" value="${login_type}" />
  	
	<!-- Navigation -->
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
	  <div class="container">
	    <a class="navbar-brand" href="/">수빅블루리본어학원</a>
	    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarResponsive">
	      <ul class="navbar-nav ml-auto">
	        <li class="nav-item">
	          <a class="nav-link" href="#">블루리본 소개</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownOnline" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	        	교육프로그램
	          </a>
	          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownOnline">
	            <a class="dropdown-item" href="#">교육프로그램</a>
	            <a class="dropdown-item" href="#">커리큘럼 및 강의 시간표</a>
	            <a class="dropdown-item" href="#">수준별 학습</a>
	          </div>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownOnline" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	        	연수신청 및 절차
	          </a>
	          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownOnline">
	            <a class="dropdown-item" href="#">연수비용</a>
	            <a class="dropdown-item" href="#">연수절차</a>
	            <a class="dropdown-item" href="#">연수규정</a>
	            <a class="dropdown-item" href="#">연수신청</a>
	          </div>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownOnline" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	        	온라인상담 및 연수신청
	          </a>
	          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownOnline">
	            <a class="dropdown-item" href="/notice/list?page=0&size=${pageSize}&sort=createDt,desc">공지사항</a>
	            <a class="dropdown-item" href="#">질의응답</a>
	            <a class="dropdown-item" href="#">모집일정</a>
	            <a class="dropdown-item" href="#">자주묻는 질문</a>
	          </div>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownOnline" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	        	사진/동영상
	          </a>
	          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownOnline">
	            <a class="dropdown-item" href="#">학원사진</a>
	            <a class="dropdown-item" href="#">원룸사진</a>
	            <a class="dropdown-item" href="#">수업사진</a>
	            <a class="dropdown-item" href="#">선생님사진</a>
	            <a class="dropdown-item" href="#">과외활동사진</a>
	            <a class="dropdown-item" href="#">캠프사진</a>
	          </div>
	        </li>
	        <li class="nav-item">
	        	<c:choose>
	        		<c:when test="${user eq null}">
	        			<a class="nav-link" href="/login/">로그인</a>
	        		</c:when>
	        		<c:otherwise>
	        			<a id="logout" class="nav-link" href="#">로그아웃</a>
	        		</c:otherwise>
	        	</c:choose>
	        	<c:if test="">
	          		
	          	</c:if>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	</body>
</html>