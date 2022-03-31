package testsuite;

import org.testng.annotations.Test;
import pages.Home;
import pages.Result;

public class UrbanTestingSmoke 
{
	public  Home ulHome;
	public  Result ulResult;

	@Test
	public void smokeTesting() throws Exception
	{
		ulHome=new Home();
		ulResult=new Result();
		//ulHome.setUP();
		ulHome.Initialize("browser");
		ulHome.openUrl();
		//ulHome.closeBrowser();
		//ulHome.tearDown();
	}
}
