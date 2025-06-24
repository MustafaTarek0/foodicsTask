Prerequisites Java Development Kit (JDK) installed. Maven installed. Web browser (Chrome/Firefox) installed. IDE (Eclipse/IntelliJ) installed.

Dependencies TestNG Selenium WebDriver Cucumber Gherkin rest assured

Clone this repository to your local machine.

Open the project in your preferred IDE then open the cloned project.

Install the required dependencies using Maven.

Locate the TestRunner class in the src/test/Test/Testing/TestRunner/Runners.java.

Reports are generated using Cucumber runner.




covered scenario: 



user navigated to amazon then clicks on side menue to select all video games then selects a random item below 15 k 

after filtering and sorting if not visible he navigates to next page but this wasn't tested becuase whenever i run the test case only one item appears

but its handeled in the script.

conditional waits are implemented for flaky tests 

then the make sure that the items are added in the cart and proceed with address and payment method but in my case cash on delivery was dimmed.

the secound test was for api by creating generic method for executing apis based on parameters for the method type and json file.


📁 Project Structure 
config/ – Loads configuration settings (e.g., base URL).

data/ – JSON payloads for API testing.

features/ – Cucumber feature files for UI & API scenarios.

Apis/ – API helper class to manage HTTP requests.

Pages/ – Page Object Model classes for UI automation.

StepDefs/ – Step definitions implementing Gherkin steps.

TestRunner/ – Cucumber test runner setup.

utilities/ – Utility classes (e.g., config readers).

target/ – Test reports and compiled outputs.

pom.xml – Maven configuration file.

