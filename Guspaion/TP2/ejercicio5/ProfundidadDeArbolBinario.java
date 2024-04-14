package tp2.ejercicio5;

import tp2.ejercicio2.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> a;
	
	public ProfundidadDeArbolBinario(Integer data) {
		a = new BinaryTree<Integer>(data);
	}
	
	public int sumaElementosProfundidad(int p) {
		if(a == null) {
			return 0;
		}
		Queue<BinaryTree<Integer>> Q = new Queue<BinaryTree<Integer>>();
		Q.enqueue(a);
		int lvl = 0;
		int total = 0;
		double cantNodos;
		BinaryTree<Integer> act;
		while(!Q.isEmpty()) {
			cantNodos = Math.pow(2, lvl);
			if(lvl < p) {
				for(int i = 0; i < cantNodos; i++) {
					act = Q.dequeue();
					if(act.hasLeftChild()) {
						Q.enqueue(act.getLeftChild());
					}	
					if(act.hasRightChild()) {
						Q.enqueue(act.getRightChild());
					}
				}
				lvl++;
			} else {
				for(int i = 0; i < cantNodos; i++) {
					act = Q.dequeue();
					total+= act.getData();
				}
			}
		}
		return total;
	}
}
