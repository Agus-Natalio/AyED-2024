public interface Graph<T> {
  public Vertex<T> createVertex(T data);
  
  public void removeVertex(Vertex<T> vertex);
  
  public Vertex<T> search(T data);
  
  public void connect(Vertex<T> origin, Vertex<T> destination);
  
  public void connect(Vertex<T> origin, Vertex<T> destination, int weight);
  
  public void disconnect(Vertex<T> origin,Vertex<T> destination);
  
  public boolean existsEdge(Vertex<T> origin, Vertex<T> destination);
  
  public int weight(Vertex<T> origin, Vertex<T> destination);
  
  public boolean isEmpty();
  
  public List<Vertex<T>> getVertexes();
  
  public List<Edge<T>> getEdges(Vertex<T> v);
  
  public int getSize();
}