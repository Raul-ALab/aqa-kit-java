package org.raul.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.raul.utils.DriverSetUp2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(AllureTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Started test method: {}", getMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Successful test method: {}", getMethodName(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Skipped test method: {}", getMethodName(result));
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
        logger.error("Test failed [screenshot is taken] for method: {}", getMethodName(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test failed with success percentage: {}", getMethodName(result));
    }

    @Override
    public void onFinish(ITestContext iContext) {
        logger.info("Completed test(s) in the {} project!", iContext.getName().toUpperCase());
    }
}
