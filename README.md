# jwt-auth-springboot
:key: Sample Spring boot application for Authentication and Authorization

## Features
* Customizable header(X-Auth-Token) to pass Auth token.
* JWT for token creation and validation.
* Role based authorization.
* Device based auth.
* Custom Validators
* OpenApi and Swagger integration.


## Running the sample app
```
mvn spring-boot:run
```

## Registering a User
```
curl -X POST "http://localhost:9000/api/auth/register" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"username\":\"nasruddin\",\"password\":\"p@ssw00d\",\"device\":\"web\",\"email\":\"nasruddin@gmail.com\"}"

{
  "id": 1,
  "username": "nasruddin",
  "password": "$2a$10$LWgocVblwyrOolL0SyUdt.fUpqdGZ8kzddUGw4d/NeFc0f/lcHf9a",
  "email": "nasruddin@gmail.com",
  "lastPasswordReset": "2020-12-09T15:04:10.391+00:00",
  "authorities": "ADMIN"
}

cache-control: no-cache,no-store,max-age=0,must-revalidate 
connection: keep-alive 
content-type: application/json 
date: Wed,09 Dec 2020 15:04:10 GMT 
expires: 0 
keep-alive: timeout=60 
pragma: no-cache 
transfer-encoding: chunked 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
x-content-type-options: nosniff 
x-xss-protection: 1; mode=block 
```

## Login a User / Fetch Token
```
curl -X POST "http://localhost:9000/api/auth" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"username\":\"nasruddin\",\"password\":\"p@ssw00d\",\"device\":\"web\"}"

{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXNydWRkaW4iLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE2MDc1MjY0NzkzMjEsImV4cCI6MTYwODEzMTI3OX0.AWNn3WcAo8E65r2nT049fKBhQoPVoAeNpENvPQp-sLJEj6ubo5bBk0waeV1mZD6Ydvqcrj0XE0LBuwE9fI3qEw"
}

 cache-control: no-cache,no-store,max-age=0,must-revalidate 
 connection: keep-alive 
 content-type: application/json 
 date: Wed,09 Dec 2020 15:07:59 GMT 
 expires: 0 
 keep-alive: timeout=60 
 pragma: no-cache 
 transfer-encoding: chunked 
 vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
 x-content-type-options: nosniff 
 x-xss-protection: 1; mode=block 
```

## Accessing User/Protected API

Without setting X-AUTH-TOKEN
```
curl -X GET "http://localhost:9000/api/user/nasruddin" -H  "accept: */*"

{
  "timestamp": "2020-12-09T15:10:49.028+00:00",
  "status": 401,
  "error": "Unauthorized",
  "message": "",
  "path": "/api/user/nasruddin"
}

cache-control: no-cache,no-store,max-age=0,must-revalidate 
connection: keep-alive 
content-type: application/json 
date: Wed,09 Dec 2020 15:10:49 GMT 
expires: 0 
keep-alive: timeout=60 
pragma: no-cache 
transfer-encoding: chunked 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
x-content-type-options: nosniff 
x-xss-protection: 1; mode=block 
```

With setting X-AUTH-TOKEN
```
curl -X GET "http://localhost:9000/api/user/nasruddin" -H  "accept: */*" -H  "X-Auth-Token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXNydWRkaW4iLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE2MDc1MjY0NzkzMjEsImV4cCI6MTYwODEzMTI3OX0.AWNn3WcAo8E65r2nT049fKBhQoPVoAeNpENvPQp-sLJEj6ubo5bBk0waeV1mZD6Ydvqcrj0XE0LBuwE9fI3qEw"

{
  "id": 1,
  "username": "nasruddin",
  "password": "$2a$10$LWgocVblwyrOolL0SyUdt.fUpqdGZ8kzddUGw4d/NeFc0f/lcHf9a",
  "email": "nasruddin@gmail.com",
  "lastPasswordReset": "2020-12-09T15:04:10.391+00:00",
  "authorities": "ADMIN"
}

cache-control: no-cache,no-store,max-age=0,must-revalidate 
 connection: keep-alive 
 content-type: application/json 
 date: Wed,09 Dec 2020 15:12:19 GMT 
 expires: 0 
 keep-alive: timeout=60 
 pragma: no-cache 
 transfer-encoding: chunked 
 vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
 x-content-type-options: nosniff 
 x-xss-protection: 1; mode=block 
```

## Admin API
```
curl -X GET "http://localhost:9000/api/admin" -H  "accept: */*" -H  "X-Auth-Token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXNydWRkaW4iLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE2MDc1Mjc1MTUzNjMsImV4cCI6MTYwODEzMjMxNX0.zHcWtUW43dXOQs8WGy1ItrMyc8gyBNf8j_irFz09lGkR7flYsNi3-o8mjYe1rqjg4SzcG8qRdbqEC7dvGASjTQ"

:O

cache-control: no-cache,no-store,max-age=0,must-revalidate 
connection: keep-alive 
content-length: 2 
content-type: text/plain;charset=UTF-8 
date: Wed,09 Dec 2020 15:26:01 GMT 
expires: 0 
keep-alive: timeout=60 
pragma: no-cache 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
x-content-type-options: nosniff 
x-xss-protection: 1; mode=block 
```

## OpenAPI Swagger
![Swagger](https://github.com/Nasruddin/spring-boot-jwt-auth/blob/master/images/swagger.PNG?raw=true)

## Credits
[brahalla/Cerberus](https://github.com/brahalla/Cerberus) 
