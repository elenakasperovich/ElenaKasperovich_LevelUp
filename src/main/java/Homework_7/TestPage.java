package Homework_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestPage extends BasePageObject {

    public TestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Elena Kasperovich <elenakasperovich-levelup@mail.ru>']")
    public WebElement emailTitle;

    @FindBy(xpath = "//*[@class='thread__subject']")
    public WebElement subjectTitle;

    @FindBy(xpath = "//*[contains(@class, 'letter-contact')]")
    public WebElement emailAddress;

    @FindBy(xpath = "//*[contains(text(), 'Level UP')]")
    public WebElement bodyText;

    public WebElement emailTitle() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailTitle));
    }

    public WebElement subjectTitle() {
        return wait.until(ExpectedConditions.elementToBeClickable(subjectTitle));
    }

    public WebElement emailAddress() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailAddress));
    }

    public WebElement bodyText() {
        return wait.until(ExpectedConditions.elementToBeClickable(bodyText));
    }
}
