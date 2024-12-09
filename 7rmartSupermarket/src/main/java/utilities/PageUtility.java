package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	JavascriptExecutor javascript = (JavascriptExecutor) driver;

	public void selectByIndex(WebElement dropdown, int index) {
		Select drop = new Select(dropdown);
		drop.selectByIndex(index);

	}

	public void adminuser_click_javascript(WebElement adminclk) {
		javascript.executeScript("arguments[0].click();", adminclk);
	}

	public void scroll(WebElement scrollbar) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0, 1000)");

	}

	public void draganddrop(WebElement drag, WebElement destination) {
		Actions action = new Actions(driver);
		action.moveToElement(drag);
		action.doubleClick(drag).perform();
		action.dragAndDrop(drag, destination).build().perform();
	}

}
