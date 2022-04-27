package org.example.Lesson3.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.bookvoed.ru/my/auth");
        WebElement webElement1 = driver.findElement(By.name("login"));
        WebElement webElement2 = driver.findElement(By.name("password"));
        WebElement webElement3 = driver.findElement(By.cssSelector(".CJ"));
        WebElement webElement4 = driver.findElement(By.xpath("//input[@name='q']"));
        WebElement webElement5 = driver.findElement(By.cssSelector(".cu > span"));
        try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        }

        List<WebElement> webElements = driver.findElements(By.name("error"));
        if(webElements.size()>1){
            //todo
        }

        webElement1.click();
        webElement1.sendKeys("xitrozhopaya");

        webElement2.click();
        webElement2.sendKeys("111401");

        webElement3.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("bookvoed"));

        //Thread.sleep(10000l);
        //Завершаем работу с ресурсом
        // driver.quit();
    }
}
