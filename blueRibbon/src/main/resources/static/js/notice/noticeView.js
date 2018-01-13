/**
 * 
 */

$(document).ready(function() {
	$('#updateBtn').on('click', function(e) {
		location.href = '/notice/update?noticeId=' + $('#noticeId').val() + '&page=' + $('#page').val() + '&size=' + $('#pageSize').val() + '&sort=createDt,desc';
	});
	
	$('#deleteBtn').on('click', function(e) {
		deleteNotice();
	});
	
	$('#listBtn').on('click', function(e) {
		history.back();
	});
});

function deleteNotice() {
	if(!confirm('정말 삭제하시겠습니까?')) {
		return;
	}
	
	var url = '/notice/deleteProc.json';
	var param = {
		noticeId: $('#noticeId').val()
	};
	
	$.post(url, param, function(rJson) {
		if(rJson.success == undefined) {
			alert('로그인이 필요합니다.');
			location.href = '/login/';
		} else {
			alert(rJson.msg);
			
			if(rJson.success) {
				location.href = rJson.url;
			}
		}
	});
}