package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoinMarket_PF {
	
	//@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]")
	//WebElement close_popup_listener;
	
	
	@FindBy(css = ".ekMmID > .sc-16r8icm-0 > .sc-16r8icm-0")
	WebElement row_display;
	
	@FindBy(css = ".bnhhNH:nth-child(3)")
	WebElement select_dropdown;
	
	
	@FindBy(css = ".sc-1hxnufv-4 > .sc-36mytl-0")
	WebElement filter_algo;
	
	@FindBy(css = ".filter:nth-child(2) .x0o17e-0")
	WebElement click_algo;
	
	@FindBy(css = ".ykm2vq-1")
	WebElement search_pow;
	
	@FindBy(css = "div:nth-child(1) > ul > .optionGroupItem:nth-child(2)")
	WebElement select_pow;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]")
	WebElement action_close;
	
	WebDriver driver;
	
	public CoinMarket_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void showRow() {
		row_display.click();
	}
	
	public void selectRow() {
		select_dropdown.click();
	}
	
	public void filterPow() {
		filter_algo.click();
	}
	
	public void clickAlgo() {
		click_algo.click();
	}
	
	public void searchPow( ) {
		search_pow.sendKeys("PoW");
	}
	
	public void selectPow() {
		select_pow.click();
	}
	
	//public WebElement actionClose() {
		//action_close.click();
//	}

}
