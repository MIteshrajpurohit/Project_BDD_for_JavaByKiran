#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: WebSite Dashboard
Scenario: Verify Dashboard
Given user should be on login page
When  User enter valid username and Password
|kiran@gmail.com|123456|
Then User should be on Dashboard page 

Scenario: Verify User page is open
Given user should be on login page
When  User enter valid username and Password
|kiran@gmail.com|123456|
Then User should be on Dashboard page
Then  User click on User link and User page should open

Scenario: Verfiy add User functionality
Given user should be on login page
When  User enter valid username and Password
|kiran@gmail.com|123456|
Then User should be on Dashboard page
Then  User click on User link and User page should open
Then  User enter user details
|Mitesh Rajpurohit|1234567890|mitesh@gmail.com|Selenium|123456|4487654321|
Then User click on Submit button
@Dash
Scenario: Verify UseFullLinks links functionality
Given user should be on login page
When  User enter valid username and Password
|kiran@gmail.com|123456|
Then User should be on Dashboard page
Then  User click on UserFul links  and User page should open
Then User Click on GO button and page should open






