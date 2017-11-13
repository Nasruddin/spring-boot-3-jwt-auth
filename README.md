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
curl -i -H "Content-Type: application/json" -X POST -d '{"username":"user","password":"user"}' http://localhost:8080/api/auth/register

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
curl -i -H "Content-Type: application/json" -X POST -d '{"username":"user","password":"user"}' http://localhost:8080/api/auth

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

## Credits
[brahalla/Cerberus](https://github.com/brahalla/Cerberus) 
