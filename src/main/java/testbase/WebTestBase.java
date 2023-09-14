package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utility.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {

    //define WebDriver-
    public static WebDriver driver;

    //define Properties-
    public static Properties prop;

    //create constructor-

    public WebTestBase()  {
        //create object of properties class-
        prop = new Properties();
        //define variable-
        FileInputStream fileInputStream;
        //to access config.properties file, create object of fileInputStream class-
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //load properties-
        try {
            prop.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //create method Initialization() to initialize all 3 browsers chrome, firefox, edge-
    public void Initialization() {
        //to fetch browser Name, use properties class object because we kept browser name in config.properties file
        String browserName = prop.getProperty("browser");

        //write pre-requisites/preconditions to open url in all three browsers - chrome, firefox, edge -
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.setBinary("C:/Users/Rahul/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
            //System.setProperty("webdriver.chrome.driver", "C:/Users/Rahul/Desktop/Edubridge/Selenium/chromedriver-win64/chromedriver-win64/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe" );
            driver = new ChromeDriver(chromeOptions);   //upcasting in java
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            edgeOptions.setBinary("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
            //System.setProperty("webdriver.edge.driver", "C:/Users/Rahul/Desktop/Edubridge/Selenium/edgedriver_win64/msedgedriver.exe");
            System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "/src/main/resources/drivers/msedgedriver.exe" );
            driver = new EdgeDriver(edgeOptions);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
            //System.setProperty("webdriver.gecko.driver", "C:/Users/Rahul/Desktop/Edubridge/Selenium/geckodriver-v0.33.0-win32/geckodriver.exe");
            System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe" );
            driver = new FirefoxDriver(firefoxOptions);

        } else {
            throw new RuntimeException("please select correct browser name");
        }
        //driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.navigate().to(prop.getProperty("url"));
        //maximize browser-
        driver.manage().window().maximize();
        //apply wait-
        //first define PAGE_LOAD AND IMPLICIT_WAIT in Utility.java class and then access it here-
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT));
        //delete cookies-
        driver.manage().deleteAllCookies();
    }




}



