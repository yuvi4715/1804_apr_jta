/**
 * 
 */
console.log("Hello World");
let defendersList = document.getElementById("defenders-list");


let xhttp = new XMLHttpRequest();
xhttp.open("GET", "https://api.myjson.com/bins/i90oz");
xhttp.send();
xhttp.onreadystatechange = function () {
  if (this.readyState ==4 & this.status == 200) {
    console.log(this.responseText);
    let objectifiedData = JSON.parse(this.responseText);
    console.log(objectifiedData);
    for (let i=0; i<objectifiedData.lenth-1;i++) {
    	
    }
  }
}