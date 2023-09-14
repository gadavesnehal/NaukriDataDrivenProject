package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utility.Utility;

import java.io.IOException;

public class MyAccountPage extends WebTestBase {
    //after login successfully , you will redirect to MyAccount page
    //verify text - Snehal Sunil Gadave
    //find web element - Snehal Sunil Gadave
    @FindBy(xpath = "//div[text()='Snehal Sunil Gadave']")
    WebElement assertionTextElement;

    //initialize web element using initElements() method
    //create constructor of this class for initialization-
    public MyAccountPage() throws IOException {
        PageFactory.initElements(driver , this);
    }

    // create method to get text - i.e get text - Snehal Sunil Gadave
    public String getTextAfterLogin() {
        return Utility.waitUntilElementToGetText(assertionTextElement);

    }


}
