package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]")))
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]")))
                .release()
                .build()
                .perform();



    }
}
