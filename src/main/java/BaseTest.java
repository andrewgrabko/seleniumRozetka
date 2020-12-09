import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Driver {

    protected MainPage mainPage;
    protected SmartphonePage smartphonePage;
    protected PhonesPage phonesPage;
    protected MobilePage mobilePage;

    @BeforeTest
    public void initializeWebDriver() {
        Driver.initialize();

        mainPage = new MainPage();
        smartphonePage = new SmartphonePage();
        phonesPage = new PhonesPage();
        mobilePage = new MobilePage();
    }

    @AfterTest
    public void quitDriver() {
        Driver.quit();
    }


}
