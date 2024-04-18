package ejercicio1;

import java.util.*;

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
}
