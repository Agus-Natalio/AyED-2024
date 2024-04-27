package tp3.ejercicio7;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> tree;
	
	public Caminos(GeneralTree<Integer> ab) {
		tree = ab;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> caminoMax = new LinkedList<Integer>();
		List<Integer> caminoAct = new LinkedList<Integer>();
		caminoAHojaMasLejana(this.tree, caminoMax, caminoAct);
		return caminoMax;
	}
	
	private void caminoAHojaMasLejana(GeneralTree<Integer> a, List<Integer> lMax, List<Integer> lAct){
		if(a != null) {
			lAct.add(a.getData());
			if(a.isLeaf()) {
				if(lMax.size() < lAct.size()) {
					lMax.clear();
					lMax.addAll(lAct);
				}
			} else {
				for(GeneralTree<Integer> child: a.getChildren()) {
					caminoAHojaMasLejana(child, lMax, lAct);
				}
			}
		}
		lAct.remove(lAct.size() - 1);
	}
}
