# Cross-Browser-Java-Selenium-Tests


# Setup and Running Instructions for Cross-Browser Selenium Tests






Prerequisites:
Java: Ensure that Java is installed on your machine. You can check by running the following command:


java -version
Maven: Use Maven to handle project dependencies. Verify that Maven is installed by running:


mvn -version
IDE: An IDE such as Eclipse or IntelliJ IDEA to manage and run the tests.

WebDriver Executables:

Download the appropriate WebDriver executables for each browser:
ChromeDriver: Download here
FirefoxDriver (GeckoDriver): Download here
EdgeDriver: Download here
Ensure the WebDriver executables are available in your system's PATH or specify their location in your project.
Project Structure:

Steps to Set Up:

##1. Download WebDriver Executables:
Download the appropriate WebDriver for the browsers you intend to test (Chrome, Firefox, Edge).

Set up the WebDriver executables by either adding them to your system's PATH or specifying their location in the BasePage.java setup code.



You can also leave this file empty and configure the browser and test URL via TestNG parameters in testng.xml.

2.Add Dependencies in pom.xml:
   Make sure your pom.xml includes the necessary dependencies for Selenium, TestNG, and WebDriver:

xml


<dependencies>
    <!-- Selenium dependency -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>

    <!-- TestNG dependency -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

3.Set Up testng.xml for Cross-Browser Testing:
   The testng.xml file allows you to run tests on multiple browsers. Here’s an example configuration:

xml

<suite name="CrossBrowserTestSuite">
    <test name="ChromeTest">
        <parameter name="browser" value="chrome"/>
        <parameter name="testurl" value="https://example.com"/>
        <classes>
            <class name="testPackage.tests.TestClass"/>
        </classes>
    </test>
    <test name="FirefoxTest">
        <parameter name="browser" value="firefox"/>
        <parameter name="testurl" value="https://example.com"/>
        <classes>
            <class name="testPackage.tests.TestClass"/>
        </classes>
    </test>
    <test name="EdgeTest">
        <parameter name="browser" value="edge"/>
        <parameter name="testurl" value="https://example.com"/>
        <classes>
            <class name="testPackage.tests.TestClass"/>
        </classes>
    </test>
</suite>

This configuration will run the tests in three different browsers: Chrome, Firefox, and Edge.
How to Run the Script:
Run Tests from the IDE:

Right-click on testng.xml file in your IDE (e.g., Eclipse or IntelliJ) and select Run As → TestNG Suite.
This will run all the tests defined in the testng.xml, executing them on different browsers as per the configuration.
Run Tests Using Maven: If you prefer to run tests from the command line, you can execute the following Maven command:


mvn test
Maven will execute the tests specified in testng.xml, using the parameters defined in the XML file or falling back to default values in config.properties.
Running with Command Line Arguments: You can also run tests with specific parameters from the command line by passing values to Maven:


mvn test -Dbrowser=chrome -Dtesturl=https://www.fitpeo.com/

Test Flow:
Setup:

WebDriver initializes based on the browser specified in the TestNG parameters (chrome, firefox, or edge).
The browser opens the specified testurl.

Test Execution:

The tests defined in your TestClass are executed after the setup is complete.

Teardown:

After the tests are complete, the WebDriver is closed using driver.quit().

Troubleshooting:

Browser Not Launching:

Ensure that the correct WebDriver executable is set up in your PATH or correctly specified in the code.

Parameter Not Found:

Make sure all parameters (browser and testurl) are either passed in the testng.xml or are defined with default values in @Optional.

Timeout Issues:


Passing all the locaters from locators.xml file inside locater folder.

Utils folder contains LocatorsReader class that has all the logic to read locators from xml file 

Pages folder contains classes like RevenueCalculatorPage and HomePage that has all the methods.

Test folder has FitPeoTest class where we are calling all the methods. 

Increase the timeouts if the page takes longer to load. Update the pageLoadTimeout and implicitlyWait times in the BasePage class.
