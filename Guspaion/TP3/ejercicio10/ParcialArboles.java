package tp3.ejercicio10;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	public static List<Integer> resolver(GeneralTree<Integer> ab) {
		List<Integer> lMax = new LinkedList<Integer>();
		lMax = resolver(ab, 0, -1, lMax);
		return lMax;
	}
	
	private static List<Integer> resolver(GeneralTree<Integer> ab, int lvl, int max, List<Integer> lMax){
		List<Integer> lAct = new LinkedList<Integer>();
		if(ab != null) {
			lAct.add(ab.getData());
			if(ab.isLeaf()) {
				int total = 0;
				for(int i: lAct) {
					total+= i * lvl;
					lvl--;
				}
				if(max < total) {
					max = total;
					lMax.clear();
					for(int i: lAct) {
						if(i > 0) {
							lMax.add(i);
						}
					}
				}
			} else {
				for(GeneralTree<Integer> child: ab.getChildren()) {
					lMax = resolver(child, (lvl+1), max, lMax);
				}
			}
			lAct.remove(lAct.size() - 1);
			return lMax;
		} else {
			return null;
		}
	}
}
