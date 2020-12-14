package Basic;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TakeScreenshot {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(scr, new File("C:\\Selenium\\IdeaProjects\\file_screensort.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
