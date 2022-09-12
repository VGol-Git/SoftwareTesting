@WebSite
Feature: logining


@positive @sprint1
Scenario: Logining
	Given I have entered login degavak468@wolfpat.com into the WebSite
	And I have entered password pasUser into the WebSite
	When I press "Log in"
	Then the result should be "Im User" on the screen