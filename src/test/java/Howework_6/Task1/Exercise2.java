package Howework_6.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {

    @Test
    public void RunEx2() {

        //Assert, что вход выполнен успешно
        WebElement newMailButton =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Написать письмо']")));
        Assert.assertEquals(newMailButton.getText(), "Написать письмо");

        //Создать новое письмо (заполнить адресата (самого себя), тему письма (должно содержать слово Тест) и тело)
        newMailButton.click();
        WebElement emailTo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--H9L5q")));
        emailTo.sendKeys(EMAIL);
        WebElement subject = driver.findElement(By.cssSelector("[name='Subject']"));
        subject.click();
        subject.sendKeys(SUBJECT);
        WebElement body = driver.findElement(By.cssSelector("[role='textbox']"));
        body.sendKeys(BODY);

        //Отправить письмо
        WebElement sendMailButton =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Отправить']")));
        sendMailButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Закрыть']"))).click();

        //Verify, что письмо появилось в папке отправленные
        WebElement sendFolder =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Отправленные')]")));
        sendFolder.click();
        Assert.assertEquals(wait.until(
                                    ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='elenakasperovich-levelup@mail.ru']")))
                                .getText(), EMAIL);

        //Verify, что письмо появилось в папке «Тест»
        WebElement testFolder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Тест')]")));
        testFolder.click();

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        WebElement emailTitle =
            wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Elena Kasperovich <elenakasperovich-levelup@mail.ru>']")));
        emailTitle.click();
        String emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated
                                                               (By.xpath("//*[contains(@class, 'letter-contact')]"))).getText();
        String emailSubject = wait.until(ExpectedConditions.visibilityOfElementLocated
                                                               (By.xpath("//*[@class='thread__subject']"))).getText();
        String emailBody = wait.until(ExpectedConditions.visibilityOfElementLocated
                                                            (By.xpath("//*[contains(@id, 'BODY')]/div/div"))).getText();

        Assert.assertEquals(emailAddress, NAME);
        Assert.assertEquals(emailSubject, SUBJECT);
        Assert.assertEquals(emailBody, BODY);
    }
}
