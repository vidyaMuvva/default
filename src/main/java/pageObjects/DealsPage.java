package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DealsPage {
	@FindBy(xpath="//*[@id='main-nav']/a[5]")
	WebElement Deals;
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a[3]/button")

	WebElement NewDeals;
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement Title;
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement cmpnyName;
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div")
	WebElement assignedClick;
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/div[2]/div/span")
	WebElement assignedSelect;
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement saveDeal;

	WebDriver driver;

	public DealsPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	public void Deals_button() throws Exception {
		Deals.click();
		Thread.sleep(2000);

	}


	public void New_Deal() throws Exception {

		NewDeals.click();
		Thread.sleep(2000);
	}


	public void FillDealForm(String strTitleName, String strCompanyName) {
		this.setTitleName(strTitleName);
		this.setCompanyName(strCompanyName);
		this.assignclick();
		this.assignselect();

		this.SaveDeal();

	}


	private void assignclick() {
	
		assignedClick.click();

	}


	private void assignselect() {
	
		assignedSelect.click();
	}


	private void SaveDeal() {
	
		saveDeal.click();
	}


	private void setTitleName(String strTitleName) {
	
		Title.sendKeys(strTitleName);
	}


	private void setCompanyName(String strCompanyName) {
	
		cmpnyName.sendKeys(strCompanyName);

	}

}
