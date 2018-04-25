window.onload = function() {
	document.getElementById("submitButton").addEventListener("click",
			getUserName);
	document.getElementById("clickHere").addEventListener("click",
			anotherFunction);
}

function getUserName() {
	let user = document.getElementById("username");
	console.log(user);
	let disUser = document.getElementById("displayUser");
	let xmlh = new XMLHttpRequest();
	if ((xmlh.readyState == 4) & (xmlh.status == 200)) {
		console.log(xmlh.responseText);
	}
	xmlh.open("GET",
			"http://localhost:1234/1804_front_controller/display.ajax?user="
					+ user);
	xmlh.send();
}

function anotherFunction(){
	let user = document.getElementById("username2");
	console.log(user);
	let disUser = document.getElementById("displayUser");
	let xmlh = new XMLHttpRequest();
	if ((xmlh.readyState == 4) & (xmlh.status == 200)) {
		console.log(xmlh.responseText);
	}
	xmlh.open("GET",
			"http://localhost:1234/1804_front_controller/display.ajax?user="
					+ user);
	xmlh.send();
}