import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PasteBinCreatePasteAndVerifyTextAndStyle {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void PasteBinTextCheck() throws InterruptedException {

        driver.get("https://pastebin.com/");


        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        WebElement syntaxDropdown = driver.findElement(By.id("select2-postform-format-container"));
        syntaxDropdown.click();
        WebElement syntaxValue = driver.findElement(By.xpath("//ul[@id='select2-postform-format-results']//*[normalize-space() = 'Bash']"));
        syntaxValue.click();

        WebElement expirationDropdown = driver.findElement(By.id("select2-postform-expiration-container"));
        expirationDropdown.click();
        WebElement expirationValue = driver.findElement(By.xpath("//ul[@id='select2-postform-expiration-results']//*[normalize-space() = '10 Minutes']"));
        expirationValue.click();

        WebElement title = driver.findElement(By.id("postform-name"));
        title.sendKeys("how to gain dominance among developers");

        WebElement button = driver.findElement(By.xpath("//button[normalize-space() = 'Create New Paste']"));
        Thread.sleep(2000);
        button.click();
        Thread.sleep(2000);

        String browserTitle = driver.getTitle();
        Assert.assertEquals(browserTitle, "how to gain dominance among developers - Pastebin.com");

        WebElement textform = driver.findElement(By.xpath("//textarea[@class='textarea']"));
        String result = textform.getText();
        System.out.println(result);
        Assert.assertEquals(result, "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        WebElement syntaxedButton = driver.findElement(By.xpath("//div[@class='post-view']//div[@class='left']/a"));
        Assert.assertEquals(syntaxedButton.getText(), "Bash");
        driver.quit();
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
        driver.quit();
        driver=null;
    }
}

