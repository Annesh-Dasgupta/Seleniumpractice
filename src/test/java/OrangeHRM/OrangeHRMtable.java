package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class OrangeHRMtable {
    WebDriver driver;

    @Test (priority = 1)
    public void test_url() throws InterruptedException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void test_login() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321");
        WebElement submit_button = driver.findElement(By.xpath("//button[@type='submit']"));
        submit_button.click();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void test_table(){
        String first_part = "//div[@class='orangehrm-container']/div/div/div[";
        String second_part = "]/div[@role='row']/div[@role='cell'][" ;
        String third_part = "]";

        int row = driver.findElements(By.xpath("//div[@class='orangehrm-container']/div/div/div ")).size();
        int col = driver.findElements(By.xpath("//div[@class='orangehrm-container']/div/div/div[1]/div[@role='row']/div[@role='cell']")).size();

        System.out.println(row + " & " + col);
        for(int i = 1;i<row;i++){
           for (int j = 1; j<=col;j++){

               String dynamic_path = first_part+i+second_part+j+third_part;
               String data = driver.findElement(By.xpath(dynamic_path)).getText();
//               System.out.println(data);
               if(data.contains("0169")){
                   String firstname = driver.findElement(By.xpath(dynamic_path+"/following-sibling::div")).getText();
                   System.out.println(firstname);
               }
           }
        }
    }
}
