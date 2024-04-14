package tp2.ejercicio5;

import java.util.*;

public class Queue<T> extends Sequence {
	private LinkedList<T> data;
	
	public Queue() {
		data = new LinkedList<T>();
	}
	
	public int size() {
		return this.data.size();
	}
	
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	
	public void enqueue(T dato) {
		this.data.add(dato);
	}
	
	public T dequeue() {
		T dato = this.data.get(0);
		this.data.remove(0);
		return dato;
	}
	
	public T head() {
		return(this.data.get(0));
	}
	
	public String toString() {
		String rta = "";
		for(int i = 0; i < this.size(); i++) {
			rta+=(i+1)+" - "+this.data.get(i)+"\n";
		}
		return rta;
	}
}
