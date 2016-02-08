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
curl -i -H "Content-Type: application/json" -X POST -d '{"username":"user","password":"user"}' http://localhost:8080/api/auth
```

## Credits
[brahalla/Cerberus](https://github.com/brahalla/Cerberus) 
