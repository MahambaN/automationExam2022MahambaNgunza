package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By btnMakeAppointment=By.linkText("Make Appointment");

    private By entryUsername = By.cssSelector("input[id='txt-username']");
    private By entryPassword= By.name("password");

    private By btnLogin = By.xpath("//button[@id='btn-login']");


    public HomePage (WebDriver driver){
        this.driver=driver;
    }

    public void clickOnBtnMakeAppointment(){
        driver.findElement(btnMakeAppointment).click();
    }

    public void usernameSet(){
        driver.findElement(entryUsername).sendKeys("John Doe");
    }

    public void passwordSet(){
        driver.findElement(entryPassword).sendKeys("ThisIsNotAPassword");
    }
    public AppointmentMakePage clickOnBtnLogin(){
        driver.findElement(btnLogin).click();
        return new AppointmentMakePage(driver);
    }

}
