/**
 * 
 */

window.onload = () => {
	
	
	var n = window.opener.responseglobal;
	console.log(n);
	document.getElementById("Y").addEventListener("click", function(){
        sort("Y");
    }, false);
	document.getElementById("N").addEventListener("click", function(){
        sort("N");
    }, false); 
	document.getElementById("ALL").addEventListener("click", function(){
        sort("All");
    }, false);
	
	getrole(n);
}
var personid;
var username;
var password;
var requestid;
var role;
var response;

function getrole(n)
{
	var result = JSON.parse(n);
	if(result[0].role == 'manager')
		{
			console.log(result[0].role + "loading");
			personid = result[0].ID;
			username = result[0].username;
			password = result[0].password;
			role = result[0].role;
			loadmanagerpage(n);
		}
	else
		{
			console.log(result[0].role + "loading");
			personid = result[0].ID;
			username = result[0].username;
			password = result[0].password;
			role = result[0].role;
			loademployee(n);
		}
}
function loademployee(response)
{
	console.log("loading employee")
	var result = JSON.parse(response);
	let container = document.getElementById("requests");
	let tableRow0 = document.createElement('tr');
    let requestdetails0 = document.createElement('th');
    let status0 = document.createElement('td');
    let requestdate0 = document.createElement('td');
    let requestamount0 = document.createElement('td');
    let reviewdate0 = document.createElement('td');
    let reviewer0 = document.createElement('td');;
    
    requestdetails0.innerHTML = "Request Details";
    status0.innerHTML = "Status";
    requestamount0.innerHTML = "Request Amount";
    requestdate0.innerHTML = "Request Date";
    
    reviewdate0.innerHTML ="Review Date";
    reviewer0.innerHTML = "Reviewer";

    tableRow0.appendChild(requestdetails0);
    tableRow0.appendChild(status0);
    tableRow0.appendChild(requestamount0);
    tableRow0.appendChild(requestdate0);
    tableRow0.appendChild(reviewdate0);
    tableRow0.appendChild(reviewer0);

    container.appendChild(tableRow0);
	
	
	for(var i=1; i<result.length; i++)
		{
			var counter = result[i];
			for(var j =0;  j<counter.length; j++)
				{
				let tableRow = document.createElement('tr');

		        let requestdetails = document.createElement('th');
		        let status = document.createElement('td');
		        let requestdate = document.createElement('td');
		        let requestamount = document.createElement('td');
		        let reviewdate = document.createElement('td');
		        let reviewer = document.createElement('td');
		        
		        
		        requestdetails.innerHTML = counter[j].requestdetails;
		        status.innerHTML = counter[j].status;
		        requestamount.innerHTML = counter[j].reqamount;
		        requestdate.innerHTML = counter[j].requestdate;
		        
		        reviewdate.innerHTML =counter[j].reviewdate;
		        if(typeof counter[j].reviewer.firstname === undefined )
	        	{
		        	reviewer.innerHTML = "Has not been reviewed";
	        	}
	        else
	        {
	        	reviewer.innerHTML = counter[j].reviewer.firstname + " "+ counter[j].reviewer.lastname;
	       
	        } 

		        tableRow.appendChild(requestdetails);
		        tableRow.appendChild(status);
		        tableRow.appendChild(requestamount);
		        tableRow.appendChild(requestdate);
		        tableRow.appendChild(reviewdate);
		        tableRow.appendChild(reviewer);

		        container.appendChild(tableRow);
				}
		}
	
	}

function loadmanagerpage(response)
{
	
	console.log("loading manager")
	var result = JSON.parse(response);
	document.getElementById('centre').innerHTML = "View All Users";
	let container = document.getElementById('requests');
	
	let tableRow0 = document.createElement('tr');
    let requestdetails0 = document.createElement('th');
    let status0 = document.createElement('td');
    let requestdate0 = document.createElement('td');
    let requestamount0 = document.createElement('td');
    let reviewdate0 = document.createElement('td');
    let reviewer0 = document.createElement('td');
    let requester = document.createElement('td');
    let requestid = document.createElement('td');
    
    requestdetails0.innerHTML = "Request Details";
    status0.innerHTML = "Status";
    requestamount0.innerHTML = "Request Amount";
    requestdate0.innerHTML = "Request Date";
    
    reviewdate0.innerHTML ="Review Date";
    reviewer0.innerHTML = "Reviewer";
    requester.innerHTML = "Requester";
	requestid.innerHTML ="Request ID";
	
    tableRow0.appendChild(requestdetails0);
    tableRow0.appendChild(status0);
    tableRow0.appendChild(requestamount0);
    tableRow0.appendChild(requestdate0);
    tableRow0.appendChild(reviewdate0);
    tableRow0.appendChild(reviewer0);
    tableRow0.appendChild(requester);
    tableRow0.appendChild(requestid);
    
    container.appendChild(tableRow0);
//	var newcols = document.getElementById('manipulate')
//	var newcoldetails=newcols.insertCell(6);
//	var requestid = newcols.insertCell(7);
	
	
	for(var i=1; i<result.length; i++)
		{
			var counter = result[i];
			for(var j =0;  j<counter.length; j++)
				{
				var tableRow = document.createElement('tr');

		        let requestdetails = document.createElement('th');
		        let status = document.createElement('td');
		        let requestdate = document.createElement('td');
		        let requestamount = document.createElement('td');
		        let reviewdate = document.createElement('td');
		        let reviewer = document.createElement('td');
		        let requester= document.createElement('td');
		        let reqid = document.createElement('td');		        
		        
		        requestdetails.innerHTML = counter[j].requestdetails;
		        status.innerHTML = counter[j].status;
		        requestamount.innerHTML = counter[j].reqamount;
		        requestdate.innerHTML = counter[j].requestdate;
		        
		        reviewdate.innerHTML =counter[j].reviewdate;
		        //var reviewername = 
		        if(typeof counter[j].reviewer.firstname === undefined)
		        	{
		        	reviewer.innerHTML = "Has not been reviewed";
		        	}
		        else
		        {
		        	reviewer.innerHTML = counter[j].reviewer.firstname + " "+ counter[j].reviewer.lastname;
		        } 
		        var name = counter[j].requester.firstname + " " + counter[j].requester.lastname;
		        requester.innerHTML = name;
		        reqid.innerHTML = counter[j].ID;
		        

		        tableRow.appendChild(requestdetails);
		        tableRow.appendChild(status);
		        tableRow.appendChild(requestamount);
		        tableRow.appendChild(requestdate);
		        tableRow.appendChild(reviewdate);
		        tableRow.appendChild(reviewer);
		        tableRow.appendChild(requester);
		        tableRow.appendChild(reqid);
		        tableRow.addEventListener("click", function(){
		            reviewrequest(reqid);
		        }, false);
		        
		        container.appendChild(tableRow);
		        
				}
		}
	
	
	}

function sendreq()
{
	var reqdetails = document.getElementById("requestdetails").value;
	var reqamount  = document.getElementById("requestamount").value;
	var xrh = new XMLHttpRequest();
	xrh.onreadystatechange = function (){
	
		if(xrh.readyState==4 && xrh.status == 200)
			{
			 hiderequest();
			 loademployeerequests();
			 loademployee(response);
			}
	}
	xrh.open("POST", "/reimbursement_system/createreq.do");
	xrh.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xrh.send("reqdetails="+reqdetails+"&reqamount="+reqamount); 
}

function Createreq()
{
	document.getElementById('abc0').style.display = "block";
	
}
function hiderequest()
{
	console.log("hiding");
	document.getElementById('abc0').style.display = "none";
}
		 
function submitrequestapproval()
{
	var radios = document.getElementsByName('radio1');
	for (var i = 0, length = radios.length; i < length; i++) {
	    if (radios[i].checked) {
	        console.log(radios[i].value);
	        updateRequest(radios[i].value, requestid);
	    }
	}
	hide();
}

function updateRequest(answer, row)
{
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(this.readyState==4 && this.status == 200)
			{
				console.log("here");
				let tbody = document.getElementById("requests");
				
				//or use :  var table = document.all.tableid;
//				for(var i = tbody.rows.length - 1; i > 0; i--)
//				{
//				    tbody.deleteRow(i);
//				    //delete added columns in manager page
//				}
				loademployeerequests();
				//loadmanagerpage(response);
			}
	}
	xhr.open("POST","/reimbursement_system/updateRequest.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("status="+answer+"&requestid="+row); 
	
}

function hide()
{
	console.log("hiding");
	document.getElementById('abc').style.display = "none";
	}

function reviewrequest(row)
{
	//console.log(row.parentNode.parentNode.textContent);
	requestid = row.innerHTML;
	console.log(row.innerHTML);
	
	console.log("clicked")
	document.getElementById('abc').style.display = "block";
	
}
function sort(stat)
{
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(this.readyState==4 && this.status == 200)
			{
				console.log("here");
				let tbody = document.getElementById("requests");
			
				while(tbody.rows.length > 0) {
					  tbody.deleteRow(0);
					}

				 response = xhr.responseText;
				 if(role == 'manager')
					{
				loadmanagerpage(response);
					}
				else
					{
					loademployee(response);
					}
				//loadmanagerpage(response);
				
			}
	}
	xhr.open("POST","/reimbursement_system/login.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("username="+username+"&password="+password+"&role="+role+"&status="+stat); 
}

function loademployeerequests()
{	
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(this.readyState==4 && this.status == 200)
			{
				console.log("here");
				let tbody = document.getElementById("requests");
			
				//or use :  var table = document.all.tableid;
				while(tbody.rows.length > 0) {
					  tbody.deleteRow(0);
					}
//				var rowd = document.getElementById("manipulate");
//				console.log(rowd[7]);
//				rowd.deleteCell(6);
				//rowd.deleteCell(7);
				 response = xhr.responseText;
				 if(role == 'manager')
					{
				loadmanagerpage(response);
					}
				else
					{
					loademployee(response);
					}
				//loadmanagerpage(response);
				
			}
	}
	xhr.open("POST","/reimbursement_system/login.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("username="+username+"&password="+password+"&role="+role); 
}