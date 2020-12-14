package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleDynamicTable {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://ui.cogmento.com/");

//                                                      Login Section
        driver.findElement(By.name("email")).sendKeys("harisroy.info@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Haris123");
        driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")).click();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement((By.xpath("//span[contains(text(),'Contacts')]"))).click();

        usingLoop(driver);
       // usingDirectXpath(driver);

//                              Xpath Format
        //*[@id="main-content"]/div/div[2]/div/table/tbody/tr[3]/td[2]/a
        //*[@id='main-content']/div/div[2]/div/table/tbody/tr[2]/td[1]/input
        //a[contains(text(),'Name 2')]/parent::td/preceding-sibling::td/div/input[@name='id']

    }

    public static void usingLoop(WebDriver driver) {
        List<WebElement> element = driver.findElements(By.xpath("//input[contains(@name,'id')]"));
        System.out.println("Number to total row : "+element.size());

        String firstXpath = "//*[@id='main-content']/div/div[2]/div/table/tbody/tr[";
        String lastXpath = "]/td[2]/a";

        for(int i = 1; i<=element.size(); i++){
            String name = driver.findElement(By.xpath(firstXpath + i + lastXpath)).getText();
            if(name.contains("Sonjoy Kaka")){
                WebElement element2 =  driver.findElement(By.xpath("//*[@id='main-content']/div/div[2]/div/table/tbody/tr[" + i + "]/td[1]/div/input"));
                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(By.xpath("//th[contains(text(),'Status')]"))).build().perform();
                actions.moveToElement(element2).click().build().perform();
            }
        }

    }
    public static void usingDirectXpath(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//th[contains(text(),'Status')]"))).build().perform();
        driver.findElement(By.xpath("//a[contains(text(),'Name 2')]/parent::td/preceding-sibling::td/div/input[@name='id']")).click();



    }


}
