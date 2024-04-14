package tp2.ejercicio2;

import java.util.*;

public class Queue<T> extends Sequence {
	List<T> data;
	
	public Queue() {
		data = new LinkedList<T>();
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public void enqueue(T dato) {
		data.add(dato);
	}
	
	public T dequeue() {
		T aux = data.get(0);
		data.remove(0);
		return aux;
	}
	
	public T head() {
		return data.get(0);
	}
	
	public String toString() {
		String str = "";
		for (T dato: data) {
			str += dato+" ";
		}
		return str;
	}
}
