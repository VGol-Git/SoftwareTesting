package main.test.ru.miet.testing;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import main.java.ru.miet.testing.Main;
import main.test.ru.miet.testing.MainMock;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class MyStepdefs {
    Main app;
    @Given("^I have entered first number ([0-9.,-]+) into the calculator$")
    public void enterFirst(double arg1){
        app = new Main();
        app.setVisible(true);
        app.inputA.setText(Double.toString(arg1));
        //throw new PendingException();
    }
    @And("^I have entered second number ([0-9.,-]+) into the calculator$")
    public void enterSecond(double arg1) {
        app.inputB.setText(Double.toString(arg1));
        //throw new PendingException();
    }
    @When("^I press plus$")
    public void pressPlus() {
        app.plus.doClick();
        //throw new PendingException();
    }
    @When("^I press minus$")
    public void pressMinus() {
        app.minus.doClick();
    }
    @When("^I press multiply$")
    public void pressMultiply() {
        app.multiply.doClick();
    }
    @When("^I press divide$")
    public void pressDivide() {
        app.divide.doClick();
    }
    @Then("^the result should be \"([a-z 'A-Z]+)\" on the screen$")
    public void divNullResult(String arg1){
        assertEquals(arg1, app.error);
        //throw new PendingException();
    }

    @Then("^the result should be ([0-9.,-]+) on the screen$")
    public void result(double arg1){
        assertEquals(Double.toString(arg1), app.output.getText());
        //throw new PendingException();
    }



}
