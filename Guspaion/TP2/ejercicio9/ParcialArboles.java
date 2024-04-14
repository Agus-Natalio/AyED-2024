package tp2.ejercicio9;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	private static void sumAndDif(BinaryTree<SumAndDif> abSumatoria, BinaryTree<Integer> abOriginal, int sum, int padre){
		SumAndDif sumatoria = new SumAndDif(abOriginal.getData() + sum, abOriginal.getData() - padre);
		abSumatoria.setData(sumatoria);
		if(abOriginal.hasLeftChild()) {
			abSumatoria.addLeftChild(new BinaryTree<SumAndDif>());
			sumAndDif(abSumatoria.getLeftChild(), abOriginal.getLeftChild(), sum + abOriginal.getData(), abOriginal.getData());
		}
		if(abOriginal.hasRightChild()) {
			abSumatoria.addRightChild(new BinaryTree<SumAndDif>());
			sumAndDif(abSumatoria.getRightChild(), abOriginal.getRightChild(), sum + abOriginal.getData(), abOriginal.getData());
		}
	}
	
	public static BinaryTree<SumAndDif> sumAndDif(BinaryTree<Integer> abOriginal){
		BinaryTree<SumAndDif> arboreo = new BinaryTree<SumAndDif>();
		sumAndDif(arboreo, abOriginal, 0, 0);
		return arboreo;
	}
}