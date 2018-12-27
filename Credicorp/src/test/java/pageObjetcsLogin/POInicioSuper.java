package pageObjetcsLogin;


import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilidadesCredicorp.Navegador;
import utilidadesCredicorp.Tablas;


public class POInicioSuper{
	
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='menu_li']/h3[text()='Transacciones']")
	private WebElement transacciones;
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='a_submenu']/div[text()='REBALANCEO FPV']")
	private WebElement rebalanceo;
	
	@CacheLookup
	@FindBy(xpath = "//a[@onclick='consultarOpcionesDeinversionPorEncargo(829301000004)']")
	private WebElement encargo;
	
	@CacheLookup
	@FindBy(xpath = "//table[@class='tabla']")
	private WebElement tablaEncargos;
	private Tablas tabla;
	
	@CacheLookup
	@FindBy(linkText = "Crear Administrador Cliente")
	private WebElement botonC;
	
	
    //constructor
	public POInicioSuper(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	tabla =  new Tablas(tablaEncargos);
	
	}

	
	//metodos
	
	public void irRuta(){
		
		transacciones.click();
		rebalanceo.click();
		encargo.click();
		
	 }
	
	public void validaTabla() {
		
		tablaEncargos.isDisplayed();
		System.out.println("Columnas:"+ tabla.retornaNumeroColumnas());
		System.out.println("Filas:"+ tabla.retornaNumeroFilas());
		System.out.println(tabla.obtenerValorCelda(4, 4));
		WebElement celdaEditar = tabla.recibirEditorCelda(13, 4, 0);
		celdaEditar.clear(); 
		celdaEditar.sendKeys("329297949,18");
		celdaEditar.sendKeys(Keys.TAB);
		Navegador.driver().switchTo().alert().accept();
		Assert.assertNotEquals(tabla.obtenerValorCelda(13, 4), "-5.960464477539063e-8"); 
		
	}
	
	private boolean estaPresente(By by) {
		
		try {
			Navegador.driver().findElement(by);
			 return true;
			 } catch (NoSuchElementException e) {
			 return false;
			 }
		
	}
	
	public boolean verificaElemento() {
		
		
		 if(estaPresente(By.xpath("//p[contains(@class, 'salir') and text() = 'Cerrar Sesión']"))){
			 return true;
		 }
		 
			 return false;
	}
	
	public void select() {
		
		Navegador.driver().get("http://192.168.4.64:8080/WebData/cliente/6.1.do");
		Select sel = new Select(Navegador.driver().findElement(By.id("id_negocio")));
		assertEquals(7, sel.getOptions().size());
		sel.selectByVisibleText("(1) FONDOS DE INVERSION");
		
		
		/*arrayList<String> expectedOptions = Arrays.asList("BMW", "Mercedes","Audi","Honda");
		List<String> actualOptions = new ArrayList<String>();
		
		 for (WebElement option : sel.getOptions()) {
			 actualOptions.add(option.getText());
			 }
		 
		 assertArrayEquals(expectedOptions.toArray(), actualOptions.toArray());*/
		
	}
	
	public void alerta() {
		
		Navegador.driver().get("http://192.168.4.64:8080/WebData/admin_cliente/8.1.do");
		botonC.click();
		System.out.println(Navegador.driver().switchTo().alert().getText());
	}
	
}
