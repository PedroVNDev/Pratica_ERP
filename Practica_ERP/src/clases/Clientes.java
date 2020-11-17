package clases;

public class Clientes {
	
	int id;
	String nombre;
	String dni;
	int telefono;
	
	public Clientes() {
		super();
		this.id = 0;
		this.nombre = "";
		this.dni = "";
		this.telefono = 0;
	}
	
	public Clientes(int id, String nombre, String dni, int telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	

}
