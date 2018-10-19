package Reto2.UserInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl ("https://www.grupobancolombia.com/wps/portal/personas/productos-servicios/creditos/consumo/libre-inversion/simulador-credito-consumo")
public class IngresarDatos extends PageObject{
	
	public static final Target QUE_DESEA = Target.the("SELECCIONAR QUE ES LO QUE SE QUIERE HACER").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[2]/select"));
	public static final Target FECHA_NACIMIENTO = Target.the("INGRESA FECHA DE NACIMIENTO").located(By.name("dateFechaNacimiento"));
	public static final Target CLICK_VACIO = Target.the("SALE DE FECHA DE NACIMIENTO").located(By.xpath("//*[@id=\"main-content\"]/div[1]/div"));
	public static final Target TASA = Target.the("SELECCIONAR LA TASA").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[4]/select"));
	public static final Target PRODUCTO = Target.the("SELECCIONAR EL PRODUCTO").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[5]/div[1]/select"));
	public static final Target PLAZO = Target.the("SELECCIONAR EL NUMERO DE MESES").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[7]/div[1]/input"));
	public static final Target VALOR = Target.the("SELECCIONAR EL VALOR REQUERIDO").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[7]/div[2]/input"));
	public static final Target BOTON_SIMULAR = Target.the("BOTON PARA REALIZAR EJECUCION").located(By.xpath("//*[@id=\"sim-detail\"]/form/div[8]/button"));
	public static final Target PASAR_PAGINA = Target.the("PASA LAS PAGINAS").located(By.xpath("//div[@id='sim-results']/div[@class='table-scroll']/table[2]/tbody/tr/td/ul/li[contains(a,'Siguiente')]/a"));
	public static final Target MENSAJE_ERROR = Target.the("VALIDA LOS MENSAJES DE ERROR").located(By.xpath("//div[@class='error text-danger bg-danger']/div/span[@class='ng-binding']"));
	public static final Target TASA_EFECTIVA_ANUAL = Target.the("CONTIENE VALOR DADO POR EL SISTEMA DE LA TASA EFECTIVA ANUAL").located(By.xpath("//*[@id=\"sim-results\"]/div[1]/table/tbody/tr[1]/td[2]"));
	public static final Target TASA_MES_VENCIDA = Target.the("VCONTIENE VALOR DADO POR EL SISTEMA DE LA TASA MES VENCIDA").located(By.xpath("//*[@id=\"sim-results\"]/div[1]/table/tbody/tr[2]/td[2]"));
	public static final Target CUOTA_GENERADA = Target.the("CONTIENE VALOR DADO POR EL SISTEMA DE LA CUOTA GENERADA").located(By.xpath("//*[@id=\"sim-results\"]/div[1]/table/tbody/tr[3]/td[3]"));
	public static final Target SEGURO_VIDA = Target.the("CONTIENE VALOR DADO POR EL SISTEMA DEL SEGURO DE VIDA").located(By.xpath("//*[@id=\"sim-results\"]/div[1]/table/tbody/tr[4]/td[2]"));
	public static final Target CUOTA_TOTAL = Target.the("CONTIENE VALOR DADO POR EL SISTEMA DE LA CUOTA TOTAL ").located(By.xpath("//*[@id=\"sim-results\"]/div[1]/table/tbody/tr[6]/td[2]"));
}
