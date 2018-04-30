window.onload = () =>{
	
// create object of html tag that needs interaction
let submitbtn = document.getElementById("submitBtn");
let clearbtn = document.getElementById("clearBtn");
let email = document.getElementById("email");
let eform = document.getElementById("registerForm");
let password = document.getElementById("password");
let lastname = document.getElementById("lastname");
let firstname = document.getElementById("firstname");

function validateRegistration(){
	
	
}

submitbtn.addEventListener("click", ()=>{
	if (password.value!=="" & email.value!=="" & lastname.value!=="" & firstname.value!=="")
	{
		console.log("got to js page");
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			//ready status: 4 received and response read
			//xhr.status: 200 => success
			//to do after received response from server
		  if((xhr.readyState === 4) & (xhr.status===200))
			{
			  //send form data to servlet, servlet calls java methods to validate data
			  //send data to email redirect
			}
		}
	
	xhr.open("post", "/ers/src/main/resources/WebServelet/servlet.java");
	xhr.send();
	}
});
}
