package parcialero4;

import java.util.List;
import java.util.LinkedList;

import tp5.ejercicio1.*;

public class Parcial {
	
	public class Ciudad {
		String nombre;
		int transito;
		
		public Ciudad(String nombre, int transito) {
			this.nombre = nombre;
			this.transito = transito;
		}
		
		public String getNombre() {
			return this.nombre;
		}
		
		public int getTransito() {
			return this.transito;
		}
	}
	
	public Vertex<Ciudad> buscar(Graph<Ciudad> ciudades, String dato){
		for(int i = 0; i < ciudades.getSize(); i++) {
			Vertex<Ciudad> v = ciudades.getVertex(i);
			if(v.getData().nombre.equals(dato)) {
				return v;
			}
		}
		return null;
	}
	
	public int resolver(Graph<Ciudad> ciudades, String origen, String destino, int maxControles) {
		Vertex<Ciudad> startingVertex = buscar(ciudades, origen);
		int transitoMax = 0;
		if(startingVertex != null) {
			boolean[] visited = new boolean[ciudades.getSize()];
			transitoMax = resolver(ciudades, startingVertex, visited, destino, maxControles, 0, 0);
		}
		return transitoMax;
	}
	
	private int resolver(Graph<Ciudad> ciudades, Vertex<Ciudad> vAct, boolean[] visited, String destino, int maxControles, int tMax, int tAct) {
		visited[vAct.getPosition()] = true;
		if(vAct.getData().getNombre().equals(destino)) {
			tAct+= vAct.getData().getTransito();
			if(tMax < tAct) {
				tMax = tAct;
			}
		} else {
			for(Edge<Ciudad> e: ciudades.getEdges(vAct)) {
				Vertex<Ciudad> v = e.getTarget();		
				if(!visited[v.getPosition()] && e.getWeight() <= maxControles) {
					tMax = resolver(ciudades, v, visited, destino, maxControles, tMax, tAct + vAct.getData().getTransito());
				}
			}	
		}
		visited[vAct.getPosition()] = false;
		return tMax;
	}
}