# things to watch out for

### semicolon injection
* you need semicolons, however JavaScript will try to help you out by injecting semicolons if it finds a syntax error

```
var someFn = function() {
  return
  {
    name : "John",
    age  : 28
  }
}

var john = someFn();
console.log(john);

```

* the battle of where to put the starting curly brace is over!

### hoisting
* JavaScript *hoists* variable declarations to the top of their respective scopes

```
var someFn = function() {
  str = "ALLO!";
  console.log(str);
  var str;
}

someFn();

```

### implied globals
* if you use a variable and do not declare it, JavaScript assumes it must be a global variable

```
var someFn = function() {
  str = "allo";
  console.log(str);
}

someFn();
console.log(str);
```
