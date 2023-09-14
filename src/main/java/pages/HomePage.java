package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.ScreenshotUtility;
import utility.Utility;

import java.io.IOException;
import java.util.List;

public class HomePage extends  WebTestBase{


    //find web element - accept cookies - click on  got it button
    @FindBy(xpath = "//span[text() = 'Got it']")
    //define web element- register/login logo
    WebElement gotItButton;
    //---------------------------------------------//
    //find web element - Login Button - click on Login button
    @FindBy(id = "login_Layer")
    WebElement loginInButton;
    //---------------------------------------------//
    //find web element - facebook logo
    @FindBy(xpath = "//a[@href='https://www.facebook.com/Naukri']")
    WebElement facebookLogo;
    //--------------------------------------------//
    //find element- enter skills textbox
    @FindBy(xpath = "//input[@placeholder = 'Enter skills / designations / companies']")
    WebElement enterSkillsTextbox;

    //find web element - Dropdown
    @FindBy(xpath = "//span[@class = 'dropArrowDD' ]")
    WebElement dropDown;

    //find web element - list of dropdown
    // List<WebElement> webElements = driver.findElements(By.xpath("//li[@class = '  active']//child::div/span"));
    @FindBy(xpath = "//div[@class = 'dropDownPrimaryContainer dropdownShow ']//li//span")
    List<WebElement> dropDownOptions;

    //find web element - Search button
    @FindBy(xpath = "//div[text() = 'Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class = 'inside']//span")
    WebElement assertionElementDrodown;
    //--------------------------------------------//
    @FindBy(xpath = "//div[text() = 'Jobs']")
    WebElement mouseOverElement;

    @FindBy(xpath = "//a[text() = 'Popular categories']")
    WebElement assertionElementMouseOver;

    //--------------------------------------------//
    @FindBy(xpath = "//i[@class = 'ni-icon-unchecked']")
    WebElement checkBox;

    //--------------------------------------------//
    @FindBy(xpath = "//a[text()='Connect with us']")
    WebElement scrollDownElement;

    //-------------------------------------------//


    //initialize web element using initElements() method
    //create constructor of this class for initialization-
    public HomePage() throws IOException {
        PageFactory.initElements( driver , this);
    }

    //-----------------------------------------------//
    //create method to click on web element - Got it button
    public void clickOnGotItButton() {
        Utility.waitUntilElementToBeClickable(gotItButton);
    }

    //create method to click on web element - Login button
    public void clickOnLoginButton() {
        Utility.waitUntilElementToBeClickable(loginInButton);
    }

    //create method to apply assertion on login using get url after login successfully
    public String getUrlAfterLogin() {
        String url = Utility.getUrl();
        return url;
    }

    //-------------------------------------------------//

    //create method to click on web element - facebook Logo
    public void clickOnFacebookLogo() throws InterruptedException {
        Utility.waitUntilElementToBeClickable(facebookLogo);
        Utility.switchWindow();
    }
    //-------------------------------------------------//

    //create method to click on enter Skills textbox and enter skills = java from properties file
    public void clickOnEnterSkillsTextbox() {
        Utility.waitUntilElementToBeClickable(enterSkillsTextbox);
        enterSkillsTextbox.sendKeys(prop.getProperty("Skills"));
    }


    //create method to click on web element - dropdown
    public void clickOnDropdown() {
        Utility.waitUntilElementToBeClickable(dropDown);

    }

    //create method to get elements from dropdown
    public void getItemsfromDropDown() {
        Utility.dropDownUtility(dropDownOptions, prop.getProperty("selectOption"));

    }

    //create method to click on search button
    public void clickOnSearchButton() {
        Utility.waitUntilElementToBeClickable(searchButton);
    }

    //create method to apply assertion on dropdown
    public String verifyDropDownAssertion() {
        return Utility.getTextOfElement(assertionElementDrodown);

    }

    //----------------------------------------------//
    //create method to mouseover on Jobs
    public void mouseOverAction() {
        //create object of Actions class-
        Actions actions = new Actions(driver);
        //move to element Jobs -
        actions.moveToElement(mouseOverElement).perform();
    }

    //create method to apply assertion on mouseover functionality
    public String verifyMouseOverAssertion() {
        return Utility.getTextOfElement(assertionElementMouseOver);

    }

    //----------------------------------------------------------//
    //create method to click on checkBox
    public void clickOnCheckBox() {
       Utility.waitUntilElementToBeClickable(checkBox);
    }

    //create method to apply assertion on checkbox - verify checkBox is selected or not
    public boolean verifyCheckBoxUsingIsDisplayedMethod() {
        return  Utility.verifyCheckBoxIsDisplayed(checkBox);
    }

    public boolean verifyCheckBoxUsingIsSelectedMethod() {
        return  Utility.verifyCheckBoxIsSelected(checkBox);
    }

    //-----------------------------------------//

    //create method to call takeScreenshotUtility() method -
    public void screenShotMethod(String filename) {
        ScreenshotUtility.takeScreenshotUtility(filename);
    }

    //-----------------------------------------//

    // create method to call javaScriptExecutorScrollDownUtility() method-
    public void  scrollDownMethod()  {
        Utility.javaScriptExecutorScrollDownUtility(scrollDownElement);
    }

    // create method to call javaScriptExecutorScrollUpUtility() method-

    public void scrollUpMethod() {
        Utility.javaScriptExecutorScrollUpUtility();
    }

    //-----------------------------------------//





}
