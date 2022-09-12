package test.java.ru.miet.testing;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleTest {
    public static WebDriver driver;
    private void doLogining(){
        WebElement loginButton = driver.findElement(By.className("login"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.name("login"));
        emailField.sendKeys("degavak468@wolfpat.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("pasUser");
        loginButton = driver.findElement(By.className("lk-enter"));
        loginButton.click();
    }

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "E:\\1\\MIET\\SoftwareTesting\\lab5\\src\\drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  driver.get("https://www.miet.ru/");
    }


    @Test
    public void doUserLogin() {
        driver.get("https://lapkins.ru/");
        doLogining();
        WebElement userButton = driver.findElement(By.className("fill1"));
        userButton.click();
        WebElement userPage = driver.findElement(By.className("social-wrap"));
        userPage.click();
        WebElement UserName = driver.findElement(By.className("social-name"));
        String name = UserName.getText();
        Assert.assertEquals(name ,"Im User");
    }
    @Test
    public void doLoginOut() {
        driver.get("https://lapkins.ru/");
        doLogining();
        WebElement userButton = driver.findElement(By.className("fill1"));
        userButton.click();
        WebElement exitButton = driver.findElement(By.linkText("Выход"));
        exitButton.click();

        WebElement loginButton = driver.findElement(By.className("login"));
        loginButton.click();
        WebElement UserName = driver.findElement(By.className("what-is"));
        String name = UserName.getText();
        Assert.assertEquals(name ,"Войти на сайт");
    }

    

    @Test
    public void nofound() {
        driver.get("https://yandex.ru/");
        WebElement searchField = driver.findElement(By.className("mini-suggest__input"));
        String search = "роароаоалпалроаордывппывпвапыпвпывпр";
        searchField.sendKeys(search);
        searchField.submit();
        String str = "По вашему запросу ничего не нашлось";
        WebElement rez = driver.findElement(By.className("misspell__message"));
        String r =rez.getText();
        Assert.assertEquals(str,r);
    }

    @Test
    public void found() {
        driver.get("https://www.miet.ru/search");
        WebElement searchField = driver.findElement(By.className("search-bar__input"));
        String search = "Молодой инноватор";
        searchField.sendKeys(search);
        searchField.submit();
        String str = "Объявлены победители конкурса «Молодой инноватор»";
        WebElement rez = driver.findElement(By.linkText(str));
        String r =rez.getText();
        Assert.assertEquals(str,r);
    }
    @AfterClass
    public static void logOut() {
        driver.quit();
    }
}
