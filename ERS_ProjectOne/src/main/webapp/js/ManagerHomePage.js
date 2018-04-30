/**
 * 
 */
	//Code for Tabs
function openLogin(evt, Login) {
    // Declare all variables
    let i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(Login).style.display = "block";
    evt.currentTarget.className += " active";
}
	//End of Tab Code

//AJAX

function loadEmployee() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("AllEmployee").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/ERS_ProjectOne/viewEmployee.do");
	  xhttp.send();
	}

function loadAllPendingRequests() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("AllPendingRequest").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/ERS_ProjectOne/employeePendingRequests.do");
	  xhttp.send();
	}

function loadAllResolvedRequests() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("AllResolvedRequest").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/ERS_ProjectOne/employeeResolvedRequests.do");
	  xhttp.send();
	}

function loadSearch() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("SearchEmployee").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/ERS_ProjectOne/searchEmployee.do");
	  xhttp.send();
	}

