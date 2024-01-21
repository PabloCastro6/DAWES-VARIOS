package com.pablo.tienda.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CastroTiendaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastroTiendaSpringApplication.class, args);
	}

	public static String cambiarFormato(String fechaOriginal) {

		DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime fecha = LocalDateTime.parse(fechaOriginal, formatoOriginal);
		DateTimeFormatter nuevoFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaFormateada = fecha.format(nuevoFormato);

		return fechaFormateada;
	}
}
