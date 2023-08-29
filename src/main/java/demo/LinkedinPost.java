package demo;

import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedinPost {

    WebDriver driver;
    public LinkedinPost()
    {
        System.out.println("Constructor: LinkedinPost");
        WebDriverManager.chromedriver().setup();
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

    
    public  void createPost() throws InterruptedException, AWTException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://in.linkedin.com/");
        Thread.sleep(20000);
        WebElement emailBox = driver.findElement(By.id("session_key"));
        emailBox.sendKeys("sksaurabhrox@gmail.com");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("Saurabh@1990patna");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        Thread.sleep(3000);
        //click on name of the user
        /*driver.findElement(By.xpath("//div[@class='t-16 t-black t-bold']")).click();
        Thread.sleep(2000);*/
        //click on Start a Post box using Locator XPath
        driver.findElement(By.xpath("//div[@class='share-box-feed-entry__top-bar']")).click();
        Thread.sleep(2000);
        //Locate photo icon using Locator "Xpath"        
        WebElement photoIcon = driver.findElement(By.xpath("(//button[@aria-label='Add media'])[1]"));
        //click on photoIcon using JavascriptExecutor class
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",photoIcon);
        //use of Robot class to upload file
        Robot rb = new Robot();
        //store the path of the file using StringSelection class object
        StringSelection filePath = new StringSelection("C:\\Users\\saura\\Downloads\\id_front.jpg");
        //copy the path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        //now press CTRL
        rb.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        //now press V
        rb.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);
        //release V
        rb.keyRelease(KeyEvent.VK_V);
        //release CTRL
        rb.keyRelease(KeyEvent.VK_CONTROL);
        //press ENTER
        rb.keyPress(KeyEvent.VK_ENTER);
        //release ENTER
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
        //click on Next button
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        //click on Post button
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);
        System.out.println("end Test case: createPost");
    }

    
}
