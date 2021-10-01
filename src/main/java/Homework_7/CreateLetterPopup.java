package Homework_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateLetterPopup extends BasePageObject {

    public CreateLetterPopup(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[contains(@class, 'H9L5q')]")
    public WebElement mailToField;

    @FindBy(css = "[name='Subject']")
    public WebElement subjectField;

    @FindBy(css = "[role='textbox']")
    public WebElement bodyField;

    @FindBy(css = "[title='Сохранить']")
    private WebElement saveButton;

    @FindBy(css = "[title='Закрыть']")
    private WebElement closeButton;

    @FindBy(xpath = "//*[@title='Отправить']")
    private WebElement sendButton;

    public WebElement mailToField() {
        return wait.until(ExpectedConditions.elementToBeClickable(mailToField));
    }

    public WebElement subjectField() {
        return wait.until(ExpectedConditions.elementToBeClickable(subjectField));
    }

    public WebElement bodyField() {
        return wait.until(ExpectedConditions.elementToBeClickable(bodyField));
    }

    public WebElement saveButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }

    public WebElement closeButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(closeButton));
    }

    public WebElement sendButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(sendButton));
    }
}
