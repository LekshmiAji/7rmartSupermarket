package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class ManageNews {
	public WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement enter_news;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageNews newButtonClick() {
		newbutton.click();
		return this;
	}

	public ManageNews enterNews() throws IOException {
		String newsreport = ExcelUtility.readStringData(1, 0, "News");
		enter_news.sendKeys(newsreport);
		return this;
	}

	public ManageNews save_Click() {
		save.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
