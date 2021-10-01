package Howework_6;

import Homework_7.CreateLetterPopup;
import Homework_7.DraftPage;
import Homework_7.ByMePage;
import Homework_7.LoginPage;
import Homework_7.MainPage;
import Homework_7.SentPage;
import Homework_7.TestPage;
import Homework_7.TrashPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected CreateLetterPopup createLetterPopup;
    protected DraftPage draftPage;
    protected SentPage sentPage;
    protected TestPage testPage;
    protected TrashPage trashPage;
    protected ByMePage byMePage;

    @BeforeClass
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        createLetterPopup = new CreateLetterPopup(driver);
        draftPage = new DraftPage(driver);
        sentPage = new SentPage(driver);
        testPage = new TestPage(driver);
        trashPage = new TrashPage(driver);
        byMePage = new ByMePage(driver);
        loginPage.open();
        loginPage.login();
    }

    @AfterMethod
    public void tearDown() {
        mainPage.logout();
        driver.quit();
    }
}

