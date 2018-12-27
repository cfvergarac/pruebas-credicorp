package pageObjetcsLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class POLogin2 {
	
	
	private WebDriver  driver;
	
	@CacheLookup
	private WebElement auth_username;
	@CacheLookup
	private WebElement inicio_sesion;
	@CacheLookup
	private WebElement auth_password;
	@CacheLookup
	private WebElement boton_login;
	
	
	
	/*@FindBy(id = "bmi_category")
	private WebElement bmiCategory;*/
	
	
    //constructor
	public POLogin2( ) {
		
		this.driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
		
	}

	
	//metodos
	public void setUsuario(String usuario) {
		
		
		
		 }

	

	 
	
	 
	 

		
		

}
