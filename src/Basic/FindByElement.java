package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindByElement {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        WebDriverWait wait = new WebDriverWait(driver,30);

        try {
            driver.findElement(By.id("u_0_2")).click();  // find by id
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.name("firstname")).sendKeys("First Name"); // find by name
            driver.findElement(By.xpath("//input[contains(@name,'last')]")).sendKeys("last Name");// find by contains
            driver.findElement(By.cssSelector("#u_2_g")).sendKeys("email@mail.com");  // find by css Selector
            driver.findElement(By.cssSelector("#u_2_j")).sendKeys("email@mail.com");

            driver.findElement(By.xpath("//*[@id=\"password_step_input\"]")).sendKeys("password"); // find by Xpath

            Select date = new Select(driver.findElement(By.xpath("//*[@id=\"day\"]")));
            date.selectByValue("24");
            Select month = new Select(driver.findElement(By.xpath("//*[@id=\"month\"]")));
           // month.selectByIndex(12);
            Select year = new Select(driver.findElement(By.xpath("//*[@id=\"year\"]")));
            year.selectByVisibleText("1994");
            driver.findElement(By.xpath("//*[@id=\"u_2_3\"]")).click();
            driver.findElement(By.id("u_2_s")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_error")));

            driver.findElement(By.id("u_2_9")).click();

            driver.findElement(By.partialLinkText("Forgotten ")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.linkText("Cancel")).click();

            System.out.println("Done");
        }catch (Exception e){

            System.out.println("\n\n\nError : "+e.toString());
        }
        finally {

            //driver.close();
        }

    }
}
