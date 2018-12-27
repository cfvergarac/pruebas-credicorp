package QA.Cred;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**

 * En esta clase se lee los datos de acceso del login de credicorp de un documento de excel,  
 * para hacerlos disponibles en la clase de PO: POLogin

 * @author: QA team

 * @version: 11/08/2018/1.0


 */
 
public class LeerExcel {
	

	private static XSSFSheet sheet;
	private static XSSFWorkbook workbook;
	private static FileInputStream file;
	public static String url;
	public static String superuser;
	public static String passSuper;
	public static String preparadoruser;
	public static String passpreparador;
	public static String liberadoruser;
	public static String passLiberador;
	public static String clienteuser;
	public static String passcliente;
	private static XSSFCell Cell;


	public LeerExcel() throws IOException
	{
	
	this.file = new FileInputStream(new File( "D:\\Credicorp\\src\\main\\java\\QA\\Cred\\Data.xlsx"));
	this.workbook = new XSSFWorkbook(file);
	this.sheet = workbook.getSheetAt(0);
    setURL(this.sheet);
    setSuperUser(this.sheet);
    setPassUsuario(this.sheet);
    setPreparadorUser(this.sheet);
    setPassPreparador(this.sheet);
    setLiberadorUser(this.sheet);
    setPassLiberador(this.sheet);
    setClienteUser(this.sheet);
    setPassCliente(this.sheet);
    
	}
	

	public  String getURL() {
		return url;
	}

	
	public static void setURL(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(0).getCell(1);
		LeerExcel.url = String.valueOf(resultCell);
	}


	public String getSuper() {
		return superuser;
	}


	public void setSuperUser(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(1).getCell(1);
		LeerExcel.superuser = String.valueOf(resultCell);
	}


	public String getPassUsuario() {
		return passSuper;
	}


	public void setPassUsuario(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(2).getCell(1);
		LeerExcel.passSuper = String.valueOf(resultCell);
	}
	
	
	public String getPreparador() {
		return preparadoruser;
	}


	public void setPreparadorUser(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(5).getCell(1);
		LeerExcel.preparadoruser = String.valueOf(resultCell);
	}
	
	
	public String getPassPreparador() {
		return passpreparador;
	}


	public void setPassPreparador(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(6).getCell(1);
		LeerExcel.passpreparador = String.valueOf(resultCell);
	}

	
	private void setLiberadorUser(XSSFSheet sheet) throws IOException {
		// TODO Auto-generated method stub
		Cell resultCell=(Cell) sheet.getRow(9).getCell(1);
		LeerExcel.liberadoruser = String.valueOf(resultCell);
		
	}
	
	public String getLiberador() {
		return liberadoruser;
	}
	

	private void setPassLiberador(XSSFSheet sheet) throws IOException {
		// TODO Auto-generated method stub
		Cell resultCell=(Cell) sheet.getRow(10).getCell(1);
		LeerExcel.passLiberador = String.valueOf(resultCell);
		
	}

	public String getPassLiberador() {
		return passLiberador;
	}
	
	private void setClienteUser(XSSFSheet sheet) throws IOException {
		// TODO Auto-generated method stub
		Cell resultCell=(Cell) sheet.getRow(11).getCell(1);
		LeerExcel.clienteuser = String.valueOf(resultCell);
		
	}


	public String getcliente() {
		return clienteuser;
	}
	


	private void setPassCliente(XSSFSheet sheet) throws IOException {
		// TODO Auto-generated method stub
		Cell resultCell=(Cell) sheet.getRow(12).getCell(1);
		LeerExcel.passcliente = String.valueOf(resultCell);
		
		
	}


	public String getpasscliente() {
		return passcliente;
	}
	
	
	public static Object[][] obtenerExcel() throws Exception {
		
		String[][] arrayTabla = null;
		
		int filaIn = 1;
		int colIn  = 1;
		int ci = 0, cj;
		
		 int totalFilas = sheet.getLastRowNum();
		 int totalCols = 2;
		
		 arrayTabla = new String[totalFilas][totalCols];
		
		 for (int i=filaIn;i<=totalFilas;i++, ci++) {           	   
			 
			  cj=0;

			   for (int j=colIn;j<=totalCols;j++, cj++){

				   arrayTabla[ci][cj]=obtenerDato(i,j);

				   System.out.println(arrayTabla[ci][cj]);  

					}

				}
		 
		return arrayTabla;
		
	}
	
	
	public static String obtenerDato(int fila, int col) throws Exception {
		 
		   try{

			  Cell = sheet.getRow(fila).getCell(col);
			  String dato = Cell.getStringCellValue();
			  return dato;
			  }catch (Exception e){

				return "";

			  }
	}
	
}
