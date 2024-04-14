package tp2.ejercicio4;

import java.util.*;

public class Queue<T> extends Sequence {
	private List<T> data;
	
	public Queue() {
		this.data = new LinkedList<T>();
	}
	
	public boolean isEmpty() {
		return(this.data.isEmpty());
	}
	
	public int size() {
		return(this.data.size());
	}
	
	public void enqueue(T data) {
		this.data.add(data);
	}
	
	public T dequeue() {
		T dato = this.data.get(0);
		this.data.remove(0);
		return dato;
	}
	
	public T head() {
		T dato = this.data.get(0);
		return dato;
	}
	
	public String toString() {
		String rta = "";
		for(int i = 0; i < this.size(); i++) {
			rta+= (i+1)+" "+this.data.get(i).toString()+"\n";
		}
		return rta;
	}
}
