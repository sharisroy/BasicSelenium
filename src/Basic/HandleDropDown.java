package Basic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;


public class HandleDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();


       // bootstrapDropDown(driver);
        locationFinder(driver);
    }


    public static void locationFinder(WebDriver driver) {
        driver.get("https://www.spicejet.com/");
        fromCity( driver);
        toCity(driver);
    }



    public static void bootstrapDropDown(WebDriver driver) {
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li/a//label"));

        for(int i = 0; i<elements.size(); i++){
            //System.out.println(elements.get(i).getText());
            if(elements.get(i).getText().contains("C#")){
                elements.get(i).click();
            }
        }
    }

    public static void fromCity( WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

        List<WebElement> fromCity = driver.findElements(By.xpath("//div[contains(@id,'dropdownGroup1')]/div/ul/li/a"));
        List<WebElement> fromCity2 = driver.findElements(By.xpath("//div[contains(@id,'dropdownGroup2')]/div/ul/li/a"));
        fromCity.addAll(fromCity2);

        for(int i = 0; i<fromCity.size(); i++){
//            System.out.println( i +" Name : " + fromCity.get(i).getAttribute("value"));
//            System.out.println( i +" Name : " + fromCity.get(i).getText());
            String name = fromCity.get(i).getText();
            if(name.contains("DAC")){
                fromCity.get(i).click();
            }
        }
    }

    public static void toCity(WebDriver driver) {

        List<WebElement> toCity = driver.findElements(By.xpath("//div[contains(@id,'glsctl00_mainContent_ddl_destinationStation1_CTNR')]/table/tbody/tr[2]/td[2]/div[3]/div[1]/div/ul/li/a"));
        List<WebElement> toCity2 = driver.findElements(By.xpath("//div[contains(@id,'glsctl00_mainContent_ddl_destinationStation1_CTNR')]/table/tbody/tr[2]/td[2]/div[3]/div[2]/div/ul/li/a"));
        toCity.addAll(toCity2);

        for (int i = 0; i < toCity.size(); i++) {
//            System.out.println( i +" Name : " + toCity.get(i).getAttribute("value"));
//            System.out.println( i +" Name : " + toCity.get(i).getText());
            String name = toCity.get(i).getText();
            if (name.contains("JED")) {
                toCity.get(i).click();
            }
        }
    }
}
