package tp2.ejercicio4postinha;

import tp2.ejercicio2.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> a;
	
	public RedBinariaLlena(BinaryTree<Integer> bt) {
		this.a = bt;
	}
	
	private int retardoReenvio(BinaryTree<Integer> bt) {
		if(bt.isLeaf()) {
			return bt.getData();
		}
		int izq = 0;
		int der = 0;
		if(bt.hasLeftChild()) {
			izq = retardoReenvio(bt.getLeftChild());
		}
		if(bt.hasRightChild()) {
			der = retardoReenvio(bt.getRightChild());
		}
		if(der < izq) {
			return bt.getData() + izq;
		} else {
			return bt.getData() + der;
		}
	}
	
	public int retardoReenvio() {
		return retardoReenvio(this.a);
	}
}