package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class CreateAnAccountPage {

   // private Object phone;

   // new void HomePage().registrationLink.click();
    public CreateAnAccountPage(){PageFactory.initElements(Driver.getDriver(), this);}

  // add findby Register link


    @FindBy (xpath = "//a[@href='/myaccount.html?goto=register']")
    public WebElement registerLink;
    @FindBy (name="Email")
    public WebElement email;

    @FindBy (name="BillingAddressName")
    public WebElement addressName;

    @FindBy (name="BillingAddressCompany")
    public WebElement companyName;

    @FindBy (name="billcompany_type")
    public WebElement companyTypeDropdown;

    @FindBy (name="BillingAddress")
    public WebElement address1;

    @FindBy (name="BillingAddressTwo")
    public WebElement address2;

    @FindBy (name="BillingAddressZipCode")
    public WebElement zipCode;

    @FindBy (name="billphone")
    public WebElement phoneNumber;

    @FindBy (name="CheckSameAsBilling")
    public WebElement shippingAddress;

    @FindBy (name="Password")
    public WebElement password;

    @FindBy (id="complete_registration")
    public WebElement createAccount;

    @FindBy (xpath="//div/p[@class=\"error_message alert\"]")
    public WebElement errorMessage;

    @FindBy (xpath = "//*[@class='page-header']")
    public WebElement dashBoard;



    public void enterRandomData() {
        Faker fake = new Faker();
       // String fullName= fake.name().fullName();
       // String company= fake.company().name();

        email.sendKeys(fake.internet().emailAddress());
        addressName.sendKeys(fake.name().fullName());
        companyName.sendKeys(fake.company().name());
        address1.sendKeys(fake.address().streetAddress());
        address2.sendKeys(fake.address().city()+fake.address().state());
        phoneNumber.sendKeys(fake.phoneNumber().cellPhone());
        zipCode.sendKeys("60185");
        password.sendKeys(fake.internet().password());}

      public void enterData(String email1, String name, String company, String address, String city, String state, String zip1, String phone, String passwordFake){

        email.sendKeys(email1);
        addressName.sendKeys(name);
        companyName.sendKeys(company);
        address1.sendKeys(address);
        address2.sendKeys(city);
        address2.sendKeys(state);
        zipCode.sendKeys(zip1);
        phoneNumber.sendKeys(phone);
        password.sendKeys(passwordFake);


}

    public void enterSomeRandomdata() {
        Faker fake = new Faker();

        email.sendKeys(fake.internet().emailAddress());
        addressName.sendKeys(fake.name().fullName());
        companyName.sendKeys(fake.company().name());
        address1.sendKeys("1685 Milwaukee Ave");
        address2.sendKeys("Glenview, IL");
        phoneNumber.sendKeys(fake.phoneNumber().cellPhone());
        zipCode.sendKeys("60025");
        password.sendKeys(fake.internet().password());
    }

    public void enterEmptyData() {
        Faker fake = new Faker();

        email.sendKeys("");
        addressName.sendKeys("");
        companyName.sendKeys("");
        address1.sendKeys("");
        address2.sendKeys("");
        phoneNumber.sendKeys("");
        zipCode.sendKeys("");
        password.sendKeys("");
    }


    public void chooseACompany(String companyType) { new Select(companyTypeDropdown).selectByVisibleText(companyType);
    }


}



