package demo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

    ChromeDriver driver;
    public WindowHandle()
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
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        Thread.sleep(1000);
        String main = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> I1 = windows.iterator();
        while (I1.hasNext()){
            String child_window = I1.next();
            if(!child_window.equalsIgnoreCase(main)){
                driver.switchTo().window(child_window);
                System.out.println(driver.getCurrentUrl());
                driver.getTitle();
                driver.close();
            }
            break;
        }
        driver.switchTo().window(main);

    }

    
}
