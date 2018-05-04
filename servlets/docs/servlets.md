# servlets
* allows Java to accept **requests** and send back **responses**
* `Servlet`, `GenericServlet`, `HttpServlet`

# web.xml
* *deployment descriptor*
* **The** configuration file for java web applications
* located in `WEB-INF/web.xml`

# create a servlet

create a class that extends `HttpServlet`

```
public class HelloWorld extends HttpServlet {
  //override methods
}
```

configure in `web.xml`

```
<servlet>
  <servlet-name>cat</servlet-name>
  <servlet-class>com.example.HelloWorld</servlet-class>
</servlet>

<servlet-mapping>
  <servlet-name>cat</servlet-name>
  <url-pattern>/dog</url-pattern>
</servlet-mapping>
```

Instead of configuring in `web.xml` you can also use annotations

```
@WebServlet("/dog")
public class HelloWorld extends HttpServlet {
  //override methods
}
```

# Methods you can override
* doGet, doPost, doPut, doDelete, doOptions, ...

```
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

```

# let's do an example

# lifecycle
* `init()`, `service()`, `destroy()`

# init
* maps urls to the servlet
* instantiates servlet object

# service
* called on every request to the servlet
  * a new thread is created first
* if GET request then calls `doGet()`
* if POST request then calls `doPost()`
* if DELETE request then calls `doDelete()`

# destroy
* destroys servlet
* called when web container stops
