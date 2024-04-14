package tp2.ejercicio4postinha;

import tp2.ejercicio2.BinaryTree;
import java.util.*;

public class EJ4 {

	public static void main(String[] args) {
		BinaryTree<Integer> arboreo = new BinaryTree<Integer>();
		int ret;
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese un numero de retardo: ");
		ret = s.nextInt();
		while(ret != 0) {
			arboreo.add(ret);
			System.out.print("Ingrese otro numero(finaliza en 0): ");
			ret = s.nextInt();
		}
		s.close();
		RedBinariaLlena redBinariaLlena = new RedBinariaLlena(arboreo);
		System.out.println("Retardo maximo: "+redBinariaLlena.retardoReenvio());
		arboreo.entreNiveles(0, 2);
		}
}
