package Homework_7;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Написать письмо']")
    private WebElement createLetterButton;

    @FindBy(xpath = "//div[contains(text(),'Черновики')]")
    private WebElement draftButton;

    @FindBy(xpath = "//div[contains(text(),'Тест')]")
    private WebElement testFolderButton;

    @FindBy(xpath = "//div[contains(text(),'Входящие')]")
    private WebElement incomingFolderButton;

    @FindBy(xpath = "//div[contains(text(),'Письма себе')]")
    private WebElement byMeFolderButton;

    @FindBy(xpath = "//div[contains(text(),'Отправленные')]")
    private WebElement sentFolderButton;

    @FindBy(xpath = "//*[@href='/trash/']")
    private WebElement trashFolderButton;

    @FindBy(css = ".ph-dropdown-icon")
    private WebElement logoutDropdownButton;

    @FindBy(xpath = "//*[@href='//auth.mail.ru/cgi-bin/logout?next=1&lang=ru_RU&page=https%3A%2F%2Fmail.ru%2F%3Ffrom%3Dlogout']")
    private WebElement logoutButton;

    public WebElement createLetterButton() {
        return wait.until(elementToBeClickable(createLetterButton));
    }

    public WebElement draftButton() {
        return wait.until(elementToBeClickable(draftButton));
    }

    public WebElement testFolderButton() {
        return wait.until(elementToBeClickable(testFolderButton));
    }

    public WebElement incomingFolderButton() {
        return wait.until(elementToBeClickable(incomingFolderButton));
    }

    public WebElement byMeFolderButton() {
        return wait.until(elementToBeClickable(byMeFolderButton));
    }

    public WebElement sentFolderButton() {
        return wait.until(elementToBeClickable(sentFolderButton));
    }

    public WebElement trashFolderButton() {
        return wait.until(elementToBeClickable(trashFolderButton));
    }

    public void logout() {
        wait.until(elementToBeClickable(logoutDropdownButton)).click();
        wait.until(elementToBeClickable(logoutButton)).click();
    }
}
