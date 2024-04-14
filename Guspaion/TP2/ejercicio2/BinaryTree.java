package tp2.ejercicio2;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	public BinaryTree() {
		super();
	}
	
	public BinaryTree(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return(this.getData().toString());
	}
	
	//Preguntar antes si existe un hijo izquierdo
	public BinaryTree<T> getLeftChild() {
		return this.leftChild;
	}
	
	//Preguntar antes si existe un hijo derecho
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}
	
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}
	
	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}
	
	public void removeLeftChild() {
		this.leftChild = null;
	}
	
	public void removeRightChild() {
		this.rightChild = null;
	}
	
	public boolean isEmpty() {
		return (this.data == null);
	}
	
	public boolean hasLeftChild() {
		return (this.leftChild != null);
	}
	
	public boolean hasRightChild() {
		return (this.rightChild != null);
	}
	
	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
	
	public int contarHojas() {
		int hojasIzq = 0;
		int hojasDer = 0;
		if(isLeaf()) {
			return 1;
		} else {
			if(hasLeftChild()) {
				hojasIzq = getLeftChild().contarHojas();
			}
			if(hasRightChild()) {
				hojasDer = getRightChild().contarHojas();
			}
		}
		return (hojasDer + hojasIzq);
	}
	
	public BinaryTree<T> espejo() {
		BinaryTree<T> arbol = new BinaryTree<T>(this.getData());
		if(!this.isLeaf()) {
			if(this.hasLeftChild()) {
				arbol.addRightChild(this.getLeftChild().espejo());
			}
			if(this.hasRightChild()) {
				arbol.addLeftChild(this.getRightChild().espejo());
			}
		}
		return arbol;
	}
	
	public void betweenLevels() {
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> Q = new Queue<BinaryTree<T>>();
		Q.enqueue(this);
		Q.enqueue(null);
		while(!Q.isEmpty()) {
			ab = Q.dequeue();
			if(ab != null) {
				System.out.println(ab.getData());
				if(ab.hasLeftChild()) {
					Q.enqueue(ab.getLeftChild());
				}
				if(ab.hasRightChild()) {
					Q.enqueue(ab.getRightChild());
				}
			} else if(!Q.isEmpty()) {
				System.out.println();
				Q.enqueue(null);
			}
		}
	}

	public void entreNiveles(int n, int m) {
		Queue<BinaryTree<T>> Q = new Queue<BinaryTree<T>>();
		Queue<Integer> level = new Queue<Integer>();
		Q.enqueue(this);
		level.enqueue(0);
		BinaryTree<T> act = new BinaryTree<T>();
		int lvl;
		while(!Q.isEmpty()) {
			act = Q.dequeue();
			lvl = level.dequeue();
			System.out.print("Nivel "+lvl+": ");
			if(n <= lvl && lvl <= m) {
				System.out.print(act.getData().toString()+" ");
				System.out.println();
			}
			if(act.hasLeftChild() && (lvl + 1) <= m) {
				level.enqueue(lvl + 1);
				Q.enqueue(act.getLeftChild());
			}
			if(act.hasRightChild() && (lvl + 1) <= m) {
				level.enqueue(lvl + 1);
				Q.enqueue(act.getRightChild());
			}
		}
	}
	
	public void add(T data) {
		if(this.getData() == null) {
			this.setData(data);
			return;
		}
		Queue<BinaryTree<T>> Q = new Queue<BinaryTree<T>>();
		BinaryTree<T> ab;
		Q.enqueue(this);
		while(!Q.isEmpty()) {
			ab = Q.dequeue();
			if(ab.hasLeftChild()) {
				Q.enqueue(ab.getLeftChild());
			} else {
				ab.addLeftChild(new BinaryTree<T>(data));
				break;
			}
			if(ab.hasRightChild()) {
				Q.enqueue(ab.getRightChild());
			} else {
				ab.addRightChild(new BinaryTree<T>(data));
				break;
			}
		}
	}
}
