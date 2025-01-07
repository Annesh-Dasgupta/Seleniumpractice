package AwsomeQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTable {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
    }
    @Test
    public void table(){
        String first_path = "//table[@id='customers']/tbody/tr[";
        String second_path = "]/td[";
        String third_path = "]";
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int colum = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        for(int i =2;i<=row;i++){
            for(int j=1;j<=colum;j++){
                String dynamic_path = first_path+i+second_path+j+third_path;
                System.out.println(dynamic_path);
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                System.out.println(data);

            }
        }
    }
}
