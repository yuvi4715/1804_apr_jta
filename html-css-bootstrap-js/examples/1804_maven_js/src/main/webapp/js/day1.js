/**
 * Cmd + Option + J in mac to open developer tools Windows: Ctrl + Shift + J or
 * Function + F12
 */

"use strict";		// enforce declaration for all the variables

var a = "Hello world!";
console.log(a);
print_variables();			// example for hoisting - call a function before its
							// definition

// alert(a); //not a good practice
// document.write(a); //bad practice

// let, const, var
// Constants are block-scoped, much like variables defined using the let
// statement. The value of a constant cannot change through re-assignment, and
// it can't be redeclared.

// scopes - global, local and block
function print_variables(){
	console.log("value of a " + a); // global scope ???? will this work
	var b = 123;
	// bcd = 234;
	console.log(b);
	// console.log(bcd);
}

// console.log(bcd);
// console.log("value of b " + b); //no why not?
// variable is declared inside a function.it is function scope or also called as
// local scope

// diff between var and let
var i = 10;
// testing to see if the variable declared with var is accessible outside if
// block
if (i ===10 ){
	var variableDefinedWithVar = "checking for block scope - var";
}
console.log("variableDefinedWithVar: " + variableDefinedWithVar);

// testing to see if the variable declared with let is accessible outside if
// block
if (i ===10 ){
	let variableDefinedWithLet = "checking for block scope - let";
}
// console.log("variableDefinedWithLet: " + variableDefinedWithLet);
// this will not work because variables defined with let lives within the block

// try example with for loop - result should be the same.

// what is so special about functions in JavaScript?
	// functions can be anonymous
	// functions can be self invoking
	// functions can be hoisted
	// functions have closures
	// functions can be callback
	// function can be assigned to a variable

var c = function one(){
	return true;
};

console.log("value of c " + c);				// prints the function itself
console.log("value of c " + c());			// invokes the function
console.log("type of c " + typeof(c));		// function

// example for anonymous
var d = function(){
	return false;
}

console.log("value of d " + d);				// prints the function itself
console.log("value of d " + d());			// invokes the function
console.log("type of d " + typeof(d));		// function


c = function(){
	return false;
}
console.log("value of c " + c());			// false

(function (){
	console.log("I'm part of self invoking and anonymous function");
})();

(function three(){
	console.log("I'm part of self invoking function");
})();

let fo = (function four(){
	console.log("I'm part of self invoking function and assigned to a variable");
})();

let fi = (function(){
	console.log("I'm part of self invoking function and anonymous. also and assigned to a variable");
})();

function abc(){
	var i = 1000;
	b();
	function b(){
		console.log("value of i : " + i);
		var j = 2000;
	}
	// console.log("value of j : " + j); //should fail
}
abc();

console.log(a);
a = function(){
	return true;
}
console.log(a());
console.log(typeof(a));


// Hoisting - calling a function before its implementation
// Bubbling - Executing events from innermost tags to outer most
// Capturing - Opposit of bubbling
// Listener - attach event handler to a tag
			// addEventListener(event, function, useCapture)
// Truthy and Falsy
// Closures - Achieve encapsulation - use private variables
// JS objects vs JSON



// truthy and falsy
// falsy - false, 0, null, undefined, NaN, ""

// false, 0 and "" - they are equal
// console.log(false == 0); //true
// console.log(false === 0); //false
// console.log(false == (0=="")); //false
// console.log(0==""); //true
// console.log(0==null); //false
// console.log(undefined==false); //false
// console.log(NaN==""); //false
// //null and undefined are not equal to anything except for themselves and each
// other
// console.log(undefined==null); //true
// console.log(null==null); //true
// console.log(undefined==undefined); //true
// console.log(NaN==NaN); //false
// console.log(0.1+0.2); //
// above examples with ===
// console.log("" + false === (0==="")); //false
// console.log(0===""); //false
// console.log(0===null); //false
// console.log(undefined===false); //false
// console.log(NaN===""); //false
// console.log(undefined===null); //false
// console.log(null===null); //true
// console.log(undefined===undefined); //true
// console.log("" + false !== (0==="")); //
// console.log(0!==""); //
// console.log(0!==null); //
// console.log(undefined!==false); //
// console.log(NaN!==""); //
// console.log(undefined!==null); //
// console.log(null!==null); //
// console.log(undefined!==undefined); //
// console.log(false !== (0===""===(undefined===(null===(0===false))))); //
// console.log(false !== (0!==""===(undefined!==(null===(0!=false))))); //
// console.log(!!(!(true)));
// console.log(!!(0));


// bar = [];
// bar = null;
// bar = {};
// typeof(bar) ==="object";


// var counter = 0;
//
// function add(){
// counter += 1;
// console.log(counter);
// }
//
// add(); //1 0 0
// add(); //2 1 1
// add(); //3 2 1


// function add(){
// var counter = 0;
// counter += 1;
// console.log(counter);
// }
//
// add(); //1
// add(); //1
// add(); //1

// console.log(typeof(50/0));


// function add(){
// var counter = 0;
// //increament();
// function increament(){
// counter += 1;
// console.log(counter);
// }
// increament();
// }
//
// add(); //
// add(); //
// add(); //

function add(){
	var counter = 0;
	return function(){
		counter+= 1;
		return counter;
	};
}

var result = add();
var result2 = add();

console.log(result());	// 1
console.log(result());	// 2
console.log(result());	// 3
console.log(result2());	// 1

// closures - above example

// json - java script object notation
// java script object


// create object using literal - {}
let obj1 = {hero:"Daredevil", name: "Matt murdock", occupation: "Attorney"};
console.log(obj1);

// js - supports prototypical inheritance
// js - pass by value for args, pass by reference for objects
// refers to same objects
let obj2 = obj1;
// var `object three = obj2`;

for (var x in obj1){
	console.log(x);
	console.log(obj1[x]);
}
obj1.hero = "PowerMan";
obj1.name = "Luke Cage";
obj1.occupation = "Barber";

for (let y in obj2){
	console.log(y);
	console.log(obj2[y]);
}

// create object using new keyword
let z = new Object();
z.name = "jessica jones";
z.hero = "Jem";
z.occupation = "Private Investigator";
z.gift = function(){
	return "jump";
}
console.log(z.gift());

var ir = {hero:"IronFist", 
		name: "Danny Rand", 
		occupation: "Protecting K'hun L'hun",
		gift : function(){
			return "iron fist";
		}
}
console.log(z.gift());

//create object using constructor
function giftedPeople(first, last, hero, suites, occupation){
	this.first = first;
	this.last = last;
	this.hero = hero;
	this.occupation = occupation;
	this.suites = suites
	this.name = function(){
		return this.first + " " + this.last;
	}
}

let ironman = new giftedPeople("Tony", "Stark", "Iron Man", 10, "Billionaire");
console.log(ironman.name() + " is a " + ironman.occupation +
		"\n" + " and has " + ironman.suites + " ironman suites");

// template literals
console.log(`${ironman.name()} "is" a  
			${ironman.occupation} 
		 	and has 
		 	${ironman.suites} 
			ironman suites`);

/*
 * Example for events: ==================== When a user clicks the mouse When a
 * web page has loaded When an image has been loaded When the mouse moves over
 * an element When an input field is changed When an HTML form is submitted When
 * a user strokes a key
 */
// Events - Reaction to user input
// - onload, onmousehover, onmouseclick, onclick, onfocus, onblur

function clickButton(){
	// e.preventDefault();
	var u = document.getElementById("username").value;
	console.log(u);
	document.getElementById("print").innerHTML = u;
}


function mouseOver(){
	document.getElementById("mousemovement").innerHTML = "does it really work, Huh??";
}

function mouseOut(){
	document.getElementById("mousemovement").innerHTML = "can't see the old text";
}

let user = document.getElementById("username");
user.onfocus = function(){
	user.style.background = "green";
}
user.onblur = function(){
	user.style.background = "red";
}

let pass = document.getElementById("password");
pass.onfocus = function(){
	pass.style.background = "blue";
}

pass.onblur = function(){
	pass.style.background = "yellow";
}



