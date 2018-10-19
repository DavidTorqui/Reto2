package Reto2.Tasks;

import java.util.List;


import Reto2.Model.Opciones;
import Reto2.UserInterface.IngresarDatos;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.conditions.Check;


public class SeleccionarMal implements Task {

	List<Opciones> opciones;
	
 	public SeleccionarMal(List<Opciones> opciones) {
		this.opciones = opciones;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		List<WebElementFacade> Cantidaderrores=	IngresarDatos.MENSAJE_ERROR.resolveAllFor(actor);
		actor.attemptsTo(SelectFromOptions.byVisibleText(opciones.get(0).getQueDesea()).from(IngresarDatos.QUE_DESEA));
		actor.attemptsTo(Click.on(IngresarDatos.FECHA_NACIMIENTO));
		actor.attemptsTo(Type.theValue(opciones.get(0).getFecha()).into(IngresarDatos.FECHA_NACIMIENTO));
		actor.attemptsTo(Click.on(IngresarDatos.CLICK_VACIO));
		actor.attemptsTo(SelectFromOptions.byVisibleText(opciones.get(0).getTasa()).from(IngresarDatos.TASA));
		actor.attemptsTo(Check.whether(Cantidaderrores.size()==3).andIfSo(SelectFromOptions.byVisibleText(opciones.get(0).getProducto()).from(IngresarDatos.PRODUCTO)).otherwise());
		actor.attemptsTo(Check.whether(Cantidaderrores.size()==2).
                andIfSo(Enter.theValue(opciones.get(0).getPlazo()).into(IngresarDatos.PLAZO),
                		Enter.theValue(opciones.get(0).getValor()).into(IngresarDatos.VALOR)).
                otherwise());
		actor.attemptsTo(Check.whether(Cantidaderrores.size()==0).andIfSo(Click.on(IngresarDatos.BOTON_SIMULAR)).otherwise());
	}

	public static SeleccionarMal simulacionmal(List<Opciones> opciones) {
		return Tasks.instrumented(SeleccionarMal.class, opciones);
	}
}
