package Reto2.Questions;

import java.util.List;

import Reto2.UserInterface.IngresarDatos;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LaRespuesta implements Question<Boolean>{
	
	public static LaRespuesta es() {
		return new LaRespuesta();
	}

	@Override
	public Boolean answeredBy(Actor actor) {
	List<WebElementFacade> Cantidaderrores=	IngresarDatos.MENSAJE_ERROR.resolveAllFor(actor);
	System.out.println(Cantidaderrores.size());
		if(Cantidaderrores.size()>0) {
		return true;
		} else {
		return false;
		}
	}
}