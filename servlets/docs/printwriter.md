# PrintWriter
* manually write response

```
String name = "john";

PrintWriter printWriter = response.getWriter();

printWriter.write("<h1>hello from " + name + "</h1>");
printWriter.write("<p>this seems like a neat way of doing things</p>");
```
