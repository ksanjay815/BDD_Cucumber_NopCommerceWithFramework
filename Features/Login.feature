
Feature: Login
  I want to verify login page with valid and invalid credentials

 #simple login with data table
  #Scenario: Successful Login with Valid Credentials 
#	Given User Launch Chrome browser 
#	When User opens URL "http://admin-demo.nopcommerce.com/login" 
#	And User enters Email and Password 
#	 | admin@yourstore.com	|	admin |
#	And Click on Login 
#	Then Page Title should be "Dashboard / nopCommerce administration" 
#	When User click on Log out link 
#	Then Page Title should be "Your store. Login" 
	
	Scenario: Successful Login with Valid Credentials 
	Given User Launch Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Log out link 
	Then Page Title should be "Your store. Login" 

Scenario Outline: Login Data Driven 
	Given User Launch Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "<email>" and Password as "<password>" 
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Log out link 
	Then Page Title should be "Your store. Login" 
	 
	
	Examples: 
		| email | password |
		| admin@yourstore.com	|	admin |
		| admin1@yourstore.com | admin123	|
	