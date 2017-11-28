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
		console.log(rJson);
	});
}