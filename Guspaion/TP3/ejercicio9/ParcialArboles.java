package tp3.ejercicio9;

import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	public static boolean esDeSeleccion(GeneralTree<Integer> ab) {
		boolean deSeleccion = true;
		int min = 90000;
		if(ab != null) {
			List<GeneralTree<Integer>> children = ab.getChildren();
			for(GeneralTree<Integer> child: children) {
				if(child.getData() < min) {
					min = child.getData();
				}
				if(child.hasChildren()) {
					deSeleccion = esDeSeleccion(child);	
					if(!deSeleccion) {
						return deSeleccion;
					}
				}
			}
			return min == ab.getData();
		} else {
			return false;
		}
	}
}
