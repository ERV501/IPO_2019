package presentation;

import java.util.Enumeration;

import javax.swing.ImageIcon;

public class Route {
	
	protected int ID; 
	protected String nombre;
	protected float longitud;
	protected Ciudades salida;
	protected Ciudades llegada;
	protected ImageIcon image;
	protected boolean valid;
	
    protected enum Ciudades {
    	Almagro("Almagro"),Alcazar("Alcazar de San Juan"), Bolaños("Bolaños"), Capital("Ciudad Real"), Daimiel("Daimiel"), Puertollano("Puertollano"), Valdepeñas("Valdepeñas");
        private String city;
        private Ciudades(String ciudad) {
            this.city = ciudad;
        }
       
        @Override
        public String toString(){
            return city;
        }
    }

	public Route(int iD, String nombre, float longitud, Ciudades salida, Ciudades llegada) {
		this.ID = iD;
		this.nombre = nombre;
		this.longitud = longitud;
		this.salida = salida;
		this.llegada = llegada;
		this.image = new ImageIcon(pnlRoute.class.getResource("/presentation/Mapa_de_carreteras_de_la_Provincia_de_Ciudad_Real.png"));
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public Ciudades getSalida() {
		return salida;
	}

	public void setSalida(Ciudades salida) {
		this.salida = salida;
	}

	public Ciudades getLlegada() {
		return llegada;
	}

	public void setLlegada(Ciudades llegada) {
		this.llegada = llegada;
	}
    
	public void setValid(boolean valid) {
		this.valid = valid;
	}
    
	public boolean getValid() {
		return this.valid;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

}
