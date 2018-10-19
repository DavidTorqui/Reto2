package Reto2.Util;

public class EliminarCaracteres {

	public String eliminaCaracteres(String s_cadena, String s_caracteres)
	{
	  String nueva_cadena = "";
	  Character caracter = null;
	  boolean valido = true;
	 
	  for (int i=0; i<s_cadena.length(); i++)
	      {
	       valido = true;
	       for (int j=0; j<s_caracteres.length(); j++)
	           {
	            caracter = s_caracteres.charAt(j);
	 
	            if (s_cadena.charAt(i) == caracter)
	               {
	                valido = false;
	                break;
	               }
	           }
	       if (valido)
	           nueva_cadena += s_cadena.charAt(i);
	      }
	 
	  return nueva_cadena;
	}
}
