/**
 * 
 */
window.onload = function() {
	
	userHeader = document.getElementById("userHeader");
	userHeader.textContent = "Logged in as: " + getCookie("username");
	
	document.getElementById("logoutButton").addEventListener("click", () => {
		document.cookie = 'username=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
		console.log(document.cookie);
		window.location.href = "http://localhost:8025/1804_Project1/"
	});
	
	document.getElementById("submitButton").addEventListener("click", () => {
		let username = getCookie("username");
		let amount = document.getElementById("amount").value;
		let reason = document.getElementById("reason").value;
		let params = "email=" + username + "&amount=" + amount + "&reason=" + reason;
			
		let textField = document.getElementById("ticketCreateText");
		
		let xmlh = new XMLHttpRequest();
 		
 		xmlh.onreadystatechange = function(){
 			if ((xmlh.readyState === 4) && (xmlh.status === 200)){
 				console.log(xmlh.responseText);
 				var ticketObj = JSON.parse(xmlh.responseText);
 					
 				
 				
 				if (ticketObj.status == "pending") {
 					console.log("Success has been achieved!");
 					textField.textContent = "Ticket successfully added.";
 				} else {
 					console.log("Ticket failed to create.");
 					textField.textContent = "Failed to create ticket.";
 				} 
 			}
 			
 		};
 				
 		xmlh.open("post", "http://localhost:8025/1804_Project1/createTicket.do");
 		xmlh.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
 		xmlh.send(params);
	});
	
	document.getElementById("viewallButton").addEventListener("click", () => {
		display("other");
	});
	
	document.getElementById("pendingButton").addEventListener("click", () => {
		display("pending");
	});
	
	document.getElementById("resolvedButton").addEventListener("click", () => {
		display("reviewed");
	});
	
	display("other");
}

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

function display(status) {
	let tableBody = document.getElementById("tableBody");
	
	//Clear table of all values
	while (tableBody.childNodes.length) {
	  tableBody.removeChild(tableBody.childNodes[0]);
	}
	
	let xmlh = new XMLHttpRequest();
		
		xmlh.onreadystatechange = function(){
			if ((xmlh.readyState === 4) && (xmlh.status === 200)){
				
				var ticketObj = JSON.parse(xmlh.responseText);
					
				console.log(ticketObj.length);
				
				for (var i in ticketObj) {
					let row = document.createElement("tr");
					let idCol = document.createElement("td");
					let amountCol = document.createElement("td");
					let statusCol = document.createElement("td");
					let reasonCol = document.createElement("td");
					let reqDateCol = document.createElement("td");
					let revDateCol = document.createElement("td");
					let managerEmailCol = document.createElement("td");
					
					idCol.textContent = ticketObj[i].id;
					amountCol.textContent = ticketObj[i].amount;
					statusCol.textContent = ticketObj[i].status;
					reasonCol.textContent = ticketObj[i].reason;
					reqDateCol.textContent = ticketObj[i].requestDate;
					revDateCol.textContent = ticketObj[i].reviewDate;
					managerEmailCol.textContent = ticketObj[i].managerEmail;
					
					row.appendChild(idCol);
					row.appendChild(amountCol);
					row.appendChild(reasonCol);
					row.appendChild(statusCol);
					row.appendChild(managerEmailCol);
					row.appendChild(reqDateCol);
					row.appendChild(revDateCol);
					tableBody.appendChild(row);
				}
			}
			
		};
				
	if (status == "pending") {
		xmlh.open("post", "http://localhost:8025/1804_Project1/getAllTicketsForPending.do");	
	} else if (status == 'reviewed'){
		xmlh.open("post", "http://localhost:8025/1804_Project1/getAllTicketsForReviewed.do");
	} else {
		xmlh.open("post", "http://localhost:8025/1804_Project1/getAllTicketsFor.do");
	}
		
	
	xmlh.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlh.send("email=" + getCookie("username"));
}