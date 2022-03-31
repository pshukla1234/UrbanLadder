package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base
{
	/* Methods Declared Here:
	 * setUP()
	 * Initialize(String browser)
	 * closeBrowser()
	 * tearDown()
	 */

	//Static Variables Declared
	public static WebDriver driver;
	public static ExtentHtmlReporter exthtml;
	public static ExtentTest exttest;
	public static ExtentReports report;
	public static Properties prop;

	@BeforeSuite
	public void setUP() throws Exception, IOException
	{
		//Setting up Reports
		prop=new Properties();
		prop.load(new FileInputStream("src/main/java/config/Config.properties"));
		exthtml = new ExtentHtmlReporter(prop.getProperty("Reports"));

		//exthtml = new ExtentHtmlReporter("./Reports/Urbanladder.html");
		report = new ExtentReports();
		report.attachReporter(exthtml);
		report.setSystemInfo("Host Name", "TestSystem"); //name of thesystem
		report.setSystemInfo("Environment", "Test Env");
		report.setSystemInfo("User Name", "Urban Ladder User");

		exthtml.config().setDocumentTitle("URBAN LADDER");
		exthtml.config().setReportName("UrbanLadder Functional Testing");
		exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
		exthtml.config().setTheme(Theme.STANDARD);
	}

	@BeforeTest
	@Parameters({"browser"})
	public void Initialize(String browser)
	{
		//Initialize the browser

		//For Edge browser
		if(browser.matches("edge"))
		{
			//WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		//For chrome browser
		if(browser.matches("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
	}

/*	@Test
	public void closeBrowser()
	{
		//closing the current window
		driver.close();
	}*/

	@AfterTest
	public void tearDown() {

		//Flushing reports to html file
		driver.quit();
		report.flush();

		//closing all the windows
		//driver.quit(); 


	}
}