/* Adding listener to the check button 
    Executes getUsername function */

var thebody;
window.onload = function () {
    document.getElementById("empDenReq").addEventListener("click", getDenReq);
    document.getElementById("empAppReq").addEventListener("click", getAppReq);
    document.getElementById("empPenReq").addEventListener("click", getPenReq);
    document.getElementById("submitReq").addEventListener("click", insertRequest);
    thebody = document.getElementById("thebody");
}

function getPenReq() {

    console.log("Looking for pending Requests.")
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var ajaxObject = JSON.parse(xhttp.responseText);
            console.log(ajaxObject);
            document.getElementById("theH3").innerHTML = "Showing " + ajaxObject.length + " Pending requests.";
            insertToTable(ajaxObject);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/certreq.ajax?status=PENDING", true);

    //Sending request to endpoint
    xhttp.send();
}

function getDenReq() {
    console.log("Looking for denied Requests.")
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var ajaxObject = JSON.parse(xhttp.responseText);
            console.log(ajaxObject);
            document.getElementById("theH3").innerHTML = "Showing " + ajaxObject.length + " Denied requests.";
            insertToTable(ajaxObject);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/certreq.ajax?status=DENIED", true);

    //Sending request to endpoint
    xhttp.send();
}

function getAppReq() {
    console.log("Looking for approved Requests.")
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var ajaxObject = JSON.parse(xhttp.responseText);
            console.log(ajaxObject);
            document.getElementById("theH3").innerHTML = "Showing " + ajaxObject.length + " Approved requests.";
            insertToTable(ajaxObject);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/certreq.ajax?status=APPROVED", true);

    //Sending request to endpoint
    xhttp.send();
}

function insertToTable(ajaxObject) {
    //Delete all current rows.
    document.getElementById('thebody').innerHTML = "";
    let i = 0;
    for (i = 0; i < ajaxObject.length; i++) {
        //Create row and columns elements
        let row = document.createElement("tr");
        let reqID = document.createElement("td");
        let revID = document.createElement("td");
        let amount = document.createElement("td");
        let reqDate = document.createElement("td");
        let revDate = document.createElement("td");
        let status = document.createElement("td");
        let purpose = document.createElement("td");

        //Insert values into the columns.
        reqID.textContent = ajaxObject[i].request_id;
        revID.textContent = ajaxObject[i].reviewer;
        amount.textContent = ajaxObject[i].req_amount;
        //Properly format date
        var requdate = new Date(ajaxObject[i].request_date);
        reqDate.textContent = requdate.getMonth() + "/" + requdate.getDate() + "/" + requdate.getFullYear()
        var revidate = new Date(ajaxObject[i].review_date);
        revDate.textContent = revidate.getMonth() + "/" + revidate.getDate() + "/" + revidate.getFullYear()
        status.textContent = ajaxObject[i].status;
        purpose.textContent = ajaxObject[i].purpose;

        //Assign the value to the columns
        row.appendChild(reqID);
        row.appendChild(revID);
        row.appendChild(amount);
        row.appendChild(reqDate);
        row.appendChild(revDate);
        row.appendChild(status);
        row.appendChild(purpose);

        //Add row to the table.
        thebody.appendChild(row);
    }
}

function insertRequest() {
    let amount = document.getElementById("reqAmount").value;
    let purpose = document.getElementById("reqPurpose").value;
    console.log("Inserting request.");
    console.log("amount is: " + amount);
    console.log("purpose is: " + purpose);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var text = xhttp.responseText;
            console.log("Result was: " + text);
            
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/insertreq.ajax?amount="+amount+"&purpose="+purpose, true);

    //Sending request to endpoint
    xhttp.send();
}