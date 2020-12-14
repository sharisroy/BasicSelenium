package Basic;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandleCalendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        //usingCalender(driver);
        jsCalender(driver);

    }
    public static void jsCalender(WebDriver driver){
        driver.get("https://www.spicejet.com");
        driver.findElement(By.xpath("//input[contains(@name,'ctl00$mainContent$view_date1')]")).click();
        WebElement element = driver.findElement(By.xpath("//input[contains(@name,'ctl00$mainContent$txt_Fromdate')]"));
        String date = "30-01-2021";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '"+date+"') ", element);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }


    public static void usingCalender(WebDriver driver){
        driver.get("https://ui.cogmento.com/");

//                                                      Login Section
        driver.findElement(By.name("email")).sendKeys("harisroy.info@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Haris123");
        driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")).click();

//                                                      Calender Button Section
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement((By.xpath("//span[contains(text(),'Calendar')]"))).click();
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a")).click();                                        // click new button
        driver.findElement(By.xpath("//input[contains(@name, 'title')]")).sendKeys("Event Title");
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[2]/div[1]/div/div[1]/div/input")).click();


//                                                      Calendar Xpath by Date wise

        //*[@id="main-content"]/div/div[2]/form/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]     // 1st row 1st column
        //*[@id="main-content"]/div/div[2]/form/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[2]     // 1st row 2nd column

        //*[@id="main-content"]/div/div[2]/form/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]     // 2nd row 1st column
        //*[@id="main-content"]/div/div[2]/form/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]     // 2nd row 2nd column

        //*[@id="main-content"]/div/div[2]/form/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[7]     // 5th row 7th column

        //                                                      Handle Calender only For Date

//        String fullDate = "31/12/2020";
//        String dateArray[] = fullDate.split("/");
//        String day = dateArray[0];
//        String month = dateArray[1];
//        String year = dateArray[2];

        String first_Xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[2]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[";
        String middle_Xpath = "]/div[";
        String last_Xpath = "]";
        String day = "30";          // This month only

        for(int row = 1; row<=5; row++){
            for(int column = 1; column<=7; column++){
                String date = driver.findElement(By.xpath(first_Xpath + row + middle_Xpath + column + last_Xpath)).getText();
                int temp = Integer.parseInt(day) ;

                if(date.contains(day)){
                    if (row == 1 &&  temp > 25){ ;
                        continue;
                    }
                    else {
                        driver.findElement(By.xpath(first_Xpath + row + middle_Xpath + column + last_Xpath)).click();
                        break;
                    }

                }
            }
        }
    }
}
