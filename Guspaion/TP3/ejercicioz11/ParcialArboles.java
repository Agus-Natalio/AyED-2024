package tp3.ejercicio11;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer> ab) {
		Queue<GeneralTree<Integer>> Q = new Queue<GeneralTree<Integer>>();
		Q.enqueue(ab);
		Q.enqueue(null);
		int nodosAct = 0;
		int nodosAnt = 0;
		while(!Q.isEmpty()) {
			GeneralTree<Integer> actual = Q.dequeue();
			if(actual != null) {
				nodosAct++;// 3
				for(GeneralTree<Integer> child: actual.getChildren()) {
					Q.enqueue(child);
				}
			} else {
				if(!Q.isEmpty()) {
					Q.enqueue(null);
				}
				if((nodosAct - nodosAnt) == 1) {
					nodosAnt = nodosAct;
					nodosAct = 0;
				} else {
					return false;
				}	
			}
		}
		return true;
	}
}
