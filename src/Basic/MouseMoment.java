package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class MouseMoment {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.daraz.com.bd/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.partialLinkText("Electronic Devices"))).build().perform();
        actions.moveToElement(driver.findElement(By.linkText("Laptops"))).build().perform();
        driver.findElement(By.linkText("Macbook")).click();
    }
}
