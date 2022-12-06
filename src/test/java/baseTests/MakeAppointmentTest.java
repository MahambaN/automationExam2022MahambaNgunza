package baseTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentMakePage;
import pages.ConfirmationAppointmentPage;
import pages.HomePage;

public class MakeAppointmentTest extends BaseTest{

    @Test(priority = 1, dataProvider = "Data")
    public void MakeAppointment(String Facility, Integer BtnRadioValue,String Date, String Comment){

          AppointmentMakePage appointmentPage= homePage.clickOnBtnLogin();
          Assert.assertEquals(appointmentPage.getTextOnScreen(),"Make Appointment");
          System.out.println("The Make Appointment screen name is displayed as " + appointmentPage.getTextOnScreen());
          appointmentPage.enterFacility(Facility);
          appointmentPage.clickOnCheckBoxApply();
          appointmentPage.selectHealthProgramOption(BtnRadioValue);
          appointmentPage.enterDate(Date);
          appointmentPage.enterComments(Comment);
          ConfirmationAppointmentPage confirmationAppointmentPage = appointmentPage.clickOnBtnBookAppointment();
          Assert.assertTrue(confirmationAppointmentPage.getFacilityDetailSelected().contains(Facility));
          System.out.println("Facility selected is " +confirmationAppointmentPage.getFacilityDetailSelected());

          Assert.assertTrue(confirmationAppointmentPage.getVisitDateDetail().contains(Date));
          System.out.println("Visit Date selected is " +confirmationAppointmentPage.getVisitDateDetail());

          Assert.assertTrue(confirmationAppointmentPage.getCommentDetail().contains(Comment));
          System.out.println("Your Comment is " +confirmationAppointmentPage.getCommentDetail());

          //AppointmentMakePage appointmentMakePage = confirmationAppointmentPage.clickOnGoToHomepageBtn();


    }

    @DataProvider()
    public Object [][] Data(){
        Object[][] data =new Object[3][4];
        data [0][0]="Hongkong CURA Healthcare Center";data[0][1]= 1;data[0][2]="21/12/2022";data[0][3]="TESTING TESTING";
        data [1][0]="Tokyo CURA Healthcare Center";data[1][1]= 2;data[1][2]="12/12/2022";data[1][3]="TESTING TESTING 2";
        data [2][0]="Seoul CURA Healthcare Center";data[2][1]= 0;data[2][2]="20/12/202";data[2][3]="I PASS MY EXAM...";
        return data;

    }
}
