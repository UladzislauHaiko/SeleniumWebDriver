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

import java.util.List;

public class GoogleCloudCalculator {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }

    @Test
    public void googleCalcalator() throws InterruptedException {

        driver.get("https://cloud.google.com/");

        WebElement searchButton = driver.findElement(By.xpath("//form[@class='devsite-search-form']"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.xpath("//input[contains(@class, 'devsite-search-field')]"));
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        String linkToOpen= driver.findElement(By.xpath("//div[contains(@class, 'gs-title')]//*[normalize-space() = 'Google Cloud Platform Pricing Calculator']")).getAttribute("href");
        driver.get(linkToOpen);
        Thread.sleep(5000);

        WebElement frame = driver.findElement(By.xpath("//iFrame[contains(@src, '/products/calculator/index_')]"));
        driver.switchTo().frame(frame);
        driver.switchTo().frame("myFrame");

        WebElement computeEngine = driver.findElement(By.xpath("(//*[@class='hexagon'and @title='Compute Engine']/*[@class='hexagon-in1']/*[@class='hexagon-in2'])[1]"));
        Thread.sleep(5000);
        computeEngine.click();


        WebElement numberOfInstances = driver.findElement(By.xpath("//input[@id='input_65' and @name='quantity']"));
        numberOfInstances.sendKeys("4");

        WebElement operatingSystemDropdown = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.os']"));
        operatingSystemDropdown.click();
        WebElement operatingSystemValue = driver.findElement(By.xpath("//*[@class='md-ink-ripple']//*[normalize-space() = 'Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']"));
        operatingSystemValue.click();

        WebElement vmClass = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.class']"));
        Thread.sleep(5000);
        vmClass.click();
        WebElement vmClassvalue = driver.findElement(By.xpath(("(//*[@class='md-ink-ripple']//*[normalize-space() = 'Regular'])[2]")));
        Thread.sleep(3000);
        vmClassvalue.click();

        WebElement seriesDpn = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.series']"));
        Thread.sleep(3000);
        seriesDpn.click();
        WebElement seriesValue = driver.findElement(By.xpath("//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = 'N1']"));
        Thread.sleep(3000);
        seriesValue.click();

        WebElement machineTypeDpn = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.instance']"));
        Thread.sleep(3000);
        machineTypeDpn.click();
        WebElement machineValue = driver.findElement(By.xpath("//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = 'n1-standard-8 (vCPUs: 8, RAM: 30GB)']"));
        Thread.sleep(3000);
        machineValue.click();

        WebElement addGPUDpn = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']"));
        Thread.sleep(3000);
        addGPUDpn.click();

        WebElement nmbGPUDpn = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.gpuCount']"));
        Thread.sleep(3000);
        nmbGPUDpn.click();
        WebElement nmbGPUValue = driver.findElement(By.xpath("//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = '1']"));
        Thread.sleep(3000);
        nmbGPUValue.click();

        WebElement typeGPUDpn = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.gpuType']"));
        Thread.sleep(3000);
        typeGPUDpn.click();
        WebElement typeGPUValue = driver.findElement(By.xpath("//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = 'NVIDIA Tesla V100']"));
        Thread.sleep(3000);
        typeGPUValue.click();

        WebElement localSSDDpn = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.ssd']"));
        Thread.sleep(3000);
        localSSDDpn.click();
        WebElement localSSDValue = driver.findElement(By.xpath("//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = '2x375 GB']"));
        Thread.sleep(3000);
        localSSDValue.click();

        WebElement dataLocDpn = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.location']"));
        Thread.sleep(3000);
        dataLocDpn.click();
        WebElement dataLocValue = driver.findElement(By.xpath(("(//*[@class='ng-scope md-ink-ripple']//*[normalize-space() = 'Frankfurt (europe-west3)'])[3]")));
        Thread.sleep(3000);
        dataLocValue.click();

        WebElement usageDpn = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.cud']"));
        Thread.sleep(3000);
        usageDpn.click();
        WebElement usageValue = driver.findElement(By.xpath("(//*[@class= 'md-ink-ripple']//*[normalize-space() = '1 Year'])[2]"));
        Thread.sleep(3000);
        usageValue.click();

        WebElement estimateBtn = driver.findElement(By.xpath("(//*[@class= 'md-raised md-primary cpc-button md-button md-ink-ripple'])[1]"));
        Thread.sleep(3000);
        estimateBtn.click();
        Thread.sleep(3000);

        WebElement vmClassResult = driver.findElement(By.xpath("(//*[@class= 'md-list-item-text ng-binding'])[2]"));
        String vmResult = vmClassResult.getText();
        System.out.println(vmResult);
        Assert.assertEquals(vmResult, "VM class: regular");

        WebElement instanceTypeResult = driver.findElement(By.xpath("(//*[@class= 'md-list-item-text ng-binding'])[3]"));
        String instResult = instanceTypeResult.getText();
        System.out.println(instResult);
        Assert.assertEquals(instResult, "Instance type: n1-standard-8");

        WebElement regionResult = driver.findElement(By.xpath("(//*[@class= 'md-list-item-text ng-binding'])[4]"));
        String rgnResult = regionResult.getText();
        System.out.println(rgnResult);
        Assert.assertEquals(rgnResult, "Region: Frankfurt");

        WebElement ssdTotalResult = driver.findElement(By.xpath("(//*[@class= 'md-list-item-text ng-binding'])[5]"));
        String ssdResult = ssdTotalResult.getText();
        System.out.println(ssdResult);
        Assert.assertEquals(ssdResult, "Total available local SSD space 2x375 GiB");

        WebElement commitmentTermResult = driver.findElement(By.xpath("(//*[@class= 'md-list-item-text ng-binding'])[6]"));
        String termResult = commitmentTermResult.getText();
        System.out.println(termResult);
        Assert.assertEquals(termResult, "Commitment term: 1 Year");

        WebElement estimatedCostResult = driver.findElement(By.xpath("(//b[@class= 'ng-binding'])[2]"));
        String costResult = estimatedCostResult.getText();
        System.out.println(costResult);
        Assert.assertEquals(costResult, "Total Estimated Cost: USD 1,082.77 per 1 month");


        Thread.sleep(10000);

        driver.quit();

    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
        driver.quit();
        driver=null;
    }
}
