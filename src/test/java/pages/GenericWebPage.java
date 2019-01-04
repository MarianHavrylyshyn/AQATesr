package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webTest.GenericWebTest;
import java.util.List;

public class GenericWebPage  {
   public WebDriver driver;
    public GenericWebPage (){
    PageFactory.initElements(driver,this);
}
    @FindBy(css = "[class= 'firstLevelMenu']")
    private List<WebElement> menuItems;

    private void clickOnMenuItem(String menuItemName){
    for (int i=0; i<menuItems.size(); i++){
        menuItems.get(i).click();
        break;
    }
}
    public  CandidatePage openCandidatePage(WebDriver driver){
    clickOnMenuItem( "Recruitment");
    return new CandidatePage(driver);
    }
}
