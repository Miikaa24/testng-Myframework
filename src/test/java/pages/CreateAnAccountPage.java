package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class CreateAnAccountPage {

    private Object phone;

    public CreateAnAccountPage(){PageFactory.initElements(Driver.getDriver(), this);}

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

    //ReceiveCoupons name

    public void enterRandomData() {
        Faker fake = new Faker();
        String fullName= fake.name().fullName();
        String company= fake.company().name();

        email.sendKeys(fullName+"gmail.com");
        addressName.sendKeys(fullName);
        companyName.sendKeys(company);
        address1.sendKeys(fake.address().streetAddress());
        address2.sendKeys(fake.address().city()+fake.address().state());
        phoneNumber.sendKeys(fake.phoneNumber().cellPhone());
        zipCode.sendKeys(fake.address().zipCode());
        password.sendKeys(companyName+"2022!");}

        public void enterData(String email1, String name, String company, String address, String addressRest, String zipcode, String phone, String passwordFake){

        email.sendKeys(email1);
        addressName.sendKeys(name);
        companyName.sendKeys(company);
        address1.sendKeys(address);
        address2.sendKeys(addressRest);
        zipCode.sendKeys(zipcode);
        phoneNumber.sendKeys(phone);
        password.sendKeys(passwordFake);


}

    public void companyTypeDropdown(String companyType) { new Select(companyTypeDropdown).selectByVisibleText(companyType);
    }
}



