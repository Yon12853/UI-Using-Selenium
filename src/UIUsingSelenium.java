import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIUsingSelenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Selenium-chrome//chromedriver.exe");

        // Create Chrome Driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        // Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Launch Google
        driver.get("https://www.google.com/");

        // Locating the elements using name locator for the text box
        driver.findElement(By.name("q")).sendKeys("Software Automated Testing");

        // find google search button by name and click it!
        WebElement searchIcon = driver.findElement(By.name("btnK"));
        searchIcon.click();

        // I extracted the first result using ChroPath (Chrome Extension) to better utilize my time. We can do this in a better way though.
        driver.findElement(By.xpath("//body[@id='gsr']/div[@id='main']/div[@id='cnt']/div[@class='mw']/div[@id='rcnt']/div[@class='col']/div[@id='center_col']/div[@id='res']/div[@id='search']/div/div[@id='rso']/div[1]/div[1]/div[1]/a[1]/h3[1]")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}