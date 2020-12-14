package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navagation {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.get("https://www.youtube.com/");
        driver.navigate().back();
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.linkText("Gmail")).click();

        //driver.navigate().forward();
        //driver.navigate().refresh();

    }
}
