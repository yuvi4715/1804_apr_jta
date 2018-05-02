/**
 * 
 */
function search() {
	let email = document.getElementById("myInput").value;
	var req = new XMLHttpRequest();
	req.overrideMimeType("application/json");
	req.open('GET', 'http://localhost:8080/Project_One/GetReimbursementsByEmployeeServlet?email='+email, true);
	req.onload = function() {
		var jsonResponse = JSON.parse(req.responseText);
		var table = document.getElementById("myTableBody");

		var new_tbody = document.createElement('tbody');
		if(jsonResponse.length){			
			populateTable(new_tbody,jsonResponse)
			
			table.parentNode.replaceChild(new_tbody, table);
		}
	}
	req.send(null);
	return false;
}

function getCookie(name) {
  var value = "; " + document.cookie;
  var parts = value.split("; " + name + "=");
  if (parts.length == 2) return parts.pop().split(";").shift();
}
window.onload = function(){
	console.log(document.cookie);
	let table = document.getElementById("mySpan");
	table.innerHTML = getCookie("name");
}
function updateReinbursement(status,rid){
	var req = new XMLHttpRequest();
	req.overrideMimeType("application/json");
	req.open('GET', 'http://localhost:8080/Project_One/ReimbursementRequestPost?reimb_status='+status+"&reimb_id="+rid, true);
	req.onload = function() {
		console.log("Update sucessfull")
	}
	req.send(null);
}
function populateTable(new_tbody,jsonResponse){
	new_tbody.setAttribute("id","myTableBody");
	for (var i = 0; i < jsonResponse.length; i++) {
		console.log(jsonResponse[i].reimbursements);
		let tableRow = document.createElement("tr");
		let tableItem = document.createElement("td");
		let t = document.createTextNode(jsonResponse[i].reimbursements.reimb_id);
		tableItem.appendChild(t);
		tableRow.appendChild(tableItem);

		tableItem = document.createElement("td");
		t = document.createTextNode(jsonResponse[i].reimbursements.reimb_request);
		tableItem.appendChild(t);
		tableRow.appendChild(tableItem);

		tableItem = document.createElement("td");
		t = document.createTextNode(jsonResponse[i].reimbursements.reimb_review);
		tableItem.appendChild(t);
		tableRow.appendChild(tableItem);

		tableItem = document.createElement("td");
		t = document.createTextNode(jsonResponse[i].reimbursements.reimb_purpose);
		tableItem.appendChild(t);
		tableRow.appendChild(tableItem);

		tableItem = document.createElement("td");
		t = document.createTextNode(jsonResponse[i].reimbursements.reimb_amount);
		tableItem.appendChild(t);
		tableRow.appendChild(tableItem);

		let tableItemStatus = document.createElement("td");
		t = document.createTextNode(jsonResponse[i].reimbursements.reimb_status);
		tableItemStatus.appendChild(t);
		tableRow.appendChild(tableItemStatus);

		tableItem = document.createElement("td");
		let tableButton = document.createElement("button");
		t = document.createTextNode("Approve");
		tableButton.appendChild(t);
		tableButton.onclick = function() {
			let status = tableItemStatus;
			let reinbursement = jsonResponse[i].reimbursements; //Closure captures the Array's values inside the function
			return function() {
				status.innerHTML="Approved";
				console.log(reinbursement)
				updateReinbursement("Approved",reinbursement.reimb_id);
			}
		}() //Closure
		tableItem.appendChild(tableButton);
		tableRow.appendChild(tableItem);

		tableItem = document.createElement("td");
		tableButton = document.createElement("button");
		t = document.createTextNode("Deny");
		tableButton.appendChild(t);
		tableButton.onclick = function() {
			let status = tableItemStatus;
			let reinbursement = jsonResponse[i].reimbursements; //Closure captures the Array's values inside the function
			return function() {
				status.innerHTML="Denied";
				console.log(reinbursement)
				updateReinbursement("Denied",reinbursement.reimb_id);
			}
		}() //Closure
		tableItem.appendChild(tableButton);
		tableRow.appendChild(tableItem);
		
		new_tbody.appendChild(tableRow);
	}
}
var req = new XMLHttpRequest();
req.overrideMimeType("application/json");
req.open('GET', 'http://localhost:8080/Project_One/GETRECEIPTS', true);
req.onload = function() {
	var jsonResponse = JSON.parse(req.responseText);
	var table = document.getElementById("myTableBody");

	var new_tbody = document.createElement('tbody');

	populateTable(new_tbody,jsonResponse)

	table.parentNode.replaceChild(new_tbody, table);
}

req.send(null);
console.log(document.cookie);