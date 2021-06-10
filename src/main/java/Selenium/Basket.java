package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Basket {
   Webdriver driver;

    By byBasked = By.xpath("//*[@id=\"__next\"]/main/div/div/section[5]/section/div/div/div/div/div/div/div[2]/div[1]/div[5]/article/div/footer/button");
    By byProductPrice = By.xpath("//*[@id=\"item-info-block-672865879\"]/div/div[1]/div[2]/div/div[1]/div[1]/div/div[4]/p");
    By byGotoBasked = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[2]/div/div/div/div/div[4]/div[1]/a");
    By byBaskedProductPrice = By.xpath("//*[@id=\"__next\"]/main/div/div/section[5]/section/div/div/div/div/div/div/div[2]/div[1]/div[6]/article/div/a/div/div[2]/section[1]/span");
    By byBaskedProductUp = By.xpath("//*[@id=\"cart-item-472334870\"]/div[1]/div[4]/div/div[2]/select");
    By byRemoveProduct = By.xpath("//*[@id=\"cart-item-472339018\"]/div[1]/div[3]/div/div[2]/div/a[1]");


    public Basket(WebDriver driver){

        this.driver = (Webdriver) driver;
    }
    public void addBasked()
    {
        String productPrice = driver.(byProductPrice).getText();
        driver.findElement().click();
    }

    public void goToBasked(){
        try {
            Thread.sleep(2000);
            driver.findElement(byGotoBasked).click();
            String baskedPrice = driver.findElement(byBaskedProductPrice).getText();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void baskedProductUp(){

        try {
            driver.findElement(byBaskedProductUp).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String baskedProductUpControl(){

        String control = driver.findElement(By.xpath("//*[@id=\"cart-item-472334870\"]/div[1]/div[4]/div/div[2]/select")).getAttribute("value");
        return control;
    }

    public void baskedProductRemove(){
        try {
            driver.findElement(byRemoveProduct).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String productRemoveControl(){
        String control = driver.findElement(By.xpath("//*[@id=\"cart-item-472339018\"]/div[1]/div[3]/div/div[2]/div/a[1]")).getText();
        return control;
    }

    private class Webdriver {
        public WebElement findElement(By byBaskedProductUp) {
            return null;
        }

    }
}