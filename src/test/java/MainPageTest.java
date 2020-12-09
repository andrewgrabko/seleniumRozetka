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


    @Test
    public void testRozetka() throws IOException {

        mainPage.clickSmartphone();
        smartphonePage.clickGpsLink();
        phonesPage.clickMobLink();
        mobilePage.getLValuesTitles();
        mobilePage.getLValuesPrices();
        List<String> mob = mobilePage.getValuesTitlesPages(3);
        mobilePage.newFile(mob);
        mobilePage.clickDropDown()
                  .selectFilter()
                  .compareRange();


    }


}
