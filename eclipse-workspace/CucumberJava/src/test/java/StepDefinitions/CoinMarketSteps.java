package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.excel.lib.util1.Xls_Reader;
import Support.ActionClose;
import Support.ListElement;
import Support.WindowHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.Additional_Filter;
import pagefactory.CoinMarket_PF;

//@SuppressWarnings("deprecation")
public class CoinMarketSteps {

	// private static final String NetworkMode = null;
	WebDriver driver = null;
	CoinMarket_PF coinmarket = new CoinMarket_PF(driver);
	Additional_Filter addFilter  = new Additional_Filter(driver);

	@Before
	public void launchBrowser() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}

	@After
	public void tearDown() {

		driver.close();
		//driver.quit();

	}

	@Given("navigate to the coinbase application")
	public void navigate_to_the_coinbase_application() {

		driver.navigate().to("https://coinmarketcap.com/");
		
	//	String Expected_Title 	=  "Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap";
	//	String Actual_Title = driver.getTitle();
	//	Assert.assertEquals(Expected_Title, Actual_Title);

	}

	@And("close all the start pop up event listener")
	public void close_all_the_start_pop_up_event_listener() throws InterruptedException {

		ActionClose a = new ActionClose(driver);
		a.ActionClick();
		
		//Thread.sleep(5000, 24);
	}

	@When("filter show column to display specified rows")
	public void filter_show_column_to_display_specified_rows() throws InterruptedException {
		coinmarket = new CoinMarket_PF(driver);
		coinmarket.showRow();
		coinmarket.selectRow();
		Thread.sleep(5000, 24);

	}


	@Then("Capture all the content of the page for price name position attributes")
	public void capture_all_the_content_of_the_page_for_price_name_position() throws InterruptedException, IOException {
		
		ListElement xcel = new ListElement(driver);
		xcel.Content_xcel();
	
		
	}

	


	@And("Filter by Algorithm for PoW")
	public void filter_by_algorithm_for_po_w() throws InterruptedException {

		coinmarket.filterPow();
		//Thread.sleep(2000, 24);

		//softassert2.assertEquals (true, filter.isDisplayed());
		//softassert2.assertAll();
		Thread.sleep(5000,20);
		coinmarket.clickAlgo();
		Thread.sleep(5000,20);
		coinmarket.searchPow();
		Thread.sleep(5000, 20);
		coinmarket.selectPow();

	}

	@Then("Add more filters")
	public void add_more_filters() {
		
		addFilter  = new Additional_Filter(driver);
		
		addFilter.addFilter();
	}

	@And("toggle the mineable")
	public void toggle_the_mineable() throws InterruptedException {
		
		//addFilter = new Additional_Filter(driver);
		WindowHandler wh = new WindowHandler(driver);
		wh.windowhandler();
		addFilter.mineToggle();
		Thread.sleep(5000,20);
//		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[6]/div/div/div[2]/div[1]/div[2]/div[2]/button")).click();
//		Thread.sleep(5000,20);
	}

	@Then("on the popup content select All Cryptocurrencies")
	public void on_the_popup_content_select_all_cryptocurrencies() throws InterruptedException {
		WindowHandler wh = new WindowHandler(driver);
		wh.windowhandler();
		addFilter.popupContent();
		Thread.sleep(5000,20);
		addFilter.coinButton();
		Thread.sleep(5000,20);
	}

	@And("select price")
	public void select_coins() throws InterruptedException {
		WindowHandler wh = new WindowHandler(driver);
		wh.windowhandler();
		addFilter.price_Button();
		Thread.sleep(5000,20);
	}

	@And("select price set min and max value")
	public void select_price_set_min_and_max_value() throws InterruptedException {
		WindowHandler wh = new WindowHandler(driver);
		wh.windowhandler();
		addFilter.minValue();
		addFilter.maxValue();
		Thread.sleep(5000,20);
	}

	@Then("apply the filter")
	public void apply_the_filter() throws InterruptedException {
		WindowHandler wh = new WindowHandler(driver);
		wh.windowhandler();
		addFilter.applyFilter();
		addFilter.showResults();
		Thread.sleep(5000,20);
	}

	@And("capture all the content of the page")
	public void capture_all_the_content_of_the_page() {
		
		ListElement xcel = new ListElement(driver);
		xcel.Content_xcel_After();
	}


	@Then("compare the page content with the previous page content")
	public void compare_the_page_content_with_the_previous_page_content() throws IOException {
		
		// ExtentReports extent = new ExtentReports("target/extreport.html", true, NetworkMode.OFFLINE);
		// ExtentTest test = extent.startTest(Difference Report", "Below is the log of difference found");
		
		FileInputStream	fileinputStream1 = new FileInputStream("./src/main/java/com/excel/lib/util1/test006.xls");
		HSSFWorkbook workbook1 = new HSSFWorkbook(fileinputStream1);
		
		HSSFSheet worksheet1 = workbook1.getSheet("TableData6");
		
		int rowCount1 = worksheet1.getPhysicalNumberOfRows();
		
		FileInputStream	fileinputStream2 = new FileInputStream("./src/main/java/com/excel/lib/util1/test006.xls");
		HSSFWorkbook workbook2 = new HSSFWorkbook(fileinputStream1);
		
		HSSFSheet worksheet2 = workbook2.getSheet("TableData6");
		
		int rowCount2 = worksheet2.getPhysicalNumberOfRows();
		
		if(rowCount1 != rowCount2) {
			
			//test.log(LogStatus.ERROR, "Row count1=" + rowCount1 + "Row count2=" +rowCount2);
			
			System.out.println("RowCount 1 = " + rowCount1 + "+RowCount2" + rowCount2 );
	}
		else {
			for(int i =1; i< rowCount1; i++) {
				HSSFRow row1 = worksheet1.getRow(i);
				HSSFRow row2 = worksheet2.getRow(i);
				
				// Comparing name
				
				String namestr1 = "";
				HSSFCell name1 = row1.getCell(1);
				if (name1 != null) {
					name1.setCellType(CellType.STRING);
					namestr1 = name1.getStringCellValue();
					
				}
				
				String namestr2 = "";
				HSSFCell name2 = row1.getCell(1);
				if (name2 != null) {
					name2.setCellType(CellType.STRING);
					namestr2 = name2.getStringCellValue();
					
				}
				
				if(!namestr1.equals(namestr2)) {
					
					System.out.println("ERROR : " + namestr1 + namestr2);
					//test.log(Logstatus.ERROR, + namestr1 + namestr2);
					}
				
				// end of name row/column
				
				//comparing Price
				
				
				String pricestr1 = "";
				HSSFCell price1 = row2.getCell(2);
				if (price1 != null) {
					price1.setCellType(CellType.STRING);
					pricestr1 = price1.getStringCellValue();
					
				}
				
				String pricestr2 = "";
				HSSFCell price2 = row2.getCell(2);
				if (price2 != null) {
					price2.setCellType(CellType.STRING);
					pricestr2 = price2.getStringCellValue();
					
				}
				
				if(!pricestr1.equals(pricestr2)) {
					
					System.out.println("ERROR : " + pricestr1 + pricestr2);
					//test.log(Logstatus.ERROR, + pricestr1 + pricestr2);
					}
				
				
				
				
				
			}
		}

}
}

