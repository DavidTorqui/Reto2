#language:es
#Author: your.email@your.domain.com

@tag
Característica: Verificar el funcionamiento de la pantalla de la simulacion de creditos expuesta por el grupo Bancolombia 
								Como usuario
								Quiero ingresar los datos al formulario
								Para validar mi Valor de Cuota 

	@tag1
  Escenario: Simulacion de Cuota
  		Dado que david necesita ingresar a la pagina de simulacion para simular un credito
  		Cuando el realiza el registro del mismo en el aplicativo
  		| queDesea					 | fecha			| tasa				| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Fija   | Crédito de Libre Inversión | 36			| 10000000 |	
  		Entonces valida el valor de la cuota
			| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Fija   	| Crédito de Libre Inversión | 36			| 10000000 |	
 	
 	@tag2
  Escenario: Simulacion de Cuota
  		Dado que david necesita ingresar a la pagina de simulacion para simular un credito
  		Cuando el realiza el registro del mismo en el aplicativo
  		| queDesea					 | fecha			| tasa				| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Fija   | Crédito de Libre Inversión | 48			| 10000000 |	
  		Entonces valida el valor de la cuota
			| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Fija   	| Crédito de Libre Inversión | 48			| 10000000 |
  
  @tag3
  Escenario: Simulacion de Cuota
  		Dado que david necesita ingresar a la pagina de simulacion para simular un credito
  		Cuando el realiza el registro del mismo en el aplicativo
  		| queDesea					 | fecha			| tasa				| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Fija   | Crédito de Libre Inversión | 60			| 10000000 |	
  		Entonces valida el valor de la cuota
			| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Fija   	| Crédito de Libre Inversión | 60			| 10000000 |
  		
  @tag4
  Escenario: Simulacion de Cuota
  		Dado que david necesita ingresar a la pagina de simulacion para simular un credito
  		Cuando el realiza el registro del mismo en el aplicativo
  		| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Variable | Crédito de Libre Inversión | 36			| 10000000 |	
  		Entonces valida el valor de la cuota con tasa variable
			| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Variable	| Crédito de Libre Inversión | 36			| 10000000 |
  		
  @tag5
  Escenario: Simulacion de Cuota
  		Dado que david necesita ingresar a la pagina de simulacion para simular un credito
  		Cuando el realiza el registro del mismo en el aplicativo
  		| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Variable | Crédito de Libre Inversión | 48			| 10000000 |	
  		Entonces valida el valor de la cuota con tasa variable
			| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Variable | Crédito de Libre Inversión | 48			| 10000000 |
  
  @tag6
  Escenario: Simulacion de Cuota
  		Dado que david necesita ingresar a la pagina de simulacion para simular un credito
  		Cuando el realiza el registro del mismo en el aplicativo
  		| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Variable | Crédito de Libre Inversión | 60			| 10000000 |	
  		Entonces valida el valor de la cuota con tasa variable
			| queDesea					 | fecha			| tasa					| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota 	 | 1997-04-03	| Tasa Variable	| Crédito de Libre Inversión | 60			| 10000000 |
  
  		
  @tag7
  Escenario: Simulacion de Cuota Errada
  		Dado que david necesita ingresar a la pagina de simulacion para simular un credito
  		Cuando el realiza el registro del mismo en el aplicativo pero le falta un dato
  		| queDesea					 | fecha			| tasa				| producto									 | plazo	| valor		 | 
  		| Simula tu Cuota  	 | 1997-04-03	| Tasa Fija   | 													 |  48		| 10000000 |	
  		Entonces valida que salgan mensajes de error
	
