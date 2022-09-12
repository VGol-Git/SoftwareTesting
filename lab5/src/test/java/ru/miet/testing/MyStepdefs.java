package test.java.ru.miet.testing;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

import  static  org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    public static WebDriver driver;
    public static void setup() {
        System.setProperty("webdriver.edge.driver", "E:\\1\\MIET\\SoftwareTesting\\lab5\\src\\drivers\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://lapkins.ru/");
        //  driver.get("https://www.miet.ru/");
    }

    public static void doLogining(){
        openUserMenu();
        doInputLogin("degavak468@wolfpat.com");
        doInputPassword("pasUser");
        doEnterLogIn();
    }
    public static void openUserMenu(){
        WebElement loginButton = driver.findElement(By.className("login"));
        loginButton.click();
    }
    public static void doInputLogin(String login){

        WebElement emailField = driver.findElement(By.name("login"));
        emailField.sendKeys(login);
    }
    public static void doInputPassword(String password){

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

    }
    public static void doEnterLogIn(){
        WebElement loginButton = driver.findElement(By.className("lk-enter"));
        loginButton.click();
    }

    @Given("^I have entered login ([a-z0-9@.']+) into the WebSite$")
    public void enterLogin(String login){
        setup();
        driver.get("https://lapkins.ru/");
        doInputLogin(login);

        //throw new PendingException();
    }
    @And("^I have entered password ([a-zA-Z]+) into the WebSite$")
    public void enterPassword(String password) {
        doInputPassword(password);
        //throw new PendingException();
    }
    @When("^I press \"Log in\"$")
    public void pressLogIn() {
        doEnterLogIn();
        //throw new PendingException();
    }

    @When("^I press \"Log out\"$")
    public void pressLogOut() {
        setup();
        driver.get("https://lapkins.ru/");
        doLogining();
        WebElement userButton = driver.findElement(By.xpath("/html/body/header/div[2]/div[2]/div"));
        userButton.click();
        WebElement exitButton = driver.findElement(By.linkText("Выход"));
        exitButton.click();
        driver.get("https://lapkins.ru/");
    }
    @When("^I press divide$")
    public void pressDivide() {

        //app.divide.doClick();
    }

    @Then("^the result should be \"([а-я А-Я]+)\" on the screen$")
    public void logOutResult(String username){
        WebElement loginButton = driver.findElement(By.className("login"));
        loginButton.click();
        WebElement UserName = driver.findElement(By.className("what-is"));
        String name = UserName.getText();
        assertEquals(name ,username);
        logOut();
    }
    @Then("^the result should be \"([a-z A-Z]+)\" on the screen$")
    public void logInResult(String username){
        WebElement userButton = driver.findElement(By.className("fill1"));
        userButton.click();
        WebElement userPage = driver.findElement(By.className("social-wrap"));
        userPage.click();
        WebElement UserName = driver.findElement(By.className("social-name"));
        String name = UserName.getText();
        assertEquals(name ,username);
        logOut();
        //throw new PendingException();
    }

    public static void logOut() {
        driver.quit();
    }

}
