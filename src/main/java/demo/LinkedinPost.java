package demo;

import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
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
        Thread.sleep(1000);
        WebElement emailBox = driver.findElement(By.id("session_key"));
        emailBox.sendKeys("sksaurabhrox@gmail.com");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("Saurabh@1990patna");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='share-box-feed-entry__top-bar']")).click();
        Thread.sleep(2000);
        //Locate photo icon and click on it using Locator "Xpath"
        //WebElement photoIcon = driver.findElement(By.xpath("//button[@aria-label='Add media']/span[@class='share-promoted-detour-button__icon-container']"));
        WebElement photoIcon = driver.findElement(By.xpath("(//button[@aria-label='Add media'])[1]"));
        //click on photoIcon
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",photoIcon);
        //send the file path
        Robot rb = new Robot();
        photoIcon.sendKeys("C:/Users/saura/OneDrive/Pictures/Screenshots/2023-06-28.png");
        Thread.sleep(4000);
        //click on Next button
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        //click on Post button
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);
        System.out.println("end Test case: createPost");
    }

    
}
