package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;

public class GeneralTree<T> {
	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();
	
	public GeneralTree(T data){
		this.data = data;
	}
	
	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this.data = data;
		this.children = children;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if(children != null) {
			this.children = children;
		}
	}
	
	public void addChild(GeneralTree<T> child) {
		getChildren().add(child);
	}
	
	public boolean hasChildren() {
		return (this.children != null);
	}
	
	public boolean isLeaf() {
		return (!this.hasChildren());
	}
	
	public boolean isEmpty() {
		return(this.data == null && !this.hasChildren());
	}
	
	public void removeChild(GeneralTree<T> child) {
		if(this.hasChildren()) {
			this.getChildren().remove(child);
		}
	}
	
	public int altura() {
		Queue<GeneralTree<T>> Q = new Queue<GeneralTree<T>>();
		int lvl = 0;
		Q.enqueue(this);
		Q.enqueue(null);
		while(!Q.isEmpty()) {
			GeneralTree<T> aux = Q.dequeue();
			if(aux != null) {
				List<GeneralTree<T>> children = aux.getChildren();
				for(GeneralTree<T> child: children) {
					Q.enqueue(child);
				}
			} else if(!Q.isEmpty()) {
				lvl ++;
				Q.enqueue(null);
			}
		}
		return lvl;
	}
	
	@SuppressWarnings("unused")
	public int nivel(T dato) {
		Queue<GeneralTree<T>> Q = new Queue<GeneralTree<T>>();
		int lvl = 0;
		Q.enqueue(this);
		Q.enqueue(null);
		while(!Q.isEmpty()) {
			GeneralTree<T> aux = Q.dequeue();
			if(aux.getData() == dato) {
				return lvl;
			}
			if(aux != null) {
				List<GeneralTree<T>> children = aux.getChildren();
				for(GeneralTree<T> child: children) {
					Q.enqueue(aux);
				}
			} else if (!Q.isEmpty()) {
				lvl++;
				Q.enqueue(null);
			}
		}
		lvl = -1;
		return lvl;
	}
	
	public int ancho() {
		Queue<GeneralTree<T>> Q = new Queue<GeneralTree<T>>();
		int cantNodos = 0;
		int maxNodos = 0;
		Q.enqueue(this);
		Q.enqueue(null);
		while(!Q.isEmpty()) {
			GeneralTree<T> aux = Q.dequeue();
			if(aux != null) {
				cantNodos++;
				List<GeneralTree<T>> children = aux.getChildren();
				for(GeneralTree<T> child: children){
					Q.enqueue(child);
				}
			} else if (!Q.isEmpty()) {
				if(maxNodos < cantNodos) {
					maxNodos = cantNodos;
				}
				Q.enqueue(null);
			}
		}
		return maxNodos;
	}
	
	public List<T> imprimirPorNiveles() {
		List<T> result = new LinkedList<T>();
		Queue<GeneralTree<T>> Q = new Queue<GeneralTree<T>>();
		Q.enqueue(this);
		while(!Q.isEmpty()) {
			GeneralTree<T> aux = Q.dequeue();
			result.add(aux.getData());
			List<GeneralTree<T>> children = aux.getChildren();
			for(GeneralTree<T> child: children) {
				Q.enqueue(child);
			}
		}
		return result;
	}
}
