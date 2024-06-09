package tp5.ejercicio1;

public interface Edge<T> {
	public Vertex<T> getTarget();//Retorna el vertice destino de la arista
	
	public int getWeight();//Retorna el peso de la arista
}
