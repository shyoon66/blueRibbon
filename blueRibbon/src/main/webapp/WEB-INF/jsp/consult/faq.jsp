<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/staticImport.jsp" %>

<jsp:include page="../common/header.jsp" />

<link href="../css/sticky-footer-navbar.css" rel="stylesheet">

<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<body>

  <!-- Page Content -->
  <div id="wrap">
	  <div id="main" class="container">
		<div>
			<!-- Page Heading/Breadcrumbs -->
			<h2 class="mt-4 mb-3">
				자주 묻는 질문
			</h2>
		</div>
	    <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
	      <div class="card">
	        <div class="card-header" role="tab" id="headingOne">
	          <h5 class="mb-0">
	            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">Collapsible Group Item #1</a>
	          </h5>
	        </div>
	
	        <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
	          <div class="card-body">
	            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	          </div>
	        </div>
	      </div>
	      <div class="card">
	        <div class="card-header" role="tab" id="headingTwo">
	          <h5 class="mb-0">
	            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">Collapsible Group Item #2
	            </a>
	          </h5>
	        </div>
	        <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
	          <div class="card-body">
	            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	          </div>
	        </div>
	      </div>
	      <div class="card">
	        <div class="card-header" role="tab" id="headingThree">
	          <h5 class="mb-0">
	            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">Collapsible Group Item #3</a>
	          </h5>
	        </div>
	        <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree">
	          <div class="card-body">
	            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
  </div>
  <!-- /.container -->
</body>
<jsp:include page="../common/footer.jsp" />