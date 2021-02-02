package presentation;

import java.io.Serializable;
import java.awt.Image;

@SuppressWarnings("serial")
public class PuntoGrafico extends ObjetoGrafico implements Serializable {
	private Image imagen;

	public PuntoGrafico(int x, int y, Image imagen) {
		super(x, y);
		this.imagen = imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public Image getImagen() {
		return imagen;
	}
}
