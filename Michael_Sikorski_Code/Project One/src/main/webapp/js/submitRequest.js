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
    	document.location.href = "http://localhost:8080/MS_Project_One/html/EmployeeLogin.html";
    }
});

function submitRequest() {
	let requester = getCookie('email');
	let amount = Number(document.getElementById("requestAmount").value);
	let purpose = document.getElementById("requestDescription").value;
	if (requester != '' && amount != '' && purpose != '' && typeof amount == "number") {
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				displayResponse(JSON.parse(xhr.responseText));
			}
		};
		xhr.open("POST", "http://localhost:8080/MS_Project_One/submitRequest.msp1", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("requester=" + requester + "&amount=" + amount + "&purpose=" + purpose);
	} else {
		document.getElementById("message").innerHTML = "Please fill out all fields before submitting";
		console.log(document.documentURI);
	}
}

function displayResponse(ajaxObject) {
	if (typeof ajaxObject != 'undefined') {
		console.log("Response to reimbursement request:");
		console.log(ajaxObject);
		if (ajaxObject == true) {
			document.write("Your request was submitted!");
		} else {
			document.write("There was a problem submitting your request!");
		}
	}
}