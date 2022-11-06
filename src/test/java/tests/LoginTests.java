package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    WebDriver driver;

 @BeforeMethod(alwaysRun = true)
    public void setupMethod(){
     driver= new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     driver.get("https://www.webstaurantstore.com/");

 }
 @AfterMethod(alwaysRun = true)
    public void tearDownMethod(){driver.quit();}

    //@Test


}
