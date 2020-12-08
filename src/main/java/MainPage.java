import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MainPage extends Driver {


    private By smartphone = By.xpath("//sidebar-fat-menu//li[2]//a[1]");

    public SmartphonePage clickSmartphone(){
        wait.until(ExpectedConditions.elementToBeClickable(smartphone));
        driver.findElement(smartphone).click();
        return new SmartphonePage();
    }
}
