import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SmartphonePage extends Driver {


    private By gpsLink = By.xpath("//a[contains(text(),', GPS')]");

    public PhonesPage clickGpsLink(){
        wait.until(ExpectedConditions.elementToBeClickable(gpsLink));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(gpsLink).click();
        return new PhonesPage();
    }
}
