/**
 * 
 */

window.onload=function(){
	document.getElementById("loginButton").addEventListener("click", loginUser)
	
}



function loginUser() {
	
	let user = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	let params = "username=" + user.value+"&password=" + password.value;
	let xmlh = new XMLHttpRequest();
	xmlh.onreadystatechange = function(){
		if ((xmlh.readystate == 4) & (xmlh.status==200)){
			console.log(xmlh.responseText);
		}
	};
	
	xmlh.open("POST", "http://localhost:8089/Project1/login.do");
	xmlh.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlh.send(params);
	
}