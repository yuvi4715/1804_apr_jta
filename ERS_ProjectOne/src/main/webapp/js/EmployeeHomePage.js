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

function loadmyEmployee() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("EmployeeView").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/ERS_ProjectOne/myEmployee.do");
	  xhttp.send();
	}

function loadmyPendingRequests() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("PendingRequest").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/ERS_ProjectOne/specificPendingRequests.do");
	  xhttp.send();
	}

function loadmyResolvedRequests() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("ResolvedRequest").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("post", "/ERS_ProjectOne/specificResolvedRequests.do");
	  xhttp.send();
	}

//Upload file
inputElement.addEventListener("change", uploadFile, false);
function uploadFile () {
	let numFiles = files.length;
	let selectedFile = document.getElementById('input').files[0];
	for (let i = 0, numFiles = files.length; i < numFiles; i++) {
		  let file = files[i];
		}
}