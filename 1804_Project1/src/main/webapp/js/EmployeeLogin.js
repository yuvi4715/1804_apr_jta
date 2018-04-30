

 window.onload = function(){
 	
 	//var cookie = document.cookie;
 	var textField = document.getElementById("loginText");
 	document.getElementById("loginButton").addEventListener("click", () => {
 		let user = document.getElementById("eIn");
 		let pass = document.getElementById("pIn");
 		let params = "email=" + user.value + "&pass=" + pass.value;
 		
 		let xmlh = new XMLHttpRequest();
 		
 		xmlh.onreadystatechange = function(){
 			if ((xmlh.readyState === 4) && (xmlh.status === 200)){
 				console.log(xmlh.responseText);
 				var userObj = JSON.parse(xmlh.responseText);
 					
 				
 				
 				if (userObj.loginStatus == "Success") {
 					console.log("Success has been achieved!");
 					document.cookie="username="+userObj.email;
 					window.location.href = "http://localhost:8025/1804_Project1/html/EmployeeHome.html"
 				} else if (userObj.loginStatus == "Incorrect Password"){
 					console.log("Incorrect Password, Try again.");
 					textField.textContent = "Incorrect Password, Try again.";
 				} else if (userObj.loginStatus == "Not a valid account email") {
 					console.log("User does not exist, try again.")
 					textField.textContent = "User does not exist, try again.";
 				}
 			}
 			
 		};
 				
 		xmlh.open("post", "http://localhost:8025/1804_Project1/login.do");
 		xmlh.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
 		xmlh.send(params);
 	});
 	
 	console.log(document.cookie);
 }