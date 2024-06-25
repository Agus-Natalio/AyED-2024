package parcialero6;

public class Recinto {
	private String nombre;
	private int tiempo;
	
	public Recinto(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTiempo() {
		return this.tiempo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}
