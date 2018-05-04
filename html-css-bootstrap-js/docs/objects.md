# objects
* collection of name/value pairs
  * a **name** can be any string
  * a **value** can be any value *except undefined*
* two ways to create an object
  * object literal `{}` (preferred)
  * constructor (ok, but should not use `new Object()`)

```
var someObject = {};

var john = {
  "name" : "John",
  "age"  : 28
};
```

```
function Person(name, age) {
  this.name = name;
  this.age  = age;
}

var john = new Person("John", 28);
```

* `:` separates names and values
* `,` separates pairs
* as you can see, objects in JavaScript are basically hash tables
* no hash nature is visible (no hash codes or rehash methods)
* members can be accessed with dot notation `object.member` or subscript notation `object["member"]`


### maker functions
* a function that creates and returns an object
* useful if it is difficult or cumbersome to create an object
  * constructors are an alternative solution

```
function makePerson(name, age) {
  var person = {
    "name" : name,
    "age"  : age
  };
  return person;
}

var john = makePerson("John", 28);

```

### object augmentation
* objects are very dynamic

```
var obj = {};

                //obj.x is undefined

obj.x = 7;

               //obj.x is 7

delete obj.x;

              //obj.x is undefined
```




[arrays](arrays.md) and [functions](functions.md) inherit *Object*
