package tp2.ejercicio4;

@SuppressWarnings("hiding")
public class BinaryTree<Integer> {
	private Integer data;
	private BinaryTree<Integer> leftChild;
	private BinaryTree<Integer> rightChild;
	
	public BinaryTree (Integer data) {
		this.data = data;
	}
	
	public Integer getData() {
		return this.data;
	}
	
	public void setData(Integer data) {
		this.data = data;
	}
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
	
	public BinaryTree<Integer> getLeftChild() {
		return this.leftChild;
	}
	
	public BinaryTree<Integer> getRightChild() {
		return this.rightChild;
	}
	
	public void addLeftChild(BinaryTree<Integer> child) {
		this.leftChild = child;
	}
	
	public void addRightChild(BinaryTree<Integer> child) {
		this.rightChild = child;
	}
	
	public void removeLeftChild() {
		this.leftChild = null;
	}
	
	public void removeRightChild() {
		this.rightChild = null;
	}
	
	public boolean isEmpty() {
		return(this.data == null);
	}
	
	public boolean isLeaf() {
		return(this.getLeftChild().isEmpty() && this.getRightChild().isEmpty());
	}
	
	public String toString() {
		return(this.getData().toString());
	}
	
	public int retardoReenvio() {
		Queue<BinaryTree<Integer>> Q = new Queue<BinaryTree<Integer>>();
		Q.enqueue(this);
		int retardo = 0;
		int max;
		int cantNodos;
		BinaryTree<Integer> act = null;
		while(!Q.isEmpty()) {
			max = 0;
			cantNodos = Q.size();
			for(int i = 0; i < cantNodos; i++) {
				act = Q.dequeue();
				max = Math.max(max, (int)act.getData());
				if(act.hasLeftChild()) {
					Q.enqueue(act.getLeftChild());
				}
				if(act.hasRightChild()) {
					Q.enqueue(act.getRightChild());
				}
			}
			retardo+= max;
		}
		return retardo;
	}
	
	private int retardoReenvio(BinaryTree<Integer> a) {
		if(this.isLeaf()) {
			return (int) a.getData();
		}
		int izq = 0;
		int der = 0;
		if(a.hasLeftChild()) {
			izq = retardoReenvio(a.getLeftChild());
		}
		if(a.hasRightChild()) {
			der = retardoReenvio(a.getRightChild());
		}
		if(der < izq) {
			return (int)a.getData() + izq;
		} else {
			return (int)a.getData() + der;
		}
	}
	
	public int retardoReenvio() {
		return retardoReenvio(this);
	}
}
