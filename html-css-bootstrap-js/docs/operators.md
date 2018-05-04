# Operators
* arithmetic + - * / %
* comparison == != <> <= >= === !==
* logical && || !
* bitwise & | ^ >> >>> <<
* ternary ?:

### arithmetic
* be careful if you need precision

### comparison
* one note about **equality** operators (==, !=) and **identity** operators (===, !==)

```
var x =  5 ;
var y = "5";

x ==  y //true
x === y //false
```

* equality operators (==, !=) do **type coersion**
* **always use identity operators (===, !==)

### logical
* because values are truthy or falsy, we can use logical operators in neat ways
* the result of a logical operator does not need to be `true` or `false`

* && is called the **guard operator**
  * if first operand is *truthy*, then return **second** operand
  * if first operand is *falsy*,  then return **first** operand
  
```

//long version
if(a) {
  return a.member;
}else {
  return a;
}

//using guard operator
return a && a.member;

```

* || is called the **default operator**
  * if first operand is *truthy*, then return **first** operand
  * if first operand is *falsy*,  then return **second** operand

```

var language = input || "en";

```

* basic examples

```
false || false  //false
true  || false  //true
false || true   //true
true  || true   //true

false && false  //false
true  && false  //false
false && true   //false
true  && true   //true
```

* other examples

```
null || 0     //0
0    || null  //null
1    || 2     //1
2    || 1     //2

null && 0     //null
0    && null  //0
1    && 2     //2
2    && 1     //1
```

* Can you explain why boolean primitives are better to use than Boolean objects?


### bitwise
* need integers to use bitwise operators
* remember numbers in JavaScript are 64 bit floating point numbers
* so when we use bitwise operators, it looks something like:
  * convert 64 bit floating point to 32 bit integer
  * perform bitwise operaton
  * convert 32 bit integer back to 64 bit floating point
* **bad practice** - slow and tough to read

### ternary
* short and sweet

```
var x = true  ? 1 : 0; //1
var y = false ? 1 : 0; //0
```

* bad practice because it is tough to understand

```
//what is x?

var a = false;
var b = true;
var c = true;
var d = false;
var x = a || b ? c && d ? 1 : 2 : 3;
```
