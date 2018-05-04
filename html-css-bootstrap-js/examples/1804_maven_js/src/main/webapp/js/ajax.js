/**
 * 
 */

//json vs java script object

//let a = {name:"Matt Murdock", hero:"Daredevil"};
//var b = `{"1":"Matt Murdock", "2":"Daredevil"}`;
//var c = '{"1":"Matt Murdock", "2":"Daredevil"}';
//console.log(a);
//console.log(b);
//let d = JSON.parse(b);
//let f = JSON.parse(c);
//let e = JSON.stringify(a);
//console.log(d);
//console.log(e);
//console.log(f);
//
////synchronous
//console.log(1);
//console.log(2);
//console.log(3);
//
////asynchronous - not confirmed order of execution
//console.log(4);
////setTimeout(() => console.log(5), 500);
////setTimeout(function(){
////	console.log(6);
////}, 500);
//console.log(7);
//
//simple example for ajax calls / requests
//var xhr = new XMLHttpRequest();
////for every ready state, onreadystatechange will get executed
////this line will always execute after the line open
//xhr.onreadystatechange = function(){
//	console.log(xhr.responseText);
//	console.log(xhr.responseXml);
//	console.log("status: " + xhr.status + "text: "+ xhr.statusText 
//			+ "readystate: "+ xhr.readyState);
//};
//
//xhr.open("get","https://api.myjson.com/bins/iw60z");
//xhr.send();

/*
 * http status codes
 * 100 - information
 * 200 - success
 * 300 - Redirect
 * 400 - client error
 * 500 - server error
 * 
 * fun fact 418 - I'm a teapot
 * https://httpstatuses.com/
 * 
 * readyState = 0, 1, 2, 3, 4
 */


window.onload = () => {
	let btn = document.getElementById("display");
	btn.addEventListener("click", () => {
		//for every ready state, onreadystatechange will get executed
		//this line will always execute after the line open
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if ((xhr.readyState === 4) & (xhr.status === 200)){
					let rt = document.getElementById("responseText");
					let rx = document.getElementById("responseXML");
					//let s = document.getElementById("status");
					let st = document.getElementById("statusText");
					//let rs = document.getElementById("readyState");
					let rh = document.getElementById("responseHeaders");
					rt.innerHTML = xhr.responseText;
					rx.innerHTML = xhr.responseXML;
					//s.innerHTML = xhr.status;
					st.innerHTML = xhr.statusText;
					//rs.innerHTML = xhr.readyState;
					rh.innerHTML = xhr.getAllResponseHeaders();
				}
		};
		xhr.open("get","https://api.myjson.com/bins/iw60z");
		xhr.send();
	})
	
	let gButton = document.getElementById("giftButton");
	gButton.addEventListener("click", gifts);
	
	
}


function gifts(){
	let gift = document.getElementById("gifted");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if ((xhr.readyState === 4) & (xhr.status === 200)){
			gift.innerHTML = xhr.responseText;
		}
	}
	xhr.open("get","https://api.myjson.com/bins/i90oz");
	xhr.send();	
}


//revisit this code
//(function () {
//for (name in xhr.getAllResponseHeaders()){
//	rh.innerHTML += name;
//	console.log(name);
//}
//})();
//console.log(xhr.responseText);
//console.log(xhr.responseXML);
//console.log("status: " + xhr.status + "text: "+ xhr.statusText 
//	+ "readystate: "+ xhr.readyState);
//console.log("response headers " + xhr.getAllResponseHeaders());
