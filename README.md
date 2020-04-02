# demo

<H1>Demo Project </H1>

This project has been created to automate the Log In and Sign up functionality of an app called JioSaavn. This app is available on the app store. It is a music streaming platform.

<h3>How To Run The Tests</h3>

1. Make sure the TestNG plugin is installed for your IDE (I used Eclipse)
2. Make sure the whole Appium setup is also done on the machine i.e. Appium + Xcode
2. Right click on the testng.xml file in Eclipse
3. Select Run As > TestNG Suite

This will run the Log In test case and the Signup test case and generate the test report

<h3>About The Project</h3>

Page Object Model design has been used to create tests. Every view has its own page class which can be found at /src/test/java/pages. The /src/test/java/tests directory contains a BaseClass which is inherited to all the test classes and is responsible for setting up the test session and ending the test session. LoginTest class contains the tests relevant for this task. All the method names and variable names are very readable and easy to undertand. For dependency management I have used Maven.
