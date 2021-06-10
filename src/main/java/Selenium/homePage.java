package Selenium;

import org.openqa.selenium.WebDriver;

public class homePage {
    WebDriver driver;

    public homePage(WebDriver driver){
        this.driver = driver;
    }

    public void connect(){
        driver.get("www.gittigidiyor.com");
    }
}