package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationAppointmentPage {

    private WebDriver driver;

    private By facilityDetailSelected = By.cssSelector("p[id='facility']");

    private By healthProgramOptionSelected = By.cssSelector("p[id='program']");

    private By visitDateDetail = By.xpath("//p[@id='visit_date']");

    private By comment = By.xpath("//p[@id='comment']");

    private By goToHomePageBtn = By.linkText("Go to Homepage");

    public ConfirmationAppointmentPage (WebDriver driver){
        this.driver=driver;
    }

    public String getFacilityDetailSelected(){
        return driver.findElement(facilityDetailSelected).getText();
    }

    public String getVisitDateDetail(){
        return driver.findElement(visitDateDetail).getText();
    }

    public String getCommentDetail(){
        return driver.findElement(comment).getText();
    }


    public String getHealthOptionsSelected(){
        return driver.findElement(healthProgramOptionSelected).getText();
    }



    public AppointmentMakePage clickOnGoToHomepageBtn(){
        driver.findElement(goToHomePageBtn).click();
        return new AppointmentMakePage(driver);
    }
}
