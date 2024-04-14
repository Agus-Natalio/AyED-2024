package tp2.ejercicio7;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> a;
	
	public ParcialArboles(BinaryTree<Integer> bt) {
		this.a = bt;
	}
	
	public boolean isLeftTree(int num) {
		if (a == null) {
			return false;
		}
		int totalIzq = 0;
		int totalDer = 0;
		BinaryTree<Integer> bt = findNode(a, num);
		if(bt == null) {
			return false;
		}
		if(bt.hasLeftChild()) {
			totalIzq = checkSubarboles(bt.getLeftChild());
		} else {
			totalIzq--;
		}
		if(bt.hasRightChild()) {
			totalDer = checkSubarboles(bt.getRightChild());
		} else {
			totalDer--;
		}
		return(totalIzq > totalDer);
	}
	 
	public BinaryTree<Integer> findNode(BinaryTree<Integer> ar, int num){
		if(ar.isEmpty()) {
			return null;
		}
		if(ar.getData() == num) {
			return ar;
		}
		BinaryTree<Integer> result = null;
		if(ar.hasLeftChild()) {
			result = findNode(ar.getLeftChild(), num);
		}
		if(result == null && ar.hasRightChild()) {
			result = findNode(ar.getRightChild(), num);
		}
		return result;
	}
	
	public int checkSubarboles(BinaryTree<Integer> ar) {
		int count = 0;
		if((ar.hasLeftChild() && !ar.hasRightChild()) || (!ar.hasLeftChild() && ar.hasRightChild())) {
			count = 1;
		}
		if(ar.hasLeftChild()) {
			count+= checkSubarboles(ar.getLeftChild());
		}
		if(ar.hasRightChild() ) {
			count+= checkSubarboles(ar.getRightChild());	
		}	
		return count;
	}
	
}
