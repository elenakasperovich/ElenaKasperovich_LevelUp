package Howework_6;

import static Homework_7.TestData.*;
import static Homework_7.TestData.BODY;
import static Homework_7.TestData.EMAIL;
import static Homework_7.TestData.SUBJECT2;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

import Homework_7.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise3 extends BaseTest {

    @Test
    public void RunEx3() {

        //Assert, что вход выполнен успешно
        assertEquals(mainPage.createLetterButton().getText(), "Написать письмо");

        //Создать новое письмо (заполнить адресата (самого себя), тему письма (должно содержать слово Тест) и тело)
        mainPage.createLetterButton().click();
        createLetterPopup.mailToField().sendKeys(EMAIL);
        createLetterPopup.subjectField().sendKeys(SUBJECT2);
        createLetterPopup.bodyField().sendKeys(BODY);

        //Отправить письмо
        createLetterPopup.sendButton().click();
        createLetterPopup.closeButton().click();

        //Verify, что письмо появилось в папке Входящие
        mainPage.incomingFolderButton().click();
        mainPage.byMeFolderButton().click();
        assertEquals(byMePage.emailTitle().getText(), NAME);

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        byMePage.emailTitle().click();
        assertEquals(byMePage.emailAddress().getText(), NAME);
        assertEquals(byMePage.subjectTitle().getText(), SUBJECT2);
        assertEquals(byMePage.bodyText().getText(), BODY);

        //Удалить письмо
        byMePage.deleteButton().click();

        //Verify что письмо появилось в папке Корзина
        mainPage.trashFolderButton().click();
        assertEquals(trashPage.emailTitle().getText(), NAME);
    }
}
