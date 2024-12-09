package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageNews;
import pages.ManageUsers;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	public Home homepage;
	public ManageNews managenews;

	@Test
	public void f() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		managenews = homepage.managenews_Click().newButtonClick().enterNews().save_Click();
		boolean isAlertShown = managenews.isAlertDisplayed();
		assertTrue(isAlertShown, Constant.ALERTMESSAGE);
	}
}
