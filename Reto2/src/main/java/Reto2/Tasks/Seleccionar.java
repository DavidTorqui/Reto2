package Reto2.Tasks;

import java.util.List;

import Reto2.Interactions.Esperar10;
import Reto2.Model.Opciones;
import Reto2.UserInterface.IngresarDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.conditions.Check;


public class Seleccionar implements Task {

	List<Opciones> opciones;
	
 	public Seleccionar(List<Opciones> opciones) {
		super();
		this.opciones = opciones;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(SelectFromOptions.byVisibleText(opciones.get(0).getQueDesea()).from(IngresarDatos.QUE_DESEA));
		actor.attemptsTo(Click.on(IngresarDatos.FECHA_NACIMIENTO));
		actor.attemptsTo(Type.theValue(opciones.get(0).getFecha()).into(IngresarDatos.FECHA_NACIMIENTO));
		actor.attemptsTo(Click.on(IngresarDatos.CLICK_VACIO));
		actor.attemptsTo(SelectFromOptions.byVisibleText(opciones.get(0).getTasa()).from(IngresarDatos.TASA));
		actor.attemptsTo(SelectFromOptions.byVisibleText(opciones.get(0).getProducto()).from(IngresarDatos.PRODUCTO));
		actor.attemptsTo(Enter.theValue(opciones.get(0).getPlazo()).into(IngresarDatos.PLAZO));
		actor.attemptsTo(Enter.theValue(opciones.get(0).getValor()).into(IngresarDatos.VALOR));
		actor.attemptsTo(Click.on(IngresarDatos.BOTON_SIMULAR));
        actor.attemptsTo(Esperar10.aMoment());
		actor.attemptsTo(Check.whether(opciones.get(0).getPlazo().equals("36")).
                andIfSo(Click.on(IngresarDatos.PASAR_PAGINA), 
                		Click.on(IngresarDatos.PASAR_PAGINA)).                		
                otherwise());
		actor.attemptsTo(Check.whether(opciones.get(0).getPlazo().equals("48")).
                andIfSo(Click.on(IngresarDatos.PASAR_PAGINA), 
                		Click.on(IngresarDatos.PASAR_PAGINA),
                	    Click.on(IngresarDatos.PASAR_PAGINA)).                		
                otherwise());
		actor.attemptsTo(Check.whether(opciones.get(0).getPlazo().equals("60")).
                andIfSo(Click.on(IngresarDatos.PASAR_PAGINA), 
                		Click.on(IngresarDatos.PASAR_PAGINA),
                		Click.on(IngresarDatos.PASAR_PAGINA),
                	    Click.on(IngresarDatos.PASAR_PAGINA)).                		
                otherwise());
		}

	public static Seleccionar simulacion(List<Opciones> opciones) {
		return Tasks.instrumented(Seleccionar.class, opciones);
	}
}
