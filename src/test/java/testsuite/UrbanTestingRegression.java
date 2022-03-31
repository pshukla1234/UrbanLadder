package testsuite;

import org.testng.annotations.Test;

import pages.Home;
import pages.Result;

public class UrbanTestingRegression {

	public  Home ulHome;
	public  Result ulResult;

	@Test
	public void regressionTesting() throws Exception {

		ulHome=new Home();
		ulResult=new Result();
		//ulHome.setUP();
		ulHome.Initialize("browser");
		ulHome.openUrl();
		ulHome.productSearch();
		ulHome.Filters();

		ulResult.addToCart();
		ulResult.selectionCriteria();
		//ulResult.closeBrowser();
		//ulResult.tearDown();	
	}

}
