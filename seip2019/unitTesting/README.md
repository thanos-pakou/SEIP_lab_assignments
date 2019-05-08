# unitTesting

## Description

This project contains a java application built with maven which have many functionalities like
reading a file, add positive numbers etc. The gold of this project is to test all the classes and their
methods using the appropriate testing cases with JUnit. 


## Technology Stack
* Java -version 10.0.2
* Apache Maven -version 3.5.3
* JUnit 4.12 (maven dependency)
* mockito 2.25.1 (maven dependency)

## Run the application

To run the application you need:
* [Java](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
* [Gitbash](https://git-scm.com/downloads)
* [Apache Maven](https://maven.apache.org/download.cgi)

installed in your machine


Then, you need to clone the project to your local machine. Download Git, and open gitbash to the location you want the project to be in. Then type
```
git clone https://github.com/thanos-pakou/SEIP_lab_assignments_2019.git
```


Once you are done open a terminal and navigate to the folder seip2019. Then type
```
mvn install
```

This will generate a target directory in the seip2019/UnitTesting. After that you can run
```
mvn test
```
on the seip2019/UnitTesting directory and you will see the results of the tests.

You can also run 
```
mvn -Dtest=IntegerOperationsTestSuite test
```

to run the Integer Operations Test suite.