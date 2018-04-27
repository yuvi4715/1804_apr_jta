/**
 * 
 */
let employeesTable;
let requestsTable;
let tableBody = document.getElementById('employee-body');
let tableBody2 = document.getElementById('request-body');

function getInfo(){
	console.log("get my info");
	while (tableBody.firstChild) {
	    tableBody.removeChild(tableBody.firstChild);
	}
	employeesTable = document.getElementById('employee-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getInfo.do');
	xhr.send();
	xhr.onreadystatechange=()=>{
		if(xhr.readyState===4&&xhr.status===200){
			let requests = JSON.parse(xhr.responseText);
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

function getAllMyRequests(){
	console.log("getting an employee's requests");
	while (tableBody2.firstChild) {
	    tableBody2.removeChild(tableBody2.firstChild);
	}
	requestsTable = document.getElementById('request-table');
		let xhr = new XMLHttpRequest();
		xhr.open('POST', 'getAllMyRequests.do');
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
					
					
					let questDate = document.createElement('td');
					questDate.innerHTML=request.questDate;
					row.appendChild(questDate);
					
					let viewDate = document.createElement('td');
					viewDate.innerHTML=request.viewDate;
					row.appendChild(viewDate);
					
					let img = document.createElement('td');
					img.innerHTML=request.image;
					row.appendChild(img);
			        
			        tableBody2.appendChild(row);
				});
		}
	}
}