/**
 * 
 */

window.onload=function(){
	document.getElementById("loginButton").addEventListener("click", loginUser)
	
}

function loginUser() {
	
	var user = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	let params = "username="+user+"&password=" + password;
	console.log(user+"&"+password);
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if ((this.readyState == 4) & (this.status==200)){
			console.log(xhr.responseText);
			if (this.responseText != "null"){
				let ors = JSON.parse(this.responseText);
				var email = ors.email
				var fName = ors.firstName;
				var lName = ors.lastName;
				var uName = ors.userName;
				var password = ors.password;
				var position = ors.position;
				
				if (position == "manager"){
					window.alert("Welcome Manager " + lName);
					document.cookie = "email="+email+"; path=/";
					document.cookie = "username="+uName+"; path=/";
					document.cookie = "password="+password+"; path=/";
					document.cookie = "firstName="+fName+"; path=/";
					document.cookie = "lastName="+lName+"; path=/";
					document.cookie = "username="+uName+"; path=/";
					document.cookie = "password="+password+"; path=/";
					document.cookie = "position="+position+"; path=/";
					window.location.replace("ManagerMenu.html");
				} else{
					document.cookie = "email="+email+"; path=/";
					document.cookie = "username="+uName+"; path=/";
					document.cookie = "password="+password+"; path=/";
					document.cookie = "firstName="+fName+"; path=/";
					document.cookie = "lastName="+lName+"; path=/";
					document.cookie = "username="+uName+"; path=/";
					document.cookie = "password="+password+"; path=/";
					document.cookie = "position="+position+"; path=/";
					window.location.replace("EmployeeMenu.html");
					window.alert("Welcome Employee" + lName);
				}
				
			} else {
				document.getElementById("text").textContent = "Incorrect login credentials";
				
			}	
		}
	};
	
	xhr.open("POST", "http://localhost:8089/ProjectOne/show.do");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
	
	
	
}