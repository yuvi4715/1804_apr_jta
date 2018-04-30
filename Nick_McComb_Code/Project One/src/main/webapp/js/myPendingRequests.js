document.getElementById("sButton").addEventListener("click", getPendingData);
document.getElementById("sButton2").addEventListener("click", getResolvedData);

function getPendingData(){
	let xmlh = new XMLHttpRequest();
	xmlh.onreadystatechange = function(){
		if((xmlh.readyState == 4) & (xmlh.status == 200)){
			document.getElementById("Requests").innerHTML = this.responseText;
		}
	};
	xmlh.open("POST", "http://localhost:8080/ProjectOne/pendingRequests.do");
	xmlh.send();
}

function getResolvedData(){
	let xmlh = new XMLHttpRequest();
	xmlh.onreadystatechange = function(){
		if((xmlh.readyState == 4) & (xmlh.status == 200)){
			document.getElementById("Requests").innerHTML = this.responseText;
		}
	};
	xmlh.open("POST", "http://localhost:8080/ProjectOne/resolvedRequests.do");
	xmlh.send();
}