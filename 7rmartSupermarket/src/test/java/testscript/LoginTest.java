package testscript;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	@Parameters({ "Username", "Password" })

	public void verifyUserIsAbleToLogin_ValidCredentials(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		login.clickonsignin();
		boolean isDashboardLoaded = login.isDashboardLoaded();
		assertTrue(isDashboardLoaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@DataProvider(name = "invalidcredentials")
	public Object[][] testData() {
		Object data[][] = { { "yyyyy", "gghhh" } };
		return data;
	}

	@Test(dataProvider = "invalidcredentials")
	public void verifyUserIsAbleToLogin_InValidCredentials(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		login.clickonsignin();
		boolean isAlert_loaded = login.isAlertLoaded();
		assertFalse(isAlert_loaded, Constant.ALERTMESSAGE);
		//login.alerthandle();

	}

	@Test
	public void verifyUserIsAbleToLogin_ValidUsernameInvalidPasswaord() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "Loginpage");
		String password = ExcelUtility.readStringData(2, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		login.clickonsignin();
		boolean isAlert_loaded = login.isAlertLoaded();
		assertTrue(isAlert_loaded, Constant.ALERTMESSAGE);
		login.alerthandle();

	}

	@Test
	public void verifyUserIsAbleToLogin_InValidUsernamevalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Loginpage");
		String password = ExcelUtility.readStringData(3, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		login.clickonsignin();

		boolean isAlert_loaded = login.isAlertLoaded();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(isAlert_loaded, Constant.ALERTMESSAGE);
		login.alerthandle();

	}

}
