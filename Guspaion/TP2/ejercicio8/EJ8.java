package tp2.ejercicio8;

import tp2.ejercicio2.BinaryTree;
import java.util.*;

public class EJ8 {
	public static void main(String[] args) {
		BinaryTree<Integer> abPrincipal = new BinaryTree<Integer>();
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese un numero entero: ");
		int entero = s.nextInt();
		while(entero != 0) {
			abPrincipal.add(entero);
			System.out.print("Ingrese otro entero(finaliza en 0): ");
			entero = s.nextInt();
		}
		s.close();
		BinaryTree<Integer> ab1 = new BinaryTree<Integer>(65);
		ab1.addLeftChild(new BinaryTree<Integer>(37));
		ab1.getLeftChild().addRightChild(new BinaryTree<Integer>(47));
		ab1.addRightChild(new BinaryTree<Integer>(81));
		ab1.getRightChild().addRightChild(new BinaryTree<Integer>(93));
		BinaryTree<Integer> ab2 = new BinaryTree<Integer>(65);
		ab2.addLeftChild(new BinaryTree<Integer>(37));
		ab2.addRightChild(new BinaryTree<Integer>(81));
		ab2.getLeftChild().addLeftChild(new BinaryTree<Integer>(47));
		System.out.println("Arbol 1 en arboreo principal: "+ParcialArboles.esPrefijo(ab1, abPrincipal));
		System.out.println("Arbol 2 en arboreo principal: "+ParcialArboles.esPrefijo(ab2, abPrincipal));
	}
}