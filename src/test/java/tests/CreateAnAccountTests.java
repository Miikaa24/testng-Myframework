package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;

import utilities.CSVreader;
import utilities.SeleniumUtils;

import java.util.Random;

public class CreateAnAccountTests extends TestBase{


    @Test //1
            public void createAnAccountRandomData(){

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

        SeleniumUtils.jsClick(createAnAccountPage.registerLink);  //Managing the correct UI

        createAnAccountPage.enterRandomData();

        createAnAccountPage.chooseACompany("Bakery");

        Assert.assertTrue(createAnAccountPage.shippingAddress.isSelected());

        createAnAccountPage.createAccount.click();

        Assert.assertTrue(createAnAccountPage.errorMessage.isDisplayed());

    }
    @Test (dataProvider = "Users") //2
    public void createAnAccountCSVFile(String email1, String name, String company, String address, String city, String state, String zip1, String phone, String passwordFake) {

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

        SeleniumUtils.jsClick(createAnAccountPage.registerLink);  //Managing the correct UI

        createAnAccountPage.enterData(email1, name, company, address, city, state,  zip1, phone, passwordFake);

        createAnAccountPage.chooseACompany("Bakery");

        Assert.assertTrue(createAnAccountPage.shippingAddress.isSelected());

        createAnAccountPage.createAccount.click();

        Assert.assertTrue(createAnAccountPage.errorMessage.isDisplayed());
    }

   @DataProvider (name = "Users")
   public Object[][] getData(){

       return CSVreader.readFromCSV("src/test/resources/TestDataForMyFramework.csv");
   }

   @Test //3
   public void createAnAccountCorrectAddress(){

       CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

       SeleniumUtils.jsClick(createAnAccountPage.registerLink);  //Managing the correct UI

       createAnAccountPage.enterSomeRandomdata();

       createAnAccountPage.chooseACompany("Bakery");

       Assert.assertTrue(createAnAccountPage.shippingAddress.isSelected());

       createAnAccountPage.createAccount.click();

       Assert.assertTrue(createAnAccountPage.dashBoard.isDisplayed());

   }

    @Test //4
    public void createAnAccountEmptyData(){

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

        SeleniumUtils.jsClick(createAnAccountPage.registerLink);  //Managing the correct UI

        createAnAccountPage.enterEmptyData();

        createAnAccountPage.chooseACompany("Bakery");

        Assert.assertTrue(createAnAccountPage.shippingAddress.isSelected());

        createAnAccountPage.createAccount.click();

        Assert.assertTrue(createAnAccountPage.errorMessage.isDisplayed());

    }
}