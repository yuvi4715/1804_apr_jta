$('document').ready(function(){
$('#home').click(function(){
	window.location.replace("/ers/html/user.html");
});
$('#requestBtn').click(function(){
		window.location.replace("/ers/html/history.html");
});
$('#logoutBtn').click(function(){
	$.ajax({
		url: '/ers/logout.do',
		type:'POST',
		success: function(){
			window.location.href= "/ers/html/home.html";
			alert("You have logged out");},
		error:  function(){
			window.location.href= "/ers/html/home.html";}
	});
});
});