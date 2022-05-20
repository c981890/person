# person application

* Clone to computer<br>
  $git clone https://github.com/c981890/person.git 
  <br><br> 
* Compile <br>
  change directory to person <br>
  $mvn compile
  <br><br>
* Make the package <br>
  $mvn package
  <br><br>
* Run the application <br>
  After previous step a new jar file is created into the target folder <br>
  $java -jar target/person-0.0.1-SNAPSHOT.jar
  <br><br>
* After using close the application with Ctrl+c
  <br><br>

Access to H2 database console from web browser localhost:8888/h2-console <br>
You can use cURL or Postman to try the application.<br>
For adding users to database <br>
![img.png](img.png)

For request to see all added persons <br>
![img_1.png](img_1.png)

For searching <br>
![img_3.png](img_3.png)


  