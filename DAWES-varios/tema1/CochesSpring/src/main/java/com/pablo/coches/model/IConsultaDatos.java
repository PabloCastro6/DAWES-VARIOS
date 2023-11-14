package com.pablo.coches.model;

import java.io.BufferedReader;
import java.io.IOException;

public interface IConsultaDatos {

	public BufferedReader accesoADatos(String nombre) throws IOException;
}
