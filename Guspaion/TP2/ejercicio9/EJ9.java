package tp2.ejercicio9;

import tp2.ejercicio2.BinaryTree;

public class EJ9 {
	public static void main(String[] args) {
		BinaryTree<Integer> elUnicoInigualable = new BinaryTree<Integer>();
		for(int i = 1; i < 16; i++) {
			elUnicoInigualable.add(i);
		}
		System.out.println("El unico e inigualable: ");
		System.out.println();
		elUnicoInigualable.betweenLevels();
		System.out.println();
		System.out.println("El sumado petero (sum and dif): ");
		System.out.println();
		ParcialArboles.sumAndDif(elUnicoInigualable).betweenLevels();
	}
}
