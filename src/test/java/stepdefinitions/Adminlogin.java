package stepdefinitions;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Adminlogin 
{
	public static WebDriver driver;
	String empid;
	
	@Given("^i open browser with the url \"([^\"]*)\"$")
	public void i_open_browser_with_the_url(String url)
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		 driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page()
	{
	    driver.findElement(By.id("btnLogin"));
	    System.out.println("Login page is displayed");
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uid)
	{
		driver.findElement(By.id("txtUsername")).clear();
	    driver.findElement(By.id("txtUsername")).sendKeys(uid);
	    
	   
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pwd)
	{
		 driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	}

	@When("^i click login$")
	public void i_click_login()
	{
		driver.findElement(By.name("Submit")).click();	
	}

	@Then("^i should see Admin page$")
	public boolean i_should_see_Admin_page()
	{
		try {
			if (driver.findElement(By.linkText("Admin")).isDisplayed())
			{
				return true;
			}
			}catch (Exception e)
			{
			return false;
		    }
		return false;
	}

	@Then("^i click logout$")
	public boolean i_click_logout() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		if (driver.findElement(By.name("Submit")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
     }  
	
	

@When("^i close browser$")
public void i_close_browser()
{
	
	driver.close();
}


@Then("^i should see error messege$")
public boolean i_should_see_error_messege() 
{
		String Rtext = driver.findElement(By.id("spanMessage")).getText();
		if (Rtext.contains("Invalid") || Rtext.contains("empty"))
		{
			return false;
		
		}else
		{
			return true;
		
		}
	}

@When("^i goto Employee Registration page$")
public void i_goto_Employee_Registration_page() 
{
	driver.findElement(By.linkText("PIM")).click();
	driver.findElement(By.linkText("Add Employee")).click();
	
}

@When("^i enter Firstname \"([^\"]*)\"$")
public void i_enter_Firstname(String Fname)
{
	driver.findElement(By.id("firstName")).sendKeys(Fname);
}
@When("^i enter Lastname  \"([^\"]*)\"$")
public void i_enter_Lastname(String Lname)
{
	
	driver.findElement(By.id("lastName")).sendKeys(Lname);
}


@When("^i click save$")
public void i_click_save()
{
	empid = driver.findElement(By.id("employeeId")).getAttribute("value");
	driver.findElement(By.id("btnSave")).click();
	System.out.println(empid);
}

@Then("^i should see Registered employee in Employee List$")
public boolean i_should_see_Registered_employee_in_Employee_List() 
{
	driver.findElement(By.linkText("Employee List")).click();
	
	driver.findElement(By.id("empsearch_id")).sendKeys(empid);
	driver.findElement(By.id("searchBtn")).click();
	
	WebElement x = driver.findElement(By.id("resultTable"));
	
	java.util.List<WebElement> rows = x.findElements(By.tagName("tr"));
	
	boolean empidexist = false;
	
	 for(int i=1; i<rows.size(); i++)
	 {
		 java.util.List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
		 
		 if(cols.get(1).getText().equals(empid))
		 {
			 return true;
		
		 }else {
			 return false;
		 }
	 }
	return empidexist;
	 
	
}

}

	

  

