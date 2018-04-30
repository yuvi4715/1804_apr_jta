window.onload =function(){

	let logoutBtn = document.getElementById("logoutBtn");
	let employeeBtn = document.getElementById("employeeBtn");
	let requestBtn = document.getElementById("requestBtn");
	let updateBtn = document.getElementById("updateBtn");

	employeeBtn.addEventListener("click", getEmployees);
	requestBtn.addEventListener("click", request);
	updateBtn.addEventListener("click", update);
	logoutBtn.addEventListener("click", logout);
	var cookie= document.cookie;
	var display=document.getElementById("display");
	//var username = '<%= session.getAttribute("userName") %>';
	display.innerHTML += cookie.substring(9);
    // 1. Instantiate XHR - Start 

    var xhr = new XMLHttpRequest(); 
   
    // 1. Instantiate XHR - End
    
    // 2. Handle Response from Server - Start
    xhr.onreadystatechange = function () {
        if (xhr.readyState < 4)
            document.getElementById("display").innerHTML = "Loading...";
        else if (xhr.readyState === 4) {
            if (xhr.status == 200 && xhr.status < 300)
            {
            	console.log("anything?");
                var json = JSON.parse(xhr.responseText); //reponseText returns the entire JSON file and we assign it to a javascript variable "json".
                document.getElementById("display").innerHTML += json;
            } 
        }
    }
    // 2. Handle Response from Server - End

    // 3. Specify your action, location and Send to the server - Start   
    xhr.open("post", "/ers/login.do");
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(null);
    // 3. Specify your action, location and Send to the server - End
}



function getEmployees()
{
	console.log("Employees");
	var xhr = new XMLHttpRequest();
	// execute every time state changes, hence doesn't matter where
	// located
	// defines how to handle response from server
	xhr.onreadystatechange = function ()
	{
		if((xhr.readystate ===4 ) && ( xhr.status===200))
		{// if server says ok, sends to new page
			console.log("get employee");
			var json = JSON.parse(xhr.responseText);
			display.innerHTML+= json;
			displa.innerHTML+=this.responseText;
		}
			
	}
	xhr.open("GET", "/ers/getEmployees.ajax");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send();
}

function request()
{
	var xhr = new XMLHttpRequest();
	// execute every time state changes, hence doesn't matter where
	// located
	// defines how to handle response from server
	xhr.onreadystatechange = function ()
	{
		if((xhr.readystate ===4 ) && ( xhr.status===200))
		{// if server says ok, sends to new page
			console.log("request");
			var json = JSON.parse(xhr.responseText);
			display.innerHTML += json;
		}
			
	}
	xhr.open("post", "/ers/request.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send();
}

function update()
{
	var xhr = new XMLHttpRequest();
	// execute every time state changes, hence doesn't matter where
	// located
	// defines how to handle response from server
	xhr.onreadystatechange = function ()
	{
		if((xhr.readystate ===4 ) && ( xhr.status===200))
		{// if server says ok, sends to new page
			console.log("Update");
			var json = JSON.parse(xhr.responseText);
		
			display.innerHTML += "Your Info";
			display.innerHTML += json;
		}
			
	}
	xhr.open("post", "/ers/update.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send();
}


//on window close, logout, 
function logout()
{
	
			var xhr = new XMLHttpRequest();
			// execute every time state changes, hence doesn't matter where
			// located
			// defines how to handle response from server
			xhr.onreadystatechange = function ()
			{
				display.innerHTML += "logout";
				display.innerHTML +=xhr.getAllResponseHeader;
				if((xhr.readystate ===4 ) && ( xhr.status===200))
				{// if server says ok, sends to new page
					console.log("you're logged out");
					display.innerHTML += "logout";
				}
					
			}
			xhr.open("post", "/ers/logout.do");
			xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			xhr.send();
}