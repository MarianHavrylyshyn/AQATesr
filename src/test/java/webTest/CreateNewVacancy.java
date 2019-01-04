
package webTest;
import data.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateNewVacancy extends GenericWebTest {
    @Test
    public void testCreatreNewVacancy() {
        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
        driver.findElement(By.id("btnAdd")).click();
        Select drpJobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
        drpJobTitle.selectByVisibleText("Sales Manager");
        driver.findElement(By.id("addJobVacancy_name")).sendKeys("Quality Assurance");
        driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("Linda");
        driver.findElement(By.xpath("/html/body/div[4]/ul/li")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
        List<WebElement> vacanciesList = driver.findElements(By.id("candidateSearch_jobVacancy"));
        List<String> vacancies = new ArrayList<>();
        for (WebElement el : vacanciesList) {
            vacancies.add(el.getText());
        }
        Assert.assertTrue(vacancies.contains("Quality Assurance"),
                "Vacancy is not found in the list of vacancies");
    }
}
