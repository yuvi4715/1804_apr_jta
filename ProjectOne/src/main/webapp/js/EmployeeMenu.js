/**
 * 
 */
window.onload=function(){
	if (getCookie("position") != "employee"){
		window.alert("You are not authorized to view this page");
		window.location.replace("login.html");
	}
	viewInformation();
	console.log("Employee Menu is here!");
	document.getElementById("getAllRequests").addEventListener("click", getRequests);
	document.getElementById("allResolvedRequests").addEventListener("click", getResolvedRequest);
	document.getElementById("updateInfoButton").addEventListener("click", updateInfo);
	
	document.getElementById("submitRequest").addEventListener("click", submitRequest);
	document.getElementById("logOutButton").addEventListener("click", logOut);
}

let table1 = document.getElementById("requestTable");

function cleanTable() {
	var rowcount = table1.rows.length;
	for(var i = rowcount - 1; i > 0; i--){
		table1.deleteRow(i);
	}
}

function submitRequest(){
	let rA = document.getElementById("amountBox").value;
	let rY = document.getElementById("purposeBox").value;
	let rE= getCookie("email");
	let params = "email="+rE+"&amount="+rA+"&purpose="+rY;
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if ((this.readyState == 4) & (this.status==200)){
	
			if (this.responseText != "null"){
				window.alert("request successfully submitted");
				getRequests();
				
			} else{
				window.alert("request was not submitted");
			}
		}
	}
	xhr.open("POST", "http://localhost:8089/ProjectOne/submit.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
	let x = document.getElementById("amountBox").value="";
	let y = document.getElementById("purposeBox").value="";
}

function getRequests() {
	document.getElementById("mainheader").textContent="All of your requests";
	cleanTable();
	let params = "email="+getCookie("email");
	document.getElementById("col1").textContent="Amount Requested";
	document.getElementById("col2").textContent="Your Email";
	document.getElementById("col3").textContent="Reviewed By";
	document.getElementById("col4").textContent="Status";
	document.getElementById("col5").textContent="Purpose";
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if ((this.readyState == 4) & (this.status==200)){
	
			if (this.responseText != "null"){
				let ors = JSON.parse(this.responseText);

				ors.forEach(request => {
				
				let row = document.createElement('tr');
				
				let cell1 = document.createElement('td');
				let cell2 = document.createElement('td');
				let cell3 = document.createElement('td');
				let cell4 = document.createElement('td');
				let cell5 = document.createElement('td');
				
				
				cell1.innerHTML = request.requestAmount;
				cell2.innerHTML = request.requester;
				cell3.innerHTML = request.reviewedBy;
				cell4.innerHTML = request.status;
				cell5.innerHTML = request.purpose;
				
				row.appendChild(cell1);
				row.appendChild(cell2);
				row.appendChild(cell3);
				row.appendChild(cell4);
				row.appendChild(cell5);

				table1.appendChild(row);
				});
				
			}
		}
		
	};
	xhr.open("POST", "http://localhost:8089/ProjectOne/pending.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
}


function viewInformation(){
	document.getElementById("infoName").textContent=getCookie("firstName")+" "+getCookie("lastName");
	document.getElementById("infoEmail").textContent=getCookie("email");
	document.getElementById("infoUsername").textContent=getCookie("username");
	
}

function getResolvedRequest(){
	document.getElementById("mainheader").textContent="All of your resolved Requests";
	cleanTable();
	let params = "email=test@gmail.com";
	document.getElementById("col1").textContent="Amount Requested";
	document.getElementById("col2").textContent="Your Email";
	document.getElementById("col3").textContent="Reviewed By";
	document.getElementById("col4").textContent="Status";
	document.getElementById("col5").textContent="Purpose";
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if ((this.readyState == 4) & (this.status==200)){
			if (this.responseText != "null"){
				let ors = JSON.parse(this.responseText);
				ors.forEach(request => {
				
				let row = document.createElement('tr');
				
				let cell1 = document.createElement('td');
				let cell2 = document.createElement('td');
				let cell3 = document.createElement('td');
				let cell4 = document.createElement('td');
				let cell5 = document.createElement('td');
				
				
				cell1.innerHTML = request.requestAmount;
				cell2.innerHTML = request.requester;
				cell3.innerHTML = request.reviewedBy;
				cell4.innerHTML = request.status;
				cell5.innerHTML = request.purpose;
				
				row.appendChild(cell1);
				row.appendChild(cell2);
				row.appendChild(cell3);
				row.appendChild(cell4);
				row.appendChild(cell5);

				table1.appendChild(row);
				});
				
			}
		}
		
	};
	xhr.open("POST", "http://localhost:8089/ProjectOne/myResolved.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
}


function getCookie(username) {
    var name = username + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function updateInfo(){
	let f = document.getElementById("firstNameBox").value;
	let l = document.getElementById("lastNameBox").value;
	let p = document.getElementById("passwordBox").value;
	console.log(l);
	let e = getCookie("email");
	let params = "email="+e+"&firstName="+f+"&lastName="+l+"&password="+p;
	console.log(params);
	if (f == null || l == null || p == null) {
		window.alert("You must fill out all 3 boxes to update your information");
	} else {
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if ((this.readyState == 4) & (this.status==200)){
				if (this.responseText != "null"){
					window.alert("Success");
					document.cookie = "firstName="+f;
					document.cookie = "lastName="+l;
					document.cookie = "password="+p;
					viewInformation();
				} else {
					console.log("update failed");
					
				}
			}
		};
		
		xhr.open("POST", "http://localhost:8089/ProjectOne/update.do");
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(params);
	}
}

function logOut() {
	document.cookie = "email=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	document.cookie = "firstName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	document.cookie = "lastName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	document.cookie = "position=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	window.location.replace("login.html");
}