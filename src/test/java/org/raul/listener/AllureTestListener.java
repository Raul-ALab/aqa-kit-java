package org.raul.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.raul.utils.DriverSetUp2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {

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
        System.out.println("Skipped test method: " + getMethodName(result));
    }

    private static String getMethodName(ITestResult result) {
        return result.getMethod().getMethodName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenShot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot(((TakesScreenshot) DriverSetUp2.startDriver()).getScreenshotAs(OutputType.BYTES));
        System.out.println("Test failed [screenshot is taken] for method: " + getMethodName(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed with success percentage: " + getMethodName(result));
    }

    @Override
    public void onFinish(ITestContext iContext) {
        System.out.println("Completed test(s) in the " + iContext.getName().toUpperCase() + " project!");
    }
}
