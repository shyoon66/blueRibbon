/**
 * 
 */

$(document).ready(function() {
	$('#summernote').summernote({
		lang: 'ko-KR',
		height: 300,
		minHeight: null,
		maxHeight: null,
		focus: false
	});
	
	$('#insertBtn').on('click', function(e) {
		valid();
	});
});

function valid() {
	if($('#title').val() == '') {
		alert('제목을 입력해 주세요.');
		return;
	}
	
	if($('#title').text().length > 100) {
		alert('제목은 100자 이하로 입력해 주세요.');
		return;
	}
	
	if($('#summernote').summernote('isEmpty')) {
		alert('내용을 입력해 주세요.');
		return;
	}
	
	if($('#summernote').summernote('code').length > 5000) {
		alert('내용은 5000자 이하로 입력해 주세요.');
		return;
	}
	
	insert();
}

function insert() {
	var url = '/notice/insertProc.json';
	var params = {
		title: $('#title').val(),
		contents: $('#summernote').summernote('code'),
		userId: $('#userId').val()
	};
	
	$.post(url, params, function(rJson) {
		console.log(rJson);
/*		if(rJson.success) {
			//alert('')
		}*/
	});
}