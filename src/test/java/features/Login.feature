Feature: Application Login

@SmokeTest
Scenario Outline: login
Given User in on login page
When User login into application with <email> and <password>
Then User lands into the home page
And <username> displays in the navbar

Examples:
|email				|password	|username	|
|test1@test.com		|test		|test1		|
|test@test.com		|Test123!	|test		|