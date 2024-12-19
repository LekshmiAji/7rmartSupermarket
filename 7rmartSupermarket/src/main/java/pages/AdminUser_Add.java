package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;

public class AdminUser_Add {
	public WebDriver driver;

	public AdminUser_Add(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbtn;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username_admin;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_admin;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype_drop;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement usercreation_alert;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alert_close;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement tablecontent;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;

	public AdminUser_Search search_click() {
		searchbtn.click();
		return new AdminUser_Search(driver);
	}

	public AdminUser_Add click_Newbtn() {
		newbtn.click();
		return this;
	}

	public AdminUser_Add add_adminuser() throws IOException {
		FakerUtility faker = new FakerUtility();
		String username = faker.getFakeFirstName();
		String password = faker.getFakeLastName();
		username_admin.sendKeys(username);
		password_admin.sendKeys(password);
		PageUtility page = new PageUtility();
		page.selectByIndex(usertype_drop, 2);
		save.click();
		return this;
	}

	public boolean isTableDisplayed() {
		return tablecontent.isDisplayed();
	}

	public boolean isUserCreatedSuccessfully() {
		return usercreation_alert.isDisplayed();

	}

	public void alert_close() {
		alert_close.click();
	}

}
