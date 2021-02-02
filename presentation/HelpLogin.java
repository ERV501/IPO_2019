package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;

public class HelpLogin extends JFrame{
	
	public HelpLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setSize(new Dimension(Main.getTamano(850), Main.getTamano(600)));
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(HelpLogin.class.getResource("/presentation/help_login.PNG")));
		label.setBackground(SystemColor.menu);
		panel.add(label, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textArea.setText(Messages.getString("HelpLogin.textArea.text")); //$NON-NLS-1$
		textArea.setFont(new Font("Verdana", Font.PLAIN, Main.getTamano(13)));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.menu);
		panel.add(textArea, BorderLayout.CENTER);
	}

}
