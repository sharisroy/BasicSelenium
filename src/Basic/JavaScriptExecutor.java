package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutor {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        WebElement element = driver.findElement(By.xpath("//button[contains(@class,'_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy')]"));

       // changeButtonColor(element,driver);                              // change  Login Button color
       // drawBorder(element,driver);                                     // change  Login Button Brder color
       // generateAlert("This is test alert generate", driver);             // Generate Alert ................
       // System.out.println(getPageTitle(driver));                        // Get page title .....................
       // System.out.println(getPageInnerText(driver));                    // Get Page inner all text .....................
       // scrollPageDown( driver);                                         // Scroll Down The Page

        WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'Help')]"));
        scrollToViewElement(element1,driver);                            // Scroll Down The Page until find the element




    }

    public static void scrollToViewElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true) ", element);
    }

    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static String getPageInnerText(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.documentElement.innerText;").toString();
        return title;
    }

    public static String getPageTitle(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title;").toString();
        return title;
    }


    public static void generateAlert(String message, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('"+message+"')");
    }

    public static void drawBorder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '9px solid #de1010' ", element);
    }

    public static void changeButtonColor(WebElement element, WebDriver driver){
        String color = element.getCssValue("backgroundColor");              // catch login button default color
        for(int i = 0; i<100; i++){
            changeColor("rgb(255,0,0)",element,driver);                  // change login button color default to red
            //changeColor(color,element,driver);                               // change login button color red to default
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"' ", element);

    }
}
