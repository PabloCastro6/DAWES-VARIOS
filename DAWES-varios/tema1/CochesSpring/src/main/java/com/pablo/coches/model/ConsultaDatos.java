package com.pablo.coches.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class ConsultaDatos implements IConsultaDatos {

	public BufferedReader accesoADatos(String nombre) throws IOException {

		File file = ResourceUtils.getFile("classpath:fichero.txt");
		BufferedReader lector = new BufferedReader(new FileReader(file));
		return lector;

	}
}
