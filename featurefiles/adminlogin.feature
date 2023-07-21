@tag
Feature: Admin Login
    I want to use this template to validate Admin Login

@tag1
Scenario: Check Admin Login with Valid Inputs

    Given i open browser with the url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see Admin page
    And  i click logout
    Then i should see login page
    When i close browser
    
 @tag2
 Scenario Outline: Check Admin Login with Invalid Inputs

    Given i open browser with the url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "<uid>"
    And i enter password as "<pwd>"
    And i click login
    Then i should see error messege
    When i close browser
    
    Examples:
|uid|pwd|
|ABC|XYZ|
|Admin|xyz|
|xyz|Qedge123!@#|

 @tag3
 Scenario: check new employee registration
 
    Given i open browser with the url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see Admin page
 ## Then i click PIM
 ## And i click ADD EMPLOYEE
    When i goto Employee Registration page
    And i enter Firstname "Bhima"
    And i enter Lastname  "A"
    And i click save
    Then i should see Registered employee in Employee List
    And  i click logout
    Then i should see login page
    When i close browser
 
 
 
 
