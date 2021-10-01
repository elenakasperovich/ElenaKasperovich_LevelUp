package Homework_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrashPage extends BasePageObject {

    public TrashPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Elena Kasperovich <elenakasperovich-levelup@mail.ru>']")
    public WebElement emailTitle;

    public WebElement emailTitle() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailTitle));
    }

}
