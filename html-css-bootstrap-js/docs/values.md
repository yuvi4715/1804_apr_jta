# values
* numbers
* strings
* booleans
* null
* undefined
* NaN
* **objects**

### Loosely Typed
* Any of these types can be stored in a variable, or passed as a parameter to any function
* the language is not *untyped*

### numbers
* 64 bit floating point
* floating point numbers are not accurate
```
var x = 0.3 - 0.2; // does not equal 0.1
```

### strings
* 0 or more 16 bit characters
* "" same as ''
* no separate character type
* immutable
* == similar strings are equal
* UCS-2, not UTF-16
* string.length
* String(value) *converts value to a string*

### booleans
* true
* false
* note: values can be *truthy* or *falsey*

### truthy and falsy
* falsy values
  * false
  * null
  * undefined
  * "" *empty string*
  * 0
  * NaN
* all other values are truthy (including all objects)

### null and undefined
* *null* is a value that is not anything
* *undefined* is not even that...

<br/>

* You can assign a value to be null
* *undefined* is the default value for variables, parameters, nonexistent members, etc.
```
var x;        //undefined
var y = null; //null
```

### NaN
* *not a number*

```
var x = 0/0; //NaN
```





