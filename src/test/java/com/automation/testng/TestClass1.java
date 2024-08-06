package com.automation.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestClass1 {
    private WebDriver driver;

    @BeforeTest
    public void launchDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
          driver.manage().window().maximize();
    }

    @Test
    public void launchURL() {
       driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       System.out.println("Title is "+driver.getTitle());
    }

    @Test
    public void verifyURL(){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Title is "+driver.getTitle());
    }

    @Test
    public void loadPage(){
        driver.navigate().to("https://duckduckgo.com/");
        System.out.println("Title is "+driver.getTitle());
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
