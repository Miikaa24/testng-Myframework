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



//    @Test (dataProvider = "registration")
//    public void registeringFromCSVfile(String email1, String name, String company, String address, String addressRest, String zipcode, String phone, String passwordFake) throws InterruptedException {



    //driver.findElement(By.xpath("//a[text()='Order']")).click();
    @Test
            public void createAnAccountRandomData(){

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

        SeleniumUtils.jsClick(createAnAccountPage.registerLink);  //Managing the correct UI

        createAnAccountPage.enterRandomData();

        createAnAccountPage.chooseACompany("Bakery");

        Assert.assertTrue(createAnAccountPage.shippingAddress.isSelected());

        createAnAccountPage.createAccount.click();

        Assert.assertTrue(createAnAccountPage.errorMessage.isDisplayed());

    }
    @Test (dataProvider = "Users")
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

   @Test
   public void createAnAccountCorrectAddress(){

       CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();

       SeleniumUtils.jsClick(createAnAccountPage.registerLink);  //Managing the correct UI

       createAnAccountPage.email.sendKeys();

       createAnAccountPage.addressName.sendKeys();

       createAnAccountPage.companyName.sendKeys();

       createAnAccountPage.chooseACompany("Bakery");

       createAnAccountPage.address1.sendKeys("1685 Milwaukee Ave");


       Assert.assertTrue(createAnAccountPage.shippingAddress.isSelected());

       createAnAccountPage.createAccount.click();

       Assert.assertTrue(createAnAccountPage.errorMessage.isDisplayed());

   }
}