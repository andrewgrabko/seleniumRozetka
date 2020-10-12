import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MainPage mainPage;
    protected SmartphonePage smartphonePage;
    protected PhonesPage phonesPage;
    protected MobilePage mobilePage;

    @BeforeTest
    public void initializeWebDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\pageObject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");

        mainPage = new MainPage(driver,wait);
        smartphonePage = new SmartphonePage(driver,wait);
        phonesPage = new PhonesPage(driver,wait);
        mobilePage = new MobilePage(driver,wait);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }


}
