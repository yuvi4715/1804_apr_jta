window.onload = function() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			populateTable(JSON.parse(xhr.responseText));
		}
	};
	xhr.open("POST", "http://localhost:8080/MS_Project_One/getAllEmployees.msp1", true);
	xhr.send();
}

function populateTable(response) {
	if (typeof response != 'undefined') {
		let tbody = document.getElementById("allEmployees");
		for (var i = 0; i < response.length; i++) {
			const row = tbody.insertRow(-1);
			/*row.innerHTML = `
			<td>${response[i].firstName}</td>
			<td>${response[i].lastName}</td>
			<td>${response[i].username}</td>
			<td>${response[i].email}</td>
			<td><a href="http://localhost:8080/MS_Project_One/test.msp1">View Requests</a></td>
			`;*/
			row.innerHTML = `
			      <td>${response[i].firstName}</td>
			      <td>${response[i].lastName}</td>
			      <td>${response[i].username}</td>
			      <td>${response[i].email}</td>
			      <td><a href="#">View Requests</a></td>
			      `;
			/*row.addEventListener("click", function() {
				viewSingleRequests(this);
			}, true);*/
			row.addEventListener("click", function() {
				setEmployee(this);
			}, true);
			row.getElementsByTagName('td')[4].addEventListener("click", function() {
				test();
			}, false);
		}
	}
}

function setEmployee(elem) {
	sessionStorage.setItem('thisEmployee', String(elem.getElementsByTagName('td')[3].innerHTML));
}

function test() {
	document.location.href = 'viewSingleEmployeesRequests.html';
}

function viewSingleRequests(elem) {

	sessionStorage.setItem('thisEmployee', String(elem.getElementsByTagName('td')[3].innerHTML));
	document.location.href = 'viewSingleEmployeesRequests.html';

}