package com.pablo.negocio;

import java.io.IOException;

import com.pablo.model.ConsultaDatos;

public class CalculoIMC {
	
	public Double calculaIMC(String nombre) throws IOException {
		
		ConsultaDatos consulta = new ConsultaDatos();
		String linea = consulta.accesoDatos(nombre);
		
		String[] datos = linea.split("-");
		int peso = Integer.parseInt(datos[1]);
		double altura = (Double.parseDouble(datos[2]))/100;
		double iMC = peso/altura;
		return iMC;
	}
}