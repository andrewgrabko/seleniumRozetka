import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class PhonesPage extends Driver {


    private By mobLink = By.xpath("//li[@class='portal-navigation__item']/a[@href='https://rozetka.com.ua/mobile-phones/c80003/']");//span/img[@src='https://i2.rozetka.ua/goods/1157174/mobile-phones_top_1157174320.jpg']

    public MobilePage clickMobLink(){

        wait.until(ExpectedConditions.elementToBeClickable(mobLink));
        driver.findElement(mobLink).click();
        return new MobilePage();
    }
    //span[text()=' Мобильные телефоны ']
}
