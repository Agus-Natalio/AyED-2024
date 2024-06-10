package tp5.ejercicio3;

import java.util.List;
import java.util.LinkedList;

import tp5.ejercicio1.*;

public class Mapa {
	public Graph<String> mapaCiudades() {
		//Codigo para generar grafo de ciudades
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
		Graph<String> grafo = mapaCiudades();
		return devolverCamino(grafo, camino, ciudad1, ciudad2);
	}
	
	private List<String> devolverCamino(Graph<String> grafo, List<String> L,String ciudad1, String ciudad2){
		boolean[] visited = new boolean[grafo.getSize()];
		Vertex<String> startingVertex = grafo.search(ciudad1);
		if(startingVertex != null) {
			if(devolverCamino(startingVertex.getPosition(), grafo, visited, camino, ciudad2)) {
				return L;
			}
		}
		return new LinkedList<String>();
	}
	
	private boolean devolverCamino(int i, Graph<String> grafo, boolean[] visited, List<String> L, String ciudad2) {
		visited[i] = true;
		Vertex<String> v = grafo.getVertex(i);
		L.add(v.getData());
		if(v.getData().equals(ciudad2)) {
			return true;
		}
		List<Edge<String>> adyacentes = grafo.getEdges(v);
		for(Edge<String> e: adyacentes) {
			int j = e.getTarget().getPosition();
			if(!visited[j]) {
				if(devolverCamino(j, grafo, visited, L, ciudad2)) {
					return true;
				}
			}
		}
		L.remove(L.size()-1);
		return false;
	}

	
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new LinkedList<String>();
		Graph<String> grafo = mapaCiudades();
		return devolverCaminoExceptuando(grafo, camino, ciudad1, ciudad2, ciudades);
	}
	
	private List<String> devolverCaminoExceptuando(Graph<String> grafo, List<String> L, String ciudad1, String ciudad2, List<String> ciudades){
		boolean[] visited = new boolean[grafo.getSize()];
		Vertex<String> startingVertex = grafo.search(ciudad1);
        for (String ciudadAct : ciudades) {
            Vertex<String> vertex = grafo.search(ciudadAct);
            if (vertex != null) {
                visited[vertex.getPosition()] = true;
            }
        }
		if(startingVertex != null) {
			if(devolverCamino(startingVertex.getPosition(), grafo, visited, L, ciudad2)) {
				return L;
			}
		}
		return new LinkedList<String>();
	}
}