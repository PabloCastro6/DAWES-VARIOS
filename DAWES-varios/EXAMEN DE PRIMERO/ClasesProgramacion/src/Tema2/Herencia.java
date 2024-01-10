package Tema2;

import java.util.ArrayList;
import java.util.List;

import herencia.Animal;
import herencia.Gato;
import herencia.Humano;
import herencia.Pablo;
import herencia.PuedeHablar;

public class Herencia {

	public static void main(String[] args) {

//		Animal animal = new Animal();
//		Gato gato = new Gato();
//		Gato gato2 = gato;
//		Animal humano = new Humano();
//
//		List<Animal> lista = new ArrayList();
//		lista.add(animal);
//		lista.add(humano);
//		lista.add(gato);
//		lista.add(gato2);
//
//		for (Animal a : lista) {
//			System.out.println(a.getPatas());
//			if (a.getPatas() > 2) {
//				System.out.println(a.getPatas());
//			}
//		}
//
//		Gato.miau(); 
//		
//     try {
//    	 gato.setPatas(-3);
//    	 Gato.miau(); 
//     } catch(Exception ex) {
//    	 System.out.println("algo ha ido mal : " + ex.getMessage());
//    	 
//     }
//     
//     
//     Pablo pablo1 = new Pablo();
//     hazHablar(pablo1);

//		System.out.println(gato.getPatas());
//		System.out.println(gato2.getPatas());

//		hazCosas(gato);
//		maullar(gato2);
		
		
		Humano humano = new Humano();
		Humano humano2 = new Humano();
		
		
		if (humano2.compareTo(humano) > 0) {
			
		}

	}

	public static void hazCosas(Animal animal) {

		System.out.println(animal.getPatas());

	}

	public static void maullar(Gato gato3) {
		gato3.miau();

	}
 public static void hazHablar(PuedeHablar animal) {
	 animal.hablar();
	 
	 
 }
 
}
