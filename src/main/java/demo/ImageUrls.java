package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUrls {

    ChromeDriver driver;
    public ImageUrls()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        //Navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        //get webelement list for “Recommended Movies” Using Locator "XPath" "//div[contains(@class,'YeNog')]/div/a"
        List<WebElement> imgs = driver.findElements(By.xpath("//div[contains(@class,'YeNog')]/div/a"));
        //iterate over list and store "id" attribute in string variable using getAttribute("id") method and print it
        for(WebElement w : imgs){
            String url = w.getAttribute("id");
            System.out.println(url);
        }
        System.out.println("end Test case: testCase01");
    }

}
