function showMyReimbursements() {

    var email = document.getElementById("loggedInAs").innerHTML;
    console.log("  succesfully started showReimbursements ")

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            var test = this.responseText;
            console.log(test);
            document.getElementById("all_reimbursements").innerHTML = this.responseText;
            console.log("sucessucesffully finished showReimbursements");

        }
    };
    xhttp.open("POST", "/reimbursement/getAllMyReimbursements.do");
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhttp.send("email="+email);

}