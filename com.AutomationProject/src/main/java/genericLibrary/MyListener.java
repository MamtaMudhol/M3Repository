package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
//rightclick--> source ---> overridemethods--->
public class MyListener extends BaseTest implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("--test--"+result.getName()+" started", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("--test--"+result.getName()+" succeeded", true);;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String failedMethod = result.getName();
		String ltd = LocalDateTime.now().toString();
		String timeStamp = ltd.replaceAll(":","-" );
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc=new File("./errorshots/"+failedMethod+timeStamp+".png");
		try {
			FileHandler.copy(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("--test--"+result.getName()+" skipped", true);;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("--test--"+result.getName()+" faild within success percentage", true);;
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("--test--"+result.getName()+" failed with timeout", true);;
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("<test> "+context.getName()+" is started", true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("<test> "+context.getName()+" finished", true);;
	}
	

}
