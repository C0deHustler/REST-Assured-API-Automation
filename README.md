# REST Assured API Automation Framework

This project is a Maven-based Hybrid API Test Automation Framework developed using Java, REST Assured, Cucumber BDD, and TestNG, following a scalable and modular design architecture.

It leverages the Behavior Driven Development (BDD) approach with Gherkin Feature Files to automate end-to-end REST API test scenarios, ensuring improved readability, reusability, and maintainability of test scripts.

Within this framework, multiple TestNG test suites have been created to execute various API test flows such as GET, POST, PUT, and DELETE requests, covering functional validation, response verification, and status code checks in a structured and scalable manner.

The framework integrates Allure Reports and Extent Reports for detailed API test execution reporting, and follows a layered architecture to support efficient request handling, response validation, and ease of maintenance.

---

## 📌 Tech Stack Used

- Java  
- REST Assured  
- TestNG  
- Cucumber BDD  
- Maven  
- Jackson API  
- Allure Reporting  
- Extent Reports  
- Eclipse IDE  
- Git & GitHub  

---

## 📂 Project Structure

```bash
rest-assured-api-automation
│── src/main/java
│   ├── base
│   ├── utilities
│   ├── endpoints
│   ├── payloads
│
│── src/test/java
│   ├── stepDefinitions
│   ├── runners
│
│── src/test/resources
│   ├── features
│   ├── config.properties
│   ├── testng.xml
│
└── pom.xml
```

---

## 🧱 Framework Design

This framework follows:

- Separation of Test Logic & API Request Handling  
- Reusable API Utility Methods  
- Payload Management using POJO Classes  
- Centralized Endpoint Management  
- Externalized Configuration using Properties File  
- Modular and Scalable Architecture  

---

## ⚙️ Features Implemented

✔ REST API Automation using REST Assured  
✔ Cucumber BDD Framework  
✔ Gherkin Feature Files  
✔ TestNG Test Execution  
✔ GET, POST, PUT, DELETE API Testing  
✔ Request & Response Validation  
✔ Maven Build Management  
✔ Allure Reporting Integration  
✔ Extent Reports Integration  
✔ External Configuration Support  
✔ Reusable Utilities  
✔ POJO-based Payload Handling  
✔ Scalable Framework Design  

---

## ▶️ How to Run the Project

### Prerequisites

- Java JDK (8 or above)  
- Maven Installed  
- Eclipse IDE  
- Internet Connection  

---

### Steps to Execute Tests

1. Clone the repository

```bash
git clone https://github.com/C0deHustler/REST-Assured-API-Automation.git
```

2. Import as Maven Project in Eclipse  

3. Run testng.xml file  

OR execute using Maven:

```bash
mvn clean test
```

---

## 📊 Test Execution

Test cases are managed and executed using:

- TestNG XML Suite  

You can execute:

- Individual API Tests  
- Test Suite  
- Entire Framework  

---

## 🔗 GitHub Repository

Project Link:

https://github.com/C0deHustler/REST-Assured-API-Automation

---

## 👨‍💻 Author

Ahmad Hamza Khan  
SDET | Automation Test Engineer
