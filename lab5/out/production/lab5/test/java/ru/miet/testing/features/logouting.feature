@WebSite
Feature: logouting
	As a top man
	I want to Log Out
	So that I can avoid silly mistakes

@positive @sprint2
Scenario: Logouting
	When I press "Log out"
	Then the result should be "Войти на сайт" on the screen