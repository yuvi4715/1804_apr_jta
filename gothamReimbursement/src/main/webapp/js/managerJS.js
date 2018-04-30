

let allapprovingTable;
let allpendingTable;
let allTable;

window.onload = function () {
    document.getElementById("submitApproval").addEventListener("click", approvalStatus);
    document.getElementById("submitAllPendingRequest").addEventListener("click", viewAllPending);
    document.getElementById("submitAllApprovedRequest").addEventListener("click", viewAllApproved);
    document.getElementById("submitAllTable").addEventListener("click", viewAllEmployees);


    allapprovingTable = document.getElementById("allapprovingTable");
    allpendingTable = document.getElementById("allpendingTable");
    allTable = document.getElementById("allTable");

}


//Decides approval status of Reimbursement
function approvalStatus() {
    let status = document.getElementById("ticketStatus").value;
    let reimbursementId = document.getElementById("ticketId").value;

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {

        }
    };

    xhttp.open("POST", "http://localhost:8080/gothamReimbursement/html/approveRequest.ajax?status=" +
        status + "&reimbursementId=" + reimbursementId, true);
    xhttp.send();
}

function viewAllApproved(){

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let tableInfo = JSON.parse(xhttp.responseText);
            insertToApproving(tableInfo);
        }
    };
    xhttp.open("POST", "http://localhost:8080/gothamReimbursement/html/viewAllApproved.ajax", true);
    xhttp.send();
}


function viewAllPending() {

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let tableInfo = JSON.parse(xhttp.responseText);
            insertToPending(tableInfo);
        }
    };
    xhttp.open("POST", "http://localhost:8080/gothamReimbursement/html/viewAllPending.ajax", true);
    xhttp.send();
}

function viewAllEmployees() {

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let tableInfo = JSON.parse(xhttp.responseText);
            getAll(tableInfo);
        }
    };
    xhttp.open("POST", "http://localhost:8080/gothamReimbursement/html/viewAllEmployees.ajax", true);
    xhttp.send();
}

function insertToPending(ajaxObject) {
    document.getElementById('allpendingTable').innerHTML = "";
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
        allpendingTable.appendChild(row);
    }
}

function insertToApproving(ajaxObject) {
    document.getElementById('allapprovingTable').innerHTML = "";
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
        allapprovingTable.appendChild(row);
    }
}


function getAll(ajaxObject) {
    document.getElementById('allTable').innerHTML = "";
    for (let i = 0; i < ajaxObject.length; i++) {
        let row = document.createElement("tr");
        let userID = document.createElement("td");
        let email = document.createElement("td");
        let first_name = document.createElement("td");
        let last_name = document.createElement("td");

        //Insert values into the columns.
        userID.textContent = ajaxObject[i].User_ID;
        email.textContent = ajaxObject[i].Email;
        first_name.textContent = ajaxObject[i].First_Name;
        last_name.textContent = ajaxObject[i].Last_Name;


        row.appendChild(userID);
        row.appendChild(email);
        row.appendChild(first_name);
        row.appendChild(last_name);

        //Add row to the table.
        allTable.appendChild(row);
    }
}