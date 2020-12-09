import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    public static void initialize(){

        if (driver == null) {
            if (Constants.browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\pageObject\\drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.addArguments("incognito");
                driver=new ChromeDriver(options);
            }
        }
        if (wait == null) {
            wait = (new WebDriverWait(driver, 10));
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.url);
    }

    public static void quit(){
        System.out.println("quitting the browser");
        driver.quit();
        driver = null;
    }


}
