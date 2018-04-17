# inheritance
* JavaScript has Prototypal inheritance
  * no classes in JavaScript
* this means that objects inherit directly from other objects
* the parent object is called the `prototype`
* every object has a property called `__proto__` that points to its prototype
* JavaScript has **method overriding**

```
var str = "dog";
console.log(str.__proto__);
```

* example: all strings inherit from `String.prototype`

```
String.prototype.hello = function() {
  console.log("hello from string");
}

var str = "dog";
str.hello();
```

* example: inheritance with custom objects

```
var Person = function() {
  this.hello = function() {
    console.log("hello from person");
  }
}

var Student = function() {
  this.__proto__ = new Person();
}

var john = new Student();
console.log(john.__proto__);
john.hello();
```
