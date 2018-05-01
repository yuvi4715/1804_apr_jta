window.onload=function(){
	if (getCookie("position") != "manager"){
		window.alert("You are not authorized to view this page");
		window.location.replace("login.html");
	}
	populateWithEmployees();
	document.getElementById("populateEmployees").addEventListener("click", populateWithEmployees);
	document.getElementById("populateAllRequests").addEventListener("click", populateWithRequests);
	document.getElementById("allPendingButton").addEventListener("click", getAllPendingRequests);
	document.getElementById("allApprovedButton").addEventListener("click", getAllApprovedRequests);
	document.getElementById("logOutButton").addEventListener("click", logOut);

}
let table1 = document.getElementById("employeeTable");
let approveButton = document.createElement("button");
let requestEmailButton = document.createElement("button");
let space1 = document.createElement('br');
let space2 = document.createElement('br');
let div = document.createElement("section");

let emailInput = document.createElement('input');
let amountInput = document.createElement('input');
let requesterInput = document.createElement('input');
let requestResponse = document.createElement('input');
let pendingEmail = document.createElement("input");

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

function cleanTable() {
	var rowcount = table1.rows.length;
	for(var i = rowcount - 1; i > 0; i--){
		table1.deleteRow(i);
	}
	
	approveButton.remove();
	requestEmailButton.remove();
	emailInput.remove();
	amountInput.remove();
	requesterInput.remove();
	requestResponse.remove();
	div.remove();
	space1.remove();
	space2.remove();
}

function populateWithEmployees() {
	cleanTable();
	document.getElementById("mainheader").textContent="All Employees";
	document.getElementById("col1").textContent="Email";
	document.getElementById("col2").textContent="First Name";
	document.getElementById("col3").textContent="Last Name";
	document.getElementById("col4").textContent="Username";
	document.getElementById("col5").textContent="Position";
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if ((this.readyState == 4) & (this.status==200)){
			//console.log(xhr.responseText);
			if (this.responseText != "null"){
				let ors = JSON.parse(this.responseText);
				console.log(ors);
				ors.forEach(request => {
				
				let row = document.createElement('tr');
				
				let cell1 = document.createElement('td');
				let cell2 = document.createElement('td');
				let cell3 = document.createElement('td');
				let cell4 = document.createElement('td');
				let cell5 = document.createElement('td');
				
				cell1.innerHTML = request.email;
				cell2.innerHTML = request.firstName;
				cell3.innerHTML = request.lastName;
				cell4.innerHTML = request.userName;
				cell5.innerHTML = request.position;
				
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
	xhr.open("POST", "http://localhost:8089/ProjectOne/showAllUsers.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();
}

function populateWithRequests() {
	document.getElementById("mainheader").textContent="All Employee requests";
	cleanTable();
	document.getElementById("col1").textContent="Amount Requested";
	document.getElementById("col2").textContent="Employee Email";
	document.getElementById("col3").textContent="Reviewed By";
	document.getElementById("col4").textContent="Status";
	document.getElementById("col5").textContent="Purpose";
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("onready state change called");
		if ((this.readyState == 4) & (this.status==200)){
			console.log(xhr.responseText);
			if (this.responseText != "null"){
				let ors = JSON.parse(this.responseText);
				console.log(ors);
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
	xhr.open("POST", "http://localhost:8089/ProjectOne/allRequests.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();
	
}

function getAllPendingRequests(){
	document.getElementById("mainheader").textContent="Pending Requests";
	cleanTable();
	document.getElementById("col1").textContent="Amount Requested";
	document.getElementById("col2").textContent="Employee Email";
	document.getElementById("col3").textContent="Reviewed By";
	document.getElementById("col4").textContent="Status";
	document.getElementById("col5").textContent="Purpose";
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if ((this.readyState == 4) & (this.status==200)){
			//console.log(xhr.responseText);
			if (this.responseText != "null"){
				let ors = JSON.parse(this.responseText);
				console.log(ors);
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
				
				
				
				var body = document.getElementsByTagName("body")[0];
				
				body.appendChild(space1)
	
				body.appendChild(emailInput);
				emailInput.type="text";
				emailInput.Name="Your email";
				emailInput.textContent="email";
				emailInput.value=(getCookie("email"));
				emailInput.disabled=true;
				
				
				body.appendChild(amountInput);
				amountInput.type="text";
				amountInput.placeholder="Enter the request amount";
				
				body.appendChild(requesterInput);
				requesterInput.type="text";
				requesterInput.placeholder="Enter the requesters email.";
				
				body.appendChild(requestResponse);
				requestResponse.type="text";
				requestResponse.placeholder="Enter your response to the request.";
				
				body.appendChild(approveButton);
				approveButton.addEventListener ("click", approveRequest);
				approveButton.textContent="Respond to request";
				
				body.appendChild(div);
				
				div.appendChild(space2);
				
				div.appendChild(pendingEmail);
				pendingEmail.placeholder="Enter employees";
				pendingEmail.responsetype="text";
				
				div.appendChild(requestEmailButton);
				requestEmailButton.addEventListener("click", getEmployeeRequests);
				requestEmailButton.textContent="Get Employee Requests";
				
			}
		}	
	};
	xhr.open("POST", "http://localhost:8089/ProjectOne/allPending.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();
}

function approveRequest(){
	
	console.log(emailInput.value);
	var email = emailInput.value;
	var amount = amountInput.value;
	var requester =requesterInput.value;
	var response= requestResponse.value;
	let params = "email="+email+"&amount=" + amount+"&requester="+requester+"&response="+response;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if ((this.readyState == 4) & (this.status==200)){
			console.log(xhr.responseText);
			if (this.responseText != "false"){
				console.log("approvale succeded");
				getAllPendingRequests();
				
				
			} else {
				console.log("approval failed");
				
			}
		}
	};
	
	xhr.open("POST", "http://localhost:8089/ProjectOne/respondToRequest.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
	
}

function getAllApprovedRequests() {
	cleanTable();
	document.getElementById("mainheader").textContent="All resolved requests";
	document.getElementById("col1").textContent="Amount Requested";
	document.getElementById("col2").textContent="Employee Email";
	document.getElementById("col3").textContent="Reviewed By";
	document.getElementById("col4").textContent="Status";
	document.getElementById("col5").textContent="Purpose";
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("onready state change called");
		if ((this.readyState == 4) & (this.status==200)){
			console.log(xhr.responseText);
			if (this.responseText != "null"){
				let ors = JSON.parse(this.responseText);
				console.log(ors);
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
	xhr.open("POST", "http://localhost:8089/ProjectOne/allResolved.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();
}

function getEmployeeRequests(){
	console.log("getting employee requests");
	let params = "email="+pendingEmail.value;
	cleanTable();
	document.getElementById("mainheader").textContent="PendingRequests from: "+ pendingEmail.value;
	document.getElementById("col1").textContent="Amount Requested";
	document.getElementById("col2").textContent="Employee Email";
	document.getElementById("col3").textContent="Reviewed By";
	document.getElementById("col4").textContent="Status";
	document.getElementById("col5").textContent="Purpose";
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("onready state change called");
		if ((this.readyState == 4) & (this.status==200)){
			console.log(xhr.responseText);
			if (this.responseText != "null"){
				let ors = JSON.parse(this.responseText);
				console.log(ors);
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
				var body = document.getElementsByTagName("body")[0];
				
				body.appendChild(emailInput);
				emailInput.type="text";
				emailInput.Name="Your email";
				emailInput.textContent="email";
				emailInput.value=getCookie("email");
				emailInput.disabled=true;
				
				
				body.appendChild(amountInput);
				amountInput.type="text";
				amountInput.placeholder="Enter the request amount";
				
				body.appendChild(requesterInput);
				requesterInput.type="text";
				requesterInput.placeholder="Enter the requesters email.";
				
				body.appendChild(requestResponse);
				requestResponse.type="text";
				requestResponse.placeholder="Enter your response to the request.";
				
				body.appendChild(approveButton);
				approveButton.addEventListener ("click", approveRequest);
				approveButton.textContent="Respond to request";
				});
				
			}
		}
		
	};
	xhr.open("POST", "http://localhost:8089/ProjectOne/pending.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
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