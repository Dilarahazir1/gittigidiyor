package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Product {
    List<WebElement> result;
    WebDriver driver;
    By bySearch = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[2]/div/form/div/div[1]/div[2]/input");
    By byButton = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[2]/div/form/div/div[2]/button");
    By byPage = By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a");
    private String searchWord = "bilgisayar";
    public Product(WebDriver driver){
        this.driver = driver;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public void sendAndClickSearch(){
        try {
            driver.findElement(bySearch).sendKeys(searchWord);
            driver.findElement(byButton).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void secondPage(){
        try {
            driver.findElement(byPage).click();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void productSelect(){
        try {
            result = driver.findElements(By.xpath("//*[@class='listView ']//*[@class='column']/div/div/a/img"));
            Random r = new Random();
            int linkNo= r.nextInt(result.size());
            result.get(linkNo).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}