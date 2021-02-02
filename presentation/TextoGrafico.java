package presentation;

import java.awt.Color;
import java.io.Serializable;

public class TextoGrafico extends ObjetoGrafico implements Serializable {
	private String texto;
	private Color color;

	public TextoGrafico(int x, int y, String text, Color color) {
		super(x, y);
		this.texto = text;
		this.color = color;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getTexto() {
		return texto;
	}

	public Color getColor() {
		return color;
	}
}