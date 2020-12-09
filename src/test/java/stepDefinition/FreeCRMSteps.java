package stepDefinition;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import com.gargoylesoftware.css.dom.Property;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CalendarPage;
import pageObjects.ContactsPage;
import pageObjects.DealsPage;
import pageObjects.LoginPage;
import pageObjects.TaskPage;

public class FreeCRMSteps {
	String driverPath ="E:\\drivers\\chromedriver.exe";  //Chromedriver path
	WebDriver driver;

	LoginPage objLogin;

	ContactsPage objContactsPage;
	DealsPage objDealsPage;
	TaskPage objTaskPage;
	CalendarPage objCalendarPage;
//	public void readPropertiesFile() throws IOException{
//		 Properties prop=new Properties();
//	        FileInputStream ip = new FileInputStream("C:\\Java_training\\FreeCRM_test\\src\\test\\java\\propertyFile\\FreeCRM.properties");
//	        prop.load(ip);
//	}

	@Before
	public void setup() throws IOException{
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver(); //Launch chrome
       
        
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://freecrm.co.in/"); //Open the FreeCRM website

		driver.manage().window().maximize(); //Maximize the window

		objLogin = new LoginPage(driver);   //Create Login Page object
		objContactsPage= new ContactsPage(driver);  //Create Contacts Page object
		objDealsPage= new DealsPage(driver);  //Create Deals Page object
		objTaskPage= new TaskPage(driver);  //Create Task Page object
		objCalendarPage= new CalendarPage(driver);  //Create Calendar Page object
	}


	@Given("^User is on Login page$")
	public void user_is_on_Login_page() throws Exception {
		objLogin.clickfirstLogin();  //calls the method clickfirstLogin
		String title=LoginPage.validateLoginTitle(); //calls the method which checks the Title
		Thread.sleep(2000); //delay
		Assert.assertEquals(title,"Cogmento CRM"); //compare the login page title with actual title

	}

	@When("^User enters valid UserName and Password$")
	public void user_enters_valid_UserName_and_Password() throws Exception{ 
	
		objLogin.setUserName("vidyamuvva.26@gmail.com"); //calls the method Enters username in the Username field
		Thread.sleep(1000);
		objLogin.setPassword("Cap123456"); //calls the method which Enters the password
		Thread.sleep(1000);

	}

	@When("^clicks on login$")
	public void clicks_on_login(){
		objLogin.clickLogin(); //calls the method which clicks on login
	}

	@Then("^User should be navigated to Home Page$")
	public void user_should_be_navigated_to_Home_Page()  {

		String homePagetitle=driver.getTitle(); //gets the title of the Home page
		Assert.assertEquals(homePagetitle,"Cogmento CRM"); //compares the Title with the actual title
		System.out.println(homePagetitle); //Prints the title
		driver.quit(); //quits the browser

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2)  {
		objLogin.setUserName(arg1); //calls the method which fills Username
		objLogin.setPassword(arg2); //calls the method which fills Password


	}

	@Then("^Displays an alert Message$")
	public void displays_an_alert_Message() {
		String alert=LoginPage.checkCredentials(); //calls the method which checks the error message
		System.out.println(alert); //Prints the alert
		driver.quit();//quits the browser

	}

	@Given("^User is on Home page$")
	public void user_is_on_Home_page() throws Exception {
		objLogin.clickfirstLogin(); //click on login button before filling credentials
		objLogin.setUserName("vidyamuvva.26@gmail.com"); //calls method that enter username
		objLogin.setPassword("Cap123456"); //calls method that enter password
		objLogin.clickLogin(); //click on login button after filling credentials
		Thread.sleep(1000);
		String title1=driver.getTitle(); //gets title of home page
		System.out.println(title1); //prints the title
		Assert.assertEquals(title1,"Cogmento CRM"); //compares the title with actual title
	}

	@When("^user clicks on contacts$")
	public void user_clicks_on_contacts() throws Exception  {

		objContactsPage.Contacts_button(); // calls the method which clicks on contacts
		Thread.sleep(1000);
	}

	@When("^user navigated to contacts page$")
	public void user_navigated_to_contacts_page() throws Exception {
		String ContactPageTitle=driver.getTitle(); //gets the title of contacts page
		Assert.assertEquals(ContactPageTitle,"Cogmento CRM"); //compares the title
		Thread.sleep(1000);
	}

	@Then("^User clicks on new$")
	public void user_clicks_on_new() throws Throwable {
		objContactsPage.New_Contact(); // calls the method which clicks on new contacts
		Thread.sleep(1000);
		//		System.out.println("user on contact page");
	}

	@Then("^User is able to create a new contact on filling the FirstName and LastName fields$")
	public void user_is_able_to_create_a_new_contact_on_filling_the_FirstName_and_LastName_fields() throws Throwable {
		objContactsPage.Contacts_formFill("Vidya", "Muvva", "V", "Capgemini"); //calls the method which fill the form
		driver.quit();//quits the browser

	}

	@Then("^User leaves the FirstName field empty and clicks on save$")
	public void user_leaves_the_FirstName_field_empty_and_clicks_on_save() throws Throwable {
		objContactsPage.Contacts_formFill("", "Muvva", "V", "Capgemini"); //calls the method which fill the form with first name empty
	}

	@Then("^Display an firstname alert Message$")
	public void display_an_firstname_alert_Message() throws Throwable {
		String fnamealert=ContactsPage.firstnamealert(); //calls the method which gets text of error
		Assert.assertEquals(fnamealert, "The field First Name is required"); //compare the first name alert with actual alert
		driver.quit();//quits the browser
	}
	@Then("^User leaves the LastName field empty and clicks on save$")
	public void user_leaves_the_LastName_field_empty_and_clicks_on_save() throws Throwable {
		objContactsPage.Contacts_formFill("Vidya", "", "V", "capgemini"); //calls the method which fill the form with last name empty
	}
	@Then("^Display an lastname alert Message$")
	public void display_an_lastname_alert_Message() throws Throwable {
		String lnamealert=ContactsPage.lastnamealert(); //calls the method which gets text of error
		Assert.assertEquals(lnamealert, "The field Last Name is required");//compare the last name alert with actual alert
		driver.quit();//quits the browser
	}

	@When("^user clicks on Deals$")
	public void user_clicks_on_Deals() throws Throwable {
		objDealsPage.Deals_button(); //calls the method which click on deals button
		Thread.sleep(1000);

	}

	@When("^user navigated to Deals page$")
	public void user_navigated_to_Deals_page() throws Throwable {
		String DealsPageTitle=driver.getTitle(); //gets the title of deals page
		Assert.assertEquals(DealsPageTitle,"Cogmento CRM"); //compares the title of deals page with actual title
		Thread.sleep(1000);

	}
	@Then("^User clicks on new deal$")
	public void user_clicks_on_new_deal() throws Throwable {
		objDealsPage.New_Deal();  //calls the method which click on new on deals page
		Thread.sleep(1000);
		//		System.out.println("user on contact page");
	}


	@Then("^User is able to create a new Deal on filling the Title field$")
	public void user_is_able_to_create_a_new_Deal_on_filling_the_Title_field() throws Throwable {
		objDealsPage.FillDealForm("Mobile software", "Capgemini"); //fills the deal page form
		driver.quit();//quits the browser

	}

	@When("^user clicks on Tasks$")
	public void user_clicks_on_Tasks() throws Throwable {
		objTaskPage.Tasks_button(); //calls the method which clicks on tasks button
		Thread.sleep(1000);
	}

	@When("^user navigated to Tasks page$")
	public void user_navigated_to_Tasks_page() throws Throwable {
		String TasksPageTitle=driver.getTitle(); //gets title of task page
		Assert.assertEquals(TasksPageTitle,"Cogmento CRM"); //compares the title of task page
		Thread.sleep(1000);
	}
	@Then("^User clicks on new task$")
	public void user_clicks_on_new_task() throws Throwable {
		objTaskPage.NewTasks(); //calls the method which click on new on tasks page
		Thread.sleep(1000);

	}

	@Then("^User is able to create a new Task on filling the Title field$")
	public void user_is_able_to_create_a_new_Task_on_filling_the_Title_field() throws Throwable {
		objTaskPage.FillTaskForm("To complete testing Mobile software","This is to test the all test cases that are executed or not");//fills the task page form
		driver.quit();//quits the browser
	}

	@When("^user clicks on Calendar$")
	public void user_clicks_on_Calendar() throws Throwable {
		objCalendarPage.clickHome(); //calls the method which clicks on home
		Thread.sleep(1000);
		objCalendarPage.clickCalendar();//calls the method which clicks on Calendar
		Thread.sleep(1000);
	}

	@When("^user navigated to Calendar page$")
	public void user_navigated_to_Calendar_page() throws Throwable {
		String CalendarPageTitle=driver.getTitle(); //gets the title of the page
		Assert.assertEquals(CalendarPageTitle,"Cogmento CRM"); //Compares the title
		Thread.sleep(1000);

	}

	@Then("^Created tasks should be displayed on Calendar Page$")
	public void created_tasks_should_be_displayed_on_Calendar_Page() throws Throwable {
		String taskmessage=CalendarPage.displayOnCalendar(); //calls the method to check task on calendar
		Thread.sleep(4000);
		Assert.assertEquals(taskmessage,"To complete testing Mobile software"); //compares the created task on calendar with task title
		driver.quit();//quits the browser
	}


}
