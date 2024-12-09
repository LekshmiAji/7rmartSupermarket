package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.List_Catagories;
import pages.LoginPage;
import utilities.ExcelUtility;

public class ListCatagory_Test extends Base {
	public Home homepage;
	public List_Catagories listcatagory;

	@Test
	public void verifyUSerisAbleToaddCatogeries() throws IOException, InterruptedException {
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		listcatagory = homepage.category();
		listcatagory.click_Newbtn();
		listcatagory.catagoryInformtions();
		boolean isAlert_loaded = listcatagory.isAlertDisplayed();
		assertTrue(isAlert_loaded, Constant.ALERTMESSAGE);

	}
}
