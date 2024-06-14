package parcialero2;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.*;

public class Parcial {
	public class Estadio {
		String estadio;
		String ciudad;
		
		public Estadio(String estadio, String ciudad) {
			this.estadio = estadio;
			this.ciudad = ciudad;
		}
	}
	
	public List<String> estadios(Graph<Estadio> mapa, String origen, int cantKm){
		int i = 1;
		List<String> L = new LinkedList<String>();
		Vertex<Estadio> startingStadium = mapa.getVertex(0);
		while(i < mapa.getSize() && !startingStadium.getData().estadio.equals(origen)) {
			startingStadium = mapa.getVertex(i);
			i++;
		}
		if(startingStadium.getData().estadio.equals(origen)) {
			List<String> lAct = new LinkedList<String>();
			boolean[] visited = new boolean[mapa.getSize()];
			estadios(mapa, startingStadium, cantKm, visited, L, lAct);
		}
		return L;
	}
	
	private void estadios(Graph<Estadio> mapa, Vertex<Estadio> vAct, int cantKm, boolean[] visited, List<String> L, List<String> lAct) {
		visited[vAct.getPosition()] = true;
		lAct.add(vAct.getData().estadio);
		if(lAct.size() > L.size()) {
			L.clear();
			L.addAll(lAct);
		}
		for(Edge<Estadio> e: mapa.getEdges(vAct)) {
			Vertex<Estadio> v = e.getTarget();
			if(!visited[v.getPosition()] && cantKm - e.getWeight() >= 0) {
				estadios(mapa, v, cantKm - e.getWeight(), visited, L, lAct);	
			}
		}
		visited[vAct.getPosition()] = false;
		lAct.remove(lAct.size() - 1);
	}
}