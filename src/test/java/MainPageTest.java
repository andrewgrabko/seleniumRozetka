import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;




public class MainPageTest extends BaseTest{
  /*  public WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private SmartphonePage smartphonePage;
    private PhonesPage phonesPage;
    private MobilePage mobilePage;

    @BeforeTest
    public void setUpTest (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\pageObject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");

        mainPage = new MainPage(driver,wait);
        smartphonePage = new SmartphonePage(driver,wait);
        phonesPage = new PhonesPage(driver,wait);
        mobilePage = new MobilePage(driver,wait);
    }*/


    @Test
    public void testRozetka() throws IOException {

        mainPage.clickSmaptphone();
        smartphonePage.clickGpsLink();
        phonesPage.clickMobLink();

      /* List<String> list = mobilePage.getLValuesTitles();
        mobilePage.getLValuesPrices();*/
        List<String> mob = mobilePage.getValuesTitlesPages();
        mobilePage.newFile(mob);
        mobilePage.clickDropDown();
        mobilePage.selectFilter();
        mobilePage.compareRange();



    }



   /* @AfterTest
    public void tearDown(){
        driver.quit();
    }*/



}
