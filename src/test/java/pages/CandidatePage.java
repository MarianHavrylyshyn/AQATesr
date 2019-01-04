package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CandidatePage extends GenericWebPage {
     WebDriver driver;
    public CandidatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "btnAdd")
    private WebElement addButton;

    public AddNewCandidatePage openAddNewCandidatePage(WebDriver driver){

        addButton.click();
        PageFactory.initElements(driver,this);
        return new CandidatePage();
}}