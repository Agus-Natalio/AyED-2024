package tp3.ejercicio10postinha;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class EJ10 {
	public static void main(String[]args) {
		GeneralTree<Integer> ab1 = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> ab2 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> ab3 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> ab4 = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> ab5 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> ab6 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> ab7 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> ab8 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> ab9 = new GeneralTree<Integer>(0);
		
		GeneralTree<Integer> ab10 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> ab11 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> ab12 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> ab13 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> ab14 = new GeneralTree<Integer>(0);
		
		GeneralTree<Integer> ab15 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> ab16 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> ab17 = new GeneralTree<Integer>(0);
		
		ab1.addChild(ab2);
		ab1.addChild(ab3);
		ab1.addChild(ab4);
		
		ab2.addChild(ab5);
		ab2.addChild(ab6);
		
		ab3.addChild(ab7);
		ab3.addChild(ab8);
		
		ab4.addChild(ab9);
		
		ab5.addChild(ab10);
		ab5.addChild(ab11);
		ab5.addChild(ab12);
		
		ab8.addChild(ab13);
		
		ab9.addChild(ab14);
		
		ab13.addChild(ab15);
		
		ab14.addChild(ab16);
		ab14.addChild(ab17);
		
		List<Integer> result = new LinkedList<Integer>();
		
		result = ParcialArboles.resolver(ab1);
		for(int i: result) {
			System.out.print(i+" -M ");
		}
	}
}
