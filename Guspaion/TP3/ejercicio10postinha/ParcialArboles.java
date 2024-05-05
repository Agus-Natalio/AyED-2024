package tp3.ejercicio10postinha;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	static int max = -1;
	static List<Integer> res = new LinkedList<Integer>();
	static List<Integer> lAct = new LinkedList<Integer>();
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		if(arbol != null) {
			res = resolver(arbol, 0, 0);
		}
		return res;
	}
	
	private static List<Integer> resolver(GeneralTree<Integer> ab, int lvl, int pesoAct){
		if(ab.isLeaf()) {
			if(ab.getData() == 1) {
				lAct.add(1);
				pesoAct+= lvl;
			}
			if(max < pesoAct) {
				max = pesoAct;
				res.clear();
				res.addAll(lAct);
			}
		} else {
			if(ab.getData() == 1) {
				lAct.add(1);
				pesoAct+= lvl;
			}
			for(GeneralTree<Integer> child: ab.getChildren()) {
				resolver(child, (lvl+1), pesoAct);
			}
		}
		lAct.remove(lAct.size()-1);
		return res;
	}
}
