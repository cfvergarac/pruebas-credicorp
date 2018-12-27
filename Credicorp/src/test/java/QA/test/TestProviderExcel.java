package QA.test;

import org.testng.annotations.AfterTest;
import utilidadesCredicorp.LeerExcel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjetcsLogin.POLogin;
import utilidadesCredicorp.Navegador;

public class TestProviderExcel {
	
	
	
	@DataProvider(name = "testData")
	public Object[][] createData1() throws Exception {
	 return new Object[][] {
	   { LeerExcel.obtenerDato(1,1), "AD4113" },
	   { "adminht",  "A11111" },
	 };
	}
	 
	/* @DataProvider(name = "testData")
		public Object[][] createData1() throws Exception{ 
		
		 return LeerExcel.obtenerExcel();
		
		}*/
	

	 @BeforeTest
	  public void beforeTest() {
		 
	     
	  }
	
	
	  @Test(dataProvider = "testData")
	  public void LoginDelSuper(String usuario, String contraseña) {
	 
		  POLogin poLogin = new POLogin(Navegador.driver());
		  poLogin.AbrirPagina();
		  poLogin.abrirLogin();
		  poLogin.ingresarUsuario(usuario);
		  //poLogin.Cerrarpagina();
		  
      }
 

	  @AfterTest
      public void afterTest() {
	
		  
     }
  
  
  
}
