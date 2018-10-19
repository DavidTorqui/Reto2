package Reto2.Questions;

import java.util.List;

import Reto2.Model.Opciones;
import Reto2.UserInterface.IngresarDatos;
import Reto2.Util.EliminarCaracteres;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValorCuota implements Question<Boolean>{
	
	List<Opciones> opciones;
	EliminarCaracteres eliminar= new EliminarCaracteres();
	
	public ValorCuota(List<Opciones> opciones) {
		super();
		this.opciones = opciones;
	}
	
	public static ValorCuota total(List<Opciones> opciones) {
		return new ValorCuota(opciones);
	}

	@Override
	public Boolean answeredBy(Actor actor) {
	String TasaMensual = Text.of(IngresarDatos.TASA_MES_VENCIDA).viewedBy(actor).asString();
	String ValorCuota = Text.of(IngresarDatos.CUOTA_GENERADA).viewedBy(actor).asString();
	String ValorSeguro = Text.of(IngresarDatos.SEGURO_VIDA).viewedBy(actor).asString();
	String ValorCuotaSeguro = Text.of(IngresarDatos.CUOTA_TOTAL).viewedBy(actor).asString();
//	ValorSeguro = ValorSeguro.replaceAll("\\$", "");
//	ValorSeguro = ValorSeguro.replaceAll(",", "");
	TasaMensual = eliminar.eliminaCaracteres(TasaMensual, "%");
	ValorCuota = eliminar.eliminaCaracteres(ValorCuota, "$");
	ValorCuota = eliminar.eliminaCaracteres(ValorCuota, ",");
	ValorSeguro = eliminar.eliminaCaracteres(ValorSeguro, "$");
	ValorSeguro = eliminar.eliminaCaracteres(ValorSeguro, ",");
	ValorCuotaSeguro = eliminar.eliminaCaracteres(ValorCuotaSeguro, "$");
	ValorCuotaSeguro = eliminar.eliminaCaracteres(ValorCuotaSeguro, ",");
	double TasaMensualDouble = Double.parseDouble(TasaMensual);
	double ValorCuotaDouble = Double.parseDouble(ValorCuota);
	double ValorSeguroDouble = Double.parseDouble(ValorSeguro);
	double ValorCuotaSeguroDouble = Double.parseDouble(ValorCuotaSeguro);
	int Plazo = Integer.valueOf(opciones.get(0).getPlazo());
	int Capital = Integer.valueOf(opciones.get(0).getValor());
	double tasaoperacion = TasaMensualDouble / 100;
	double Operacion = 1 + tasaoperacion;
	double Elevar = Math.pow(Operacion, Plazo);
	double Primero = Elevar * tasaoperacion;
	double Segundo = Elevar - 1;
	double Resultado = Primero / Segundo;
	double CuotaParcial = Capital * Resultado;
	CuotaParcial = (double)Math.round(CuotaParcial * 100d) / 100d;
	double CuotaTotal = CuotaParcial + ValorSeguroDouble;
		if (CuotaTotal == ValorCuotaSeguroDouble && CuotaParcial == ValorCuotaDouble) {
			return true;
		}else {
			return false;
		}
	}
}
