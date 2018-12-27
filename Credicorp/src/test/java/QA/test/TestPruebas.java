package QA.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjetcsLogin.POInicioSuper;
import pageObjetcsLogin.POLogin;
import utilidadesCredicorp.Navegador;


public class TestPruebas 
{
	
	private POLogin poLogin = new POLogin(Navegador.driver());
	private POInicioSuper po = new POInicioSuper(Navegador.driver());
	
    @BeforeClass
	  public void beforeTest() {
		  poLogin.AbrirPagina();
	  }
		
	
	
    @Test
     public void CP001() {
    	
  	  poLogin.ingresarSuper();
  	  Assert.assertTrue(po.verificaElemento());
  	  po.select();
  	  po.alerta();
      }
  
    
}
