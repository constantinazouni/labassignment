# Source Code Analyzer
A maven project that receives a Java source code file, analyzes it and exports the following metrics:
* LOC = lines of code
* NOM = number of methods
* NOC = number of classes
## Getting Started 
### Requirements
* [java](https://www.java.com/en/) installed
* [maven](https://maven.apache.org/) installed

### Installation
Clone
```
git clone https://github.com/constantinazouni/labassignment.git
```
Change path
```
cd ./labassignment
```
Build
```
mvn package jacoco:report
```

Run
```
java –jar ./sourcecodeanalyzer/target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar arg0 arg1 arg2 arg3 arg4
```
Where args translate to: 	
   *	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
   *	arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
   *	arg2 = “SourceCodeLocationType” [local|web]
   *	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
   *	arg4 = “OutputFileType” [csv|json]

Example
```
java –jar ./sourcecodeanalyzer/target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar sourcecodeanalyzer/src/test/resources/TestClass.java regex local outputs csv
```


# Architecture of the module
## UML Diagram 
![Test Image 1](https://raw.githubusercontent.com/constantinazouni/labassignment/developer2/sourcecodeanalyzer/recources/uml.png?token=GHSAT0AAAAAABSSKDRYATT6ARIFJGVNGZ4YYVAL6HQ)

## Patterns

### Strategy
This pattern provides support for more than one default functionality. This means that we can have functionalities with some difference depending on the requirements of every case. This implementation allow us to adapt on every case. Also, in that way we can easily expand the functionalities of the program. As a result of using this pattern the complexity and the if-else statments of the code where reduce. Also, now we are able to handle differenet cases without writing a lot of code. The only drawback of that pattern is that the system must be aware of all the available strategies and choose each time the one that fitts better through the interface. I used strategy for the differenet types of analyzers, metrics, readers and exporters.

### Factory
Using this pattern we can create objects without showing the utiliazing method to the clients. Also, with factory we can create objects that refer to the same interface. So some of the benefits of this pattern is the seperation of the initialization from the logic of the program. Morover, this pattern allows each subclass to choose the type of object to generate and it is not needed to have application-specific classes into the code. Some disadvantages of that pattern is that we need to create a factory method for every different product and thus the class are increased and that it is applicable only to families of related objects.  I used this pattern to generate analyzer, reader and exporter objects.

### Façade

With this type o pattern we can give client access to the functionality of a component. That means that with facade we can mask more complex procedures. So this pattern provides some importan advantages like giving a simple interface to a complex system and promoting the independence of the subsystem. I used this pattern to remove the direct dependence of some components like the data analyzer and the exporter or the client and the data analyzer and the exporter. In that way the process is more simple and the client don’t need to know the classes or their relationships and dependencies. Some of the drawbacks of this pattern is that the approach is coupled to an additional level of indirection and that we need to create new classes for every indirection level. In order to implement this pattern I created the analyzer facade which is called by the client and is responsible for calling the data analyzer and start the analyzing process. After that analyzer facade call the exporter to export the output of the analysis.

### Null Object (candidate)
This pattern implements its interface to do nothing for specific client behaviors. In that way it simplifies the client code because it is not needed to write code or 
testing which handles the null cases. Some of the disadvantages of null object are that it hides errors because it doesn't indicate exactly where the problem occurred and that you can't show exactly what type of exception occured. In this case null object was a candidate pattern to use but I didn't implemented because I believe that it has significant disadvantages. In this program I could use the null object to handle the cases where the user gives invalid types of readers, analyzers or exporters. For this purpose I would have to create null classes that implement nothing. Every time that I want to add a new method to the interface I would have to add the same method that implements nothing at the null class as well. Otherwise the progam will fail. Also with null object I can't track where the error occured and what exaclty was the exception. For those reasons I opted to not use this pattern. 