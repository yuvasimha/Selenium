package TestNGListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListeners implements ITestListener {

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("Test suit has Finished");
		
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Test Suite Started Execution"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getName()+" Test Suite Failed Execution"+((ITestContext) result).getFailedButWithinSuccessPercentageTests());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case is Failed to execute "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case is Skipped executed "+result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case is Starting execution "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case is sucessfully executed "+result.getName());
		
	}

}
