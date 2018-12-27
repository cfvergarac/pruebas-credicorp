package QA.test;

import org.testng.annotations.Test;

import pageObjetcsLogin.POInicioSuper;
import pageObjetcsLogin.POLogin;
import utilidadesCredicorp.Navegador;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class TestTabla {
	
	private POLogin poLogin = new POLogin(Navegador.driver());
	private POInicioSuper po = new POInicioSuper(Navegador.driver());
	
	  @BeforeClass
	  public void beforeTest() {
		  poLogin.AbrirPagina();
	  }
	
	  @Test
	  public void LoginDelSuper() {
		  
	  poLogin.ingresarCliente();
	  po.irRuta();
	  po.validaTabla();
	  
      }
  

	  @AfterTest
      public void afterTest() {
	 // poLogin.Cerrarpagina();
      }

}