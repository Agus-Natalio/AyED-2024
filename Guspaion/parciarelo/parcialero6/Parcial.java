package parcialero6;

import tp5.ejercicio1.*;

public class Parcial {
	public Vertex<Recinto> search(Graph<Recinto> sitios, String origen) {
		for(int i = 0; i < sitios.getSize(); i++) {
			Vertex<Recinto> v = sitios.getVertex(i);
			if(v.getData().getNombre().equals(origen)) {
				return v;
			}
		}
		return null;
	}
	
	public String resolver(Graph<Recinto> sitios, int tiempo) {
		Vertex<Recinto> startingVertex = search(sitios, "Entrada");
		if(startingVertex != null) {
			boolean[] visited = new boolean[sitios.getSize()];
			if(resolver(sitios, startingVertex, visited, tiempo - startingVertex.getData().getTiempo())) {
				return "Alcanzo";
			}
		}
		return "No alcanzo";
	}
	
	private boolean allVertexVisited(boolean[] visited) {
		for(boolean v: visited) {
			if(!v) {
				return false;
			}
		}
		return true;
	}
	
	private boolean resolver(Graph<Recinto> sitios, Vertex<Recinto> vAct, boolean[] visited, int tiempo) {
		if(tiempo < 0) {
			return false;
		}
		visited[vAct.getPosition()] = true;
		if(allVertexVisited(visited)) {
			return true;
		}
		for(Edge<Recinto> e: sitios.getEdges(vAct)) {
			Vertex<Recinto> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				if(resolver(sitios, v, visited, tiempo - e.getWeight() - v.getData().getTiempo())) {
					return true;
				}
			}
		}
		visited[vAct.getPosition()] = false;
		return false;
	}
}
