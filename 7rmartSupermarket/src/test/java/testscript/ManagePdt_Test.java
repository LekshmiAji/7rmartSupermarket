package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageProduct;
import utilities.ExcelUtility;

public class ManagePdt_Test extends Base {
	public Home homepage;
	public ManageProduct managepdt;

	@Test
	public void verifyUSerisAbleToManageProducts() throws IOException, InterruptedException {
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		managepdt = homepage.clickManagePdt();
		managepdt.newbtnclick();
		managepdt.enterProductDetails();
		boolean isalertdisplay = managepdt.isAlertShown();
		assertTrue(isalertdisplay, Constant.ALERTMESSAGE);
	}
}
