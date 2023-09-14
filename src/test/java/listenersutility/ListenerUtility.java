package listenersutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import testbase.WebTestBase;

import java.io.IOException;

public class ListenerUtility extends WebTestBase implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxCount) {
            retryCount++;
            return true;
        }
        return false;
    }


}
