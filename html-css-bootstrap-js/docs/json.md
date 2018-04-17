# json
* [reference](http://www.json.org/)
* JavaScript Object Notation
* created by Douglas Crockford
* a way to represent data in a language agnostic way
  * similar to xml, yaml, csv
* JSON was inspired by the way JavaScript represents objects
  * JSON and JavaScript objects are not the same thing
* JSON restrictions
  * 'undefined'
  * functions
  * numbers must be base 10
  * names must have quotes

### JSON document
* object `{key : value, key : value}`

### Keys
* Must be strings

### Values
* string
* number
* true / false
* array `[value, value, value]`
* object `{key : value, key : value}`
* null

```
{}
```

```
{
  "name" : "John"
}
```

```
{
  "colors": ["blue", "green", 42]
}
```

```
{
  "make": "Jeep",
  "model": "Wrangler",
  "year": 2004
}
```


```
{
  "name" : "John",
  "car": {
    "make": "Jeep",
    "model": "Wrangler",
    "year": 2004
  }
}
```
