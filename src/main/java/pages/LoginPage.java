package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.Utility;

import java.io.IOException;

public class LoginPage extends WebTestBase {

    //find web element - Email id textbox
    @FindBy(xpath = "//input[@placeholder = 'Enter your active Email ID / Username']")
    WebElement emailIdTextBox;

    //find web element - Password textbox
    @FindBy(xpath = "//input[@placeholder = 'Enter your password']")
    WebElement passwordTextBox;

    //find Web element - Login button - click on Login button after entering email id and password
    @FindBy(xpath = "//button[text()= 'Login']")
    WebElement loginBtn;

  //---------------------------------------------------//

    //initialize web element using initElements() method
    //create constructor of this class for initialization-
    public LoginPage() throws IOException {
        PageFactory.initElements(driver , this);
    }

    //create method to click on web element - Login button after entering email id and password
    public void clickOnLogin( String email , String password) {
        //enter email id -
        emailIdTextBox.sendKeys(email);
        //enter password-
        passwordTextBox.sendKeys(password);
        //click on login button-
        loginBtn.click();
    }


}
