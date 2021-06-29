import com.sun.javafx.geom.Edge;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;


public class PasteBinCreatePaste {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void PasteBinCreate() throws InterruptedException {

        driver.get("https://pastebin.com/");
        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys("Hello from WebDriver");
        WebElement dropdownBtn = driver.findElement(By.id("select2-postform-expiration-container"));
        dropdownBtn.click();
        WebElement dropdownvalue = driver.findElement(By.xpath("//ul[@id='select2-postform-expiration-results']/*[normalize-space() = '10 Minutes']"));
        dropdownvalue.click();
        WebElement title = driver.findElement(By.id("postform-name"));
        title.sendKeys("helloweb");
        WebElement button = driver.findElement(By.xpath("//button[normalize-space() = 'Create New Paste']"));
        button.click();
        Thread.sleep(5000);
        driver.quit();

    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
        driver.quit();
        driver=null;
    }
}

