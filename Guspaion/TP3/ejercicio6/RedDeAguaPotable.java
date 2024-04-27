package tp3.ejercicio6;

import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> ab;
	
	public RedDeAguaPotable(GeneralTree<Character> tree) {
		ab = tree;
	}
	
	public double minimoCaudal(double caudal) {
		double min = 90000;
		if(!this.ab.isEmpty()) {
			return minimoCaudal(this.ab, caudal, min);			
		}
		return 0;
	}
	
	private double minimoCaudal(GeneralTree<Character> tree, double caudal, double min) {
		if(caudal < min) {
			min = caudal;
		}
		if(tree.hasChildren()) {
			List<GeneralTree<Character>> children = tree.getChildren();			
			for(GeneralTree<Character> child: children) {
				min = minimoCaudal(child, caudal/children.size(), min);
			}
		}
		return min;
	}
}
