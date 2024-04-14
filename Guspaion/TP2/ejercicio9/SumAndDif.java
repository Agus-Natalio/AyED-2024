package tp2.ejercicio9;

public class SumAndDif {
	private int sum;
	private int dif;
	
	public SumAndDif(int a, int b) {
		this.sum = a;
		this.dif = b;
	}
	
	public int getSum() {
		return this.sum;
	}
	
	public int getDif() {
		return this.dif;
	}
	
	public void setSum(int n) {
		this.sum = n;
	}
	
	public void setDif(int n) {
		this.dif = n;
	}
	
	public String toString() {
		return "SumAndDif - sum = "+this.getSum()+" - dif = "+this.getDif();
	}
}