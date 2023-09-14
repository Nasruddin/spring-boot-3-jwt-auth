# jwt-auth-springboot
:key: Sample Spring boot application for Authentication and Authorization

## Features
* Customizable header(X-Auth-Token) to pass Auth token.
* JWT for token creation and validation.
* Role based authorization.
* Device based auth.
* Custom Validators
* Spring doc.


## Running the sample app
```
mvn spring-boot:run
```

## Registering a User
```
curl -X POST "http://localhost:9000/api/auth/register" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"username\":\"nasruddin\",\"password\":\"p@ssw00d\",\"device\":\"web\",\"email\":\"nasruddin@gmail.com\"}"
```

```
{
    "id":2,
    "username":"nasruddin",
    "password":"$2a$10$U3CR4T1Gowd50Q.0yK/UuOh.XWVx0BYIe7BiAmymXZ.MYPUtU5F.e",
    "email":"nasruddin@gmail.com",
    "lastPasswordReset":"2023-09-14T08:41:10.080+00:00",
    "authorities":"ADMIN"
}
```
H2-console can be accessed at <http://localhost:9000/api/h2-console>
![JWT Decoded](https://github.com/Nasruddin/spring-boot-jwt-auth/blob/pom-update/images/h2-console.png?raw=true)

## Login a User / Fetch Token
```
curl -X POST "http://localhost:9000/api/auth" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"username\":\"nasruddin\",\"password\":\"p@ssw00d\",\"device\":\"web\"}"
```
```
{"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXNydWRkaW4iLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE2OTQ2ODE2ODE3MDUsImV4cCI6MTY5NTI4NjQ4MX0.MydwIWzN3SgCvB8cYozKcR2tHMCM5nrIPXUBtx4o82ot1taL_NQM5TRHZ4yOc9uUcZFrz1XQAL_fDNXAIwmZxw"}
```

![JWT Decoded](https://github.com/Nasruddin/spring-boot-jwt-auth/blob/pom-update/images/decoded-jwt.png?raw=true)

## Accessing User/Protected API

Without setting X-AUTH-TOKEN
```
curl -X GET "http://localhost:9000/api/user/nasruddin" -H  "accept: */*"
```
```
{
    "timestamp":"2023-09-14T08:57:08.403+00:00",
    "status":401,
    "error":"Unauthorized",
    "path":"/api/user/nasruddin"
} 
```

With setting X-AUTH-TOKEN
```
curl -X GET "http://localhost:9000/api/users/nasruddin" -H  "accept: */*" -H  "X-Auth-Token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXNydWRkaW4iLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE2OTQ2ODE2ODE3MDUsImV4cCI6MTY5NTI4NjQ4MX0.MydwIWzN3SgCvB8cYozKcR2tHMCM5nrIPXUBtx4o82ot1taL_NQM5TRHZ4yOc9uUcZFrz1XQAL_fDNXAIwmZxw"
```
```
{
    "id":1,
    "username":"nasruddin",
    "password":"$2a$10$dq6uFlehtetsfI6glLkA.OaeoIEu5PPqIVNZHDMCCiEej8b/0vhWa","email":"nasruddin@gmail.com",
    "lastPasswordReset":"2023-09-14T08:42:37.758+00:00",
    "authorities":"ADMIN"
} 
```

## Admin API
```
curl -X GET "http://localhost:9000/api/admin" -H  "accept: */*" -H  "X-Auth-Token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXNydWRkaW4iLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE2OTQ2ODE2ODE3MDUsImV4cCI6MTY5NTI4NjQ4MX0.MydwIWzN3SgCvB8cYozKcR2tHMCM5nrIPXUBtx4o82ot1taL_NQM5TRHZ4yOc9uUcZFrz1XQAL_fDNXAIwmZxw"
```
```
:O
```

## OpenAPI Swagger
1. Swagger can be accessed at <http://localhost:9000/api/swagger-ui/index.html>

![Swagger](https://github.com/Nasruddin/spring-boot-jwt-auth/blob/pom-update/images/swagger.png?raw=true)

2. API Docs can be accessed at <http://localhost:9000/api/api-docs>
![API Docs](https://github.com/Nasruddin/spring-boot-jwt-auth/blob/pom-update/images/open-api.png?raw=true)
