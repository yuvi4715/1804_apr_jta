/**
 * Contains dom manipulation example, call back functions and some arrow
 * notation examples as well
 * 
 * 
 * 
 * Event handlers ================= 
 * element.addEventListener(event, function,
 * useCapture);
 * 
 * To find elements ================ 
 * document.getElementById(id)
 * document.getElementsByTagName(name)
 * document.getElementsByClassName(name)
 * document.querySelectorAll - css selectors
 * 
 * To change elements ===================== 
 * element.innerHTML = new html content
 * element.attribute = new value 
 * element.setAttribute(attribute, value)
 * element.style.property = new style
 * 
 * To add and delete elements ============================
 * document.createElement(element) 
 * document.removeChild(element)
 * document.appendChild(element) 
 * document.replaceChild(element)
 * document.write(text)
 * 
 * Properties to navigate between nodes with JavaScript;
 * ========================================================== parentNode
 * childNodes[nodenumber] firstChild lastChild nextSibling previousSibling
 * 
 * sub-properties of properties ============================ nodeValue nodeType
 * nodeName
 * 
 * createElement createTextNode appendChild insertBefore removeChild
 * replaceChild
 */
console.log("did the page load??");
window.onload = function(){
	console.log("the page is loaded!!!");
	// simple example - calling a call back function
	console.log(f2("hello, ", f1));
	// creating an instance of the button tag where the id is addButton
	let addBtn = document.getElementById("addButton");
	
	// attach an event handler (listener) to this addBtn object
	addBtn.addEventListener("click",two);
	// anonymous function
	addBtn.addEventListener("click",function() {
		console.log("three")
	});
	// could use, functions or anonymous functions or arrow notations
	addBtn.addEventListener("click",() => {
		let num1 = document.getElementById("number1").value;
		let num2 = document.getElementById("number2").value;
		let res = parseInt(num1) + parseInt(num2);
		document.getElementById("results").textContent = res;
	});
}

function two(){
	console.log("another function");
}
// callback function examples
function f1(){
	console.log("function f1");
}
function f2(message, myvar){
	myvar();
	return message;
}


// lambdas: define a function you are only going to use once in the place you
// will use it.
window.onload = () => {
    console.log("We started the thing!");
};
// With no curly braces, we can have one line, and it will return.
var a = (a, b) => a+b;
console.log(a(1,2));

