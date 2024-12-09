package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class SubCatagory_Search {
	public WebDriver driver;

	public SubCatagory_Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='un']")
	WebElement categry;
	@FindBy(xpath = "//input[@placeholder='Sub Category']")
	WebElement entersubcategry;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchbutton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement tablecontent_cateogryname;
	@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr/td[1]")
	WebElement subcat_table;

	public SubCatagory_Search search_Category() throws IOException {
		PageUtility page = new PageUtility();
		page.selectByIndex(categry, 1);
		String catagoryname = ExcelUtility.readStringData(1, 0, "Sub_Categories");
		entersubcategry.sendKeys(catagoryname);
		searchbutton.click();
		return this;
	}

	public boolean isSubCategoryTableShown() {
		return subcat_table.isDisplayed();
	}
}
