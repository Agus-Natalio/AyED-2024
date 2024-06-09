package tp5.ejercicio1;

import java.util.List;

public interface Graph<T> {
	public Vertex<T> createVertex(T data);//Crea un vertice con el dato recibido
	
	public void removeVertex(Vertex<T> vertex);//Elimina el vertice del grafo, si el vertice esta relacionado con otros, tambien elimina las relaciones
	
	public Vertex<T> search(T data);//Busca y retorna el primer vertice cuyo dato es igual al parametro ingresado o null si no lo encuentra

	public void connect(Vertex<T> origin, Vertex<T> destination);//Conecta el vertice origen con el vertice destinto, previo chequea si ambos existen

	public void connect(Vertex<T> origin, Vertex<T> destination, int weight);//Conecta el vertice origen con el vertice destino añadiendo un peso en las aristas, previo chequea que ambos vertices existan

	public void disconnect(Vertex<T> origin, Vertex<T> destination);//Desconecta el vertice origen del vertice destino, previo chequea que ambos existan. Si la conexion es destino --> origen no realiza ningun cambio
	
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination);//Retorna true si existe una arista entre el vertice origen y el destino
	
	public List<Vertex<T>> getVertices();//Retorna la lista de vertices

	public int weight(Vertex<T> origin, Vertex<T> destination);//Retorna el peso entre dos vertices, si no existe la arista retorna 0
	
	public boolean isEmpty();
	
	public List<Edge<T>> getEdges(Vertex<T> v);//Retorna la lista de adyacentes al vertice recibido
	
	public Vertex<T> getVertex(int position);//Obtiene el vertice para la posicion recibida
	
	public int getSize();//Retorna la cantidad de vertices del grafo
}
