package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class List_Catagories {
	public WebDriver driver;
	static FileInputStream f;

	public List_Catagories(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;
	@FindBy(xpath = "//input[@placeholder='Enter the Category']")
	WebElement entercatagory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement drag;
	@FindBy(xpath = "//li[@id='134-selection']")
	WebElement drop;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")
	WebElement choosebtn;

	public List_Catagories click_Newbtn() {
		newbtn.click();
		return this;
	}

	public List_Catagories catagoryInformtions() throws IOException, InterruptedException {
		String catagory = ExcelUtility.readStringData(1, 0, "List_Catagories");
		entercatagory.sendKeys(catagory);
		String imagepath = Constant.IMAGEPATH;
		
		drag.click();
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0, 9000)");
		Thread.sleep(3000);
		FileUploadUtility file=new FileUploadUtility();
		file.sendKeysFileUpload(choosebtn, imagepath);
		save.click();

		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
