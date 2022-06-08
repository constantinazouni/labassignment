1. Build the executable Java application with: 
	mvn package jacoco:report

2. Run the executable by executing
	java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
were args translate to: 	
	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	arg2 = “SourceCodeLocationType” [local|web]
	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	arg4 = “OutputFileType” [csv|json]
example: 
	java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv

# Architecture of the module
## UML Diagram 
![Test Image 1](https://raw.githubusercontent.com/constantinazouni/labassignment/developer2/sourcecodeanalyzer/recources/uml.png?token=GHSAT0AAAAAABSSKDRZKCZ4NRMYC6UQRX7UYU7JVWQ)

## Patterns

### Strategy
This pattern provides support for more than one default functionality. This means that we can have functionalities with some difference depending on the requirements of every case. This implementation allow us to adapt on every case. Also, in that way we can easily expand the functionalities of the program. As a result of using this pattern the complexity and the if-else statments of the code where reduce. Also, now we are able to handle differenet cases without writing a lot of code. The only drawback of that pattern is that the system must be aware of all the available strategies and choose each time the one that fitts better through the interface. I used strategy for the differenet types of analyzers, metrics, readers and exporters.

### Factory
Using this pattern we can create objects without showing the utiliazing method to the clients. Also, with factory we can create objects that refer to the same interface. So some of the benefits of this pattern is the seperation of the initialization from the logic of the program. Morover, this pattern allows each subclass to choose the type of object to generate and it is not needed to have application-specific classes into the code. Some disadvantages of that pattern is that we need to create a factory method for every different product and thus the class are increased and that it is applicable only to families of related objects.  I used this pattern to generate analyzer, reader and exporter objects.

### Façade

With this type o pattern we can give client access to the functionality of a component. That means that with facade we can mask more complex procedures. So this pattern provides some importan advantages like giving a simple interface to a complex system and promoting the independence of the subsystem. I used this pattern to remove the direct dependence of some components like the data analyzer and the exporter or the client and the data analyzer and the exporter. In that way the process is more simple and the client don’t need to know the classes or their relationships and dependencies. Some of the drawbacks of this pattern is that the approach is coupled to an additional level of indirection and that we need to create new classes for every indirection level. In order to implement this pattern I created the analyzer facade which is called by the client and is responsible for calling the data analyzer and start the analyzing process. After that analyzer facade call the exporter to export the output of the analysis.