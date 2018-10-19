package Reto2.StepDefinitions;

import java.util.List;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import Reto2.Model.Opciones;
import Reto2.Questions.LaRespuesta;
import Reto2.Questions.ValorCuota;
import Reto2.Questions.ValorCuotaVariable;
import Reto2.Tasks.Abrir;
import Reto2.Tasks.Seleccionar;
import Reto2.Tasks.SeleccionarMal;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class SimularCredito {
	
	@Managed (driver="chrome")
	private WebDriver hisBrowser;
	private Actor david = Actor.named("David");
	
	@Before
	public void configuracionInicial() {
		david.can(BrowseTheWeb.with(hisBrowser));
	}

	@Dado("^que david necesita ingresar a la pagina de simulacion para simular un credito$")
	public void queDavidNecesitaIngresarALaPaginaDeSimulacionParaSimularUnCredito() {
		david.wasAbleTo(Abrir.lapaginaweb());
	}

	@Cuando("^el realiza el registro del mismo en el aplicativo$")
	public void elRealizaElRegistroDelMismoEnElAplicativo(List<Opciones> opciones) {
		david.attemptsTo(Seleccionar.simulacion(opciones));
	}

	@Cuando("^el realiza el registro del mismo en el aplicativo pero le falta un dato$")
	public void elRealizaElRegistroDelMismoEnElAplicativoPeroLeFaltaUnDato(List<Opciones> opciones) {
		david.attemptsTo(SeleccionarMal.simulacionmal(opciones));
	}
	
	@Entonces("^valida el valor de la cuota$")
	public void validaElValorDeLaCuota(List<Opciones> opciones) {
		david.should(GivenWhenThen.seeThat(ValorCuota.total(opciones), Matchers.equalTo(true)));
	}
	
	@Entonces("^valida el valor de la cuota con tasa variable$")
	public void validaElValorDeLaCuotaConTasaVariable(List<Opciones> opciones) {
		david.should(GivenWhenThen.seeThat(ValorCuotaVariable.totalvariable(opciones), Matchers.equalTo(true)));
	}
	
	@Entonces("^valida que salgan mensajes de error$")
	public void validaQueSalganMensajesDeError() {
		david.should(GivenWhenThen.seeThat(LaRespuesta.es(), Matchers.equalTo(true)));
	}

}
