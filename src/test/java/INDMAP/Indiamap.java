package INDMAP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Indiamap {
    WebDriver driver;
    @Test
    public void test_map() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
        driver.manage().window().fullscreen();

        Thread.sleep(3000);
        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for(WebElement state : states){
            System.out.println(state.getAttribute("aria-label"));
            if(state.getAttribute("aria-label").contains("West Bengal")){
                state.click();
            }

        }
    }


}
