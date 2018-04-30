window.onLoad = function(){
	document.getElementById("sButton").addEventListener("click", getUsername);
}

function sendDetails(){
	let em = document.getElementById("sum");
	let pw = document.getElementById("reason");
	let xmlh = new XMLHttpRequest();
	if((xmlh.readyState == 4) & (xmlh.status == 200)){
		console.log(xmlh.responseText);
	}
	xmlh.open("POST", "http://localhost:8080/ProjectOne/Frontcontroller.ajax?sum=" + sum + "reason=" + reason);
	xmlh.send();
}