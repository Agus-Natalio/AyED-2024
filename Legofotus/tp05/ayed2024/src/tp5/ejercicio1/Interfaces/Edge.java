public interface Edge<T> {
  private Vertex<T> target;
  private int weight;
  
  public Vertex<T> getTarget() {
    return target;
  }
  
  public int getWeight() {
    return weight;
  }
}