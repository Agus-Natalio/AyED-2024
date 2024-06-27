import java.util.LinkedList;
import java.util.List;

public class Mapa {
  public Graph<String> mapaCiudades;

  public List<String> devolverCamino(String ciudad1, String ciudad2) {
    LinkedList<String> resultList = dfs(mapaCiudades, ciudad1, ciudad2);
    if(resultLis.getLast().equals(ciudad2)) {
      return resultList;
    } else {
      return LinkediList<String>("");
    }
  }
  
  private List<String> dfs(Graph<String> grafo, String startCity, String endCity) {
    boolean[] visited = new boolean[grafo.getSize()];
    List<String> L = new LinkedList<String>();
    int startIndex = grafo.search(startCity);
    if(!visited[startIndex]) {
      System.out.println("Voy por: "+grafo.getVertex(i).getData());
      dfs(i, grafo, visited, L);
    }
    return L;
  }

  private void dfs(int i, Graph<String> grafo, boolean[] visited, List<String> L) {
    visited[i] = true;
    Vertex<String> v = grafo.getVertex(i);
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
}
