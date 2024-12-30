package com.annesh.KatalonLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.PriorityQueue;

public class KatalonLogin {
    WebDriver driver;


    @BeforeTest
    public void setup(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("Incognito"); // only work on Chrome
        driver = new EdgeDriver(options);
        driver.manage().window().fullscreen();
    }
    @Test(priority = 1)
    public void mainpage(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");

    }
    @Test(priority = 2)
    public void make_appointment() throws InterruptedException {
        WebElement make_appointment = driver.findElement(By.id("btn-make-appointment"));
        make_appointment.click();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void demo_login() throws InterruptedException {
        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");
        Thread.sleep(2000);
        WebElement login_button = driver.findElement(By.id("btn-login"));
        login_button.click();
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void take_appointment() throws InterruptedException {
        WebElement facility = driver.findElement(By.id("combo_facility"));
        facility.click();
        Thread.sleep(2000);
        List<WebElement> optionlist = driver.findElements(By.tagName("option"));
        optionlist.get(1).click();
        Thread.sleep(2000);

    }
    @Test(priority = 5)
    public void check_readmission() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox.click();
        Thread.sleep(2000);
    }
    @Test(priority = 6)
    public void health_care_program() throws InterruptedException {
        WebElement radiobutton = driver.findElement(By.id("radio_program_none"));
        radiobutton.click();
        Thread.sleep(2000);
    }
    @Test(priority = 7)
    public void calender() throws InterruptedException {
        WebElement calander = driver.findElement(By.className("glyphicon-calendar"));
        calander.click();
        Thread.sleep(2000);
        WebElement nextmonth = driver.findElement(By.className("next"));
        nextmonth.click();
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.xpath("//td[text()='16']"));
        date.click();

    }
    @Test(priority = 8)
    public void comments() throws InterruptedException {
        WebElement comments = driver.findElement(By.id("txt_comment"));
        comments.sendKeys("Comments by Annesh");
        Thread.sleep(2000);

    }
    @Test(priority = 9)
    public void booking_button() throws InterruptedException {
        WebElement bookingbutton = driver.findElement(By.id("btn-book-appointment"));
        bookingbutton.click();
        Thread.sleep(10000);
    }

    @AfterTest
    public void driverQuite(){
        driver.quit();
    }


}
