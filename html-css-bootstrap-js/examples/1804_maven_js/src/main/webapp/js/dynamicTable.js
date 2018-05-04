/**
 * 
 */
window.onload = () => {
	//create object of html tags that needs interaction 
	let eid = document.getElementById("employeeid");
	let ename = document.getElementById("employeename");
	let gender = document.getElementById("gender");
	let email = document.getElementById("emailid");
	let sumit = document.getElementById("submitBtn");
	let clr = document.getElementById("clearBtn");
	let etable = document.getElementById("empTable");
	
		sumit.addEventListener("click",()=>{
			if ((eid.value !="") & (ename.value !="") & (gender.value!="") & (email.value!="")){			
				let row = document.createElement("tr");
				let idcol = document.createElement("td");
				let namecol = document.createElement("td");
				let gencol = document.createElement("td");
				let emailcol = document.createElement("td");
				
				idcol.textContent = eid.value;
				namecol.textContent = ename.value;
				gencol.textContent = gender.value;
				emailcol.textContent = email.value;
				
				row.appendChild(idcol);
				row.appendChild(namecol);
				row.appendChild(gencol);
				row.appendChild(emailcol);
				
				etable.appendChild(row);
				clearValues();
			} else {
				console.log("one of the form inputs have no value");
			}
		}	
		);
}
function clearValues(){
	document.getElementById("employeeid").value = "";
	document.getElementById("employeename").value = "";
	document.getElementById("gender").value = "";
	document.getElementById("emailid").value = "";
}
