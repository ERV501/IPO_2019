package presentation;

public class Group {
	
	protected int id;
	protected int Nmiembros;
	protected int mediaEdad;
	protected String nombre;
	protected String apellidos;
	protected String DNI;
	protected boolean valid;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNmiembros() {
		return this.Nmiembros;
	}
	public void setNmiembros(int nmiembros) {
		this.Nmiembros = nmiembros;
	}
	public int getMediaEdad() {
		return mediaEdad;
	}
	public void setMediaEdad(int mediaEdad) {
		this.mediaEdad = mediaEdad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDNI() {
		return this.DNI;
	}
	public void setDNI(String dNI) {
		this.DNI = dNI;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
    
	public boolean getValid() {
		return this.valid;
	}
	
	public Group(int id, int nmiembros, int mediaEdad, String nombre, String apellidos, String dNI) {
		this.id = id;
		this.Nmiembros = nmiembros;
		this.mediaEdad = mediaEdad;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = dNI;
		this.valid = false;
	}
	

}
