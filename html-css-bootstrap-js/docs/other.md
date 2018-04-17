# other

### garbage collection
* JavaScript has a garbage collector

### use strict
* put string literal `"use strict"` at the top of a scope to enforce rules

```
"use strict"

var someFn = function() {
  "use strict"

}

```

### typeof

| typeof |    result    |
|:--------------:|:------------:|
|     object     |   "object"   |
|    function    |  "function"  |
|      array     | **"object"** |
|     number     |   "number"   |
|     string     |   "string"   |
|     boolean    |   "boolean"  |
|      null      | **"object"** |
|    undefined   |  "undefined" |


### eval
* can evaluate a string as code
* do not do this

### build-in wrapper types
* JavaScript copied Java wrapper types: Integer, Boolean, etc.
* do not use these

### global
* there is always a global object
* it does not have a name, but it is there
* when JavaScript is running in a browser, the global object does have a name: `window`

### global variables are evil
* use of global namespace must be minimized

### Date
* there is a date object

### RegEx
* we have regular expressions

### threads
* language is neutral on threads
* most implementations do not have threads

### exception handling
* `throw`, `try` and `catch` statements
* 7 built in errors
  * EvalError
  * InternalError
  * RangeError
  * ReferenceError
  * SyntaxError
  * TypeError
  * URIError
