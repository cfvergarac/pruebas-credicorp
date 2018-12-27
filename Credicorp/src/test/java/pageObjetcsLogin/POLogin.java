package pageObjetcsLogin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import  utilidadesCredicorp.LeerExcel;
import  utilidadesCredicorp.Navegador;



public class POLogin {
	
	
	private WebDriver  driver;
	
	@CacheLookup
	private WebElement auth_username;
	@CacheLookup
	private WebElement inicio_sesion;
	@CacheLookup
	private WebElement auth_password;
	@CacheLookup
	private WebElement boton_login;
	
	private LeerExcel excel;
	
	
	
    //constructor
	public POLogin(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			excel = new LeerExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//metodos
	
	public void AbrirPagina() {
	 Navegador.abrirPagina(excel.getURL());
	 }

	
	 public void abrirLogin() {
		 inicio_sesion.click();
     }
	
	 
	 public void ingresar(){
		 boton_login.click();
		 new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
			 
			 public Boolean apply(WebDriver d) {
				 return d.findElement(By.xpath("//p[contains(@class, 'salir') and text() = 'Cerrar Sesión']")).isDisplayed();
				}});
	 }
	 
	 
	 public void clicCajaPassword(){
		 auth_password.click();
	 }
	 
	 
	 
	 
	public void Cerrarpagina(){
		Navegador.CerrarPagina();
	 }
		
	
	public void ingresarUsuarioSuper(){
		auth_username.sendKeys(excel.getSuper());
	
	}
	
	public void ingresarUsuario(String usuario){
		auth_username.sendKeys(usuario);
		//Navegador.refrescarPagina();
		
	}
	
	
	
	public void IngresarcontraseñaSuper(){
			
		this.ingresarContraseña(excel.getPassUsuario());
	}
	
	
	public void ingresarUsuarioPreparador(){
		auth_username.sendKeys(excel.getPreparador());
	
	}
	
	public void IngresarcontraseñaPreparador(){
		
		this.ingresarContraseña(excel.getPassPreparador());
	}
		
	
	public void ingresarUsuariocliente(){
		auth_username.sendKeys(excel.getcliente());
	
	}
	
	public void IngresarContraseñaCliente(){
		
		this.ingresarContraseña(excel.getpasscliente());
	}
		
	
		
	public void ingresarContraseña(String pass){
			
		 for (int i=1;i<=pass.length();i++){
		   
		    WebElement tecla = driver.findElement(By.xpath( "//a[starts-with(@class, 'tecla_') and contains(.,'" +  pass.substring((i-1),i)   + "')]"));
		    tecla.click();
		    new Actions(driver).moveToElement(auth_username).perform();
		    
		  }
		
    }
	
	
	public void ingresarSuper()
	{
		
		 this.abrirLogin();
		 this.ingresarUsuarioSuper(); 
		 this.clicCajaPassword();
		 this.IngresarcontraseñaSuper();
		 this.ingresar();
		
	}
	
	public void ingresarPreparador()
	{
		
		 this.abrirLogin();
		 this.ingresarUsuarioPreparador(); 
		 this.clicCajaPassword();
		 this.IngresarcontraseñaPreparador();
		 this.ingresar();
		
	}
	
	public void ingresarCliente()
	{
		
		 this.abrirLogin();
		 this.ingresarUsuariocliente(); 
		 this.clicCajaPassword();
		 this.IngresarContraseñaCliente();
		 this.ingresar();
		
	}
	
	
	
	
		
}
