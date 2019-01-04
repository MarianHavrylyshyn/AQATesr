package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  GenericWebPage{
    private WebDriver driver;

    @FindBy(id = "txtUsername")
    private WebElement usernameElement;

    @FindBy(id = "txtPassword")
    private WebElement passwordElement;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    private void fillLoginForm(String username, String password){
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
    }
    public LoginPage fillLoginFormWithInvalidData(String username, String password){
        fillLoginForm(username, password);
        return this;
    }


    public HomePage loginAs(String username, String password){
        fillLoginForm(username, password);
        loginButton.click();
        return new HomePage(driver);
    }
}
