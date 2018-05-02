/**
 * 
 */
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
var req = new XMLHttpRequest();
req.overrideMimeType("application/json");
req.open('GET', 'http://localhost:8080/Project_One/GETRECEIPTS?id=true', true);
req.onload  = function() {
   var jsonResponse = JSON.parse(req.responseText);
   var table = document.getElementById("myTableBody");
   
   var new_tbody = document.createElement('tbody');
  
   for(var i=0;i<jsonResponse.length;i++) {
		console.log(jsonResponse[i].employee);
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
		
		tableItem = document.createElement("td");                       
		t = document.createTextNode(jsonResponse[i].reimbursements.reimb_status);       
		tableItem.appendChild(t);
		tableRow.appendChild(tableItem);
		
		new_tbody.appendChild(tableRow);  		   

   }
   table.parentNode.replaceChild(new_tbody, table)
}

req.send(null);