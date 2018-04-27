/**
 * 
 */

let employeesTable;
let requestsTable;
let tableBody = document.getElementById('employee-body');
let tableBody2 = document.getElementById('request-body');
function getInfo(){
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getInfo.do');
	xhr.send();
	xhr.onreadystatechange=()=>{
		if(xhr.readyState===4&&xhr.status===200){
			let requests = JSON.parse(xhr.responseText);
			console.log(requests);
		}
	}
}

function getAllEmployees(){
	console.log("gettign all employees");
	while (tableBody.firstChild) {
	    tableBody.removeChild(tableBody.firstChild);
	}
	employeesTable = document.getElementById('employee-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getAllEmployees.do');
	xhr.send();
	xhr.onreadystatechange=()=>{
		if(xhr.readyState===4&&xhr.status===200){
			console.log('before parse' + xhr.responseText)
			let requests = JSON.parse(xhr.responseText);
			console.log('after parse' + requests);
			console.log('is array' + Array.isArray(requests));
			requests.forEach(request=>{
				let row =document.createElement('tr');
				
				let idCell = document.createElement('td');
				idCell.innerHTML=request.empId;
				row.appendChild(idCell);
				
				let fName = document.createElement('td');
				fName.innerHTML=request.firstName;
				row.appendChild(fName);
				
				let lName = document.createElement('td');
				lName.innerHTML=request.lastName;
				row.appendChild(lName);
				
				let uName = document.createElement('td');
				uName.innerHTML=request.username;
				row.appendChild(uName);
				
				let pass = document.createElement('td');
				pass.innerHTML=request.password;
				row.appendChild(pass);
				
				let email = document.createElement('td');
				email.innerHTML=request.email;
				row.appendChild(email);
				
				let empRole = document.createElement('td');
				empRole.innerHTML=request.empRole;
				row.appendChild(empRole);
				
		        
		        tableBody.appendChild(row);
			});
		}
	}
}

function getAllRequests(){
	console.log("gettign all requests");
	while (tableBody2.firstChild) {
	    tableBody2.removeChild(tableBody2.firstChild);
	}
	requestsTable = document.getElementById('request-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getRequests.do');
	xhr.send();
	xhr.onreadystatechange=()=>{
		if(xhr.readyState===4&&xhr.status===200){
			let requests = JSON.parse(xhr.responseText);
			requests.forEach(request=>{
				let row =document.createElement('tr');
				
				let idCell = document.createElement('td');
				idCell.innerHTML=request.requestId;
				row.appendChild(idCell);
				
				let amm = document.createElement('td');
				amm.innerHTML=request.ammount;
				row.appendChild(amm);
				
				let quester = document.createElement('td');
				quester.innerHTML=request.requester;
				row.appendChild(quester);
				
				let by = document.createElement('td');
				by.innerHTML=request.reviewedBy;
				row.appendChild(by);
				
				let stat = document.createElement('td');
				stat.innerHTML=request.status;
				row.appendChild(stat);
				
				let purp = document.createElement('td');
				purp.innerHTML=request.purpose;
				row.appendChild(purp);
				
				let img = document.createElement('td');
				img.innerHTML=request.image;
				row.appendChild(img);
				
				let questDate = document.createElement('td');
				questdate.innerHTML=request.requestDate;
				row.appendChild(questDate);
				
				let viewDate = document.createElement('td');
				viewDate.innerHTML=request.reviewDate;
				row.appendChild(viewDate);
				
		        
		        tableBody.appendChild(row);
			});
		}
	}
}

function getAllResolved(){
	console.log("getting resolved requests");
	while (tableBody2.firstChild) {
	    tableBody2.removeChild(tableBody2.firstChild);
	}
	requestsTable = document.getElementById('request-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getResolvedRequests.do');
	xhr.send();
	xhr.onreadystatechange=()=>{
		if(xhr.readyState===4&&xhr.status===200){
			let requests = JSON.parse(xhr.responseText);
			requests.forEach(request=>{
				let row =document.createElement('tr');
				
				let idCell = document.createElement('td');
				idCell.innerHTML=request.requestId;
				row.appendChild(idCell);
				
				let amm = document.createElement('td');
				amm.innerHTML=request.ammount;
				row.appendChild(amm);
				
				let quester = document.createElement('td');
				quester.innerHTML=request.requester;
				row.appendChild(quester);
				
				let by = document.createElement('td');
				by.innerHTML=request.reviewedBy;
				row.appendChild(by);
				
				let stat = document.createElement('td');
				stat.innerHTML=request.status;
				row.appendChild(stat);
				
				let purp = document.createElement('td');
				purp.innerHTML=request.purpose;
				row.appendChild(purp);
				
				let img = document.createElement('td');
				img.innerHTML=request.image;
				row.appendChild(img);
				
				let questDate = document.createElement('td');
				questdate.innerHTML=request.requestDate;
				row.appendChild(questDate);
				
				let viewDate = document.createElement('td');
				viewDate.innerHTML=request.reviewDate;
				row.appendChild(viewDate);
				
		        
		        tableBody.appendChild(row);
			});
		}
	}
}
function getAllPending(){
	console.log("getting resolved requests");
	while (tableBody2.firstChild) {
	    tableBody2.removeChild(tableBody2.firstChild);
	}
	requestsTable = document.getElementById('request-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getUnresolvedRequests.do');
	xhr.send();
	xhr.onreadystatechange=()=>{
		if(xhr.readyState===4&&xhr.status===200){
			let requests = JSON.parse(xhr.responseText);
			requests.forEach(request=>{
				let row =document.createElement('tr');
				
				let idCell = document.createElement('td');
				idCell.innerHTML=request.requestId;
				row.appendChild(idCell);
				
				let amm = document.createElement('td');
				amm.innerHTML=request.ammount;
				row.appendChild(amm);
				
				let quester = document.createElement('td');
				quester.innerHTML=request.requester;
				row.appendChild(quester);
				
				let by = document.createElement('td');
				by.innerHTML=request.reviewedBy;
				row.appendChild(by);
				
				let stat = document.createElement('td');
				stat.innerHTML=request.status;
				row.appendChild(stat);
				
				let purp = document.createElement('td');
				purp.innerHTML=request.purpose;
				row.appendChild(purp);
				
				let img = document.createElement('td');
				img.innerHTML=request.image;
				row.appendChild(img);
				
				let questDate = document.createElement('td');
				questdate.innerHTML=request.requestDate;
				row.appendChild(questDate);
				
				let viewDate = document.createElement('td');
				viewDate.innerHTML=request.reviewDate;
				row.appendChild(viewDate);
				
		        
		        tableBody.appendChild(row);
			});
		}
	}
}