/**
 * @author kathe
 */

//it is fired when the entire page loads, including its content (images, css, scripts, etc.)

//"use strict"
/*window.onload = () =>{
	
	document.getElementById("submit").addEventListener("click", login);
	
}*/

var responseglobal;
function login()
{	
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var role = document.getElementById("role").value;
	console.log(role);
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(this.readyState==4 && this.status == 200)
			{
				if(xhr.responseText.length >0)
					
					{
						homepagelayout(xhr.responseText);
					}
				else
					{
						document.getElementById("errormessage").innerHTML = "Username or Password is wrong. Try again!";
					}
				
				//console.log(xhr.responseText);
				
				
			}
	}
	xhr.open("POST","/reimbursement_system/login.do");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("username="+username+"&password="+password+"&role="+role); 
}

function homepagelayout(response)
{
	responseglobal = response;
	var n = response;
	if( n.includes('not in the database'))
		{
			document.getElementById("errormessage").innerHTML = n;
		}
	else
		{
	var nwindow = window.open("/reimbursement_system/html/homepage.html");
		
		}
	}
