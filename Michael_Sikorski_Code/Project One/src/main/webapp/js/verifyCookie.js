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
    var email = getCookie("email");
    var type = getCookie("type");
    if (email != "") {
        
    } else {
    	if (document.location.href != "http://localhost:8080/MS_Project_One/html/EmployeeLogin.html" &&
    			document.location.href != "http://localhost:8080/MS_Project_One/html/ManagerLogin.html") {
    		document.location.href = "http://localhost:8080/MS_Project_One/html/EmployeeLogin.html";
    	}
    }
});
