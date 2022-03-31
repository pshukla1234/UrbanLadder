package pages;

import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import base.Base;
import objects.Elements;
import reusables.Interactions;

public class Result extends Base 
{
	/* Methods:
	 * addToCart();
	 * selectionCriteria();
	 */


	public void addToCart() throws Exception
	{
		//Adding the items to cart
		List<WebElement> items=driver.findElements(Elements.itemsList);
		Elements.numberOfItems=items.size();
		List<WebElement> itemsprices=driver.findElements(Elements.itemspricesList);

		//Reporting 4th Test
		exttest=report.createTest("Product_names_And_Prices");
		for(int i=0;i<items.size();i++)
		{
			items.get(i).click();
			//String str=itemsprices.get(i).getText();
			exttest.log(Status.INFO, items.get(i).getText() + ": " + itemsprices.get(i).getText());

			ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
			//driver.switchTo().window(windows.get(2));
			driver.switchTo().window(windows.get(1));
			//opening,adding to cart and closing the item page
			WebElement addcart=driver.findElement(Elements.addTocart);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",addcart);
			driver.close();
			//driver.switchTo().window(windows.get(1));
			driver.switchTo().window(windows.get(0));
		}
	}


	public void selectionCriteria() throws Exception
	{
		//Evaluating the number of items added
		driver.navigate().refresh();


		String countincart=driver.findElement(Elements.countofitem).getText();
		Interactions.testAssertFunction(Elements.assert2,driver.getTitle());



		//Reporting 5th Test
		exttest=report.createTest("Check_if_Cart_Matches_Items_Added");
		if(countincart.matches(String.valueOf(Elements.numberOfItems)))
		{
			//System.out.println("The number of items added and in cart is same");
			exttest.log(Status.PASS, "The number of items added and in cart is same:Success::"+countincart+" items Found");
		}
		else
		{
			//System.out.println("The number of items in the cart is not same");
			exttest.log(Status.FAIL, "The number of items added and in cart is not:Failure");
		}

		//4th screenshot for proof
		Interactions.Screenshot("4.ItemsInCart.jpg");
	}
}
