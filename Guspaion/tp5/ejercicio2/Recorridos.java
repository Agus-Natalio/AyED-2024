package tp5.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.*;

public class Recorridos<T> {
	public List<T> dfs(Graph<T> grafo) {
		boolean[] visited = new boolean[grafo.getSize()];
		List<T> L = new LinkedList<T>();
		for(int i = 0; i < grafo.getSize(); i++) {
			if(!visited[i]) {
				System.out.println("largo con: "+grafo.getVertex(i).getData());
				dfs(i, grafo, visited, L);
			}
		}
		return L;
	}
	private void dfs(int i, Graph<T> grafo, boolean[] visited, List<T> L) {
		visited[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		L.add(v.getData());
		System.out.println(v);
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for(Edge<T> e: adyacentes) {
			int j = e.getTarget().getPosition();
			if(!visited[j]) {
				dfs(j, grafo, visited, L);
			}
		}
	}
	
	public List<T> bfs(Graph<T> grafo){
		boolean[] visited = new boolean[grafo.getSize()];
		Queue<Vertex<T>> Q = new Queue<Vertex<T>>();
		List<T> L = new LinkedList<T>();
		Q.enqueue(grafo.getVertex(0));
		while(!Q.isEmpty()) {
			Vertex<T> aux = Q.dequeue();			
			visited[aux.getPosition()] = true;
			L.add(aux.getData());
            for (Edge<T> edge : grafo.getEdges(aux)) {
                Vertex<T> target = edge.getTarget();
                int pos = target.getPosition();
                if (!visited[pos]) {
                    Q.enqueue(target);
                    visited[pos] = true;
                }
            }
		}
		return L;
	}
}
