window.onLoad = function(){
	document.getElementById("sButton").addEventListener("click", getUsername);
}

function getSomeText(){
	let em = document.getElementById("email");
	let pw = document.getElementById("pass");
	let fn = document.getElementById("fname");
	let ln = document.getElementById("lname");
	let xmlh = new XMLHttpRequest();
	if((xmlh.readyState == 4) & (xmlh.status == 200)){
		console.log(xmlh.responseText);
	}
	xmlh.open("POST", "http://localhost:8080/ProjectOne/Frontcontroller.ajax?em=" + em + "pw=" + pw + "fn=" + 
			fn + "ln=" + ln);
	xmlh.send();
}