# SelfProject
## About
I had to creat automated tests for Automation Exercise website where there are pre-made test cases.
Here you can find the website https://www.automationexercise.com
## Dependencies
- JDK 19
- MAVEN 3.8.7

## Config file

- You will need to create a config file with the given parameters below.


| url               | The Automation Exercise website       |
|-------------------|---------------------------------------|
| correctUsername   | A valid username                      |
| correctPassword   | A valid password                      |
| correctEmail      | A valid email                         |
| incorrectPassword | An invalid password                   |
| incorrectEmail    | An invalid email                      |
| firstName         | Any first name                        |
| lastName          | Any last name                         |
| address1          | Any address                           |
| address2          | Any address                           |
| state             | Any state                             |
| city              | Budapest                              |
| zipCode           | Any zipcode                           |
| mobileNumber      | Any mobile number                     |
| loginCorrectEmail | An email that is already registered   |
| loginCorrectPassword | A password that is already registered |

## How to run a test from command line
 - Open cmd or any terminal on your computer, navigate to the project and type this command: 
```
mvn test -Dtest="required test class name"
```
 and if you want the login test you will need a few argument ->
 ```
 -DloginCorrectEmail=the email that you gave in the config file
 ```
```
-DloginCorrectPassword=the password that you gave in the config file.
```
 - So the full command will look like this (example):
```
 mvn test -Dtest="LogIntest#successLogIn" -DloginCorrectEmail=exampleEmail -DloginCorrectPassword=examplePassword
 ```

