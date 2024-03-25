package org.raul.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.raul.utils.DriverSetUp;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {
    private static String getMethodName(ITestResult result) {
        return result.getMethod().getMethodName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenShot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Started test method: " + getMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Successful test method: " + getMethodName(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped trest method: " + getMethodName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot(((TakesScreenshot) DriverSetUp.setUpChromeDriver()).getScreenshotAs(OutputType.BYTES));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed with success percentage: " + getMethodName(result));
    }

    @Override
    public void onFinish(ITestContext iContext) {
        System.out.println("Completed method: " + iContext.getName());
    }
}
