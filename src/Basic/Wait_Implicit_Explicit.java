package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait_Implicit_Explicit {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://fast.com/");

//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        driver.findElement(By.id("show-more-details-link")).click();

        explicit(driver, driver.findElement(By.id("show-more-details-link")),50 );

    }

    public static void explicit (WebDriver driver, WebElement element, int times) {
        new WebDriverWait(driver, times).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
