package com.pablo.descuentos.modelo;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component("consultaBBDD")
public class ConsultaBBDD  implements IConsultaDatos{

	@Override
	public Integer consultaEdad(String nombre) throws IOException {
		System.out.println("me conecto a la BBDD y obtengo el valor");
		return 40;
	}

}
