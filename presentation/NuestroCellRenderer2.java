package presentation;

import java.awt.Color;
import java.awt.Component;
import java.sql.Date;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import java.lang.NullPointerException;

class NuestroCellRenderer2 extends ElementOfListContraction implements ListCellRenderer {

	private Object o = new Object();

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		o = list.getModel().getElementAt(index);
		
			this.lblRoute.setText(((RouteContraction) o).getR().getNombre());
			this.lblGroup.setText(((RouteContraction) o).getG().getNombre());
			this.lblDate.setText(((RouteContraction) o).getD().toString());
		
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
