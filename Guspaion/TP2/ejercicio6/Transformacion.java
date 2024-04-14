package tp2.ejercicio6;

import tp2.ejercicio2.*;

public class Transformacion {
	private BinaryTree<Integer> a;
	
	public Transformacion(BinaryTree<Integer> bt) {
		this.a = bt;
	}
	
	public BinaryTree<Integer> suma() {
		BinaryTree<Integer> t;
		if(a == null) {
			return t = new BinaryTree<Integer>(0);
		}
		t = sumaSubarboles(a);
		return t;
	}
	
	public BinaryTree<Integer> sumaSubarboles(BinaryTree<Integer> ar) {
		if(ar.hasLeftChild()) {
			ar.setData(ar.getLeftChild().getData() + sumaSubarboles(ar.getLeftChild()).getData());
		} else {
			ar.setData(0);
		}
		if(ar.hasRightChild()) {
			ar.setData(ar.getData() + ar.getRightChild().getData() + sumaSubarboles(ar.getRightChild()).getData());
		} else {
			ar.setData(0);
		}
		return ar;
	}
}
