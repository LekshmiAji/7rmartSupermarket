package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home;
import pages.List_Catagories;
import pages.LoginPage;
import pages.Sub_Categories;
import utilities.ExcelUtility;

public class SubCategory_Test extends Base {
	public Home homepage;
	public Sub_Categories subcatagory;

	@Test
	public void verifyUserisAbleToAddSubCatogories() throws IOException, InterruptedException {
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		subcatagory = homepage.list_SubCategory();
		subcatagory.newbtnClick();
		subcatagory.subCategory_Add();
		subcatagory.search_Click();
		boolean isalertdisplay = subcatagory.isAlertDisplayed();
		assertTrue(isalertdisplay, Constant.ALERTMESSAGE);
	}
}
