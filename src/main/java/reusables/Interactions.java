package reusables;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import base.Base;

public class Interactions extends Base {


	public static void Screenshot(String imageName) throws Exception 
	{
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Users\\pshukla\\OneDrive - Planit Test Management Solutions Pty Ltd\\Desktop\\screenshots\\"+imageName));
	}


	public static void testAssertFunction(String ExpectedTitle,String ActualTitle )
	{
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	} 

}
