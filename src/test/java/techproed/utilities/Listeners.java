package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println(" onStart - Tum testlerden once tek bir kere cagrilir"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(" onFinish - Tum testlerden sonra tek bir kere cagrilir "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(" onTestStart - Herbir @Test den once tek bir kez cagrilir "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(" onTestSuccess - Sadece PASS olan testlerden SONRA tek bir kez cagrilir " +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(" onTestFailure - Sadece fail olan testlerden hemen sonra birkez cagrilir " +result.getName());
        try {
            ReusableMethods.getScreenshot("Test-Case-FAIL-" +result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(" onTestSkipped - Sadece SKIP testlerden sonra birkez cagrilir" +result.getName());
    }

}
