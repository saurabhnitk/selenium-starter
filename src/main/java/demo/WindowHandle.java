package demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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
        Thread.sleep(3000);
        //switch to iframe
        WebElement f = driver.findElement(By.xpath("//*[@id='iframeResult']"));
        driver.switchTo().frame(f);
        Thread.sleep(1000);
        //Click on the  "Try it" button
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        //get all window handles
        Set<String> handles = driver.getWindowHandles();
        //switch to new window handle
        driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);
        Thread.sleep(2000);
        //get url of new window handle
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(2000);
        //close window
        driver.close();
        //return to previous window
        driver.switchTo().window(handles.toArray(new String[handles.size()])[0]);

    }

    
}
