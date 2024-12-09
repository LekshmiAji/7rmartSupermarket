package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUser_Add;
import pages.Home;
import pages.LoginPage;
import pages.ManageProduct;
import pages.SubCatagory_Search;
import pages.Sub_Categories;
import utilities.ExcelUtility;

public class SubCategory_SearchTest extends Base {
	public Home homepage;
	public SubCatagory_Search search;
	public Sub_Categories category;
	public AdminUser_Add admin;

	@Test
	public void verifyUserIsAbleToSearch() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "Loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(username, password);
		homepage = login.clickonsignin();
		category = homepage.list_SubCategory();
		search = category.search_Click().search_Category();
		boolean isTableShown = search.isSubCategoryTableShown();
		assertTrue(isTableShown, Constant.TABLECONTENTMISSING);

	}
}
