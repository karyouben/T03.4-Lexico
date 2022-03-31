package fp.lexico.test;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import fp.lexico.LectorTexto;
import fp.lexico.Lexico;

public class TestLexico {

	public static void main(String[] args) {
		LectorTexto lector1 = new LectorTexto();
		lector1.agregaFichero("./res/lazarillo.txt", StandardCharsets.UTF_8);
		System.out.println("LECTOR 1");
		System.out.println(lector1.getPalabras().subList(0, 100));
	
		LectorTexto lector2 = new LectorTexto();
		System.out.println("LECTOR 2");
		lector2.agregaFichero("./res/platero.txt", StandardCharsets.UTF_8);
		System.out.println(lector2.getPalabras().subList(0,100));
		

//		List<String> palabras = List.of("Hola", "Adios");
//		Lexico l = new Lexico(palabras);
//		System.out.println(l);
//		SortedSet<String> ss = l.getPalabras();
//		ss.add("HOLA");
		
		Lexico l1 = new Lexico(lector1.getPalabras());
		System.out.println("Num palabras Lazarillo " + l1.getTotalPalabras());
		
		Lexico l2 = new Lexico(lector2.getPalabras());
		System.out.println("Num palabras Lazarillo " + l2.getTotalPalabras());
		
		System.out.println("Las palabras comunes a ambos lexicos son ");
		Set<String> c = l1.getPalabrasComunes(l2);
		for (String palabra: c) {
			System.out.println(palabra);
		}
		
	}

}
