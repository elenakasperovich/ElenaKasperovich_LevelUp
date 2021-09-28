package Howework_6.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {
    @SuppressWarnings("checkstyle:MethodParamPad")
    @Test
    public void runEx1() {

        //Assert, что вход выполнен успешно
        WebElement newMailButton =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Написать письмо']")));
        Assert.assertEquals(newMailButton.getText(), "Написать письмо");

        //Создать новое письмо (заполнить адресата, тему письма и тело)
        newMailButton.click();
        WebElement emailTo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--H9L5q")));
        emailTo.sendKeys(EMAIL);
        WebElement subject = driver.findElement(By.cssSelector("[name='Subject']"));
        subject.click();
        subject.sendKeys(SUBJECT);
        WebElement body = driver.findElement(By.cssSelector("[role='textbox']"));
        body.sendKeys(BODY);

        //Сохранить его как черновик
        WebElement saveButton = driver.findElement(By.cssSelector("[title='Сохранить']"));
        saveButton.click();
        WebElement closeButton = driver.findElement(By.cssSelector("[title='Закрыть']"));
        closeButton.click();

        //Verify, что письмо сохранено в черновиках
        WebElement draftButton = driver.findElement(By.xpath("//div[contains(text(),'Черновики')]"));
        draftButton.click();
        WebElement emailTitle =
            wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='elenakasperovich-levelup@mail.ru']")));
        Assert.assertEquals(emailTitle.getText(), "elenakasperovich-levelup@mail.ru");
        emailTitle.click();

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        String emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated
                                                               (By.xpath("//*[contains(@class, 'contacts--1ofjA')][@data-type='to']//span"))).getText();
        String emailSubject = wait.until(ExpectedConditions.visibilityOfElementLocated
                                                              (By.xpath("//*[@name='Subject']"))).getAttribute("value");
        String emailBody = wait.until(ExpectedConditions.visibilityOfElementLocated
                                                            (By.xpath("//*[contains(@id, 'BODY')]/div/div"))).getText();

        Assert.assertEquals(emailAddress, EMAIL);
        Assert.assertEquals(emailSubject, SUBJECT);
        Assert.assertEquals(emailBody, BODY);

        //Отправить письмо
        WebElement sendMailButton =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Отправить']")));
        sendMailButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Закрыть']"))).click();

        //Verify, что письмо исчезло из черновиков
        WebElement withoutDraftMails =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='octopus__title']")));
        Assert.assertEquals(withoutDraftMails.getText(), "У вас нет незаконченных\nили неотправленных писем");

        //Verify, что письмо появилось в папке отправленные
        WebElement sendFolder =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Отправленные')]")));
        sendFolder.click();
        Assert.assertEquals(wait.until(
                                    ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='elenakasperovich-levelup@mail.ru']")))
                                .getText(), EMAIL);
    }
}
