import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MobilePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<String> strings;

    public MobilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By valuesTitle = By.xpath("//span[text()=' Топ продаж ']/following-sibling::a[@class='goods-tile__heading']/span");
    private By valuesPrice = By.xpath("//span[text()=' Топ продаж ']/following-sibling::div[@class='goods-tile__prices']//span[@class='goods-tile__price-value']");
    private By heading = By.xpath("//h1[@class='catalog-heading']");
    private By priceForRange = By.xpath("//span[@class='goods-tile__price-value']");
    private By dropDown = By.xpath("//select[@class='select-css ng-untouched ng-pristine ng-valid']");
    private By select = By.xpath("//option[text()=' От дешевых к дорогим ']");


    public List<String> getLValuesTitles(){
        List<WebElement> titles = driver.findElements(valuesTitle);
        List<String> valuesTitle = new ArrayList<>();
        for(WebElement value: titles){
            valuesTitle.add(value.getText());
        }
        return valuesTitle;
    }
    public List<String> getLValuesPrices(){
        List<WebElement> prices = driver.findElements(valuesPrice);
        List<String> valuesPrice = new ArrayList<>();
        for(WebElement value: prices){
            valuesPrice.add(value.getText());
        }
        return valuesPrice;
    }

    public List<String> getValuesTitlesPages(){
        List<String> titlePages = getLValuesTitles();
        List<String> pricePages = getLValuesPrices();
        for (int i = 2; i<=3; i++){
            String xpath = "//a[@class='pagination__link'][contains(text(),'%s')]";
            WebElement pagPage = driver.findElement(By.xpath(String.format(xpath,i)));
            pagPage.click();
            wait = (new WebDriverWait(driver, 4));
            wait.until(ExpectedConditions.presenceOfElementLocated(heading));
            titlePages.addAll(getLValuesTitles());
            pricePages.addAll(getLValuesPrices());
        }
        int length = titlePages.size();
        ArrayList<String> titlePrice = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            titlePrice.add(titlePages.get(i) + " - " + pricePages.get(i));
        }
        return titlePrice;
    }

    public void newFile (List<String> titlePrice) throws IOException {
        FileWriter nFile = new FileWriter("C:/autodoc/result.txt");
        for (String i: titlePrice){
            nFile.write(i+"\n");
        }
        nFile.close();
    }

    public List<Integer> priceInt(){
        List<WebElement> prices = driver.findElements(priceForRange);
        List<String> priceInt = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (WebElement myInt: prices){
            list.add(Integer.parseInt(myInt.getText().replaceAll(" ","")));
            priceInt.add(myInt.getText());
        }
        return list;
    }

    public MobilePage clickDropDown(){
        driver.findElement(dropDown).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(select));
        return this;
    }

    public MobilePage selectFilter(){
        driver.findElement(select).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(heading));
        return this;
    }

    public void compareRange(){
        List<Integer> pricesRoz = new ArrayList<>(priceInt());
        Collections.sort(pricesRoz);
        Assert.assertEquals(priceInt(),pricesRoz);

    }



}
