package presentation;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import presentation.Guide.Estado;
import presentation.Guide.Genero;
import presentation.Guide.Pais;

class NuestroCellRenderer extends ElementOfList implements ListCellRenderer {

	private Object o = new Object();

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		o = list.getModel().getElementAt(index);

		if (o.getClass() == Guide.class) {
			this.lblTitle.setText(((Guide) o).getNombre());
			this.lblInfo.setText(Integer.toString(((Guide) o).getEdad()));
		} 
		else if (o.getClass() == Group.class) {
			this.lblTitle.setText("Lider: " + ((Group) o).getNombre());
			this.lblInfo.setText("Nº miembros: " +  Integer.toString(((Group) o).getNmiembros()));
		}
		else if (o.getClass() == Route.class) {
			this.lblTitle.setText(((Route) o).getNombre());
			this.lblInfo.setText(Float.toString(((Route) o).getLongitud()));
		}
		
		if (isSelected) {
			setBackground(Color.green);
			setForeground(Color.white);
		} else {
			setBackground(Color.white);
			setForeground(Color.black);
		}

		return this;
	}

}