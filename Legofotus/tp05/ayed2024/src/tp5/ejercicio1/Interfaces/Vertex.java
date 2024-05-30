public interface Vertex<T> {
  private T data;
  private int position;
  
  public T getData() {
    return data;
  }
  
  public void setData(newData: T) {
    data = newData;
  }
  
  public int getPosition() {
    return position;
  }
}