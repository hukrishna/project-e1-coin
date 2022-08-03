package Support;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.excel.lib.util1.Xls_Reader;

public class ListElement {
	
	WebDriver driver = null;
	public void Content_xcel() {
		
		String beforeXpath_price = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr[";
		String afterXpath_price = "]/td[4]";
		
		
		String beforeXpath_name = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr[";
		String afterXpath_name = "]/td[3]";

		
//		List<WebElement> colList = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/thead/tr/th"));
//		System.out.println("header size:" + colList.size());
//
//		int columnIndex = 2;

        Xls_Reader reader = new Xls_Reader("/home/humakri1/eclipse-workspace/CucumberJava/src/main/java/com/excel/lib/util1/test006.xls");
        reader.addSheet("TableData5");
        reader.addColumn("TableData5", "Price");
        reader.addColumn("TableData5", "Name");


//		for(int i=0; i<colList.size(); i++){
//			System.out.println("Get the text:" +colList.get(i).getText());
//			if("Name".equals(colList.get(i).getText())){
//				columnIndex = i ;
//				break;
//			}
//		}

//        System.out.println("column Index : " + columnIndex);
        
        List<WebElement> numberOfRows = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr"));
        System.out.println("number of rows : " + numberOfRows.size());

            
        for(int i=2; i<=numberOfRows.size(); i++) {
        	
        	String actualXpath_price = beforeXpath_price+i+afterXpath_price;
        	String value = driver.findElement(By.xpath(actualXpath_price)).getText();
        	//String value = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr["+i+"]/td["+columnIndex+"]")).getText();
        	System.out.println(value);
//        	  Xls_Reader reader = new Xls_Reader("/home/humakri1/eclipse-workspace/CucumberJava/src/main/java/com/excel/lib/util1/test004.xls");
//              reader.addSheet("TableData");
//              reader.addColumn("TableData", "Price");
        	
            reader.setCellData("TableData5", "Price", i, value);
		


        	
        	String actualXpath_name = beforeXpath_name+i+afterXpath_name;
        	String value1 = driver.findElement(By.xpath(actualXpath_name)).getText();
        	//String value = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr["+i+"]/td["+columnIndex+"]")).getText();
        	System.out.println(value1);       	
        	reader.setCellData("TableData5", "Name", i, value1);
        	//Thread.sleep(5000, 24);
        	
        }
		
	}
	
	public void Content_xcel_After() {
		String beforeXpath_price1 = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr[";
		String afterXpath_price1 = "]/td[4]";
		
		
		String beforeXpath_name1 = "/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr[";
		String afterXpath_name1 = "]/td[3]";

		
//		List<WebElement> colList = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/thead/tr/th"));
//		System.out.println("header size:" + colList.size());
//
//		int columnIndex = 2;

        Xls_Reader reader = new Xls_Reader("/home/humakri1/eclipse-workspace/CucumberJava/src/main/java/com/excel/lib/util1/test006.xls");
       // Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util1/test006.xls");
        reader.addSheet("TableData6");
        reader.addColumn("TableData6", "Price");
        reader.addColumn("TableData6", "Name");


//		for(int i=0; i<colList.size(); i++){
//			System.out.println("Get the text:" +colList.get(i).getText());
//			if("Name".equals(colList.get(i).getText())){
//				columnIndex = i ;
//				break;
//			}
//		}

//        System.out.println("column Index : " + columnIndex);
        
        List<WebElement> numberOfRows = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr"));
        System.out.println("number of rows : " + numberOfRows.size());

        
        
        for(int i=2; i<=numberOfRows.size(); i++) {
        	
        	String actualXpath_price1 = beforeXpath_price1+i+afterXpath_price1;
        	String value_p = driver.findElement(By.xpath(actualXpath_price1)).getText();
        	//String value = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr["+i+"]/td["+columnIndex+"]")).getText();
        	System.out.println(value_p);
            reader.setCellData("TableData6", "Price", i, value_p);
		


        	
        	String actualXpath_name1 = beforeXpath_name1+i+afterXpath_name1;
        	String value_n = driver.findElement(By.xpath(actualXpath_name1)).getText();
        	//String value = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr["+i+"]/td["+columnIndex+"]")).getText();
        	System.out.println(value_n);       	
        	reader.setCellData("TableData6", "Name", i, value_n);
        	//Thread.sleep(5000, 24);
        	
        }
		
	}
	
	public ListElement(WebDriver driver) {
		this.driver = driver;
	}
	

}
