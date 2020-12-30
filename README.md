# seleniumAutomationProject

## This is the final project in the Selenium WebDriver Course





###TestNG Maven Integration

Using Suite XML Files

Copy from https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html  a plugin surefire,
wrap into "build"  and put into pom.xml.

<plugins>
    [...]
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M5</version>
        <configuration>
          <suiteXmlFiles>
            <suiteXmlFile>testng.xml</suiteXmlFile>
          </suiteXmlFiles>
        </configuration>
      </plugin>
    [...]
</plugins>



