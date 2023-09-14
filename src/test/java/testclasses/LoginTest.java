package testclasses;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

import java.io.IOException;

public class LoginTest extends WebTestBase  {



    //define HomePage-
    public HomePage homePage;
    //define LoginPage-
    public LoginPage loginPage;

    //define MyAccountPage-
    public MyAccountPage myAccountPage;


    //create constructor of this class-
    public LoginTest() throws IOException {
        super();
    }

        //for that create one beforeMethod()-
    @BeforeMethod
    public void beforeMethod() throws IOException {
        //call Initialization() method from WebTestBase.java class to open chrome browser
        Initialization();
        //create object of HomePage class-
        homePage = new HomePage();
        //create object of LoginPage class-
        loginPage = new LoginPage();
        //create object of MyAccountPage class-
        myAccountPage = new MyAccountPage();
    }

    //write test case to test - login with valid username and valid password
    @Test(description = "verify login with valid username and valid password" )
    public  void verifyLoginWithValidUserNameAndValidPassword() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        //from HomePage.java class - call below methods-
         homePage.clickOnGotItButton();
         homePage.clickOnLoginButton();

        //from LoginPage.java class - call clickOnLogin() method
        loginPage.clickOnLogin(prop.getProperty("email") , prop.getProperty("password"));
        //take email= snehalgadave1503@gmail.com and password = Snehyog@123 from config.properties file
        

        //apply assertion to verify text
        softAssert.assertEquals(myAccountPage.getTextAfterLogin() , "Snehal Sunil Gadave" , "Text should be match");
        softAssert.assertAll();
    }

    @Test(description = "sample test case to run only failed test cases")
    public void sampleFailedTestCase2() {
        //make this test case fail-
        Assert.assertFalse(true);
    }


    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

}
