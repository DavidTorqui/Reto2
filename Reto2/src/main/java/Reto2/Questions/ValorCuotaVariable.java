package Reto2.Questions;

import java.util.List;

import Reto2.Model.Opciones;
import Reto2.UserInterface.IngresarDatos;
import Reto2.Util.EliminarCaracteres;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValorCuotaVariable implements Question<Boolean>{
	
	List<Opciones> opciones;
	EliminarCaracteres eliminar= new EliminarCaracteres();
	
	public ValorCuotaVariable(List<Opciones> opciones) {
		super();
		this.opciones = opciones;
	}
	
	public static ValorCuotaVariable totalvariable(List<Opciones> opciones) {
		return new ValorCuotaVariable(opciones);
	}

	@Override
	public Boolean answeredBy(Actor actor) {
	String TasaMensual = Text.of(IngresarDatos.TASA_MES_VENCIDA).viewedBy(actor).asString();
	String ValorCuota = Text.of(IngresarDatos.CUOTA_GENERADA).viewedBy(actor).asString();
	String ValorSeguro = Text.of(IngresarDatos.SEGURO_VIDA).viewedBy(actor).asString();
	String ValorCuotaSeguro = Text.of(IngresarDatos.CUOTA_TOTAL).viewedBy(actor).asString();
	TasaMensual = TasaMensual.replaceAll("\\%", "");
	TasaMensual = TasaMensual.replaceAll(",", "");
	ValorCuota = ValorCuota.replaceAll("\\$", "");
	ValorCuota = ValorCuota.replaceAll(",", "");
	ValorSeguro = ValorSeguro.replaceAll("\\$", "");
	ValorSeguro = ValorSeguro.replaceAll(",", "");
	ValorCuotaSeguro = ValorCuotaSeguro.replaceAll("\\$", "");
	ValorCuotaSeguro = ValorCuotaSeguro.replaceAll(",", "");
	double TasaMensualDouble = Double.parseDouble(TasaMensual);
	double ValorCuotaDouble = Double.parseDouble(ValorCuota);
	double ValorSeguroDouble = Double.parseDouble(ValorSeguro);
	double ValorCuotaSeguroDouble = Double.parseDouble(ValorCuotaSeguro);
	double Plazo = Integer.valueOf(opciones.get(0).getPlazo());
	double Capital = Integer.valueOf(opciones.get(0).getValor());
	double tasaoperacion = TasaMensualDouble / 100;
	double Operacion = Capital * tasaoperacion;
	double Dividir = Capital / Plazo;
	double CuotaParcial = Operacion +  Dividir;
	CuotaParcial = (double)Math.round(CuotaParcial * 100d) / 100d;
	double CuotaTotal = CuotaParcial + ValorSeguroDouble;
		if (CuotaTotal == ValorCuotaSeguroDouble && CuotaParcial == ValorCuotaDouble) {
			return true;
		}else {
			return false;
		}
	}
}