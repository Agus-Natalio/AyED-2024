package parcialero9;

import java.util.List;
import java.util.LinkedList;

import tp5.ejercicio1.*;

public class Parcial {
	private Graph<String> estaciones;
	
	public List<String> buscarCamino(String origen, String destino){
		List<String> L = new LinkedList<String>();
		Vertex<String> startingVertex = this.estaciones.search(origen);
		Vertex<String> endingVertex = this.estaciones.search(destino);
		if(startingVertex != null && endingVertex != null) {
			boolean[] visited = new boolean[this.estaciones.getSize()];
			buscarCamino(startingVertex, visited, destino, L);
		}
		return L;
	}
	
	private boolean buscarCamino(Vertex<String> vAct, boolean[] visited, String destino, List<String> L) {
		visited[vAct.getPosition()] = true;
		L.add(vAct.getData());
		if(vAct.getData().equals(destino)) {
			return true;
		}
		for(Edge<String> e: this.estaciones.getEdges(vAct)) {
			Vertex<String> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				if(buscarCamino(v, visited, destino, L)) {
					return true;
				}
			}
		}
		L.remove(L.size() - 1);
		visited[vAct.getPosition()] = false;
		return false;
	}
}