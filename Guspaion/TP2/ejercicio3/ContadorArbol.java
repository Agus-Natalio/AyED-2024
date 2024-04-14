package tp2.ejercicio3;

import tp2.ejercicio2.*;

public class ContadorArbol {
	private BinaryTree<Integer> Arboreo;
	
	public ContadorArbol(Integer data) {
		this.Arboreo = new BinaryTree<Integer>(data);
	}
	
	public boolean esPar(int num) {
		return(num % 2 == 0);
	}
	
	public int numerosPares() {
		return contarPares(this.Arboreo);
	}
	
	public int contarPares(BinaryTree<Integer> a) {
		int cantPar = 0;
		int cantIzq = 0;
		int cantDer = 0;
		if(this.esPar(a.getData())) {
			cantPar++;
		}
		if(a.hasLeftChild()) {
			cantIzq = contarPares(a.getLeftChild());
			cantPar += cantIzq;
		}
		if(a.hasRightChild()) {
			cantDer = contarPares(a.getRightChild());
			cantPar += cantDer;
		}	
		return cantPar;
	}
	
	public int contarParesInorden(BinaryTree<Integer> a) {
		int cantPar = 0;
		int cantIzq = 0;
		int cantDer = 0;
		if(a.hasLeftChild()) {
			cantIzq = contarParesInorden(a.getLeftChild());
			cantPar+= cantIzq;
		}
		if(this.esPar(a.getData())) {
			cantPar++;
		}
		if(a.hasRightChild()) {
			cantDer = contarParesInorden(a.getRightChild());
			cantPar+= cantDer;
		}
		return cantPar;
	}
	
	public int contarParesPostorden(BinaryTree<Integer> a) {
		int cantPar = 0;
		int cantIzq = 0;
		int cantDer = 0;
		if(a.hasLeftChild()) {
			cantIzq = contarParesPostorden(a.getLeftChild());
			cantPar+= cantIzq;
		}
		if(a.hasRightChild()) {
			cantDer = contarParesPostorden(a.getRightChild());
			cantPar+= cantDer;
		}
		if(this.esPar(a.getData())) {
			cantPar++;
		}
		return cantPar;
	}
}
