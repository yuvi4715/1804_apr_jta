window.onload = function() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			populateTable(JSON.parse(xhr.responseText));
		}
	};
	xhr.open("POST", "http://localhost:8080/MS_Project_One/viewAllPending.msp1", true);
	xhr.send();
}

function populateTable(response) {
	if (typeof response != 'undefined') {
		let tbody = document.getElementById("allPendingRequests");
		for (var i=0; i<response.length; i++) {
			const row = tbody.insertRow(-1);
		      row.innerHTML = `
		      <td>${response[i].requestID}</td>
		      <td>${response[i].requestAmount}</td>
		      <td>${response[i].requester}</td>
		      <td>${response[i].requestDate}</td>
		      <td>${response[i].purpose}</td>`;
		}
	}
}