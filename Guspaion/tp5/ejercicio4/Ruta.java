package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;

public class Ruta {
	public List<String> lugares;
	public int peso;
	
	public Ruta(List<String> lugares, int peso) {
		this.lugares = new LinkedList<String>(lugares);
		this.peso = peso;
	}
}
