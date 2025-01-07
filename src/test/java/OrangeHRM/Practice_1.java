package OrangeHRM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice_1 {
    @Test
    @Description("Test Case Description")
    public void test_web_table_login() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("Hacker@4321");
        WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        login.click();

        String st1 = "//div[@class=\"oxd-table-body\"]/div[";
        String st2 = "]/div[1]/div[";
        String st3 = "]";

        int row = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"]")).size();
        int col = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]/div[1]/div[1]/div")).size();

        for (int i=1; i<=row; i++){
            for (int j=1; j<=col; j++){
                String dynamic_XPath = st1+i+st2+j+st3;
                //System.out.println(dynamic_XPath);
                String data = driver.findElement(By.xpath(dynamic_XPath)).getText();
                //System.out.println(data);

                if (data.contains("0182")){
                    String surname_xPath = dynamic_XPath+"/following-sibling::div";
                    String surname = driver.findElement(By.xpath(surname_xPath)).getText();
                    System.out.println(surname);
                }
            }
        }
    }
}
