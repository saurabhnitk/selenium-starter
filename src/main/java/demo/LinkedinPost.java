package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedinPost {

    ChromeDriver driver;
    public LinkedinPost()
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

    
    public  void createPost() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://in.linkedin.com/");
        Thread.sleep(1000);
        WebElement emailBox = driver.findElement(By.id("session_key"));
        emailBox.sendKeys("sksaurabhrox@gmail.com");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("Saurabh@1990patna");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='share-box-feed-entry__top-bar']")).click();
        Thread.sleep(2000);
        WebElement photoIcon = driver.findElement(By.xpath("//button[@aria-label='Add media']/span[@class='share-promoted-detour-button__icon-container']"));
        photoIcon.sendKeys("C:/Users/saura/OneDrive/Pictures/Screenshots/2023-06-28.png");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(3000);
        System.out.println("end Test case: createPost");
    }

    
}
