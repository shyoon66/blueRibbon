/**
 * 
 */

$(document).ready(function() {
	$('#listBtn').on('click', function(e) {
		history.back();
	});
	
	$('#updateBtn').on('click', function(e) {
		location.href = '/notice/update?noticeId=' + $('#noticeId').val() + '&page=' + $('#page').val() + '&size=' + $('#pageSize').val() + '&sort=createDt,desc';
	});
});