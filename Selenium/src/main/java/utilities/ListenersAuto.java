package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public  class ListenersAuto extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution){
        System.out.println("------------------Starting Execution------------------");
    }

    public void onFinish(ITestContext execution){
        System.out.println("------------------Execution Ended------------------");
    }

    public void onTestStart(ITestResult test){
        System.out.println("------------------Starting Test: "+test.getName()+"------------------");
    }

    public void onTestSuccess(ITestResult test){
        System.out.println("------------------Test: "+test.getName()+" Passed------------------");
    }

    public void onTestFailure(ITestResult test){
        System.out.println("------------------Test: "+test.getName()+" Failed------------------");
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult test){
        System.out.println("------------------Skipping Test: "+test.getName()+"------------------");
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
