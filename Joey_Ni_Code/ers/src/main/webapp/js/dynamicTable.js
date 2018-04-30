window.onload = () =>{
	
// create object of html tag that needs interaction
let submitbtn = document.getElementById("submitBtn");
let clearbtn = document.getElementById("clearBtn");
let searchbtn = document.getElementById("searchBtn");
let eid = document.getElementById("employeeid");
let ename = document.getElementById("employeename");
let email = document.getElementById("employeeemail");
let etable = document.getElementById("empTable");


// add event listener to submit

submitbtn.addEventListener("click", ()=>{
	if (!(eid.value=="" | ename.value=="" | email.value=="")){
		let row = document.createElement("tr");
		let idcol =	document.createElement("td");
		let namecol =document.createElement("td");
		let emailcol =document.createElement("td");
//		var xhr = new XMLHttpRequest();
	//	xhr.onreadystatechange = function(){
			//ready status: 4 received and response read
			//xhr.status: 200 => sucess
			//to do after received response from server
		//	if((xhr.readyState === 4) & (xhr.status===200))
			{
				idcol.textContent=eid.value;
				namecol.textContent=ename.value;
				emailcol.textContent=email.value;
				row.appendChild(idcol);
				row.appendChild(namecol);
				row.appendChild(emailcol);
				etable.appendChild(row);
			}
	//	}
	
	/*xhr.open("get", '/server');
	xhr.send('data');
	xhr.send(document);
	xhr.send('input');*/
	}
});










}