package Tema2;

import java.util.ArrayList;

public class Persona {
String nombre;
int edad;

Persona padre;
ArrayList <Persona> hijos;
ArrayList <Persona> hermanos;


public Persona(String nombre, int edad) {
	this.nombre = nombre;
	this.edad = edad;
	
}

public String getNombre () {
	return this.nombre;
}
}
