package Howework_6;

import static Homework_7.TestData.*;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    @Test
    public void runEx1() {

        //Assert, что вход выполнен успешно
        assertEquals(mainPage.createLetterButton().getText(), "Написать письмо");

        //Создать новое письмо (заполнить адресата, тему письма и тело)
        mainPage.createLetterButton().click();
        createLetterPopup.mailToField().sendKeys(EMAIL);
        createLetterPopup.subjectField().sendKeys(SUBJECT);
        createLetterPopup.bodyField().sendKeys(BODY);

        //Сохранить его как черновик
        createLetterPopup.saveButton().click();
        createLetterPopup.closeButton().click();

        //Verify, что письмо сохранено в черновиках
        mainPage.draftButton().click();
        assertEquals(draftPage.emailTitle().getText(), "elenakasperovich-levelup@mail.ru");
        draftPage.emailTitle().click();

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        assertEquals(draftPage.emailAddress().getText(), EMAIL);
        assertEquals(draftPage.emailSubject().getAttribute("value"), SUBJECT);
        assertEquals(draftPage.emailBody().getText(), BODY);

        //Отправить письмо
        createLetterPopup.sendButton().click();
        createLetterPopup.closeButton().click();

        //Verify, что письмо исчезло из черновиков
        assertEquals(draftPage.withoutDraftMails().getText(), "У вас нет незаконченных\nили неотправленных писем");

        //Verify, что письмо появилось в папке отправленные
        mainPage.sentFolderButton().click();
        assertEquals(sentPage.emailTitle().getText(), EMAIL);
    }
}
