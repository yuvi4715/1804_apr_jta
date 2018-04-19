// This example also shows what happens with let
console.log('--Hoisting--');

//Variable hoisting
console.log(a); // undefined
//console.log(b); //It won't be hoisted because of let.

var a = 5;
let b = 6;

console.log(a); // 5
console.log(b); // 6

//Local scope
console.log(hoisted); //undefined
//console.log(nonHoisted); //It won't be hoisted because of let.

if(true) {
    var hoisted = 90;
    let nonHoisted = 40;
}

console.log(hoisted); //90
//console.log(nonHoisted); //It won't be hoisted because of let.

//Function hoisting
console.log(hoistMe()); // 0

console.log(f); // undefined

function hoistMe() {
    return 0;
}

var f = function() {
    return 0;
};