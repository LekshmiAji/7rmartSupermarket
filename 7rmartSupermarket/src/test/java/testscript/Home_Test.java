package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import utilities.ExcelUtility;

public class Home_Test extends Base {
	public Home homepage;

	@Test
	public void verifyUserisabletoLogout() throws IOException {
		String expectedresult = "Login | 7rmart supermarket";
		String actualresult = driver.getTitle();
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		homepage.Logout();
		assertEquals(actualresult, expectedresult, Constant.TITLEMISMATCH);

	}
}
