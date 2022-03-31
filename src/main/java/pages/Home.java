package pages;

import java.net.HttpURLConnection; 
import java.net.URL;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import base.Base;
import objects.Elements;
import reusables.Interactions;

public class Home extends Base 
{
	/* Methods Declared Here:
	 * openUrl();
	 * productSearch();
	 * Filters();
	 */


	public void openUrl() throws Exception 
	{
		//Opening Url 

		URL url = new URL(Elements.urbanLadderSite);
		HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		httpURLConnect.setConnectTimeout(5000);
		httpURLConnect.connect();

		//Creating 1st Test
		exttest=report.createTest("Check_Home_Page");

		//Checking Response code and Reporting 1st Test
		if(httpURLConnect.getResponseCode()>200 && httpURLConnect.getResponseCode()<=299)
		{
			//System.out.println("URL not Working");
			exttest.log(Status.FAIL, "URL not Working");
			System.exit(0);
		}
		else 
		{
			//System.out.println("URL is Working");
			exttest.log(Status.PASS, "URL is Working");
		}

		//driver.get(Elements.urbanLadderSite);
		driver.get(prop.getProperty("url"));
		Interactions.testAssertFunction(Elements.assert1,driver.getTitle());

		//1st screenshot for proof
		Interactions.Screenshot("1.HomePage.jpg");

		//Reporting 2nd Test
		exttest=report.createTest("Check_If_User_On_Home_Page");
		if(Elements.assert1.contentEquals(driver.getTitle()))
		{
			exttest.log(Status.PASS, "User is on Home Page");
		}
		else
		{
			exttest.log(Status.FAIL, "User is not on Home Page");
		}
	}


	public void productSearch() throws Exception
	{
		//For Opening bookshelves Webpage
		new Actions(driver).moveToElement(driver.findElement(Elements.storage)).perform();

		
		Thread.sleep(2000);
		//2nd screenshot for proof
		Interactions.Screenshot("2.Storagemenu.jpg");

		// Perform the click operation that opens new window
		new Actions(driver).moveToElement(driver.findElement(Elements.bookshelves)).click().perform();


		//Interactions.testAssertFunction(Elements.assert1,driver.getTitle());




		/*	// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}*/
	}


	public void Filters() throws Exception
	{
		//Applying Filters

		driver.findElement(Elements.popUp).click();
		new Actions(driver).moveToElement(driver.findElement(Elements.priceFilter)).perform();
		driver.findElement(Elements.selectRange).click();
		Thread.sleep(2000);
		new Actions(driver).moveToElement(driver.findElement(Elements.storageFilter)).perform();
		driver.findElement(Elements.storageType).click();
		Thread.sleep(2000);

		//3rd screenshot for proof
		Interactions.Screenshot("3.AppliedFilters.jpg");

		Interactions.testAssertFunction(Elements.assert2,driver.getTitle());

		//Reporting 3rd Test
		exttest=report.createTest("Check_If_User_On_Products_Page");
		if((Elements.assert2).equals(driver.getTitle()))
		{
			exttest.log(Status.PASS, "User is on Products Page");
		}
		else
		{
			exttest.log(Status.FAIL, "User is not on Products Page");
		}
	}
}
