/* Adding listener to the check button 
    Executes getUsername function */
    window.onload = function () {
        document.getElementById("empDenReq").addEventListener("click", getDenReq);
        document.getElementById("empAppReq").addEventListener("click", getAppReq);
        document.getElementById("empPenReq").addEventListener("click", getPenReq);
    }
    
    function getPenReq(){
        
        console.log("Looking for Pending Requests.")
        var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
            //If ready state is DONE and HTTP Status is OK
             if (xhttp.readyState == 4 && xhttp.status == 200) { 
                //Grabbing JSON object from response body.
                //THIS EXECUTES LAST WITHIN THIS FUNCTION
                var ajaxObject = JSON.parse(xhttp.responseText);
                console.log(ajaxObject)
                var date = new Date(ajaxObject[1].request_date);
                console.log(date.getMonth() + "/" +  date.getDate()+ "/" + date.getFullYear());
                
             }
            };
          //Opening connection for endpoint
          xhttp.open("POST", "http://localhost:8080/ERS/html/certreq.ajax?status=PENDING", true);
          
          //Sending request to endpoint
          xhttp.send();
    }
    
    function getDenReq(){
        console.log("Looking for Pending Requests.")
        var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
            //If ready state is DONE and HTTP Status is OK
             if (xhttp.readyState == 4 && xhttp.status == 200) { 
                //Grabbing JSON object from response body.
                //THIS EXECUTES LAST WITHIN THIS FUNCTION
                var ajaxObject = JSON.parse(xhttp.responseText);
                console.log(ajaxObject)
                
             }
            };
          //Opening connection for endpoint
          xhttp.open("POST", "http://localhost:8080/ERS/html/certreq.ajax?status=DENIED", true);
          
          //Sending request to endpoint
          xhttp.send();
    }

    function getAppReq(){
        console.log("Looking for Pending Requests.")
        var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
            //If ready state is DONE and HTTP Status is OK
             if (xhttp.readyState == 4 && xhttp.status == 200) { 
                //Grabbing JSON object from response body.
                //THIS EXECUTES LAST WITHIN THIS FUNCTION
                var ajaxObject = JSON.parse(xhttp.responseText);
                console.log(ajaxObject)
                
             }
            };
          //Opening connection for endpoint
          xhttp.open("POST", "http://localhost:8080/ERS/html/certreq.ajax?status=APPROVED", true);
          
          //Sending request to endpoint
          xhttp.send();
    }
