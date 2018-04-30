//window.onunload = function() { debugger; }

window.onkeypress = function validateLogin(event){
		var key= event.which || event.keyCode;
		if (key===13)
		{
			let username = document.getElementById("user").value;
			let password = document.getElementById("pass").value;
	/////////////////////////////////test//////////////////////////
		/*	if (username==="hello@yahoo.com" && password ==="1234")
			{	
				setTimeout(function() {window.location = "../html/user.html" });
				//return true;
			}
			else 
			{
				alert("Invalid Login");
				
				document.getElementById("invalidLogin").innerHTML+="Invalid Login";				
			//	return false;
			}
			/////////////////////////////////test//////////////////////////
		*/	var xhr = new XMLHttpRequest();
			// execute every time state changes, hence doesn't matter where
			// located
			// defines how to handle response from server
			xhr.onreadystatechange = function ()
			{
				console.log("onreadystatechange");
				if((xhr.readystate ===4 ) && ( xhr.status===200))
			    {// if server says ok, sends to new page
					console.log("in if");
					var ajaxObject = JSON.parse(this.responseText);
					var auth=xhr.getResponseHeader("auth"); 
					if (auth==1)
					{
						console.log("xhr.responseText: " + this.responseText);
						console.log("Logging in");
						console.log(ajaxObject);
						setTimeout(function() {window.location = "../html/user.html" });
					}else
					{
						//location.reload();
						alert("Invalid Login");
						document.getElementById("invalidLogin").innerHTML += "Invalid Login";
						
					}
					
				}
					
			}
			xhr.open("post", "/ers/user.html");
			xhr.send("username="+username+"&password="+password);
			
		}
		
	}




