package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUser_Add;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUser_Add_Test extends Base {
	public Home homepage;
	public AdminUser_Add adminuser;

	@Test(groups = { "smoketest" })
	public void verifywhetheruserisadded() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		adminuser = homepage.admin_click();
		adminuser.click_Newbtn();
		adminuser.add_adminuser();
		adminuser.alert_close();
		boolean isTableShown = adminuser.isTableDisplayed();
		assertTrue(isTableShown, Constant.TABLECONTENTMISSING);
	}
}
