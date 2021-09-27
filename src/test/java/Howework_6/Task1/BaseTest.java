package Howework_6.Task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public final String URL = "https://mail.ru/";
    public final String LOGIN = "elenakasperovich-levelup";
    public final String PASSWORD = "1234Levelup";
    public final String EMAIL = "elenakasperovich-levelup@mail.ru";
    public final String SUBJECT = "Test";
    public final String SUBJECT2 = "Exercise3";
    public final String BODY = "Test";
    public final String NAME = "Elena Kasperovich";

    public void login(String login, String password) {
        driver.get(URL);
        WebElement loginWindow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".email-input")));
        loginWindow.sendKeys(login);

        WebElement submitLogin = driver.findElement(By.cssSelector(".button"));
        submitLogin.click();

        WebElement passwordWindow =
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".password-input")));
        passwordWindow.sendKeys(password);

        WebElement submitPassword = driver.findElement(By.cssSelector(".second-button"));
        submitPassword.click();
    }

    public void logout() {
        WebElement dropDownButton = driver.findElement(By.cssSelector(".ph-dropdown-icon"));
        dropDownButton.click();

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='//auth.mail.ru/cgi-bin/logout?next=1&lang=ru_RU&page=https%3A%2F%2Fmail.ru%2F%3Ffrom%3Dlogout']")));
        logoutButton.click();
    }

    @BeforeClass
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
        login(LOGIN, PASSWORD);
    }

    @AfterMethod
    public void tearDown() {
        logout();
        driver.quit();
    }
}

