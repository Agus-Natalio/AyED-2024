package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.*;

public class VisitaOslo {
	public List<String>paseoEnBici (Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
		boolean[] visited = new boolean[lugares.getSize()];
		for(String lugar: lugaresRestringidos) {
			Vertex<String> lugarRestringido = lugares.search(lugar);
			visited[lugarRestringido.getPosition()] = true;
		}
		Ruta path = new Ruta(new LinkedList<String>(), 0);
		Vertex<String> startingVertex = lugares.search("Ayuntamiento");
		if(startingVertex != null && lugares.search(destino) != null) {
			paseoEnBici(lugares, startingVertex, visited, destino, maxTiempo, path);
		}
		return path.lugares;
	}
	
	private void paseoEnBici(Graph<String> lugares, Vertex<String> vAct, boolean[] visited, String destino, int maxTiempo, Ruta path) {
		visited[vAct.getPosition()] = true;
		path.lugares.add(vAct.getData());
		if(vAct.getData().equals(destino)) {
			return;
		}
		for(Edge<String> e: lugares.getEdges(vAct)) {
			Vertex<String> v = e.getTarget();
			if(!visited[v.getPosition()]) {
				path.peso+= e.getWeight();
				if(path.peso <= maxTiempo) {
					paseoEnBici(lugares, v, visited, destino, maxTiempo, path);
				}
				path.peso-= e.getWeight();
			}
		}
		visited[vAct.getPosition()] = false;
		path.lugares.remove(path.lugares.size() - 1);
	}
}
