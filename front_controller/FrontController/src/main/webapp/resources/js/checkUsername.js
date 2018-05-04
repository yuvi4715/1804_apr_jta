/* Adding listener to the check button 
    Executes getUsername function */
window.onload = function(){
	document.getElementById("checkUsername")
		.addEventListener("click", getUsername);
}

function getUsername(){
	//Getting the username from input field
	var username = document.getElementById("username").value;
	
	console.log("Performing function with: " + username);
	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			//Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
			var ajaxObject = JSON.parse(xhttp.responseText);
			setValues(ajaxObject);
		 }
		};
	  //Opening connection for endpoint
	  xhttp.open("POST", "http://localhost:8085/FrontController/checkUsername.ajax?username="+username, true);
	  
	  //Sending request to endpoint
	  xhttp.send();
}

/* Modify the DOM after receiving JSON */
function setValues(ajaxObject){
	document.getElementById("message").innerHTML = ajaxObject.message;
}