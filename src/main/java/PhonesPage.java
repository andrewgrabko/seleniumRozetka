import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class PhonesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PhonesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By mobLink = By.xpath("//span/img[@src='https://i2.rozetka.ua/goods/1157174/mobile-phones_top_1157174320.jpg']");

    public MobilePage clickMobLink(){
        wait = (new WebDriverWait(driver, 4));
        wait.until(ExpectedConditions.presenceOfElementLocated(mobLink));
        driver.findElement(mobLink).click();
        return new MobilePage(driver, wait);
    }
    //span[text()=' Мобильные телефоны ']
}
