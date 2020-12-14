package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleDynamicSearch {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[contains(@class,'gLFyf')]")).sendKeys("Bangladesh");
        WebElement e = driver.findElement(By.xpath("//input[contains(@class,'gLFyf')]"));
        
        e.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        e.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        e.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        e.sendKeys(Keys.ENTER);

    }
}
