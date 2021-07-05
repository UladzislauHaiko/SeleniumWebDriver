package PasteBin.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteBinHomePage {
    private WebDriver driver;
    public static String PasteBinHomePageURL="https://pastebin.com/";

    @FindBy(id = "postform-text")
    public WebElement NewPasteInputField;

    @FindBy(id = "select2-postform-format-container")
    public WebElement SyntaxDpn;

    @FindBy(xpath = "//ul[@id='select2-postform-format-results']//*[normalize-space() = 'Bash']")
    public WebElement SyntaxValue;

    @FindBy(id = "select2-postform-expiration-container")
    public WebElement ExpirationDpn;

    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']/*[normalize-space() = '10 Minutes']")
    public WebElement ExpirationValue;

    @FindBy(id = "postform-name")
    public WebElement TitleInputField;

    @FindBy(xpath = "//button[normalize-space() = 'Create New Paste']")
    public WebElement CreatePasteBtn;

    public PasteBinHomePage (WebDriver driver){
        this.driver=driver;
        driver.get(PasteBinHomePageURL);
        PageFactory.initElements(driver,this);
    }
    public void ClickOnSyntaxDpn(){
        SyntaxDpn.click();
    }
    public void ClickOnSyntaxValue(){
        SyntaxValue.click();
    }
    public void ClickOnExpirationDpn(){
        ExpirationDpn.click();
    }
    public void ClickOnExpirationValue(){
        ExpirationValue.click();
    }
    public void ClickOnCreateBtn(){
        CreatePasteBtn.click();
    }


}
