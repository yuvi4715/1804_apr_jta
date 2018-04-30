 window.onload = getInfo;
 console.log("Hello");
	
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
	xhr.open('POST', "EmployeeHomeRequest.do");
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