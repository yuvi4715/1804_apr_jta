# redirect
* sends a 301 response
* **pro:** changes url
* **con:** total of 2 requests/responses

```
response.sendRedirect("dog.html");
```

# forward
* sends response directly
* **pro:** only 1 request/response
* **con:** url does not change

```
request.getRequestDispatcher("dog.html").forward(request, response);
```
