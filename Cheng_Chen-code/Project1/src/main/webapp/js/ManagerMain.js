//Javascript source code
let requestsTable;
let employeesTable;

let tableBody = document.getElementById('request-body');
let tableBody2 = document.getElementById('employee-body');

function getAllEmployees()
{
	console.log("getting all employees");
	while (tableBody2.firstChild) 
	{
	    tableBody2.removeChild(tableBody2.firstChild);
	}
	employeesTable = document.getElementById('employee-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getAllEmployees.do');
	xhr.send();
	xhr.onreadystatechange=()=>
	{
		if(xhr.readyState===4&&xhr.status===200)
		{
			let requests = JSON.parse(xhr.responseText);
			requests.forEach(request=>
			{
				let row =document.createElement('tr');
				
				let fName = document.createElement('td');
				fName.innerHTML=request.name;
				row.appendChild(fName);
				
				let email = document.createElement('td');
				email.innerHTML=request.email;
				row.appendChild(email);
		        
				tableBody2.appendChild(row);
			});
		}
	}
}

function getAllRequests()
{
	console.log("getting all requests");
	while (tableBody.firstChild) 
	{
	    tableBody.removeChild(tableBody.firstChild);
	}
	requestsTable = document.getElementById('request-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getAllRequests.do');
	xhr.send();
	xhr.onreadystatechange=()=>
	{
		if(xhr.readyState===4&&xhr.status===200)
		{
			let requests = JSON.parse(xhr.responseText);
			requests.forEach(Reimbursement=>
			{
				let row = document.createElement('tr');

                let idCell = document.createElement('td');
                idCell.innerHTML = Reimbursement.id;
                row.appendChild(idCell);

                let quester = document.createElement('td');
                quester.innerHTML = Reimbursement.email;
                row.appendChild(quester);
                
                let amm = document.createElement('td');
                amm.innerHTML = Reimbursement.amount;
                row.appendChild(amm);
                
                let purp = document.createElement('td');
                purp.innerHTML = Reimbursement.purpose;
                row.appendChild(purp);

                let stat = document.createElement('td');
                stat.innerHTML = Reimbursement.status;
                row.appendChild(stat);
          
                let by = document.createElement('td');
                by.innerHTML = Reimbursement.manager;
                row.appendChild(by);

                let questDate = document.createElement('td');
                questDate.innerHTML = Reimbursement.requestDate;
                row.appendChild(questDate);

                let viewDate = document.createElement('td');
                viewDate.innerHTML = Reimbursement.approvedDate;
                row.appendChild(viewDate);

                let img = document.createElement('td');
                img.innerHTML = Reimbursement.image;
                row.appendChild(img);

                tableBody.appendChild(row);
			});
		}
	}
}

function getAllResolved()
{
	console.log("getting resolved requests");
	while (tableBody.firstChild) 
	{
	    tableBody.removeChild(tableBody.firstChild);
	}
	requestsTable = document.getElementById('request-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getResolvedRequests.do');
	xhr.send();
	xhr.onreadystatechange=()=>
	{
		if(xhr.readyState===4&&xhr.status===200)
		{
			let requests = JSON.parse(xhr.responseText);
			requests.forEach(Reimbursement=>
			{
				let row = document.createElement('tr');

                let idCell = document.createElement('td');
                idCell.innerHTML = Reimbursement.id;
                row.appendChild(idCell);

                let quester = document.createElement('td');
                quester.innerHTML = Reimbursement.email;
                row.appendChild(quester);
                
                let amm = document.createElement('td');
                amm.innerHTML = Reimbursement.amount;
                row.appendChild(amm);
                
                let purp = document.createElement('td');
                purp.innerHTML = Reimbursement.purpose;
                row.appendChild(purp);

                let stat = document.createElement('td');
                stat.innerHTML = Reimbursement.status;
                row.appendChild(stat);
          
                let by = document.createElement('td');
                by.innerHTML = Reimbursement.manager;
                row.appendChild(by);

                let questDate = document.createElement('td');
                questDate.innerHTML = Reimbursement.requestDate;
                row.appendChild(questDate);

                let viewDate = document.createElement('td');
                viewDate.innerHTML = Reimbursement.approvedDate;
                row.appendChild(viewDate);

                let img = document.createElement('td');
                img.innerHTML = Reimbursement.image;
                row.appendChild(img);

                tableBody.appendChild(row);
			});
		}
	}
}

function getAllPending()
{
	console.log("getting pending requests");
	while (tableBody.firstChild) 
	{
	    tableBody.removeChild(tableBody.firstChild);
	}
	requestsTable = document.getElementById('request-table');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getUnresolvedRequests.do');
	xhr.send();
	xhr.onreadystatechange=()=>
	{
		if(xhr.readyState===4&&xhr.status===200)
		{
			let requests = JSON.parse(xhr.responseText);
			requests.forEach(Reimbursement=>
			{
				let row = document.createElement('tr');

                let idCell = document.createElement('td');
                idCell.innerHTML = Reimbursement.id;
                row.appendChild(idCell);

                let quester = document.createElement('td');
                quester.innerHTML = Reimbursement.email;
                row.appendChild(quester);
                
                let amm = document.createElement('td');
                amm.innerHTML = Reimbursement.amount;
                row.appendChild(amm);
                
                let purp = document.createElement('td');
                purp.innerHTML = Reimbursement.purpose;
                row.appendChild(purp);

                let stat = document.createElement('td');
                stat.innerHTML = Reimbursement.status;
                row.appendChild(stat);
          
                let by = document.createElement('td');
                by.innerHTML = Reimbursement.manager;
                row.appendChild(by);

                let questDate = document.createElement('td');
                questDate.innerHTML = Reimbursement.requestDate;
                row.appendChild(questDate);

                let viewDate = document.createElement('td');
                viewDate.innerHTML = Reimbursement.approvedDate;
                row.appendChild(viewDate);

                let img = document.createElement('td');
                img.innerHTML = Reimbursement.image;
                row.appendChild(img);

                tableBody.appendChild(row);
			});
		}
	}
}

function getRequest()
{
	console.log("getting an employee's requests");
	let val = document.getElementById('email').value;
	console.log(val);
	while (tableBody.firstChild) 
	{
	    tableBody.removeChild(tableBody.firstChild);
	}
	requestsTable = document.getElementById('request-table');
	if(val!=null)
	{
		let xhr = new XMLHttpRequest();
		xhr.open('POST', `getRequestsFor.do?email=${val}`);
		xhr.send();
		xhr.onreadystatechange=()=>
		{
			if(xhr.readyState===4&&xhr.status===200){
				let requests = JSON.parse(xhr.responseText);
				requests.forEach(Reimbursement=>
				{
					let row = document.createElement('tr');

	                let idCell = document.createElement('td');
	                idCell.innerHTML = Reimbursement.id;
	                row.appendChild(idCell);

	                let quester = document.createElement('td');
	                quester.innerHTML = Reimbursement.email;
	                row.appendChild(quester);
	                
	                let amm = document.createElement('td');
	                amm.innerHTML = Reimbursement.amount;
	                row.appendChild(amm);
	                
	                let purp = document.createElement('td');
	                purp.innerHTML = Reimbursement.purpose;
	                row.appendChild(purp);

	                let stat = document.createElement('td');
	                stat.innerHTML = Reimbursement.status;
	                row.appendChild(stat);
	          
	                let by = document.createElement('td');
	                by.innerHTML = Reimbursement.manager;
	                row.appendChild(by);

	                let questDate = document.createElement('td');
	                questDate.innerHTML = Reimbursement.requestDate;
	                row.appendChild(questDate);

	                let viewDate = document.createElement('td');
	                viewDate.innerHTML = Reimbursement.approvedDate;
	                row.appendChild(viewDate);

	                let img = document.createElement('td');
	                img.innerHTML = Reimbursement.image;
	                row.appendChild(img);

	                tableBody.appendChild(row);
				});
			}
		}
	}
}