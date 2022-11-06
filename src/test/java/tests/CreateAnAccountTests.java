package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.HomePage;
import utilities.CSVreader;

import java.util.Random;

public class CreateAnAccountTests extends TestBase{


    @Test (dataProvider = "registration")
    public void registeringFromCSVfile(String email1, String name, String company, String address, String addressRest, String zipcode, String phone, String passwordFake) throws InterruptedException {

        new HomePage().registrationLink.click();

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

        createAnAccountPage.companyTypeDropdown("Bakery");

        createAnAccountPage.enterData(email1, name, company, address, addressRest, zipcode, phone, passwordFake);

        Assert.assertTrue(createAnAccountPage.shippingAddress.isSelected());

        createAnAccountPage.createAccount.click();


    }


//    @DataProvider (name = "registration")
//    public Object[][] getData(){return CSVreader.readFromCSV()
//    }

}