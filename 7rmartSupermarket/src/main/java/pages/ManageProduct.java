package pages;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Table.Cell;

import constants.Constant;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageProduct {
	public WebDriver driver;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div[2]/div[1]/label[3]")
	WebElement radiobtn;
	@FindBy(xpath = "//input[@id='tag']")
	WebElement tag;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement catagory;
	@FindBy(xpath = "//select[@id='sub_id']")
	WebElement subcategry;
	@FindBy(xpath = "//select[@id='grp_id']")
	WebElement group;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div[4]/div[2]/label[4]")
	WebElement pricetype;
	@FindBy(xpath = "//input[@id='l_minimum']")
	WebElement weightvalue;
	@FindBy(xpath = "//select[@id='l_unit']")
	WebElement weightunit;
	@FindBy(xpath = "//input[@id='l_max']")
	WebElement maxorder;
	@FindBy(xpath = "//input[@id='l_price']")
	WebElement litreprice;
	@FindBy(xpath = "//input[@id='l_price']")
	WebElement price;
	@FindBy(xpath = "//input[@id='l_stock']")
	WebElement stock;
	@FindBy(xpath = "/html/body/div[1]/div[1]/section/div/div/div/div/form/div/div[10]/div[2]/div/input")
	WebElement chooseimage;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebtn;
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div")
	WebElement alert;

	public ManageProduct newbtnclick() {
		newbtn.click();
		return this;
	}

	public ManageProduct enterProductDetails() throws IOException, InterruptedException {
		String titlevalue = ExcelUtility.readStringData(1, 0, "ManageProduct");
		title.sendKeys(titlevalue);
		radiobtn.click();
		String tagvalue = ExcelUtility.readStringData(1, 1, "ManageProduct");
		tag.sendKeys(tagvalue);
		PageUtility page = new PageUtility();
		page.selectByIndex(catagory, 0);
		page.selectByIndex(subcategry, 0);
		page.selectByIndex(group, 1);
		pricetype.click();

		String value = ExcelUtility.readIntegerData(1, 2, "ManageProduct");
		weightvalue.sendKeys(value);
		page.selectByIndex(weightunit, 1);
		String maxquantity = ExcelUtility.readIntegerData(1, 3, "ManageProduct");
		maxorder.sendKeys(maxquantity);
		String price_litre = ExcelUtility.readIntegerData(1, 4, "ManageProduct");
		litreprice.sendKeys(price_litre);
		String price_value = ExcelUtility.readIntegerData(1, 5, "ManageProduct");
		price.sendKeys(price_value);
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0, 7000)");
		String stock_value = ExcelUtility.readIntegerData(1, 6, "ManageProduct");
		stock.sendKeys(stock_value);
		savebtn.click();
		return this;
	}

	public boolean isAlertShown() {
		return alert.isDisplayed();
	}
}
