package presentation;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class MiAreaDibujo extends JLabel {
	private ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<ObjetoGrafico>();

	public MiAreaDibujo() {
		setForeground(SystemColor.window);
		setHorizontalAlignment(SwingConstants.CENTER);
		setBackground(SystemColor.window);
	}

	void addObjetoGrafico(ObjetoGrafico objg) {
		objetosGraficos.add(objg);
	}

	public ObjetoGrafico getUltimoObjetoGrafico() {
		return objetosGraficos.get(objetosGraficos.size() - 1);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < objetosGraficos.size(); i++) {
			ObjetoGrafico objg = objetosGraficos.get(i);
			if (objg instanceof ImagenGrafico) {
				g.drawImage(((ImagenGrafico) objg).getImagen(), objg.getX(), objg.getY(), null);
			} else if (objg instanceof RectaGrafico) {
				g.setColor(((RectaGrafico) objg).getColor());
				int w = ((RectaGrafico) objg).getX1();
				int h = ((RectaGrafico) objg).getY1();
				g.drawLine(objg.getX(),objg.getY(),w, h);
			} else { // Es un objeto de tipo TextoGrafico
				g.setColor(((TextoGrafico) objg).getColor());
				g.drawString(((TextoGrafico) objg).getTexto(), objg.getX(), objg.getY());
			}
		}
	}
}