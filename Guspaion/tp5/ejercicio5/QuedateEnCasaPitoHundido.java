package tp5.ejercicio5;

import java.util.List;
import java.util.LinkedList;

import tp5.ejercicio1.*;

public class QuedateEnCasaPitoHundido {
	
	public List<List<Persona>> carteraJubilados(Graph<Persona> grafo, int gradoSeparacion) {
		boolean[] visited = new boolean[grafo.getSize()];
		List<List<Persona>> carteraEmpleados = new LinkedList<List<Persona>>();
	    for (int i = 0; i < grafo.getSize(); i++) {
	        Vertex<Persona> v = grafo.getVertex(i);
	        if (v.getData().empleado && !visited[v.getPosition()]) {
	            List<Persona> cartera = new LinkedList<Persona>();
	            int distancia = 0;
	            carteraJubilados(grafo, v, cartera, gradoSeparacion, visited, distancia);
	            carteraEmpleados.add(cartera);
	        }
	    }
		return carteraEmpleados;
	}
	
	private void carteraJubilados(Graph<Persona> grafo, Vertex<Persona> v, List<Persona> cartera, int gradoSeparacion, boolean[] visited, int distancia){
		visited[v.getPosition()] = true;
		Persona p = v.getData();
		if(cartera.size() < 40) {
			if(p.jubilado && !visited[v.getPosition()]) {
				cartera.add(p);
			}
			for(Edge<Persona> e: grafo.getEdges(v)) {
				if(distancia < gradoSeparacion) {
					carteraJubilados(grafo, e.getTarget(), cartera, gradoSeparacion, visited, distancia+1);
				}
			}
		}
	}
}
