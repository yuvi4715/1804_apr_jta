# events

### event categories
* [reference](http://www.w3schools.com/jsref/dom_obj_event.asp)

| categories |            |              |       |
|------------|------------|--------------|-------|
| mouse      | keyboard   | frame/object | form  |
| drag       | clipboard  | print        | media |
| animation  | transition | server-sent  | misc  |
| touch      |            |              |       |

### create event listeners
* three ways to create event listeners
  * `<div onclick="someFn"></div>`
  * `element.onclick = function(){}`
  * `element.addEventListener("click", function(){});`

### the two bad ways
* these are perfect examples of obtrusive / bad JavaScript
* put in HTML section of JSFiddle

```
<div onclick="someFn()">my div</div>

<script>
  var someFn = function(){
    console.log("ALLO!");
  }
</script>
```

```
<div id="my-div">my div</div>

<script>
  var someFn = function(){
    console.log("ALLO!");
  }
  var element = document.getElementById("my-div");
  element.onclick = someFn;
</script>
```

### the one good way
* this is unobtrusive / good JavaScript
* put in HTML section of JSFiddle

```
<div id="my-div">my div</div>

<script>
  var someFn = function(){
    console.log("ALLO!");
  }
  var element = document.getElementById("my-div");
  element.addEventListener("click", someFn);
</script>
```

```
<div id="my-div">my div</div>

<script>
  var element = document.getElementById("my-div");
  element.addEventListener("click", function(){
    console.log("ALLO!");
  });
</script>
```

### addEventListener
* `element.addEventListener(type, handler, useCapture)`
  * **type**       - type of event
  * **handler**    - the function to handle this event
  * **useCapture** - true to use capture *(default is false)*
    * most of the time you do not want capture; instead use bubble


### event handler
* event handlers get passed an `event` parameter
* `event.stopPropagation()` is an important method
  * it will stop calling event handlers
* `event.target` is an important member
  * always points to the lowest element on the tree that was clicked
* while inside the event handler, `this` points to the element that was clicked on
*

```
<div id="my-div">my div</div>

<script>
  var element = document.getElementById("my-div");
  element.addEventListener("click", function(event){
    console.log(event);
  });
</script>
```

### bubble vs capture
* [reference](https://javascript.info/tutorial/bubbling-and-capturing)
* when you click on something, you are actually clicking on many different elements
* bubble and capture determine how you traverse those elements and call their event handlers
* assume I have an event handler for `click` on the elements `body` and `div`

```
<body>
  <div>hello</div>
</body>
```

* **bubble** starts at the bottom of the tree and works its way up
  * first the event handler for the `div` is called, then the event handler for the `body` is called
* **capture** starts at the top of the tree and works its way down
  * first `body` is called, then `div`
* most of the time, **bubble** is what you want
* assume we are using bubble and I want the event handler to run for `div`, but not for `body`
  * this is where `event.stopPropagation()` comes in handy

<br/><br/>
* example - putting it all together
  * put in HTML section of JSFiddle
<br/>

* CSS

```
div {
  text-align:center;
  margin: auto;
}

#three {
  background-color: red;
  width: 100px;
  height: 100px;
}
#two {
  background-color: green;
  width: 80px;
  height: 80px;
}
#one {
  background-color: white;
  width: 60px;
  height: 60px;
}
```

* HTML

```
<div id='three'>3
  <div id="two">2
    <div id="one">1</div>
  </div>
</div>
```

* JavaScript

```
var myEventHandler = function(event){
  alert("target: " + event.target.id + " - this: " + this.id);
}

var divs = document.getElementsByTagName("div");

for(var i = 0; i < divs.length; i++){
  divs[i].addEventListener("click", myEventHandler);
}
```

* try adding a third parameter of `true` to the `addEventListener` method
  * how does the output change?
