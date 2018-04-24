# ServletContext and ServletConfig
* `ServletContext` contains config for **all** servlets

```
<web-app>

  <context-param>
    <param-name>favoriteColor</param-name>
    <param-value>blue</param-value>
  </context-param>

  <context-param>
    <param-name>favoriteAnimal</param-name>
    <param-value>dog</param-value>
  </context-param>

</web-app>
```

* `ServletConfig` contains config for **one** servlet

```
<web-app>

  <servlet>
    <servlet-name>cat</servlet-name>
    <servlet-class>com.example.CatServlet</servlet-class>

    <init-param>
      <param-name>favoriteColor</param-name>
      <param-value>blue</param-value>
    </init-param>

    <init-param>
      <param-name>favoriteAnimal</param-name>
      <param-value>dog</param-value>
    </init-param>
  </servlet>

</web-app>
```
