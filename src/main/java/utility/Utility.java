package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.WebTestBase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Utility extends WebTestBase {
    //whatever re-useable things are there, write it in Utility.java class

    //define implicit wait-
    public  static  final  long IMPLICIT_WAIT = 20;

    //define PAGE_LOAD-
    public  static  final  long PAGE_LOAD = 20;

    public static final long EXPLICIT_WAIT = 20;


    public Utility() throws IOException {
    }

    public static WebDriverWait wait;

    //--------------------------------------------//
    public static void waitUntilElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }
    //--------------------------------------------//
    public static String getTextOfElement(WebElement element) {
        return  element.getText();
    }

    //------------------------------------------//
    public static String getUrl() {
        return driver.getCurrentUrl();
    }
    //------------------------------------------//

    public static boolean verifyCheckBoxIsSelected(WebElement element) {
        return  element.isSelected();
    }

    public static boolean verifyCheckBoxIsDisplayed(WebElement element) {
        return  element.isDisplayed();
    }

    //--------------------------------------------//

    public static void switchWindow() throws InterruptedException {

        //fetch parent window id- getWindowHandle() method- this method return current window id
       String parentWindowId = driver.getWindowHandle();
       System.out.println(parentWindowId);

        //fetch child window id- getWindowHandles() method - this method return id's of all child windows as well as id of parent window
        Set<String> allWindowId = driver.getWindowHandles();


        //how to iterate all child windows one by one- use for each loop
        for (String s : allWindowId) {
            if (!parentWindowId.contentEquals(s)){
                driver.switchTo().window(s); //switch to child window
                Thread.sleep(3000);
                driver.close(); //close child window
            }
            driver.switchTo().window(parentWindowId); //it will go back to parent window

        }

    }

    //------------------------------------------------------//

  public static void dropDownUtility(List<WebElement> elements , String options) {
      for (WebElement e : elements) {
          //write method to ignore space between text of option if any
          if (e.getText().trim().equalsIgnoreCase(options)) {
              e.click();
              break;
          }
      }

  }

    public static String waitUntilElementToGetText(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
       return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();


    }


    public static void javaScriptExecutorScrollDownUtility(WebElement element) {
        //define JavaScriptExecutor-
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;  //downcasting

        //Scroll down webpage by visibility text-
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", element);

    }

    public static void javaScriptExecutorScrollUpUtility() {
        //define JavaScriptExecutor-
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;  //downcasting

        //Scroll down webpage by visibility text-
       javascriptExecutor.executeScript("window.scrollBy(0, -5000)");


    }









}



