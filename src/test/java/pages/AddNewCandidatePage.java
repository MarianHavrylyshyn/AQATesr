package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddNewCandidatePage extends GenericWebPage {
    WebDriver driver;
public AddNewCandidatePage(){}
    public AddNewCandidatePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
