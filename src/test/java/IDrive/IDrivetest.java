package IDrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IDrivetest {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().window().fullscreen();
    }
    @Test(priority = 1)
    public void test_idriveurl() throws InterruptedException {
        driver.get("https://www.idrive360.com/enterprise/login");
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void test_login_input() throws InterruptedException {
        WebElement email = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        email.sendKeys("augtest_040823@idrive.com");
        Thread.sleep(2000);
        password.sendKeys("123456");
        Thread.sleep(2000);
        WebElement remembercheck = driver.findElement(By.className("id-checkmark"));
        remembercheck.click();
        WebElement signin = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signin.click();
        Thread.sleep(20000);
       WebElement header = driver.findElement(By.xpath("//h5[text()='Your free trial has expired']"));
       if(header.isDisplayed()){
           System.out.println("header visible");
       }
       else{
           System.out.println("something wrong");
       }
    }
}
