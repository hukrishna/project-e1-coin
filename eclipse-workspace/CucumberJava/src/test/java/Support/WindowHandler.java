package Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WindowHandler {
	
	WebDriver driver = null;
	
	
	public void windowhandler() {
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
	}

	
	public WindowHandler(WebDriver driver) {
		this.driver = driver;
	}
}
