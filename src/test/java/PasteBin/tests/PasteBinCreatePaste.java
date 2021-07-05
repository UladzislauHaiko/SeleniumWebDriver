package PasteBin.tests;

import GoogleCloudCalculator.webpages.GoogleCloudHomePage;
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
import PasteBin.webpages.PasteBinHomePage;

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
        PasteBinHomePage PasteHome = new PasteBinHomePage(driver);
        PasteHome.NewPasteInputField.sendKeys("Hello from WebDriver");
        PasteHome.ClickOnExpirationDpn();
        PasteHome.ClickOnExpirationValue();
        PasteHome.TitleInputField.sendKeys("helloweb");
        PasteHome.ClickOnCreateBtn();
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

