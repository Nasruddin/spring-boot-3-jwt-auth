# jwt-auth-springboot
:key: A sample Spring boot security application using JWT auth to

* secure a resource
* provide an endpoint to supply JWT access tokens to the resource

## Running the sample app
```
mvn spring-boot:run
```

## Registering a User
```
curl -i -H "Content-Type: application/json" -X POST -d '{"username":"user","password":"user"}' http://localhost:9000/api/auth/register

HTTP/1.1 200 
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
X-Application-Context: application:local:9000
Content-Length: 0
Date: Mon, 13 Nov 2017 11:15:36 GMT

```

## Login a User / Fetch Token
```
curl -i -H "Content-Type: application/json" -X POST -d '{"username":"user","password":"user"}' http://localhost:9000/api/auth

HTTP/1.1 200 
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
X-Application-Context: application:local:9000
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Mon, 13 Nov 2017 11:15:43 GMT

{
  "token" : "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXNpciIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUxMDU3MTc0MjAyMCwiZXhwIjoxNTExMTc2NTQyfQ.D4E7ZAiBbqhW2V3jw9-jtl6GDd2scHBpp0bMX9nUg-CpS8dmU5fe1pGDNHrtNlswPtwMrf0W27H87KSeJGVr8g" 
}

```

## Accessing TODO API

Without setting X-AUTH-TOKEN
```
curl -i -H GET http://localhost:9000/api/todo
HTTP/1.1 401 
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 14 Nov 2017 13:52:46 GMT

{
  "timestamp" : 1510667566718,
  "status" : 401,
  "error" : "Unauthorized",
  "message" : "Access Denied",
  "path" : "/api/todo"
}  
```

With setting X-AUTH-TOKEN
```
curl -i -H "X-AUTH-TOKEN":"eyJhbGciOiJIUzUxMiJ9.eyJdWIiOiJ1c2VyIiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNTEwNjY2NzAyNTUyLCJleHAiOjE1MTEyNzE1MDJ9.8LbOIWqiepORUj9xF4aYELUnWh6cyuKqdvj9Neo2zSZ1Jb5ZFHcpa6HLoOBKpz2E4DmpbMwo4Ad1VUUHPfvrXA" GET http://localhost:9000/api/todo

HTTP/1.1 200 
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
X-Application-Context: application:local:9000
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 14 Nov 2017 13:51:10 GMT

[ {
  "id" : 1,
  "task" : "I have to create a repo",
  "completed" : false
}, {
  "id" : 2,
  "task" : "Commit to the repo",
  "completed" : false
}, {
  "id" : 3,
  "task" : "Add proper README",
  "completed" : false
} ]
```

## Credits
[brahalla/Cerberus](https://github.com/brahalla/Cerberus) 
