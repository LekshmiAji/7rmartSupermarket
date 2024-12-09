package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class Sub_Categories {
	public WebDriver driver;

	public Sub_Categories(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement category_drop;
	@FindBy(xpath = ("//input[@id='subcategory']"))
	WebElement entersubcategry;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosebtn;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	WebElement subcategory;

	public SubCatagory_Search search_Click() {
		subcategory.click();
		searchbutton.click();
		return new SubCatagory_Search(driver);
	}

	public Sub_Categories newbtnClick() {
		newbtn.click();
		return this;
	}

	public Sub_Categories subCategory_Add() throws IOException, InterruptedException {
		PageUtility page = new PageUtility();
		page.selectByIndex(category_drop, 1);
		String catagory = ExcelUtility.readStringData(1, 0, "Sub_Categories");
		entersubcategry.sendKeys(catagory);
		String imagepath = Constant.IMAGEPATH;
		choosebtn.sendKeys(imagepath);
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0, 9000)");

		Thread.sleep(3000);
		savebtn.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
