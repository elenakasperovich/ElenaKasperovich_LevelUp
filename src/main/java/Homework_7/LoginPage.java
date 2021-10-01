package Homework_7;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".email-input")
    private WebElement loginWindow;

    @FindBy(css = ".button")
    private WebElement submitLogin;

    @FindBy(css = ".password-input")
    private WebElement passwordWindow;

    @FindBy(css = ".second-button")
    private WebElement submitPassword;

    public void open() {
        driver.navigate().to(URL);
    }

    public void login() {
        Properties loginPropetries = new Properties();
        try {
            loginPropetries.load(this.getClass().getClassLoader().getResourceAsStream("login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String login = loginPropetries.getProperty("login");
        String password = loginPropetries.getProperty("password");

        wait.until(elementToBeClickable(loginWindow)).sendKeys(login);
        submitLogin.click();
        wait.until(elementToBeClickable(passwordWindow)).sendKeys(password);
        submitPassword.click();
    }
}
