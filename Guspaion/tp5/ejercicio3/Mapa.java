package tp5.ejercicio3;

import java.util.List;
import java.util.LinkedList;

import tp5.ejercicio1.*;

public class Mapa {
	public Graph<String> mapaCiudades() {
		//Codigo para generar grafo de ciudades
		return null;//Para que no joda este metodo
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
			if(devolverCamino(startingVertex.getPosition(), grafo, visited, L, ciudad2)) {
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
	
	
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		Graph<String> grafo = mapaCiudades();
		List<String> L = new LinkedList<String>();
		List<String> lAux = new LinkedList<String>();
		boolean[] visited = new boolean[grafo.getSize()];
		Vertex<String> startingVertex = grafo.search(ciudad1);
		Ruta min = new Ruta(L, 99999);
		Ruta aux = new Ruta(lAux, 0);
		if(startingVertex != null) {
			caminoMasCorto(grafo, startingVertex, ciudad2, visited, min, aux);
			return min.ciudades;
		}
		return new LinkedList<String>();
	}
	
	private void caminoMasCorto(Graph<String> grafo, Vertex<String> vAct, String ciudad2, boolean[] visited, Ruta min, Ruta aux) {
		visited[vAct.getPosition()] = true;
		aux.ciudades.add(vAct.getData());
		if(vAct.getData().equals(ciudad2)) {
			if(aux.peso < min.peso) {
				min.ciudades = new LinkedList<String>(aux.ciudades);
				min.peso = aux.peso;
			}
		}
		for(Edge<String> e: grafo.getEdges(vAct)) {
			Vertex<String> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				aux.peso+= e.getWeight();
				caminoMasCorto(grafo, v, ciudad2, visited, aux, min);
				aux.peso -= e.getWeight();
			}
		}
		visited[vAct.getPosition()] = false;
		aux.ciudades.remove(aux.ciudades.size()-1);
	}
	
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		Graph<String> grafo = mapaCiudades();
		boolean[] visited = new boolean[grafo.getSize()];
		Vertex<String> startingVertex = grafo.search(ciudad1);
		Ruta camino = new Ruta(new LinkedList<String>(), 0);
		if(startingVertex != null) {
			caminoSinCargarCombustible(grafo, startingVertex, ciudad2, visited, camino, tanqueAuto);
		}
		return camino.ciudades;
	}
	
	private void caminoSinCargarCombustible(Graph<String> grafo, Vertex<String> vAct, String ciudad2, boolean[] visited, Ruta camino, int fuel) {
		visited[vAct.getPosition()] = true;
		camino.ciudades.add(vAct.getData());
		if(vAct.getData().equals(ciudad2)) {
			return;
		}
		for(Edge<String> e: grafo.getEdges(vAct)) {
			Vertex<String> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				camino.peso+= e.getWeight();
				if(camino.peso <= fuel) {
					caminoSinCargarCombustible(grafo, v, ciudad2, visited, camino, fuel);
				}
				camino.peso-= e.getWeight();
			}
		}
		visited[vAct.getPosition()] = false;
		camino.ciudades.remove(camino.ciudades.size() - 1);
	}
	
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		Graph<String> grafo = mapaCiudades();
		boolean[] visited = new boolean[grafo.getSize()];
		Vertex<String> startingVertex = grafo.search(ciudad1);
		Ruta minPath = new Ruta(new LinkedList<String>(), 99999);
		if(startingVertex != null) {
			Ruta auxPath = new Ruta(new LinkedList<String>(), 0);
			int pesoAct = 0;
			caminoConMenorCargaDeCombustible(grafo, startingVertex, ciudad2, visited, minPath, auxPath, tanqueAuto, pesoAct);
		}
		return minPath.ciudades;
	}
	
	private void caminoConMenorCargaDeCombustible(Graph<String> grafo, Vertex<String> vAct, String ciudad2, boolean[] visited, Ruta min, Ruta aux, int fuel, int pesoAct) {
		visited[vAct.getPosition()] = true;
		aux.ciudades.add(vAct.getData());
		if(vAct.getData().equals(ciudad2)) {
			List<String> auxCopy = new LinkedList<String>();
			auxCopy.addAll(aux.ciudades);
			if(pesoAct < min.peso) {
				min.ciudades = new LinkedList<String>(auxCopy);
				min.peso = pesoAct;
			}
			return;
		}
		for(Edge<String> e: grafo.getEdges(vAct)) {
			Vertex<String> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				pesoAct += e.getWeight();
				if(aux.peso + e.getWeight() >= fuel) {
					aux.peso = 0;
				}
				aux.peso+= e.getWeight();
				caminoConMenorCargaDeCombustible(grafo, v, ciudad2, visited, min, aux, fuel, pesoAct);
			}
		}
		visited[vAct.getPosition()] = false;
		aux.ciudades.remove(aux.ciudades.size() - 1);
	}
}

//Ejercicio verguero
