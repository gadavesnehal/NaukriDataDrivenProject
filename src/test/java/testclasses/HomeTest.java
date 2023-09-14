package testclasses;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import testbase.WebTestBase;
import utility.ScreenshotUtility;
import utility.Utility;

import java.io.IOException;

public class HomeTest extends WebTestBase  {


    SoftAssert softAssert;

    //define HomePage-
    public HomePage homePage;
    //define LoginPage-
    public LoginPage loginPage;
    public Utility utility;

    //create constructor of this class-
    public HomeTest() {
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
    }

    //write test case to test - Window handling functionality
    @Test( priority = 1 , description = "verify window handling functionality")
    public void verifyWindowHandlingFunctionality() throws InterruptedException {
        softAssert = new SoftAssert();
        //from HomePage.java class - call below methods-
        homePage.clickOnGotItButton();
        homePage.clickOnFacebookLogo();

        // Use an assertion to verify parent window url-
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.naukri.com/", "url should be same");
        softAssert.assertAll();

    }

    @Test(priority = 2 , description = "verify dropdown functionality")
    public void verifyDropDownFunctionality() throws InterruptedException {
        softAssert = new SoftAssert();

        homePage.clickOnEnterSkillsTextbox();
        homePage.clickOnDropdown();
        homePage.getItemsfromDropDown();
        homePage.clickOnSearchButton();

        //apply asserion to verify text
        softAssert.assertEquals(homePage.verifyDropDownAssertion(), "1", "text should be match");
        softAssert.assertAll();

        //call method to take screenshot-
        homePage.screenShotMethod("DropDown_experience1year");
    }


    @Test(priority = 3 , description = "verify mouseover functionality")
    public void verifyMouseOverFunctionality() {
        softAssert = new SoftAssert();
        //from HomePage.java class - call mouseOverAction() method
        homePage.mouseOverAction();

        //apply asserion to verify text
        softAssert.assertEquals(homePage.verifyMouseOverAssertion(), "Popular categories", "text should be match");
        softAssert.assertAll();

        //call method to take screenshot-
        homePage.screenShotMethod("MouseOver");
    }


    @Test(priority = 4 , description = "verify checkbox functionality")
    public void verifyCheckBoxFunctionality() throws InterruptedException {
        softAssert = new SoftAssert();
        //call below method from HomePage.java class-
        homePage.clickOnEnterSkillsTextbox();
        homePage.clickOnDropdown();
        homePage.getItemsfromDropDown();
        homePage.clickOnSearchButton();
        homePage.clickOnCheckBox();

        //apply assertion to check checkBox is selected-
      softAssert.assertTrue(homePage.verifyCheckBoxUsingIsDisplayedMethod() , "checkBox should be selected");
      softAssert.assertAll();
    }


    @Test(priority = 5 , description = "verify scroll down and scroll up functionality")
    public void verifyScrollDownScrollUpFunctionality() {
       //call below methods from HomePage.java class-
        homePage.scrollDownMethod();
        homePage.scrollUpMethod();
    }

    @Test(priority = 6 , description = "sample test case to run only failed test cases")
    public void sampleFailedTestCase() {
        //make this test case fail-
        Assert.assertFalse(true);
    }



    @AfterMethod
    public void afterMethod() {
        driver.close();
    }


}
