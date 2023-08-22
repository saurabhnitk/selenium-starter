package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

    ChromeDriver driver;
    public NestedFrames()
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

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(1000);
        List<WebElement> frameElements = driver.findElements(By.xpath("//frameset//frame"));
        String name;
        String text;
        for(WebElement f : frameElements){
            name = f.getAttribute("name");
            if(!name.contains("top")){
                driver.switchTo().frame(f);
                text = driver.findElement(By.xpath("//body")).getText();
                System.out.println(text);
                driver.switchTo().defaultContent();
            }else{
                driver.switchTo().frame(f);
                List<WebElement> innerFrameElements = driver.findElements(By.xpath("//frameset//frame"));
                for(WebElement f1: innerFrameElements){
                    driver.switchTo().frame(f1);
                    text = driver.findElement(By.xpath("//body")).getText();
                    System.out.println(text);
                    driver.switchTo().parentFrame();
                }
                driver.switchTo().defaultContent();
            }
            
        }
    }

    
}
