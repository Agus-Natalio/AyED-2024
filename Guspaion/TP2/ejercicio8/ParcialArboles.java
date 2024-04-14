package tp2.ejercicio8;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	public static boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		if(a1.getData() != a2.getData()) {
			return false;
		}
		boolean result = true;
		if(a1.hasLeftChild()) {
			if(a2.hasLeftChild()) {
				result = esPrefijo(a1.getLeftChild(), a2.getLeftChild());
			} else {
				return false;
			}
		}
		if(result && a1.hasRightChild()) {
			if(a2.hasRightChild()) {
				result = esPrefijo(a1.getRightChild(), a2.getRightChild());
			} else {
				return false;
			}
		}
		return result;
	}
}
