package parcialero3;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.*;

public class ParcialArboles {
	
	public class recorrido {
		List<Integer> L;
		int peso;
		
		public recorrido(List<Integer> L, int peso) {
			this.L = L;
			this.peso = peso;
		}
		
		public void setPeso(int peso) {
			this.peso = peso;
		}
	}
	
	public List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> L = new LinkedList<Integer>();
		recorrido recMax = new recorrido(L, 0);
		if(arbol != null) {
			List<Integer> lAct = new LinkedList<Integer>();
			resolver(arbol, lAct, 0, recMax, 0);
		}
		return recMax.L;
	}
	
	private void resolver(GeneralTree<Integer> ab, List<Integer> lAct, int suma, recorrido recMax, int lvl) {
		if(ab.getData() == 1) {
			lAct.add(ab.getData());
			suma += lvl;
		}
		if(ab.isLeaf()) {
			if(recMax.peso < suma) {
				recMax.L.clear();
				recMax.L.addAll(lAct);
				recMax.setPeso(suma);
			}
		} else {
			for(GeneralTree<Integer> child: ab.getChildren()) {
				resolver(child, lAct, suma, recMax, lvl+1);
			}
		}
		if(ab.getData() == 1) {
			lAct.remove(lAct.size() - 1);	
		}
	}
}