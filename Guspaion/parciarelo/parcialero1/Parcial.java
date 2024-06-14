package parcialero1;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio2.*;

public class Parcial {
	public List<Integer> resolver(BinaryTree<Integer> ab, int min){
		List<Integer> L = new LinkedList<Integer>();
		int imparAct = 0;
		resolver(ab, min, imparAct, L);
		return L;
	}
	
	public boolean resolver(BinaryTree<Integer> ab, int min, int imparAct, List<Integer> L) {
		L.add(ab.getData());
		if(ab.getData() % 2 != 0) {
			imparAct++;
		}
		if(ab.isLeaf()) {
			return(imparAct >= min);
		} else {
			if(resolver(ab.getLeftChild(), min, imparAct, L)) {
				return true;
			}
			if(resolver(ab.getRightChild(), min, imparAct, L)) {
				return true;
			}
		}
		if(ab.getData() % 2 != 0) {
			imparAct--;	
		}
		L.remove(L.size() - 1);
		return false;
	}
}
