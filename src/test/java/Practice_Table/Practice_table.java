package Practice_Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Practice_table {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new EdgeDriver();
        driver.get("https://practice.expandtesting.com/dynamic-table");
        driver.manage().window().maximize();
    }
    @Test
    public void test_table(){
        WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody"));
        List<WebElement> table_list = table.findElements(By.tagName("tr"));
        for(int i =0;i<table_list.size();i++){
            List<WebElement> colum_list = table_list.get(i).findElements(By.tagName("td"));
            for(WebElement colum : colum_list){
                System.out.println(colum.getText());

            }
        }

    }
}
