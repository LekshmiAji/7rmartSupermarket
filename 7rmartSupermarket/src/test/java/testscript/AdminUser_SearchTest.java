package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
import constants.Constant;
import pages.AdminUser_Add;
import pages.AdminUser_Search;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUser_SearchTest extends Base {
	public Home homepage;
	public AdminUser_Add adminuser;
	public AdminUser_Search adminsearch;

	@Test(retryAnalyzer =retry.Retry.class) 
			
	public void verifyWhethersearchitemispresent() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		adminuser = homepage.admin_click();
		adminsearch = adminuser.search_click();
		adminsearch.searchuser();
		adminsearch.isElementPresent();

		boolean isSearchPresent = adminsearch.isElementPresent();
		assertTrue(isSearchPresent, Constant.USERNOTPRESENT);
	}
}
