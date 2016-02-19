import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import org.junit.*;
import pages.MainPage;

import java.io.IOException;
import java.net.MalformedURLException;

public class MainTest {
    private static WebDriver driver;
    private final String BASE_URL = "http://timvroom.com/selenium/playground/";

    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "chrome/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void AllTasks() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        //Task #1
        String titleText = mainPage.getTitle();   //here and later it's possible to write nested statements, e.g.:
        mainPage.setAnswer1(titleText)            //mainPage.setAnswer1(mainPage.getTitle());
                                                  //it was possible to hide everything into mainPage (less reusable), e.g.:
                                                  //mainPage.answerWithPageTitle();

        //Task #2
                .setName("Kilgore Trout")

        //Task #3
                .selectOccupation("scifiauthor");

        //Task #4
        int blueBoxesAmount = mainPage.countBlueBoxes();
        mainPage.setAnswer4(Integer.toString(blueBoxesAmount));

        //Task #5
        mainPage.clickClickMeLink();

        //Task #6
        String redBoxClass = mainPage.getRedBoxClass();
        mainPage.setAnswer6(redBoxClass);

        //Task #7
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("ran_this_js_function();");

        //Task #8
        Long response = (Long) js.executeScript("return got_return_from_js_function();");
        mainPage.setAnswer8(response.toString());

        //Task #9
        mainPage.setWroteBookRadioToYes();

        //Task #10
        String redBoxText = mainPage.getRedBoxText();
        mainPage.setAnswer10(redBoxText);

        //Task #11
        String color = mainPage.whichBoxIsOnTop();
        mainPage.setAnswer11(color);

        //Task #12
        driver.manage().window().setSize(new Dimension(850, 650));

        //Task #13
        String ishere = mainPage.isIsherePresent();     //function returns "yes" or "no"
        mainPage.setAnswer13(ishere);

        //Task #14
        boolean visible = mainPage.isPurpleBoxVisible();  //function returns true or false
        mainPage.setAnswer14(visible ? "yes" : "no");

        //Task #15
        mainPage.clickClickThenWaitLink()
                .clickClickAfterWaitLink();

        //Task #16
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Task #17
        mainPage.submitForm();
    }

    @After
    public void tearDown() throws IOException {
        driver.quit();
    }
}