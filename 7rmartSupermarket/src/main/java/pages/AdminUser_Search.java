package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class AdminUser_Search {
	public WebDriver driver;

	public AdminUser_Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='un']")
	WebElement search_username;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement search_usertype;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchbutton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement tablecontent;

	public AdminUser_Search searchuser() throws IOException {
		String user = ExcelUtility.readStringData(1, 0, "Admin_User_add");
		search_username.sendKeys(user);
		PageUtility page = new PageUtility();
		page.selectByIndex(search_usertype, 2);
		searchbutton.click();
		return this;

	}

	public boolean isElementPresent() {
		return tablecontent.isDisplayed();
	}

}
