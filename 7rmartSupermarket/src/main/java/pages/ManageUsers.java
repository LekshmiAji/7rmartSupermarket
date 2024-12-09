package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsers {
	public WebDriver driver;

	public ManageUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement table_adminuser;

	public boolean isAdminTableDisplayed() {
		return table_adminuser.isDisplayed();
	}
}
