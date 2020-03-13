## Todo App

This is very basic versions of Todo App. This was developed using
 - Spring Boot
 - Spring Security
 - Spring Data JPA 
 - Hibernate
 - MySQL
 - JSP
 - Bootstrap
 - Docker Compose
 
***Functionality***
- UI and APIs for login and registration flow
- Basic APIs for Todo management

### Todo:
- Need to add unit testing
- Need to add proper error handling
- Need to add proper logs mechanism
- Need to add methods for enforcing code quality
- Need to add few more features to make it more robust
- Need to handle some of edge cases
- Need to add better authorization like JWT/OAuth
- Need to add UI support for Todo operations
- Need to add better management for category deletion and its linking to Users

### Run Applications

```bash
cd todoapp
docker-compose up
```

### Test APIs
```bash
//Register Users
curl -X POST \
  http://localhost:8080/api/v1/registration \
  -H 'content-type: application/json' \
  -d '{
  "username": "test1234",
  "password": "test1234",
  "passwordConfirm": "test1234",
  "lastName": "Kumar",
  "firstName": "Vivek",
  "email": "vivekiitb544@gmail.com",
  "mobileNumber": "+971506708336",
  "gender": "Male"
}'

//Login Users
curl -X POST http://localhost:8080/api/v1/login --user test1234:test1234 -v

//Get the JSESSIONID from login response and use it for follow up requests

//Create Category 
curl -X POST \
  http://localhost:8080/api/v1/category \
  -b 'JSESSIONID=7F029D78B52B06D9EA5001250EBD1E3D' \
  -H 'content-type: application/json' \
  -d '{
	"name": "taskType1"
}'

//Create Todo 
curl -X POST \
  http://localhost:8080/api/v1/create/todo \
  -b 'JSESSIONID=7F029D78B52B06D9EA5001250EBD1E3D' \
  -H 'content-type: application/json' \
  -d '{
	"name": "test task",
	"description": "test task",
	"categoryId": 1
}'

//Create one more Category 
curl -X POST \
  http://localhost:8080/api/v1/category \
  -b 'JSESSIONID=7F029D78B52B06D9EA5001250EBD1E3D' \
  -H 'content-type: application/json' \
  -d '{
	"name": "taskType2"
}'

//Create one more Todo 
curl -X POST \
  http://localhost:8080/api/v1/create/todo \
  -b 'JSESSIONID=B0E4BD39DB5737194EAC72FFDF4B40C7' \
  -H 'content-type: application/json' \
  -d '{
	"name": "test task 2",
	"description": "test task 2",
	"categoryId": 2
}'

//Get Todo
curl -X GET http://localhost:8080/api/v1/list/todo -b 'JSESSIONID=7F029D78B52B06D9EA5001250EBD1E3D' -v


//Update Todo 
curl -X PUT \
  http://localhost:8080/api/v1/update/todo \
  -b 'JSESSIONID=7F029D78B52B06D9EA5001250EBD1E3D' \
  -H 'content-type: application/json' \
  -d '{
	"id": "1",
	"status":"STARTED"
}'

//Delete Category 
curl -X DELETE \
  http://localhost:8080/api/v1/category/{categoryId} \
  -b 'JSESSIONID=7F029D78B52B06D9EA5001250EBD1E3D' \
  -H 'content-type: application/json'
```

### Test UI Flow
- http://localhost:8080/registration: to register new users from UI
- http://localhost:8080/login: to login user
