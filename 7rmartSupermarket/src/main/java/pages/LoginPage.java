package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// for using finddBy annotation

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;
	@FindBy(xpath = "//img[@class='img-circle elevation-2']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alertclose;

	public LoginPage enterCredentials(String usernamefield, String passwordfield) {
		username.sendKeys(usernamefield);
		password.sendKeys(passwordfield);
		return this;

	}

	public Home clickonsignin() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementTobeClickable(driver, signin);
		signin.click();

		return new Home(driver);

	}

	public boolean isDashboardLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertLoaded() {
		return alert.isDisplayed();
	}
}
