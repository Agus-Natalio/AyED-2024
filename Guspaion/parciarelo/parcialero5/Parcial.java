package parcialero5;

import tp5.ejercicio1.*;

public class Parcial {
	public Vertex<Recinto> search(Graph<Recinto> sitios, String origen){
		for(int i = 0; i < sitios.getSize(); i++) {
			Vertex<Recinto> v = sitios.getVertex(i);
			if(v.getData().getNombre().equals(origen)) {
				return v;
			}
		}
		return null;
	}
	
	public int resolver(Graph<Recinto> sitios, int tiempo) {
		int total = 0;
		Vertex<Recinto> startingVertex = search(sitios, "Entrada");
		if(startingVertex != null) {
			boolean[] visited = new boolean[sitios.getSize()];
			total = resolver(sitios, tiempo - startingVertex.getData().getTiempo(), startingVertex, visited, total, 0);
		}
		return total;
	}
	
	private int resolver(Graph<Recinto> sitios, int tiempo, Vertex<Recinto> vAct, boolean[] visited, int totMax, int totAct) {
		visited[vAct.getPosition()] = true;
		if(tiempo >= 0) {
			totAct++;
			if(totAct > totMax) {
				totMax = totAct;
			}
		} else {
			visited[vAct.getPosition()] = false;
			return totMax;
		}
		for(Edge<Recinto> e: sitios.getEdges(vAct)) {
			Vertex<Recinto> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				totMax = resolver(sitios, tiempo - e.getWeight() - v.getData().getTiempo(), v, visited, totMax, totAct);	
			}
		}
		visited[vAct.getPosition()] = false;
		return totMax;
	}
}