document.getElementById("sButton").addEventListener("click", resolve);

function resolve(){
	let rid = document.getElementById("rid");
	let st = document.getElementById("stat");
	let cm = document.getElementById("comm");
	let xmlh = new XMLHttpRequest();
	if((xmlh.readyState == 4) & (xmlh.status == 200)){
		console.log(xmlh.responseText);
	}
	xmlh.open("POST", "http://localhost:8080/ProjectOne/Frontcontroller.ajax?rid=" + rid + "st=" + stat + "cm=" + comm);
	xmlh.send();
}