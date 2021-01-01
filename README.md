# seleniumAutomationProject

## This is the final project in the Selenium WebDriver Course





### TestNG Maven Integration

Using Suite XML Files

Copy from https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html  a plugin surefire,
wrap into "build"  and put into pom.xml.


To run tests by maven:

1. mvn clean  - cleans all previous tests
2. mvn compile - checks sintax errors
3. mvn test  -  run test


### Adding logs

1. add dependencies into pom.xml (core and api);
2. add log4j2.xml file intp path folder.
3. add into build of pom.xml  --> plugin 
	"<resources>
      <resource>
        <directory>src/main/java/resources</directory>
        <filtering>true</filtering>
      </resource>
     </resources>"
4. Instantiate Logger in tests and use it.  ( private static Logger log = LogManager.getLogger(Demo.class.getName());)
5. After test refresh main folder and check log files.

### If browsers wait open until the test ending

Wrap them all individual test cases

### Parallel tests running
add into testng.xml 
"<suite name="Suite" parallel="tests">"


### Implementation ITestListener interface 

public class Listeners implements ITestListener  and implement all methods of this interface

Example of using  you can find in the method onTestFailure, where when a test fails, the screenshot of page will be taken 
and saved into file.

### Extent report example


1. Add extent report dependency to pom.xml
2. Define Extent Reports methods as in class ExtentReporterNG
3. Use instances as in Listener class
4. After running test update Project folder, open index.html file

Above defined works well  fer sequential execution, but parallel running won't work correctly.

To work on parallel mode, we need to create an instance of ThreadLocal class to be ThreadSafe
 "ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>()"
 Usage of tests
 "extentTest.get().log(Status.PASS, "Test Passed")"
 
 #### getting screenshot in extent report
 extentTest.get().addScreenCaptureFromPath(getScreenShot(failedTestMethod, driver), failedTestMethod);
 extentTest.get()  == test instance
 











