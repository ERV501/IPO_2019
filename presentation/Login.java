package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Login extends JDialog {

	private final JPanel pnlContent = new JPanel();
	private JTextField txtEmail;
	private JPasswordField pwdContrasena;
	protected JMenuBar menuBar;
	protected JMenu mnAyuda, mnIdioma, mnTamao;
	protected JRadioButtonMenuItem rdbtnmntmEspaol, rdbtnmntmIngls, rdbtnmntmPequeo, rdbtnmntmNormal, rdbtnmntmGrande;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login("español"); //$NON-NLS-1$
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login(String idioma) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 450, 250));
		setPreferredSize(new Dimension(Main.getTamano(450), Main.getTamano(250)));
		setLocationRelativeTo(null);
		Messages.setIdioma(idioma);
		setResizable(false);
		setTitle(Messages.getString("Login.this.title")); //$NON-NLS-1$
		getContentPane().setLayout(new BorderLayout());
		{
			menuBar = new JMenuBar();
			getContentPane().add(menuBar, BorderLayout.NORTH);

			mnAyuda = new JMenu(Messages.getString("Login.mnAyuda.text")); //$NON-NLS-1$
			menuBar.add(mnAyuda);

			JMenuItem mntmAyuda = new JMenuItem(Messages.getString("Login.mntmAyuda.text")); //$NON-NLS-1$
			mntmAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HelpLogin h = new HelpLogin();
					h.setVisible(true);
				}
			});
			mntmAyuda.setIcon(new ImageIcon(Login.class.getResource("/presentation/info.png"))); //$NON-NLS-1$
			mnAyuda.add(mntmAyuda);

			mnIdioma = new JMenu(Messages.getString("Login.mnIdioma.text")); //$NON-NLS-1$
			menuBar.add(mnIdioma);

			rdbtnmntmEspaol = new JRadioButtonMenuItem(Messages.getString("Login.rdbtnmntmEspaol.text")); //$NON-NLS-1$
			rdbtnmntmEspaol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login dialog = new Login("español"); //$NON-NLS-1$
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.buttonGroup.clearSelection();
					dialog.rdbtnmntmEspaol.setSelected(true);
					dialog.txtEmail.setText(txtEmail.getText());
					dialog.pwdContrasena.setText(pwdContrasena.getText());
					if (rdbtnmntmPequeo.isSelected()) {
						dialog.rdbtnmntmPequeo.setSelected(true);
					} else if (rdbtnmntmNormal.isSelected()) {
						dialog.rdbtnmntmNormal.setSelected(true);
					} else {
						dialog.rdbtnmntmGrande.setSelected(true);
					}
					dispose();
				}
			});
			buttonGroup.add(rdbtnmntmEspaol);
			mnIdioma.add(rdbtnmntmEspaol);

			rdbtnmntmIngls = new JRadioButtonMenuItem(Messages.getString("Login.rdbtnmntmIngls.text")); //$NON-NLS-1$
			rdbtnmntmIngls.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login dialog = new Login("inglés"); //$NON-NLS-1$
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.buttonGroup.clearSelection();
					dialog.rdbtnmntmIngls.setSelected(true);
					dialog.txtEmail.setText(txtEmail.getText());
					dialog.pwdContrasena.setText(pwdContrasena.getText());
					if (rdbtnmntmPequeo.isSelected()) {
						dialog.rdbtnmntmPequeo.setSelected(true);
					} else if (rdbtnmntmNormal.isSelected()) {
						dialog.rdbtnmntmNormal.setSelected(true);
					} else {
						dialog.rdbtnmntmGrande.setSelected(true);
					}
					dispose();
				}
			});
			buttonGroup.add(rdbtnmntmIngls);
			mnIdioma.add(rdbtnmntmIngls);

			mnTamao = new JMenu(Messages.getString("Login.mnTamao.text")); //$NON-NLS-1$
			menuBar.add(mnTamao);

			rdbtnmntmPequeo = new JRadioButtonMenuItem(Messages.getString("Login.rdbtnmntmPequeo.text")); //$NON-NLS-1$
			buttonGroup_1.add(rdbtnmntmPequeo);
			mnTamao.add(rdbtnmntmPequeo);

			rdbtnmntmNormal = new JRadioButtonMenuItem(Messages.getString("Login.rdbtnmntmNormal.text")); //$NON-NLS-1$
			buttonGroup_1.add(rdbtnmntmNormal);
			mnTamao.add(rdbtnmntmNormal);

			rdbtnmntmGrande = new JRadioButtonMenuItem(Messages.getString("Login.rdbtnmntmGrande.text")); //$NON-NLS-1$
			buttonGroup_1.add(rdbtnmntmGrande);
			mnTamao.add(rdbtnmntmGrande);

			buttonGroup.clearSelection();
			rdbtnmntmEspaol.setSelected(true);
			buttonGroup_1.clearSelection();
			rdbtnmntmNormal.setSelected(true);

		}
		pnlContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlContent, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlContent = new GridBagLayout();
		gbl_pnlContent.columnWidths = new int[] { 46, 100, 32, 30, 90, 50, 0 };
		gbl_pnlContent.rowHeights = new int[] { 25, 25, 25, 25, 25, 25, 0 };
		gbl_pnlContent.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlContent.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlContent.setLayout(gbl_pnlContent);
		{
			txtEmail = new JTextField();
			{
				JLabel lblEmail = new JLabel(Messages.getString("Login.lblEmail.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblEmail = new GridBagConstraints();
				gbc_lblEmail.anchor = GridBagConstraints.EAST;
				gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail.gridx = 1;
				gbc_lblEmail.gridy = 1;
				pnlContent.add(lblEmail, gbc_lblEmail);
			}
			GridBagConstraints gbc_txtEmail = new GridBagConstraints();
			gbc_txtEmail.gridwidth = 2;
			gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
			gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEmail.gridx = 3;
			gbc_txtEmail.gridy = 1;
			pnlContent.add(txtEmail, gbc_txtEmail);
			txtEmail.setColumns(10);
		}
		{
			{
				pwdContrasena = new JPasswordField();
				{
					JLabel lblContrasena = new JLabel(Messages.getString("Login.lblContrasena.text")); //$NON-NLS-1$
					GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
					gbc_lblContrasena.anchor = GridBagConstraints.EAST;
					gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
					gbc_lblContrasena.gridx = 1;
					gbc_lblContrasena.gridy = 2;
					pnlContent.add(lblContrasena, gbc_lblContrasena);
				}
				GridBagConstraints gbc_pwdContrasena = new GridBagConstraints();
				gbc_pwdContrasena.insets = new Insets(0, 0, 5, 5);
				gbc_pwdContrasena.fill = GridBagConstraints.HORIZONTAL;
				gbc_pwdContrasena.gridx = 3;
				gbc_pwdContrasena.gridy = 2;
				pnlContent.add(pwdContrasena, gbc_pwdContrasena);
			}
		}
		JButton btnIniciarSesion = new JButton(Messages.getString("Login.btnIniciarSesion.text")); //$NON-NLS-1$
		btnIniciarSesion.addActionListener(new BtnIniciarSesionActionListener());
		GridBagConstraints gbc_btnIniciarSesion = new GridBagConstraints();
		gbc_btnIniciarSesion.fill = GridBagConstraints.VERTICAL;
		gbc_btnIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciarSesion.gridx = 3;
		gbc_btnIniciarSesion.gridy = 4;
		pnlContent.add(btnIniciarSesion, gbc_btnIniciarSesion);
	}

	private class BtnIniciarSesionActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {

				if (txtEmail.getText() == "" || !txtEmail.getText().contains("@")) { //$NON-NLS-1$ //$NON-NLS-2$
					throw new Exception(Messages.getString("Login.6")); //$NON-NLS-1$
				}
				if (pwdContrasena.getPassword().length == 0) {
					throw new Exception(Messages.getString("Login.7")); //$NON-NLS-1$
				}
				String idioma = "";
				String tamaño = "";

				if (rdbtnmntmEspaol.isSelected()) {
					idioma = "español";
				} else {
					idioma = "inglés";
				}
				if (rdbtnmntmPequeo.isSelected()) {
					tamaño = "pequeño";
				} else if (rdbtnmntmNormal.isSelected()) {
					tamaño = "normal";
				} else {
					tamaño = "grande";
				}
				
				String user = txtEmail.getText();

				Main main = new Main(idioma, tamaño, user);
				main.setVisible(true);
				dispose();
			} catch (Exception ex) {
				showError(ex.getMessage());
			}

		}
	}

	public static void showError(String errorMessage) {
		showError(errorMessage, "Error!"); //$NON-NLS-1$
	}

	public static void showError(Exception exceptionError) {
		String errorMessage = Messages.getString("Login.9") + exceptionError.getMessage() + "\nStackTrace: " //$NON-NLS-1$ //$NON-NLS-2$
				+ Arrays.toString(exceptionError.getStackTrace());
		String title = exceptionError.getClass().getName();
		showError(errorMessage, title);
	}

	public static void showError(String errorMessage, String title) {
		JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);

	}

}
