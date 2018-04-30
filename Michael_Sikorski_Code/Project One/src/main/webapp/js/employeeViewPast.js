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

window.onload = function() {
	let email = getCookie('email');
	let type = getCookie('type');
	if (email != "") {
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				populateTable(JSON.parse(xhr.responseText));
			}
		};
		xhr.open("POST", "http://localhost:8080/MS_Project_One/employeeViewPast.msp1", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("email="+email);
    } else {
    	if (document.location.href != "http://localhost:8080/MS_Project_One/html/EmployeeLogin.html" &&
    			document.location.href != "http://localhost:8080/MS_Project_One/html/ManagerLogin.html") {
    		document.location.href = "http://localhost:8080/MS_Project_One/html/EmployeeLogin.html";
    	}
    }
	
}

function populateTable(response) {
	if (typeof response != 'undefined') {
		let tbody = document.getElementById("myPastRequests");
		console.log(response);
		for (var i=0; i<response.length; i++) {
			const row = tbody.insertRow(-1);
		      row.innerHTML = `
		      <td>${response[i].requestID}</td>
		      <td>${response[i].requestAmount}</td>
		      <td>${response[i].reviewer}</td>
		      <td>${response[i].status}</td>
		      <td>${response[i].requestDate}</td>
		      <td>${response[i].reviewDate}</td>`;
		}
	}
}