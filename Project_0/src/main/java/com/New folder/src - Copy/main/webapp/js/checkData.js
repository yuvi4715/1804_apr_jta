
window.onload = function(){
    document.getElementById("submitButton").addEventListener("click", getUserName);

}

function getUserName(){
    let user = document.getElementById("username");
    let disUser = document.getElementById("displayUser");
    let xmlh = new XMLHttpRequest();

    if((xmlh.readyState ==4) & (xmlh.status == 200)){
        console.log(xmlh.responseText);
    }

    xmlh.open("GET", "http://localhost:8080/html/login.html");
    xmlh.send()
}
