package SpiceJet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SpiceJet {
    EdgeDriver driver;

    @BeforeTest
    public void testbase() throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid='application-id']/div/div[3]")));

    }
    @Test
    public void testdestination(){
        WebElement from_sourse = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(from_sourse).click().build().perform();


        List<WebElement>cities = driver.findElements(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/div/div/div/div/div/div"));
        for(WebElement city : cities){
            if(city.getText().equals("IXG")){
                city.click();
                break;
            }
        }

    }
}
