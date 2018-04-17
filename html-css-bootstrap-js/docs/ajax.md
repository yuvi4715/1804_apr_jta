# ajax
* Asynchronous JavaScript and XML
* ignore the XML part of that word, JSON is frequently used
* the ability to send requests from JavaScript **asynchronously**
  * this means we can send a request and forget about it
  * when we get the response, then we will handle it
  * do not have to wait in the meantime (think about when you text or email someone... do you have to wait for a response?)
* AJAX has four steps
  1. create object
  +  define onreadystatechange function
  +  open request *(can configure HTTP method and url)*
  +  send request *(can send data in request body)*
* naive example - do not run

```
var xhr = new XMLHttpRequest();

xhr.onreadystatechange = function(){
  if(this.readyState == 4 && this.status == 200){
    console.log("response received!");
    console.log(this.responseText);
  }
}

xhr.open("GET", "someUrl", true);

xhr.send();

```

### creating the object
* most of the time, the object we need is XMLHttpRequest
* older versions of IE had a different object from everyone else

```
var xhr;
if(XMLHttpRequest) {
  xhr = new XMLHttpRequest();
}else {
  xhr = new ActiveXObject("Microsoft.XMLHTTP"); //IE6 and older
}
```

### onreadystatechange
* most notably, XMLHttpRequest has members called `readystate`, `status` and `responseText`
* the `onreadystatechange` function is called whenever the `readystate` member changes

| readystate |                 meaning                |
|:----------:|:--------------------------------------:|
|      0     | request not initialized                |
|      1     | server connection established          |
|      2     | request received                       |
|      3     | processing request                     |
|      4     | request finished and response is ready |

* obviously we care the most when `readystate` is 4
* `status` will be one of the HTTP status codes - see [this reference](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
  * this is a naive example because we only handle when the status code is `200`
* `responseText` is the response body represented as a string

### open request
* `open(method, url, async)`
  * **method** - the HTTP method
  * **url**    - the url to send the request to
  * **async**  - true or false *(default is true)*


### send request
* `send(string)`
* sends the request
* **string** is optional
  * use to send data in the request body
  * cannot use with GET requests

### example
* open a browser and enter following url: `https://pokeapi.co/api/v2/pokemon/pikachu/`
* we are going to get that data using JavaScript
* you can enter the following into JSFiddle *(JavaScript section)*

```
var xhr = new XMLHttpRequest();

xhr.onreadystatechange = function(){
  if(this.readyState == 4 && this.status == 200){
    var pikachu = JSON.parse(this.responseText);
    console.log(pikachu.name);
    console.log(pikachu);
  }
}

xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/pikachu/");

xhr.send();
```
