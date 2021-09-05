package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void typeYourEmail() {
        driver.get("https://diary.ru/");
        driver.findElement(By.linkText("Регистрация")).click();
        {
            WebElement element = driver.findElement(By.linkText("Регистрация"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.id("signupform-username")).sendKeys("TestResu");
        driver.findElement(By.id("signupform-password")).sendKeys("Test");
        driver.findElement(By.id("signupform-email")).sendKeys("s.pilko@gmail.com");
        driver.findElement(By.cssSelector("html")).click();
        driver.findElement(By.cssSelector(".i-logo-full")).click();
        driver.findElement(By.id("wrapper")).click();
    }
}
