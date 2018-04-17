# jQuery
* JavaScript library
* turns 10 lines of JavaScript into 1 line of jQuery
* only a single global object
  * `$` and `jQuery` point to the same global object
* the `jQuery` object is actually a function
  * when you invoke the function, it traverses the DOM
  * the `jQuery` function has methods like `ajax`
* the `ajax` method takes in an object
  * this object has members to configure the request
  * no more worrying about what browser you are in
  * this is one step... remember with plain JavaScript it was four steps

```
$.ajax({
  method   : "get",
  url      : "someUrl",
  success  : function(){},
  error    : function(){},
  complete : function(){}
});
```

