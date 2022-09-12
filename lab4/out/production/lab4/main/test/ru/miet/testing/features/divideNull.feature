@calculator
Feature: DivNull


@positive @sprint5
Scenario: Subtract two numbers with null
	Given I have entered first number 50.0 into the calculator
	And I have entered second number 0.0 into the calculator
	When I press divide
	Then the result should be "You can't divide by zero" on the screen
