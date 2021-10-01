package Homework_7;

import java.security.PublicKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DraftPage extends BasePageObject {

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='elenakasperovich-levelup@mail.ru']")
    public WebElement emailTitle;

    @FindBy(xpath = "//*[@class='text--1tHKB']")
    public WebElement emailAddress;

    @FindBy(xpath = "//*[@name='Subject']")
    public WebElement emailSubject;

    @FindBy(xpath = "//*[contains(text(), 'Level UP')]")
    public WebElement emailBody;

    @FindBy(xpath = "//*[@class='octopus__title']")
    public WebElement withoutDraftMails;

    public WebElement emailTitle() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailTitle));
    }

    public WebElement withoutDraftMails() {
        return wait.until(ExpectedConditions.elementToBeClickable(withoutDraftMails));
    }

    public WebElement emailAddress() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailAddress));
    }

    public WebElement emailSubject() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailSubject));
    }

    public WebElement emailBody() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailBody));
    }
}
