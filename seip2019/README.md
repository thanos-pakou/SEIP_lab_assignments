# seip2019

## Description
This directory is the parent module in the maven project. Every project inside this directory is 
a child of seip2019 and a standalone project.

## Projects
The projects are listed below

### [Grades Histogram](gradeshistogram)

This project contains a java application built with maven which reads a txt file with students'
grades data, generates a frequency chart and presents it to the user. Its purpose is to help user gets 
familiar with a building tool.

[README](gradeshistogram/README.md)  file for gradeshistogram


### [Source Code Analyser](codeAnalyser)
This project contains a java application built with maven which reads a java file and then
calculates 3 metrics (Lines of code excluding blank and comments, number of classes and number
of method) using either analysis with regular expressions or string comparison. In the end it writes
a csv file with the results and saves it in the ```seip2019/codeAnalyzer/src/main/resources``` directory

[README](codeAnalyser/README.md)  file for codeAnalyser

### [Unit Testing](unitTesting)
This project contains a java application built with maven which have many functionalities like
reading a file, add positive numbers etc. The gold of this project is to test all the classes and their
methods using the appropriate testing cases with JUnit. 

[README](unitTesting/README.md)  file for unitTesting

