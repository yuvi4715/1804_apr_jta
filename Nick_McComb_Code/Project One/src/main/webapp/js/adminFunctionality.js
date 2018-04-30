document.getElementById("sButton").addEventListener("click", getPendingData);
document.getElementById("sButton2").addEventListener("click", getResolvedData);
document.getElementById("sButton3").addEventListener("click", getAllData);

function getPendingData(){
	let xmlh = new XMLHttpRequest();
	xmlh.onreadystatechange = function(){
		if((xmlh.readyState == 4) & (xmlh.status == 200)){
			document.getElementById("Requests").innerHTML = this.responseText;
		}
	};
	xmlh.open("POST", "http://localhost:8080/ProjectOne/allPendingRequests.do");
	xmlh.send();
}

function getResolvedData(){
	let xmlh = new XMLHttpRequest();
	xmlh.onreadystatechange = function(){
		if((xmlh.readyState == 4) & (xmlh.status == 200)){
			document.getElementById("Requests").innerHTML = this.responseText;
		}
	};
	xmlh.open("POST", "http://localhost:8080/ProjectOne/allResolvedRequests.do");
	xmlh.send();
}

function getAllData(){
	let xmlh = new XMLHttpRequest();
	xmlh.onreadystatechange = function(){
		if((xmlh.readyState == 4) & (xmlh.status == 200)){
			document.getElementById("Requests").innerHTML = this.responseText;
		}
	};
	xmlh.open("POST", "http://localhost:8080/ProjectOne/allRequests.do");
	xmlh.send();
}