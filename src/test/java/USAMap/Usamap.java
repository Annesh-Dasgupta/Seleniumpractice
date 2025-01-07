package USAMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Usamap {
    @Test
    public void test_usa_map() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.amcharts.com/svg-maps/?map=usa");

        WebElement button1 = driver.findElement(By.xpath("//input[@value='I agree']"));
        button1.click();

        Thread.sleep(3000);

        List<WebElement> usaStates = driver.findElements(By.xpath("//*[local-name()=\"svg\"]/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for(WebElement states : usaStates){
            System.out.println(states.getAttribute("aria-label"));
            if(states.getAttribute("aria-label").contains("Texas")){
                states.click();
            }
        }



    }
}
