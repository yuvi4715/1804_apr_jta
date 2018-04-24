# Session

* a user using a site for a time period (until 30 minutes inactive)
* allows us to store data between requests

# HttpSession
*   Save things about a specific user
*   Data in session scope exist for as long as the user is using the site

*   Some methods:
    *   	setAttibute
    *   	getAttribute
    *   	removeAttribute
    *   	invalidate
    *   	setMaxInactiveInterval


#  HttpServletRequest
*   Save things about a request
*   Data in request scope exist until a response is sent back to the client

*   Some methods:
    *   	setAttribute
    *   	getAttribute
    *   	getParameter (form data / url data)


```
HttpSession httpSession = request.getSession();
```


# Cookies
* file on the client's computer
* `JSESSIONID` is a cookie that holds a user's unique session id
