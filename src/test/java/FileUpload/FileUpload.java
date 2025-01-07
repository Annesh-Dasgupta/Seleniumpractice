package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
    }
    @Test
    public void upload(){
        WebElement file = driver.findElement(By.id("file-upload"));
        String working_dir = System.getProperty("user.dir");
        System.out.println(working_dir);
        file.sendKeys(working_dir+"/src/test/java/FileUpload/newsuv.jpg");
        WebElement submit = driver.findElement(By.id("file-submit"));
        submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        WebElement message = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        String message_contains = message.getText();
        System.out.println(message_contains);
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(message_contains,"File Uploaded!");

    }
}
