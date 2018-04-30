function getCookie(cname) {
	console.log("getting cookie");
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

window.onload = (function() {
	var email = getCookie('email');
	var type = getCookie('type');
	if (email == "") {
		document.location.href = "http://localhost:8080/MS_Project_One/html/EmployeeLogin.html";
	} else {
		getCurrentInfo();
	}
});

function getCurrentInfo() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			displayResponse(JSON.parse(xhr.responseText));
		}
	};
	xhr.open("POST", "http://localhost:8080/MS_Project_One/employeeViewInfo.msp1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("email=" + getCookie('email'));

}

function updateInfo() {
	var currentFirst = document.getElementById("currentFirstName").innerHTML;
	var currentLast = document.getElementById("currentLastName").innerHTML;
	var currentUserName = document.getElementById("currentUserName").innerHTML;
	var newFirst = document.getElementById("newFirstName").value;
	var newLast = document.getElementById("newLastName").value;
	var newUserName = document.getElementById("newUserName").value;
	if (newFirst == '') {
		newFirst = currentFirst;
	}
	if (newLast == '') {
		newLast = currentLast;
	}
	if (newUserName == '') {
		newUserName = currentUserName;
	}
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			if (xhr.responseText == 'true') {
				document.write("Your information was successfully updated!");
			} else {
				document.write("An error occured while updating your information!");
			}
		}
	};
	xhr.open("POST", "http://localhost:8080/MS_Project_One/employeeUpdateInfo.msp1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("email=" + getCookie('email') + "&newUsername=" + newUserName + "&newFirst=" + newFirst + "&newLast=" + newLast);
}

function displayResponse(ajaxObject) {
	if (typeof ajaxObject != 'undefined') {
		document.getElementById("currentFirstName").innerHTML = ajaxObject.firstName;
		document.getElementById("currentLastName").innerHTML = ajaxObject.lastName;
		document.getElementById("currentUserName").innerHTML = ajaxObject.username;
	}
}