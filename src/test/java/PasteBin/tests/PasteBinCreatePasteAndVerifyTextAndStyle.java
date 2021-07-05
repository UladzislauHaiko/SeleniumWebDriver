package PasteBin.tests;

import PasteBin.webpages.PasteBinHomePage;
import PasteBin.webpages.PasteBinResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class PasteBinCreatePasteAndVerifyTextAndStyle {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void PasteBinTextCheck() throws InterruptedException {

        PasteBinHomePage PasteHome = new PasteBinHomePage(driver);

        PasteHome.NewPasteInputField.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        PasteHome.ClickOnSyntaxDpn();
        PasteHome.ClickOnSyntaxValue();
        PasteHome.ClickOnExpirationDpn();
        PasteHome.ClickOnExpirationValue();
        PasteHome.TitleInputField.sendKeys("how to gain dominance among developers");
        PasteHome.ClickOnCreateBtn();

        PasteBinResultPage PasteResult = new PasteBinResultPage(driver);

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(PasteResult.ResultTextForm));

        String browserTitle = driver.getTitle();
        System.out.println("Title is the same as entered");
        Assert.assertEquals(browserTitle, "how to gain dominance among developers - Pastebin.com");

        String result = PasteResult.ResultTextForm.getText();
        System.out.println("Text is the same as entered");
        Assert.assertEquals(result, "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        Assert.assertEquals(PasteResult.SyntaxButton.getText(), "Bash");
        System.out.println("Syntax is the same as entered");
        driver.quit();
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
        driver.quit();
        driver=null;
    }
}

