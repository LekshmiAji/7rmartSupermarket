package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class Home {

	public WebDriver driver;
	PageUtility page = new PageUtility();

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[1]/div/a")
	WebElement adminuser;

	@FindBy(xpath = "(//a[@class='small-box-footer'][normalize-space()='More info'])[3]")
	WebElement catagory;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[4]/div/a")
	WebElement subcategory;
	@FindBy(xpath = "/html/body/div/aside[1]/div/div[4]/div/div/nav/ul/li[8]/a")
	WebElement managepdt;
	@FindBy(xpath = "/html/body/div/aside[1]/div/div[4]/div/div/nav/ul/li[1]")
	WebElement adminUser;
	@FindBy(xpath = "//li[@class='nav-item has-treeview menu-open'][2]")
	WebElement settings;
	@FindBy(xpath = "/html/body/div/aside[1]/div/div[6]/div/div']")
	WebElement Scrollbar;
	@FindBy(xpath = "/html/body/div/aside[1]/div/div[4]/div/div/nav/ul/li[10]/a/p")
	WebElement managenews;

	public Home Logout() {
		admin.click();
		logout.click();
		return this;

	}

	public ManageNews managenews_Click() {
		managenews.click();
		return new ManageNews(driver);
	}

	public ManageUsers adminuser_ManageClick() {
		adminuser.click();
		return new ManageUsers(driver);
	}

	public AdminUser_Add admin_click() {

		WaitUtility wait = new WaitUtility();
		wait.waitForElementTobeClickable(driver, adminuser);
		adminuser.click();
		return new AdminUser_Add(driver);

	}

	public List_Catagories category() {
		catagory.click();
		return new List_Catagories(driver);
	}

	public Sub_Categories list_SubCategory() {
		subcategory.click();
		return new Sub_Categories(driver);
	}

	public ManageProduct clickManagePdt() {
		managepdt.click();
		return new ManageProduct(driver);
	}

}
