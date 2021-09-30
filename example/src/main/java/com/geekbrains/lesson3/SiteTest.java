package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class SiteTest {
    private static WebDriver driver;
    private static final String CRM_URL = "https://www.hometesterclub.com/ca/en/account/login";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //WebDriverWait webDriverWait = new WebDriverWait(driver,10);

        driver.get(CRM_URL);
        Thread.sleep(3000);
        login();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[.='View all products']")).click();//нажимаем "View all products"

        driver.findElement(By.id("cat-147")).click();//выбираем Beauty&Hair
        driver.findElement(By.id("cat-151")).click();//выбираем skin care
        //Фильтруем новые продукты с наивысшим рейтингом
        driver.findElement(By.id("dropdownMenu2")).click();
        driver.findElement(By.cssSelector(".open li:nth-child(2) label")).click();
        driver.findElement(By.cssSelector(".open li:nth-child(3) label")).click();

        driver.findElement(By.id("dropdownMenu1")).click();
        driver.findElement(By.cssSelector(".open li:nth-child(3) label")).click();

        Thread.sleep(5000);
        driver.quit();
    }
    public static void login() throws InterruptedException {

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();//Accept cookies
        driver.findElement(By.id("btnEmail")).click();//Login via email
        driver.findElement(By.id("EmailAddress")).sendKeys("testerksu@gmail.com");//Вводим e-mail
        driver.findElement(By.id("Password")).sendKeys("Tester2021!");//вводим пароль
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[.='Login via email']")).click();//нажимаем войти

    }
}
