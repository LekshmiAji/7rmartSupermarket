package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUser_Add;
import pages.Home;
import pages.LoginPage;
import pages.ManageUsers;
import pages.SubCatagory_Search;
import pages.Sub_Categories;
import utilities.ExcelUtility;

public class ManageUserTest extends Base {
	public Home homepage;
	public ManageUsers manageuser;

	@Test
	public void verifywhetherAdminUsersareListed() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		manageuser = homepage.adminuser_ManageClick();
		boolean isTableShown = manageuser.isAdminTableDisplayed();
		assertTrue(isTableShown, Constant.TABLECONTENTMISSING);
	}
}
