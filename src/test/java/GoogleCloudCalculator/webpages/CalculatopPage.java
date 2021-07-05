package GoogleCloudCalculator.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CalculatopPage {
    private WebDriver driver;

    @FindBy(xpath = "//iFrame[contains(@src, '/products/calculator/index_')]")
    public WebElement frame;

    @FindBy(xpath = "(//*[@class='hexagon'and @title='Compute Engine']/*[@class='hexagon-in1']/*[@class='hexagon-in2'])[1]")
    public WebElement computeEngine;

    @FindBy(xpath = "//input[@id='input_66' and @name='quantity']")
    public  WebElement numberOfInstances;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.os']")
    public  WebElement operatingSystemDropdown;

    @FindBy(xpath = "//*[@class='md-ink-ripple']//*[normalize-space() = 'Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")
    public  WebElement operatingSystemValue;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.class']")
    public  WebElement vmClass;

    @FindBy(xpath = "(//*[@class='md-ink-ripple']//*[normalize-space() = 'Regular'])[2]")
    public  WebElement vmClassvalue;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.series']")
    public  WebElement seriesDpn;

    @FindBy(xpath = "//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = 'N1']")
    public  WebElement seriesValue;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.instance']")
    public  WebElement machineTypeDpn;

    @FindBy(xpath = "//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = 'n1-standard-8 (vCPUs: 8, RAM: 30GB)']")
    public  WebElement machineValue;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    public  WebElement GPUBtn;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.gpuCount']")
    public  WebElement nmbGPUDpn;

    @FindBy(xpath = "//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = '1']")
    public  WebElement nmbGPUValue;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.gpuType']")
    public  WebElement typeGPUDpn;

    @FindBy(xpath = "//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = 'NVIDIA Tesla V100']")
    public  WebElement typeGPUValue;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.ssd']")
    public  WebElement localSSDDpn;

    @FindBy(xpath = "//*[@class= 'ng-scope md-ink-ripple']//*[normalize-space() = '2x375 GB']")
    public  WebElement localSSDValue;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.location']")
    public  WebElement dataLocDpn;

    @FindBy(xpath = "(//*[@class='ng-scope md-ink-ripple']//*[normalize-space() = 'Frankfurt (europe-west3)'])[3]")
    public  WebElement dataLocValue;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.cud']")
    public  WebElement usageDpn;

    @FindBy(xpath = "(//*[@class= 'md-ink-ripple']//*[normalize-space() = '1 Year'])[2]")
    public  WebElement usageValue;

    @FindBy(xpath = "(//*[@class= 'md-raised md-primary cpc-button md-button md-ink-ripple'])[1]")
    public  WebElement estimateBtn;

    @FindBy(xpath = "(//*[@class= 'md-list-item-text ng-binding'])[2]")
    public  WebElement vmClassResult;

    @FindBy(xpath = "(//*[@class= 'md-list-item-text ng-binding'])[3]")
    public  WebElement instanceTypeResult;

    @FindBy(xpath = "(//*[@class= 'md-list-item-text ng-binding'])[4]")
    public  WebElement regionResult;

    @FindBy(xpath = "(//*[@class= 'md-list-item-text ng-binding'])[5]")
    public  WebElement ssdTotalResult;

    @FindBy(xpath = "(//*[@class= 'md-list-item-text ng-binding'])[6]")
    public  WebElement commitmentTermResult;

    @FindBy(xpath = "(//b[@class= 'ng-binding'])[2]")
    public  WebElement estimatedCostResult;




    public CalculatopPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void switchFrame(){
        driver.switchTo().frame(frame);
        driver.switchTo().frame("myFrame");
    }

    public void clickOnComputeEngine(){
        computeEngine.click();
    }

    public void clickOSdropdown(){
        operatingSystemDropdown.click();
    }
    public void selectOSvalue(){
        operatingSystemValue.click();
    }

    public void clickVMdropdown(){
        vmClass.click();
    }
    public void selectVMvalue(){
        vmClassvalue.click();
    }

    public void clickSeriesDropdown(){
        seriesDpn.click();
    }
    public void selectSeriesValue(){
        seriesValue.click();
    }

    public void clickMachineDropdown(){
        machineTypeDpn.click();
    }
    public void selectMachineValue(){
        machineValue.click();
    }

    public void clickAddGPUBtn(){
        GPUBtn.click();
    }

    public void clickGPUdropdown(){
        nmbGPUDpn.click();
    }
    public void selectGPUvalue(){
        nmbGPUValue.click();
    }

    public void clickGPUTypeDropdown(){
        typeGPUDpn.click();
    }
    public void selectGPUTypeValue(){
        typeGPUValue.click();
    }

    public void clickSSDdropdown(){
        localSSDDpn.click();
    }
    public void selectSSDvalue(){
        localSSDValue.click();
    }

    public void clickLocDropdown(){
        dataLocDpn.click();
    }
    public void selectLocValue(){
        dataLocValue.click();
    }

    public void clickUsageDropdown(){
        usageDpn.click();
    }
    public void selectUsageValue(){
        usageValue.click();
    }

    public void clickEstimateBtn(){
        estimateBtn.click();
    }


}
