import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    private By smartphone = By.xpath("//sidebar-fat-menu//li[2]//a[1]");

    public SmartphonePage clickSmaptphone(){
        driver.findElement(smartphone).click();
        return new SmartphonePage(driver, wait);
    }
}
