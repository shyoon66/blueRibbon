/**
 * 
 */

$(document).ready(function() {
	$('#summernote').summernote({
		lang: 'ko-KR',
		height: 300,
		minHeight: 350,
		maxHeight: null,
		dialogsFade: true,
		focus: true,
		callbacks: {
			onImageUpload: function(files, editor, welEditable) {
				for(var i = files.length - 1; i >= 0; i--) {
					var type = files[i].type;
					var name = files[i].name;
					var extension = name.substr(name.lastIndexOf('.') + 1, name.length - 1);
					var size = files[i].size;
					
					if(validImage(type, extension, size)) {
						uploadImage(files[i], this);
					}
				}
			}
		}
	});
	
	$('#insertBtn').on('click', function(e) {
		valid();
	});
});

function validImage(type, extension, size) {
	if(type.indexOf('image') < 0) {
		alert('사진파일만 업로드 가능합니다.');
		return false;
	}
	
	if(extension != 'png' && extension != 'jpg' && extension != 'gif') {
		alert('확장자가 png, jpg, gif인 파일만 업로드 가능합니다.');
		return false;
	}
	
	if((size / 1024 / 1024) > 20) {
		alert('업로드는 20MB까지 가능합니다.');
		return false;
	}
	
	return true;
}

function uploadImage(file, el) {
    var form_data = new FormData();
    form_data.append('file', file);
    form_data.append('noticeId', 0);
    
	$.ajax({
		data: form_data,
		type: 'POST',
		url: '/notice/uploadImage',
		cache: false,
		contentType: false,
		enctype: 'multipart/form-data',
		processData: false,
		success: function(url) {
	        $(el).summernote('editor.insertImage', url);
	        $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');		
		}
	});
}

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