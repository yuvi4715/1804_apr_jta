function getCookie(cname) {
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
    	document.location.href = "http://localhost:8080/MS_Project_One/html/ManagerLogin.html";
    }
});

function approveDeny() {
	let manager = getCookie('email');
	let requestID = Number(document.getElementById("requestID").value);
	let newStatus = document.getElementById("newStatus").value;
	if (requestID != '' && newStatus != '' && typeof requestID == 'number') {
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				displayResponse(JSON.parse(xhr.responseText));
			}
		};
		xhr.open("POST", "http://localhost:8080/MS_Project_One/approveDeny.msp1", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("reviewedBy=" + manager + "&newStatus=" + newStatus + "&requestID=" + requestID);
	} else {
		console.log("Please fill out all fields correctly before submitting");
	}
}

function displayResponse(ajaxObject) {
	if (typeof ajaxObject != 'undefined') {
		if (ajaxObject == true) {
			document.write("The request has been updated!");
		} else {
			document.write("There was a problem updating the request!");
		}
	}
}