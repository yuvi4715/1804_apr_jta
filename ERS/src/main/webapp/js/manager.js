var myInfo;
var theemphead;
var theempbody;
var thebody;
window.onload = function () {

    document.getElementById("theH3").addEventListener("click", getAllEmp);
    theempbody = document.getElementById("theempbody");
    theemphead = document.getElementById("theemphead");
    document.getElementById("manAllReq").addEventListener("click", manAllReq);
    document.getElementById("manPenReq").addEventListener("click", manPenReq);
    document.getElementById("manEmpReq").addEventListener("click", manCertEmp);
    document.getElementById("appReq").addEventListener("click", ApproveRequest);
    document.getElementById("DenReq").addEventListener("click", DenyRequest);
    thebody = document.getElementById("thebody");
    myInfo = document.getElementById("myInfo");
    showMyInfo();
}

function ApproveRequest() {
    console.log("Modifying a request")
    let aRequestID = document.getElementById("requestID").value / 1;
    console.log(aRequestID);
    console.log(typeof (aRequestID));

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            let text = xhttp.responseText;
            console.log("Result was: " + text);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/modareq.ajax?requestid="+aRequestID +"&status=APPROVED", true);

    //Sending request to endpoint
    xhttp.send();
}

function DenyRequest() {
    console.log("Modifying a request")
    let aRequestID = document.getElementById("requestID").value / 1;
    console.log(aRequestID);
    console.log(typeof (aRequestID));

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            let text = xhttp.responseText;
            console.log("Result was: " + text);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/modareq.ajax?requestid="+aRequestID +"&status=DENIED", true);

    //Sending request to endpoint
    xhttp.send();
}

function showMyInfo() {
    myInfo.innerHTML = "";
    let firstN = document.createElement("li");
    let lastN = document.createElement("li");
    let email = document.createElement("li");
    let passwd = document.createElement("li");

    console.log("Looking for logged user.")
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var ajaxObject = JSON.parse(xhttp.responseText);
            console.log(ajaxObject);
            firstN.textContent = "First Name: " + ajaxObject.firstName;
            lastN.textContent = "Last Name: " + ajaxObject.lastName;
            email.textContent = "Email: " + ajaxObject.email;
            passwd.textContent = "Password: ********";

            myInfo.appendChild(firstN);
            myInfo.appendChild(lastN);
            myInfo.appendChild(email);
            myInfo.appendChild(passwd);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/getuser.ajax", true);

    //Sending request to endpoint
    xhttp.send();

}

function getAllEmp() {
    console.log("Looking for all employees.")
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var ajaxObject = JSON.parse(xhttp.responseText);
            console.log(ajaxObject);
            insertToTable(ajaxObject);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/getallemp.ajax", true);

    //Sending request to endpoint
    xhttp.send();
}

function insertToTable(ajaxObject) {
    //Delete all current rows.
    document.getElementById("theempbody").innerHTML = "";
    document.getElementById("theemphead").innerHTML = "";

    //Create head columns for the table.
    let huserid = document.createElement("th");
    let hfirstname = document.createElement("th");
    let hlastname = document.createElement("th");
    let hemail = document.createElement("th");

    //Insert values into the th elements
    huserid.textContent = "User ID";
    hfirstname.textContent = "First Name";
    hlastname.textContent = "Last Name";
    hemail.textContent = "Email";

    //Append the th elements to theemphead
    theemphead.appendChild(huserid);
    theemphead.appendChild(hfirstname);
    theemphead.appendChild(hlastname);
    theemphead.appendChild(hemail);

    let i = 0;
    for (i = 0; i < ajaxObject.length; i++) {
        //Create row and columns elements
        let row = document.createElement("tr");
        let userid = document.createElement("td");
        let firstname = document.createElement("td");
        let lastname = document.createElement("td");
        let email = document.createElement("td");
        if (ajaxObject[i].isManager == 1)
            row.style.color = "red";

        //Insert values into the columns.
        userid.textContent = ajaxObject[i].user_id;
        firstname.textContent = ajaxObject[i].firstName;
        lastname.textContent = ajaxObject[i].lastName;
        email.textContent = ajaxObject[i].email;

        //Assign the value to the columns
        row.appendChild(userid);
        row.appendChild(firstname);
        row.appendChild(lastname);
        row.appendChild(email);

        //Add row to the table.
        theempbody.appendChild(row);
        //theemptable.style.display = "block";
    }
}

function manAllReq() {
    console.log("Looking for resolved Requests.")
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var ajaxObject = JSON.parse(xhttp.responseText);
            console.log(ajaxObject);
            document.getElementById("anH3").innerHTML = "Showing " + ajaxObject.length + " Resolved requests.";
            insertToReqTable(ajaxObject);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/manallreq.ajax", true);

    //Sending request to endpoint
    xhttp.send();
}

function manPenReq() {
    console.log("Looking for Pending Requests.")
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var ajaxObject = JSON.parse(xhttp.responseText);
            console.log(ajaxObject);
            document.getElementById("anH3").innerHTML = "Showing " + ajaxObject.length + " Pending requests.";
            insertToReqTable(ajaxObject);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/mancertreq.ajax?status=PENDING", true);

    //Sending request to endpoint
    xhttp.send();
}

function insertToReqTable(ajaxObject) {
    //Delete all current rows.
    document.getElementById('thebody').innerHTML = "";
    let i = 0;
    for (i = 0; i < ajaxObject.length; i++) {
        //Create row and columns elements
        let row = document.createElement("tr");
        let reqID = document.createElement("td");
        let requester = document.createElement("td");
        let revID = document.createElement("td");
        let amount = document.createElement("td");
        let reqDate = document.createElement("td");
        let revDate = document.createElement("td");
        let status = document.createElement("td");
        let purpose = document.createElement("td");

        //Insert values into the columns.
        reqID.textContent = ajaxObject[i].request_id;
        requester.textContent = ajaxObject[i].requester;
        revID.textContent = ajaxObject[i].reviewer;
        amount.textContent = ajaxObject[i].req_amount;
        //Properly format date
        var requdate = new Date(ajaxObject[i].request_date);
        reqDate.textContent = requdate.getMonth() + "/" + requdate.getDate() + "/" + requdate.getFullYear()

        var revidate = new Date(ajaxObject[i].review_date);
        if (revidate.getFullYear() === 1969) {
            revDate.textContent = "N/A"
        } else {
            revDate.textContent = revidate.getMonth() + "/" + revidate.getDate() + "/" + revidate.getFullYear()
        }
        status.textContent = ajaxObject[i].status;
        purpose.textContent = ajaxObject[i].purpose;

        //Assign the value to the columns
        row.appendChild(reqID);
        row.appendChild(requester);
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

function manCertEmp() {
    console.log("Looking for Employee's Requests.")
    let aRequester = document.getElementById("requester").value / 1;
    console.log(aRequester);
    console.log(typeof (aRequester));

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //If ready state is DONE and HTTP Status is OK
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            //Grabbing JSON object from response body.
            //THIS EXECUTES LAST WITHIN THIS FUNCTION
            var ajaxObject = JSON.parse(xhttp.responseText);
            console.log(ajaxObject);
            document.getElementById("anH3").innerHTML = "Showing " + ajaxObject.length + " employee requests.";
            insertToReqTable(ajaxObject);
        }
    };
    //Opening connection for endpoint
    xhttp.open("POST", "http://localhost:8080/ERS/html/mancertemp.ajax?requester=" + aRequester, true);

    //Sending request to endpoint
    xhttp.send();
}