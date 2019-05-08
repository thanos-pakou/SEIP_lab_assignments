# gradeshistogram

## Description

This is a maven project. The source code receives a text file with students' grades, generates a chart with the grades' frequencies and shows it to the user.
Apache Maven CI is responsible for packaging the whole project with the dependencies necessary so that 
anyone with java and maven installed in his/her local machine can run the application just by generating and
running the excitable jar file.

## Technology Stack
* Java -version 10.0.2
* Apache Maven -version 3.5.3

The source code uses the JFreeChart library for generating and showing the chart.

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

This will generate a target directory in the seip2019/gradeshistogram. Navigate to that file via terminal and type
```
java -jar gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar ../src/main/resources/grades.txt
```

If everything is ok you will be able to see a frame with the generated histogram on your screen.