# seleniumAutomationProject

## This is the final project in the Selenium WebDriver Course





###TestNG Maven Integration

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
3. Instantiate Logger in tests and use it.  ( private static Logger log = LogManager.getLogger(Demo.class.getName());)



