package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;


	@FindBy(xpath="//*[@id='main-nav']/a[3]/span")
	WebElement Contacts;
	//click on new

	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	WebElement Contact_creation;

	@FindBy(name="first_name")
	WebElement fname;

	@FindBy(name="last_name")
	WebElement lname;
	@FindBy(name="middle_name")
	WebElement mname;

	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement CompanyName;

	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div/div[1]/button/i")
	WebElement Accesibility;

	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div/div[2]/div/div[1]")
	WebElement AccessClick;

	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div/div[2]/div/div[2]/div/span")
	WebElement User_access;


	//click on save
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement Save;

	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/label/span")
	static
	WebElement fnamewarning;
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/label/span")
	static
	WebElement lnamewarning;

	public ContactsPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void Contacts_button() throws Exception{

		Contacts.click();
		Thread.sleep(2000);
	}
	public void New_Contact() throws Exception{
		Contact_creation.click();
		Thread.sleep(2000);
	}
	public void setFirstName(String strFirstName){

		fname.sendKeys(strFirstName);     
	}
	public void setLastName(String strLastName){

		lname.sendKeys(strLastName);     
	}
	public void setMiddleName(String strMiddleName){

		mname.sendKeys(strMiddleName);     
	}
	public void setCompanyName(String strCmpnyName){

		CompanyName.sendKeys(strCmpnyName);     

	}
	
	public void Save_contact(){

		Save.click(); 
	}


	public void Contacts_formFill(String strFirstName, String strLastName, String strMiddleName,String strCmpnyName) {
		this.setFirstName(strFirstName);
		//Fill password
		this.setLastName(strLastName);

		this.setMiddleName(strMiddleName);

		this.setCompanyName(strCmpnyName);

		this.Save_contact();

	}

	public static String firstnamealert() {

		return fnamewarning.getText();
	}

	public static String lastnamealert() {

		return lnamewarning.getText();
	}


}

