package tp5.ejercicio6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.*;

public class BuscadorDeCaminos {
	private Graph<String> bosque; 
	
	public List<List<String>> recorridosMasSeguro(){
		boolean[] visited = new boolean[bosque.getSize()];
		Vertex<String> origen = bosque.search("Casa Caperucita");
		Vertex<String> destino = bosque.search("Casa Abuelita");
		List<List<String>> caminos = new LinkedList<List<String>>();
		if(origen != null && destino != null) {
			List<String> caminoAct = new LinkedList<String>();
			recorridosMasSeguro(origen, destino.getData(), visited, caminoAct, caminos);
		}
		return caminos;
	}
	
	private void recorridosMasSeguro(Vertex<String> vAct, String destino, boolean[] visited, List<String> caminoAct, List<List<String>> caminos) {
		visited[vAct.getPosition()] = true;
		caminoAct.add(vAct.getData());
		if(!vAct.getData().equals(destino)) {
			for(Edge<String> e: bosque.getEdges(vAct)) {
				if(!visited[e.getTarget().getPosition()] && e.getWeight() < 5) {
					recorridosMasSeguro(e.getTarget(), destino, visited, caminoAct, caminos);
				}
			}
		} else {
			caminos.add(new LinkedList<>(caminoAct));
		}
		caminoAct.remove(caminoAct.size() - 1);
		visited[vAct.getPosition()] = false;
	}

  public setBosque(Graph<String> bosque) {
    this.bosque = bosque;
  }
}
