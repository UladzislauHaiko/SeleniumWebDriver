package GoogleCloudCalculator.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class GoogleCloudHomePage {
    private WebDriver driver;
    public static String CloudHomePageURL="https://cloud.google.com/";

    @FindBy(xpath = "//form[@class='devsite-search-form']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[contains(@class, 'devsite-search-field')]")
    public WebElement searchInputField;

    public GoogleCloudHomePage (WebDriver driver){
        this.driver=driver;
        driver.get(CloudHomePageURL);
        PageFactory.initElements(driver,this);
    }

    public void clickOnSearchBtn(){
        searchButton.click();
    }
    public void clickOnSearchInputField(){
        searchInputField.click();
    }
}
