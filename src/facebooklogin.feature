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
@tag
Feature: facebooklogin

@tag1
Scenario: valid login
Given  browser as "Firefox" And URL as "https://www.facebook.com/"
When  user logs in using Username  And Password 
|mareddy697@gmail.com  |970436212|	
|ramireddy591@gmail.com|9989593467|
Then login should be successful
	


