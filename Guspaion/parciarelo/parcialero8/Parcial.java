package parcialero8;

import java.util.List;
import java.util.LinkedList;

import tp5.ejercicio1.*;

public class Parcial {
	public List<String> resolver(Graph<String> ciudades, String origen, String destino, List<String> pasandoPor) {
		List<String> L = new LinkedList<String>();
		Vertex<String> startingVertex = ciudades.search(origen);
		Vertex<String> endingVertex = ciudades.search(destino);
		if(startingVertex != null && endingVertex != null) {
			boolean[] visited = new boolean[ciudades.getSize()];
			boolean[] visitedNefasto = new boolean[pasandoPor.size()];
			List<String> aux = new LinkedList<String>();
			resolver(ciudades, startingVertex, visited, visitedNefasto, destino, L, aux, pasandoPor, -1);
		}
		return L;
	}
	
	private int visitados(boolean[] visitedNefasto, List<String> path) {
		int n = 0;
		for(int i = 0; i < visitedNefasto.length; i++) {
			if(visitedNefasto[i]) {
				n++;
			}
		}
		return n;
	}
	
	private int resolver(Graph<String> ciudades, Vertex<String> vAct, boolean[] visited, boolean[] visitedNefasto, String destino, List<String> l, List<String> lAct, List<String> pasandoPor, int max) {
		visited[vAct.getPosition()] = true;
		lAct.add(vAct.getData());
		if(pasandoPor.contains(vAct.getData())) {
			visitedNefasto[pasandoPor.indexOf(vAct.getData())] = true;
		}
		if(vAct.getData().equals(destino)) {
			int visitedAct = visitados(visitedNefasto);
			if(visitedAct > max) {
				l.clear();
				l.addAll(lAct);
				max = visitedAct;
			}
			visited[vAct.getPosition()] = false;
			lAct.remove(lAct.size() - 1);
			if (pasandoPor.contains(vAct.getData())) {
           			visitedNefasto[pasandoPor.indexOf(vAct.getData())] = false;
        		}
			return max;
		}
		for(Edge<String> e: ciudades.getEdges(vAct)) {
			Vertex<String> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				max = resolver(ciudades, v, visited, visitedNefasto, destino, l, lAct, pasandoPor, max);
			}
		}
		visited[vAct.getPosition()] = false;
		lAct.remove(lAct.size() - 1);
		if (pasandoPor.contains(vAct.getData())) {
           		visitedNefasto[pasandoPor.indexOf(vAct.getData())] = false;
        	}
		return max;
	}
}




Ejercicio re putisimo
