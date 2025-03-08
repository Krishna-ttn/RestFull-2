**Q1)Internationalization 
A) Add support for Internationalization in your application allowing messages to be shown in English, German and Swedish, keeping English as default.
B) Create a GET request which takes "username" as param and shows a localized message "Hello Username". (Use parameters in message properties)**

present in: /controller/SayHelloController.java , /service/SayHelloService.java , messages.properties , messages_de.properties,messages_sv.properties

**Q2)Content Negotiation
A) Create POST Method to create user details which can accept XML for user creation. 
B) Create GET Method to fetch the list of users in XML format.**

present in : /controller/UserController , /service/UserService , /models/User

**Q3)Swagger 
A) Configure the swagger plugin and create a document of the following methods: Get details of the User using GET request.
Save details of the user using POST request. Delete a user using DELETE request.
B) In swagger documentation, add the description of each class and URI so that in swagger UI the purpose of class and URI is clear.**

present in : pom.xml , /model/User , /controller/UserController
![image](https://github.com/user-attachments/assets/76fc4b8a-f839-4dda-a25a-e57300c72098)

**Q4)Static and Dynamic filtering 
A) Create API which saves details of User (along with the password) but on successfully saving returns only non-critical data. (Use static filtering) 
B) Create another API that does the same by using Dynamic Filtering.**

A) present in : /model/Users (used @JsonIgnore) , /controller/UserController
B) present in : /model/UserDynamicFilter  , /controller/UserDynamicControlloer
used a diffrent model for dynamic Filtering , if applied to any Other user class for eg UserEnhanced , then would have to use filter in every Api

**Q5)Versioning Restful APIs Create 2 API for showing user details. 
The first api should return only basic details of the user and the other API should return more/enhanced details of the user, Now apply versioning using the following methods:
A) MimeType Versioning B) Request Parameter versioning C) URI versioning D) Custom Header Versioning**

present in : /controller/UserEnhaced

**Q6)HATEOAS A) Configure hateoas with your springboot application. Create an api which returns User Details along with url to show all topics.**

present in : /controller/UserEnhancedController , 




