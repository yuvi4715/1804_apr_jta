# functions.md
* functions are first-class citizens
  * they can be passed, returned, and stored just like any other value
* Function inherits from Object and can store name/value pairs
* What JavaScript calls function, other language call lambda
  * JavaScript was the first lambda based language to go mainstream
* function statement is shorthand for var statement
  * `function foo(){}` *expands to* `var foo = function(){}`
* no function overloading
  * number of parameters can vary



### scope
* there is a global scope
* functions have scope
* nothing else has scope
  * there is no block scope in JavaScript
  * this means you should define your variables at the beginning of the function

### closure
* this is how we achieve encapsulation
* basically a function in a function

```
function abc() {
  function def() {}
}
```

* inner function retains its *environment*

```
function abc () {
  var str = "hello from outer function";
  function def() {
    console.log(str);
  }
  return def;
}

abc()();
```

* Challenge: write an `add` function such that `add(3,4)` and `add(3)(4)` both return `7`


### method
* a method is a function that belongs to an object

### invocation
* if a function is called with too many arguments, the extra arguments are ignored
* if a function is called with too few arguments, the missing values will be undefined
* no type checking on parameters
* every function gets an `arguments` parameter
* every function gets a `this` parameter, but what it points to depends on the **invocation form**
  * that means that `this` is bound at invocation time

### invocation forms
* function form `someFn(args)`
* method form `someObj.someFn(args)` or `someObj["someFn"](args)`
* constructor form `new someFn(args)`
* apply form `someFn.apply(someObj, [args])`

### function form
* `this` points to the global object
* that is not very useful
* cause of many bugs

### method form
* `this` points to the object which was used during method invocation

```
someObj.someFn(); //inside of someFn, 'this' will point to someObj
```

### constructor form
* when a function is called with the `new` operator, a new object is created and assigned to `this`
* if there is no explicit return statement, then `this` will be returned
* **best practice** is to capitalize functions that are meant to be constructors
  * see below example for why

```
var Person = function(name, age) {
  this.name = name;
  this.age = age;
}

var john = Person("John", 28);
console.log(john);
```


### apply form
* looks weird
* allows you to invoke a method while dynamically setting the object
* `this` points to the object that you pass into the `apply` method
