package com.automation.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.lang.Boolean.TRUE;

public class TestClass1 {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
    public void launchDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        // Remote mode
        if ("grid".equals("normal")) {

            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
    }

    @Test
    public void Test1() {
       driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       System.out.println("Title is "+driver.getTitle());
    }

    @Test
    public void Test2(){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Title is "+driver.getTitle());
    }

    @Test
    public void Test3(){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Title is "+driver.getTitle());
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
