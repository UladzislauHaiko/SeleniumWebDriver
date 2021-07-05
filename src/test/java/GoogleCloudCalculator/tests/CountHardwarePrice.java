package GoogleCloudCalculator.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import GoogleCloudCalculator.webpages.CalculatopPage;
import GoogleCloudCalculator.webpages.GoogleCloudHomePage;
import GoogleCloudCalculator.webpages.SearchResultsPage;

import java.util.List;

public class CountHardwarePrice {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito", "start-maximized");
        driver = new ChromeDriver(options);

    }

    @Test
    public void googleCalcalator() throws InterruptedException {

        GoogleCloudHomePage home = new GoogleCloudHomePage(driver);
        home.clickOnSearchBtn();
        home.clickOnSearchInputField();
        home.searchInputField.sendKeys("Google Cloud Platform Pricing Calculator");
        home.searchInputField.sendKeys(Keys.ENTER);


        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(resultsPage.matchingLink));
        resultsPage.openMatchingLink();

        CalculatopPage calcpage = new CalculatopPage(driver);

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.frame));
        calcpage.switchFrame();


        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.computeEngine));
        calcpage.clickOnComputeEngine();

        calcpage.numberOfInstances.sendKeys("4");

        calcpage.clickOSdropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.operatingSystemValue));
        calcpage.selectOSvalue();

        calcpage.clickVMdropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.vmClassvalue));
        calcpage.selectVMvalue();

        calcpage.clickSeriesDropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.seriesValue));
        calcpage.selectSeriesValue();

        calcpage.clickMachineDropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.machineValue));
        calcpage.selectMachineValue();

        calcpage.clickAddGPUBtn();

        calcpage.clickGPUdropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.nmbGPUValue));
        calcpage.selectGPUvalue();

        calcpage.clickGPUTypeDropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.typeGPUValue));
        calcpage.selectGPUTypeValue();

        calcpage.clickSSDdropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.localSSDValue));
        calcpage.selectSSDvalue();

        calcpage.clickLocDropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.dataLocValue));
        calcpage.selectLocValue();

        calcpage.clickUsageDropdown();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOf(calcpage.usageValue));
        calcpage.selectUsageValue();

        calcpage.clickEstimateBtn();

        String vmResult = calcpage.vmClassResult.getText();
        System.out.println(vmResult);
        Assert.assertEquals(vmResult, "VM class: regular");

        String instResult = calcpage.instanceTypeResult.getText();
        System.out.println(instResult);
        Assert.assertEquals(instResult, "Instance type: n1-standard-8");

        String rgnResult = calcpage.regionResult.getText();
        System.out.println(rgnResult);
        Assert.assertEquals(rgnResult, "Region: Frankfurt");

        String ssdResult = calcpage.ssdTotalResult.getText();
        System.out.println(ssdResult);
        Assert.assertEquals(ssdResult, "Total available local SSD space 2x375 GiB");

        String termResult = calcpage.commitmentTermResult.getText();
        System.out.println(termResult);
        Assert.assertEquals(termResult, "Commitment term: 1 Year");

        String costResult = calcpage.estimatedCostResult.getText();
        System.out.println(costResult);
        Assert.assertEquals(costResult, "Total Estimated Cost: USD 1,082.77 per 1 month");


        driver.quit();

    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
        driver.quit();
        driver=null;
    }
}
