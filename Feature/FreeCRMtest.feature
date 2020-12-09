@FreeCRMTest
Feature: FreeCRM Website

#Login Scenario Creation
@LoginTest
Scenario: Successful Login
    Given User is on Login page
    When User enters valid UserName and Password 
    And clicks on login
    Then User should be navigated to Home Page
    
@InvalidLoginTest
Scenario Outline: Failure to Login when invalid credentials are entered
    Given User is on Login page
    When User enters "<UserName>" and "<Password>" 
    And clicks on login
    Then Displays an alert Message
Examples:
|UserName|Password|
|        |ramu1|
|Raghu|    |
|helloselenium|regular|
    
#Contact creation Scenario

@contacts
Scenario: Successful creation of contact
    Given User is on Home page
    When user clicks on contacts
    And user navigated to contacts page
    Then User clicks on new
    Then User is able to create a new contact on filling the FirstName and LastName fields

@InvalidFirstName
Scenario: Failure in contact creation by leaving FirstName field empty
    Given User is on Home page
    When user clicks on contacts
    And user navigated to contacts page
    Then User clicks on new
    But User leaves the FirstName field empty and clicks on save
    Then Display an firstname alert Message

@InvalidLastName
Scenario: Failure in contact creation by leaving LastName field empty
    Given User is on Home page
    When user clicks on contacts
    And user navigated to contacts page
    Then User clicks on new
    But User leaves the LastName field empty and clicks on save
    Then Display an lastname alert Message

#Deals Creation Scenario
@Deals
Scenario: Successful creation of Deals
    Given User is on Home page
    When user clicks on Deals
    And user navigated to Deals page
    Then User clicks on new deal
    Then User is able to create a new Deal on filling the Title field

#Tasks Creation Scenario
@Tasks
Scenario: Successful creation of Tasks
    Given User is on Home page
    When user clicks on Tasks
    And user navigated to Tasks page
    Then User clicks on new task
    Then User is able to create a new Task on filling the Title field

#Verifying if created tasks are reflected on calendar page
@Calendar
Scenario: Reflection of created tasks on Calendar page
    Given User is on Home page
    When user clicks on Calendar
    And user navigated to Calendar page
    Then Created tasks should be displayed on Calendar Page