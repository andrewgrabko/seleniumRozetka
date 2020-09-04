import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By smartphone = By.xpath("//sidebar-fat-menu//li[2]//a[1]");

    public SmartphonePage clickSmaptphone(){
        driver.findElement(smartphone).click();
        return new SmartphonePage(driver);
    }
}
