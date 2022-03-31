package fp.lexico;

import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lexico {
	
	//Atributos
	private SortedSet<String> palabras;
	
	//C1: Constructor sin parámetros
	public Lexico() {
		palabras = new TreeSet<String>();
	}
	
	//C2: Constructor con un parámetro de tipo Collection
	public Lexico(Collection<String> palabras) {
		this.palabras = new TreeSet<String>();
		agregarPalabras(palabras);
		
	}
	//Métodos consultores (getter)
	public SortedSet<String> getPalabras(){
		return new TreeSet<String>(palabras);
		
		
	}
	public Integer getTotalPalabras() {
		return palabras.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palabras == null) ? 0 : palabras.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Lexico))
			return false;
		Lexico other = (Lexico) obj;
		if (palabras == null) {
			if (other.palabras != null)
				return false;
		} else if (!palabras.equals(other.palabras))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lexico [palabras=" + palabras + "]";
	}
	public void agregarPalabra (String palabra) {
		palabras.add(palabra.toLowerCase());
	}
	
	public void agregarPalabras(Collection<String> palabras) {
		for (String palabra:palabras) {
			agregarPalabra(palabra);
		}
	}
	
	public Set<String> getPalabrasComunes(Lexico lexico){
		Set<String> interseccion = lexico.getPalabras();
		interseccion.retainAll(this.palabras);
		return interseccion;
		
	}
	public Set<String> getTodasPalabras(Lexico lexico){
		Set<String> union = lexico.getPalabras();
		union.retainAll(this.palabras);
		return union;
		
	}
	public Set<String> getDiferenciaPalabras(Lexico lexico){
		Set<String> diferencia = this.getPalabras();
		diferencia.removeAll(lexico.getPalabras());
		return diferencia;
		
	}

}
