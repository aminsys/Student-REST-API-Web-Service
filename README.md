# Student-REST-API-Web-Service
A REST API web service to mange students repository in MongoDB container.

## Notes
* Every time the application is started and it connects to an already running MongoDB container, it will insert same documents specified in class `StudentConfig.java` with new IDs. To avoid this, the following database operation can be run to drop all documents before starting the application again:
  
  ``` NoSQL
  db.[NAME OF COLLECTION].drop()
  ```

## Getting started
To pull the latest version of a MongoDB image from Docker (assuming a copy of this repo is already setup on development machine), using the following command in terminal:
``` powershell
docker pull mongo
```

you can run the pulled image with the following command:
``` powershell
docker run -d --name my-mongo-container -p 27017:27017 mongo
```

To connect your application to the newly started MongoDB container, add the following connection parameters into the `application.properties` file:
``` bash
spring.data.mongodb.host=172.17.0.2
spring.data.mongodb.port=27017
spring.data.mongodb.database=[NAME OF THE DATABASE TO BE USED/ CREATED IN THE MONGODB CONTAINER]
```
## Check that data is being saved into the database
To verify that the application is connected correctly to the MongoDB database, an interactive shell environment can be opened:
1. If VS Code is being used and the Docker extension is installed, simply right-click on the running container and choose "Attach Shell" as illustrated in the following image (pay no attention to the containers shown in the image below):

   ![image](https://github.com/aminsys/Student-REST-API-Web-Service/assets/18234996/efae628c-d836-4992-aa46-a6278ef95a21)

2. Through terminal:
   ``` bash
   docker exec -it [THE NAME OF THE CREATED MONGODB CONTAINER] bash
   ```


Once the shell is accessed through terminal, input the following command to gain a MongoDB interface:
``` shell
mongosh
```
Here, the existance of database can be checked by running the following command:
``` shell
show databases # to check existance of databases
show collections # To check existance of collections
```

Notice that if the command `show collections` doesn't return anything, it means that it doesn't contain any documents (the name of data entries in MongoDB) even if the collection exists. Another way to check wether a collection contains any documents is through running this operation:
``` NoSQL
db[NAME OF COLLECTION].find()
```

A sample of how a document looks like is as following:
``` JSON
  {
    _id: ObjectId("64a5534e3a8b06354b206082"),
    name: 'Jane Doe',
    grade: 91,
    _class: 'com.student.studentregistration.Student'
  }
```

