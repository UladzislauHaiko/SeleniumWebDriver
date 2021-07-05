package PasteBin.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteBinResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//textarea[@class='textarea']")
    public WebElement ResultTextForm;

    @FindBy(xpath = "//div[@class='post-view']//div[@class='left']/a")
    public WebElement SyntaxButton;


    public PasteBinResultPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
