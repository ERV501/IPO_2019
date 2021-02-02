package presentation;

import presentation.Route.Ciudades;

public class Guide {
	
	protected String DNI;
	protected String nombre;
	protected String apellidos;
	protected String email;
	protected int edad;	
	protected String tlf;
	protected Genero genero;
	protected Estado civil;
	protected Pais procedencia;
	protected boolean valid;
	
    protected enum Genero {
    	Varon("Varón"),Hembra("Hembra");
    	private String genero;
        private Genero(String gender) {
            this.genero = gender;
        }
       
        @Override
        public String toString(){
            return genero;
        }
    }
	
    protected enum Estado {
    	Casado("Casado"),Soltero("Soltero"),Divorciado("Divorciado"),Viudo("Viudo"),Otro("Otro");
    	private String estado;
        private Estado(String state) {
            this.estado = state;
        }
       
        @Override
        public String toString(){
            return estado;
        }
    }
    
    protected enum Pais {
    	Espana("España"),Francia("Francia"),Italia("Italia");
    	private String pais;
        private Pais(String country) {
            this.pais = country;
        }
       
        @Override
        public String toString(){
            return pais;
        }
    }

	public Guide(String DNI, String nombre, String apellidos, String email, int edad, String tlf, Genero genero, Estado civil,
			Pais procedencia) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.edad = edad;
		this.tlf = tlf;
		this.genero = genero;
		this.civil = civil;
		this.procedencia = procedencia;
		this.valid = false;
	}

	public String getDNI() {
		return this.DNI;
	}

	public void setDNi(String dNi) {
		this.DNI = dNi;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTlf() {
		return this.tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Estado getCivil() {
		return civil;
	}

	public void setCivil(Estado civil) {
		this.civil = civil;
	}

	public Pais getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(Pais procedencia) {
		this.procedencia = procedencia;
	}
    
	public void setValid(boolean valid) {
		this.valid = valid;
	}
    
	public boolean getValid() {
		return this.valid;
	}
    

}
