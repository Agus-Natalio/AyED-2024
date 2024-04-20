package tp3.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio4.Queue;
import tp3.ejercicio1.GeneralTree;

public class RecorridosAG {
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
	    List<Integer> L = new LinkedList<Integer>();
	    List<GeneralTree<Integer>> children = a.getChildren();
	    if (a.getData() > n && a.getData() % 2 != 0) {
	        L.add(a.getData());
	    }
	    for (GeneralTree<Integer> child : children) {
	        L.addAll(numerosImparesMayoresQuePreOrden(child, n));
	    }
	    return L;
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> L = new LinkedList<Integer>();
		List<GeneralTree<Integer>> children = a.getChildren();
		if(!children.isEmpty()) {
			L.addAll(numerosImparesMayoresQueInOrden(children.get(0),n));
		}
		if(a.getData() > n && a.getData() % 2 != 0) {
			L.add(a.getData());
		}
		if(!a.isLeaf()) {
			for(int i = 1; i < children.size(); i++) {
				L.addAll(numerosImparesMayoresQueInOrden(children.get(i),n));
			}	
		}
		return L;
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> L = new LinkedList<Integer>();
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child: children) {
			L.addAll(numerosImparesMayoresQuePostOrden(child, n));
		}
		if(a.getData() > n && a.getData() % 2 != 0) {
			L.add(a.getData());
		}
		return L;
	}
	
	public List<Integer> numeroImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> L = new LinkedList<Integer>();
		Queue<GeneralTree<Integer>> Q = new Queue<GeneralTree<Integer>>();
		Q.enqueue(a);
		while(!Q.isEmpty()) {
			GeneralTree<Integer> aux = Q.dequeue();
			if(aux.getData() > n && aux.getData() % 2 != 0) {
				L.add(aux.getData());
			}
			List<GeneralTree<Integer>> children = a.getChildren();
			for(GeneralTree<Integer> child : children) {
				Q.enqueue(child);
			}
		}
		return L;
	}

	/*Al trabajarlo en el mismo GeneralTree.java no habria mucho para modificar (creo)*/
}
