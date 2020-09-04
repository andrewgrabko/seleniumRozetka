import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartphonePage {
    private WebDriver driver;

    public SmartphonePage(WebDriver driver) {
        this.driver = driver;
    }

    private By gpsLink = By.xpath("//a[contains(text(),', GPS')]");

    public PhonesPage clickGpsLink(){
        driver.findElement(gpsLink).click();
        return new PhonesPage(driver);
    }
}
