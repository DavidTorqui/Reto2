package Reto2.Tasks;

import Reto2.UserInterface.IngresarDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class Abrir implements Task {
	
	private IngresarDatos ingresardatos;
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn(ingresardatos));
	}
	
	public static Abrir lapaginaweb() {
		return Tasks.instrumented(Abrir.class);
	}
}