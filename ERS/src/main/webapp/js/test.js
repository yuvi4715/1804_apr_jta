/* Adding listener to the check button 
    Executes getUsername function */
window.onload = function () {
    document.getElementById("test")
        .addEventListener("click", getUser);
}

function getUser(){
	//Getting the username from input field
    var email = document.getElementById("email").value;
    var passwd = document.getElementById("passwd").value;
	
	console.log("Performing function with: " + email);
	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		//If ready state is DONE and HTTP Status is OK
		 if (xhttp.readyState == 4 && xhttp.status == 200) { 
			//Grabbing JSON object from response body.
			//THIS EXECUTES LAST WITHIN THIS FUNCTION
			
			var ajaxObject = JSON.parse(xhttp.responseText);
			console.log("object is: " + ajaxObject);
			setValues(ajaxObject);
		 }
		};
	  //Opening connection for endpoint
	  xhttp.open("POST", "http://localhost:8080/ERS/html/test.ajax?email="+email+"&passwd="+passwd, true);
	  
	  //Sending request to endpoint
	  xhttp.send();
}

/* Modify the DOM after receiving JSON */
function setValues(ajaxObject){
	document.getElementById("testP").innerText = ajaxObject.user_id;
}