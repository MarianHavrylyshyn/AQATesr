package webTest;
import data.Constant;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.ArrayList;
import java.util.List;

public class createNewCandidate extends GenericWebTest {
    @Test
    public void testCreatreNewCadidate(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName+" "+lastName;

        openWebApp(Constant.URL).loginAs(Constant.USERNAME,Constant.PASSWORD);

        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("addCandidate_firstName")).sendKeys (firstName);
        driver.findElement(By.id("addCandidate_lastName")).sendKeys (lastName);
        driver.findElement(By.id("addCandidate_email")).sendKeys ("test@trest.com");
        driver.findElement(By.id("addCandidate_contactNo")).sendKeys ("+123456789");
        driver.findElement(By.id("addCandidate_comment")).sendKeys ("Text of comment");
        //driver.findElement(By.xpath("//*[@id='addCandidate_appliedDate']")).clear();
        //driver.findElement(By.xpath("//*[@id='addCandidate_appliedDate']")).sendKeys("2018-12-12");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();

        List<WebElement> candidateNames = driver.findElements(By.cssSelector("#resultTable a[href *='addCandidate']"));
        List<String> names = new ArrayList<>();
        for(WebElement el : candidateNames){
            names.add(el.getText()); }
        Assert.assertTrue(names.contains(fullName),
                "Candidate is not found in Candidate table");
    }
    }
