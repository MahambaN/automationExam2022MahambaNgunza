package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentMakePage {
    private WebDriver driver;

    private By facilitySelect = By.id("combo_facility");
    private By selectApplyForHspCheckBox = By.cssSelector("input[type='checkbox'][name='hospital_readmission']");

    private By selectHealthPrgmRadioButton = By.xpath("//input[@name='programs']");


    private By dateVisit = By.id("txt_visit_date");

    private By commentField = By.name("comment");

    private By btnBookAppointment = By.cssSelector("button[id='btn-book-appointment']");

    private By textOnScreen = By.cssSelector("#appointment > div > div > div > h2");

    public AppointmentMakePage(WebDriver driver){
        this.driver=driver;
    }

    public void enterFacility(String facility){
        driver.findElement(facilitySelect).sendKeys(facility);
    }

    public void clickOnCheckBoxApply(){
        driver.findElement(selectApplyForHspCheckBox).click();
    }

    public void selectHealthProgramOption (Integer HealthProgramBtnValue){
        driver.findElements(selectHealthPrgmRadioButton).get(HealthProgramBtnValue.intValue()).click();
    }

    public void enterDate(String date){
        driver.findElement(dateVisit).sendKeys(date);
    }

   public void enterComments(String comments){
        driver.findElement(commentField).sendKeys(comments);
   }


    public ConfirmationAppointmentPage clickOnBtnBookAppointment(){
        driver.findElement(btnBookAppointment).click();
        return new ConfirmationAppointmentPage(driver);
    }

    public String getTextOnScreen(){
        return driver.findElement(textOnScreen).getText();
    }


}
