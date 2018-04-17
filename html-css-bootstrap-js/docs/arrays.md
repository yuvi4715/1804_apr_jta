# arrays
* array literal `[]`
* `,` separated values

```
var arr = [];

var arr = [10, 20, "John", "Amy", {}];
```


* `[]` is preferred to `new Array()`
* should not use dot notation, instead use *subscript notation*

```
var arr = [10,20,30];

arr[1]; //20
```

* Array inherits from Object
  * array indices are converted to strings and used as names for retreiving values
  * this means arrays and objects are almost exactly the same

```
var example1 = ["John", 20, true];

var example2 = {
  "0" : "John",
  "1" : 20,
  "2" : true
};
```

* main difference between objects and arrays: arrays have *array nature*
  * arrays have a length

### length
* arrays have a length member
* always one larger than the highest integer subscript
  * allows traditional use of for loop

```
var arr = [];
                  //arr.length is 0
arr[9] = "allo";
                  //arr.length is 10

```


### JavaScript arrays in a nutshell
* very efficient for sparse arrays
* not very efficient in most other cases
* one advantage: no need to provide a length or type when creating an array


### should I use objects or arrays?
* use objects when names are arbitrary strings
* use arrays when names are sequential integers

 
