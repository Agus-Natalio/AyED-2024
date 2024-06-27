package parcialero7;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.*;

public class Parcial {
	private Vertex<Ciudad> search(Graph<Ciudad> ciudades, String objetivo) {
		for(int i = 0; i < ciudades.getSize(); i++){
			Vertex<Ciudad> v = ciudades.getVertex(i);
			if(v.getData().getNombre().equals(objetivo)) {
				return v;
			}
		}
		return null;
	}
	
	public List<Ciudad> resolver(Graph<Ciudad> ciudades, String origen, String destino){
		List<Ciudad> L = new LinkedList<Ciudad>();
		Vertex<Ciudad> startingVertex = search(ciudades, origen);
		Vertex<Ciudad> endingVertex = search(ciudades, destino);
		if(startingVertex != null && endingVertex != null) {
			boolean[] visited = new boolean[ciudades.getSize()];
			resolver(ciudades, visited, startingVertex, L, destino);
		}
		return L;
	}
	
	private boolean resolver(Graph<Ciudad> ciudades, boolean[] visited, Vertex<Ciudad> vAct, List<Ciudad> L, String destino) {
		visited[vAct.getPosition()] = true;
		L.add(vAct.getData());
		if(vAct.getData().getNombre().equals(destino)) {
			return true;
		} else {
			if(vAct.getData().getFase() <= 1) {
				L.remove(L.size() - 1);
				visited[vAct.getPosition()] = false;
				return false;
			}
		}
		for(Edge<Ciudad> e: ciudades.getEdges(vAct)) {
			Vertex<Ciudad> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				if(resolver(ciudades, visited, v, L, destino)) {
					return true;
				}
			}
		}
		visited[vAct.getPosition()] = false;
		L.remove(L.size() - 1);
		return false;
	}
}