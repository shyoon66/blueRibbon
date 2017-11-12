<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/staticImport.jsp" %>
<!DOCTYPE HTML>
<!--
	Minimaxing by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>공지사항</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="../assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="../assets/css/ie9.css" /><![endif]-->
		<style>
			.table4_11 table {
				width: 100%;
				margin: 15px 0;
				border: 0;
			}
			.table4_11 th {
				background-color: #1E90FF;
				color: #FFFFFF;
			}
			.table4_11,.table4_11 th,.table4_11 td {
				font-size: 0.95em;
				text-align: center;
				padding: 4px;
				border-collapse: collapse;
			}
			.table4_11 th,.table4_11 td {
				border: 1px solid #7ebffe;
				border-width: 1px 0 1px 0
			}
			.table4_11 tr {
				border: 1px solid #7ebffe;
			}
			.table4_11 tr:nth-child(odd) {
				background-color: #b4dafe;
			}
			.table4_11 tr:nth-child(even) {
				background-color: #fdfdfd;
			}
		</style>
	</head>
	<body>
		<jsp:include page="../common/header.jsp"></jsp:include>
		
		<div id="main">
			<div class="container">
				<div class="row main-row">
					<div class="12u">
						<section>
							<h2>공지사항</h2>
						</section>
					</div>
				</div>
				<div class="row main-row">
					<table class="table4_11">
						<tbody>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
							<tr>
								<td>SAMPLE</td><td>SAMPLE</td><td>SAMPLE</td>
							</tr>
							<tr>
								<td>SAMPLE</td><td>SAMPLE</td><td>SAMPLE</td>
							</tr>
								<tr>
								<td>SAMPLE</td><td>SAMPLE</td><td>SAMPLE</td>
							</tr>
							<tr>
								<td>SAMPLE</td><td>SAMPLE</td><td>SAMPLE</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- Scripts -->
		<script src="../assets/js/jquery.min.js"></script>
		<script src="../assets/js/skel.min.js"></script>
		<script src="../assets/js/skel-viewport.min.js"></script>
		<script src="../assets/js/util.js"></script>
		<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
		<script src="../assets/js/main.js"></script>
	</body>
</html>