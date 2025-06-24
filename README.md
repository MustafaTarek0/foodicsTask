# Foodics Task

This project demonstrates end-to-end UI and API automation testing using Java, Selenium WebDriver, TestNG, Cucumber, and Rest Assured.

## Prerequisites

- **Java Development Kit (JDK)** installed
- **Maven** installed
- **Web browser:** Chrome or Firefox
- **IDE:** Eclipse, IntelliJ, or any preferred Java IDE

## Dependencies

The following libraries are used in this project:

- TestNG
- Selenium WebDriver
- Cucumber
- Gherkin
- Rest Assured

All dependencies are managed via Maven.

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/MustafaTarek0/foodicsTask.git

2.Open the project:
Launch your preferred IDE and open the cloned project directory.

3.Install dependencies:
Run the following command in the project root to install dependencies:

4.Locate the test runner:
The TestRunner class is located at:
src/test/Test/Testing/TestRunner/Runners.java

5.Run the tests:
Execute the tests using your IDE or via Maven commands.

6.View Reports:
Test reports are generated using the Cucumber runner and saved in the target/ directory.

Scenarios Covered

UI Automation

User navigates to Amazon and clicks on the side menu to select "All Video Games".

Selects a random item with a price below 15,000.

If the item is not found on the first page after filtering and sorting, the script handles navigation to the next page (although, in practice, only one item appeared during testing).

Conditional waits are implemented for flaky tests.

Adds the item to the cart and proceeds to address and payment selection (note: "Cash on Delivery" was disabled during testing).


API Automation

A generic method is implemented to execute API requests based on parameters such as method type and JSON file input.


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

