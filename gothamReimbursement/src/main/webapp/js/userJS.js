
let approvingTable;
let pendingTable;
let myInfo;


window.onload = function () {
    document.getElementById("submitRequest").addEventListener("click", insertRequest);
    document.getElementById("submitPendingRequest").addEventListener("click", viewPending);
    document.getElementById("submitApprovedRequest").addEventListener("click", viewApproved);
    document.getElementById("logoutButton").addEventListener("click", logOutNow);

    approvingTable = document.getElementById("approvingTable");
    pendingTable = document.getElementById("pendingTable");
    myInfo = document.getElementById("myInfo");
}


function insertRequest() {
    let amount = document.getElementById("reimbursementAmount").value;
    let purpose = document.getElementById("purpose").value;
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
        }
    };

    xhttp.open("POST", "http://localhost:8080/gothamReimbursement/html/insertRequest.ajax?amount=" +
        amount + "&purpose=" + purpose, true);
    xhttp.send();
}


function logOutNow(){

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
        }
    };
    xhttp.open("POST", "http://localhost:8080/gothamReimbursement/html/logout.ajax", true);
    xhttp.send();
}


function viewApproved(){

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let tableInfo = JSON.parse(xhttp.responseText);
            insertToApproving(tableInfo);
        }
    };
    xhttp.open("POST", "http://localhost:8080/gothamReimbursement/html/viewApproved.ajax", true);
    xhttp.send();
}


function viewPending() {

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let tableInfo = JSON.parse(xhttp.responseText);
            insertToPending(tableInfo);
        }
    };
    xhttp.open("POST", "http://localhost:8080/gothamReimbursement/html/viewPending.ajax", true);
    xhttp.send();
}


function insertToPending(ajaxObject) {
    document.getElementById('pendingTable').innerHTML = "";
    for (let i = 0; i < ajaxObject.length; i++) {
        let row = document.createElement("tr");
        let reqID = document.createElement("td");
        let purpose = document.createElement("td");
        let amount = document.createElement("td");
        let reqDate = document.createElement("td");
        //Insert values into the columns.
        reqID.textContent = ajaxObject[i].Reimbursement_ID;
        purpose.textContent = ajaxObject[i].Purpose;
        amount.textContent = ajaxObject[i].Amount;
        reqDate.textContent = ajaxObject[i].Date_Submitted;

        row.appendChild(reqID);
        row.appendChild(purpose);
        row.appendChild(amount);
        row.appendChild(reqDate);
        //Add row to the table.
        pendingTable.appendChild(row);
    }
}

function insertToApproving(ajaxObject) {
    document.getElementById('approvingTable').innerHTML = "";
    for (let i = 0; i < ajaxObject.length; i++) {
        let row = document.createElement("tr");
        let reqID = document.createElement("td");
        let purpose = document.createElement("td");
        let amount = document.createElement("td");
        let reqDate = document.createElement("td");
        let manID = document.createElement("td");
        let approveDate = document.createElement("td");
        //Insert values into the columns.
        reqID.textContent = ajaxObject[i].Reimbursement_ID;
        purpose.textContent = ajaxObject[i].Purpose;
        amount.textContent = ajaxObject[i].Amount;
        reqDate.textContent = ajaxObject[i].Date_Submitted;
        manID.textContent = ajaxObject[i].Manager;
        approveDate.textContent = ajaxObject[i].Date_Approved;

        row.appendChild(reqID);
        row.appendChild(purpose);
        row.appendChild(amount);
        row.appendChild(reqDate);
        row.appendChild(manID);
        row.appendChild(approveDate);

        //Add row to the table.
        approvingTable.appendChild(row);
    }
}
