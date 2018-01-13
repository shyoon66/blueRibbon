$(document).ready(function() {
	$('#logout').on('click', function() {
		logout();
	});
});

function logout() {
	var login_type = $('#login_type').val();
	
	if(login_type == 'kakao') {
		kakao_logout();
	}	
}

function kakao_logout() {
	location.href = '/logout/kakao';
}