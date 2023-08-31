package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImdbRatings {

    ChromeDriver driver;
    public ImdbRatings()
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
        driver.get("https://www.imdb.com/chart/top");
        Thread.sleep(5000);
        //the highest rated movie on IMDb
        WebElement topRated = driver.findElement(By. xpath("//h3[contains(text(),'1. The Shawshank Redemption')]"));
        System.out.println(topRated.getText());
        //movies included in the table
        String movies = driver.findElement(By.xpath("//span[text()='250 Titles']")).getText();
        System.out.println(movies);
        //click on Sort By dropdown and select Release Date option
        Select sortBy = new Select(driver.findElement(By.id("sort-by-selector")));
        sortBy.selectByVisibleText("Release date");
        Thread.sleep(1000);
        //locate the first movie and get text
        WebElement recentMovie = driver.findElement(By.xpath("//ul[contains(@class,'sTTRj')]/li/div[2]//h3"));
        String recentMovieName = recentMovie.getText();
        System.out.println(recentMovieName);
        //click on Sort By dropdown and select Number of ratings option
        Select sortByRatings = new Select(driver.findElement(By.id("sort-by-selector")));
        sortByRatings.selectByVisibleText("Number of ratings");
        Thread.sleep(1000);
        //locate the first movie and get text
        WebElement mostRatingsMovie = driver.findElement(By.xpath("//ul[contains(@class,'sTTRj')]/li/div[2]//h3"));
        String mostRatingsMovieName = mostRatingsMovie.getText();
        System.out.println(mostRatingsMovieName);
    }

    
}
