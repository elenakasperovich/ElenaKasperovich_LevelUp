package Howework_6.Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise3 extends BaseTest {

    @Test
    public void RunEx3() {

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
        subject.sendKeys(SUBJECT2);
        WebElement body = driver.findElement(By.cssSelector("[role='textbox']"));
        body.sendKeys(BODY);

        //Отправить письмо
        WebElement sendMailButton =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Отправить']")));
        sendMailButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Закрыть']"))).click();

        //Verify, что письмо появилось в папке Входящие
        WebElement incomingFolder =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Входящие')]")));
        incomingFolder.click();
        WebElement byMeFolder =
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Письма себе')]")));
        byMeFolder.click();
        Assert.assertEquals(wait.until(
                                    ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Elena Kasperovich <elenakasperovich-levelup@mail.ru>']")))
                                .getText(), NAME);

        //Удалить письмо
        driver.findElement(By.xpath("//*[@title='Elena Kasperovich <elenakasperovich-levelup@mail.ru>']")).click();
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Удалить']")));
        deleteButton.click();

        //Verify что письмо появилось в папке Корзина
        WebElement trashFolder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='/trash/']")));
        trashFolder.click();
        Assert.assertEquals(wait.until(
                                    ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Elena Kasperovich <elenakasperovich-levelup@mail.ru>']")))
                                .getText(), NAME);
    }
}
