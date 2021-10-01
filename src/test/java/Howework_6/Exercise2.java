package Howework_6;

import static Homework_7.TestData.*;
import static Homework_7.TestData.BODY;
import static Homework_7.TestData.EMAIL;
import static Homework_7.TestData.SUBJECT;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

import Homework_7.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {

    @Test
    public void RunEx2() {

        //Assert, что вход выполнен успешно
        assertEquals(mainPage.createLetterButton().getText(), "Написать письмо");

        //Создать новое письмо (заполнить адресата (самого себя), тему письма (должно содержать слово Тест) и тело)
        mainPage.createLetterButton().click();
        createLetterPopup.mailToField().sendKeys(EMAIL);
        createLetterPopup.subjectField().sendKeys(SUBJECT);
        createLetterPopup.bodyField().sendKeys(BODY);

        //Отправить письмо
        createLetterPopup.sendButton().click();
        createLetterPopup.closeButton().click();

        //Verify, что письмо появилось в папке отправленные
        mainPage.sentFolderButton().click();
        assertEquals(sentPage.emailTitle().getText(), EMAIL);

        //Verify, что письмо появилось в папке «Тест»
        mainPage.testFolderButton().click();

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        testPage.emailTitle().click();
        assertEquals(testPage.subjectTitle().getText(), SUBJECT);
        assertEquals(testPage.emailAddress().getText(), NAME);
        assertEquals(testPage.bodyText().getText(), BODY);
    }
}
