package Support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import StepDefinitions.CoinMarketSteps;
import pagefactory.CoinMarket_PF;

public class ActionClose {
	
	WebDriver driver = null;

	public void ActionClick() {
		
		WebElement m= driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]"));
		
		Actions a = new Actions(driver);
		a.moveToElement(m).
		click().build().perform();
		
	}
	
	public ActionClose(WebDriver driver) {
		this.driver = driver;
		//support.initElements(driver,this);
	}
}
