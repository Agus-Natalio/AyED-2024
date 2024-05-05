package tp3.ejercicio8;

import tp3.ejercicio1.GeneralTree;

public class Navidad {
	GeneralTree<Integer> abeto;
	
	public Navidad(GeneralTree<Integer> a) {
		abeto = a;
	}
	
	public String esAbetoNavidenio() {
		if(esAbetoNavidenio(this.abeto, true)) {
			return "Es abeto";
		} else {
			return "No es abeto";
		}
	}
	
	private boolean esAbetoNavidenio(GeneralTree<Integer> ab, boolean esAbeto) {
		if(ab == null) {
			return false;
		} else {
			if(ab.isLeaf()) {
				return true;
			} else {
				for(GeneralTree<Integer> child: ab.getChildren()) {
					esAbeto = esAbetoNavidenio(child, esAbeto);
				}
				if(esAbeto) {
					if(ab.getChildren().size() >= 3){
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
	}
}
