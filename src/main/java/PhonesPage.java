import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhonesPage {

    private WebDriver driver;

    public PhonesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By mobLink = By.xpath("//span[text()=' Мобильные телефоны ']");

    public MobilePage clickMobLink(){
        driver.findElement(mobLink).click();
        return new MobilePage(driver);
    }

}
