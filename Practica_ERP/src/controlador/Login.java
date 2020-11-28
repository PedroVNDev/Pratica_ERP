package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setIconImage(
							Toolkit.getDefaultToolkit().getImage(getClass().getResource("/071-cocheazul.png")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1463, 894);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Labels
		JLabel lblAclaratoria = new JLabel("*Nota aclaratoria*");
		lblAclaratoria.setBounds(443, 294, 129, 30);
		contentPane.add(lblAclaratoria);

		JLabel lblAclaratoria2 = new JLabel(
				" la contrase\u00F1a para tabajadores ser\u00E1 1, la contrase\u00F1a para administradores ser\u00E1 2");
		lblAclaratoria2.setBounds(440, 325, 560, 30);
		contentPane.add(lblAclaratoria2);

		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBounds(684, 133, 228, 52);
		contentPane.add(lblSotecars1);

		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(719, 172, 152, 22);
		contentPane.add(lblSotecars2);

		JLabel lblIcono = new JLabel("");
		lblIcono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIcono.setBounds(583, 454, 64, 80);
		contentPane.add(lblIcono);

		// Labels Login
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsuario.setBounds(684, 435, 108, 63);
		contentPane.add(lblUsuario);

		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setFont(new Font("Arial", Font.PLAIN, 18));
		lblContrasenia.setBounds(657, 525, 108, 63);
		contentPane.add(lblContrasenia);

		// JTextFields
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.BOLD, 18));
		txtUsuario.setBounds(785, 454, 135, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Arial", Font.BOLD, 18));
		txtPassword.setColumns(10);
		txtPassword.setBounds(785, 538, 135, 30);
		contentPane.add(txtPassword);

		// JPanels
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(376, 247, 29, 487);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(376, 238, 828, 30);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(1176, 264, 29, 470);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(391, 704, 809, 30);
		contentPane.add(panel_3);

		//Botones
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String loginusuario = txtUsuario.getText();
				String loginpass = txtPassword.getText();
				boolean puesto = false;
				// si es true es admin, si es false es trabajador

				if (loginpass.equals("1")) {

					dispose();
					Home home = new Home();
					home.setExtendedState(JFrame.MAXIMIZED_BOTH);
					home.setUndecorated(true);
					home.setVisible(true);
					puesto = true;

				} else if (loginpass.equals("2")) {

					dispose();
					HomeTrabajador home2 = new HomeTrabajador();
					home2.setExtendedState(JFrame.MAXIMIZED_BOTH);
					home2.setUndecorated(true);
					home2.setVisible(true);
					puesto = false;

				} else {

					Login frame = new Login();
					JOptionPane.showMessageDialog(frame, "Usuario Incorrecto");
				}
				try {
					crearTXT(loginusuario, puesto);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnLogin.setBounds(749, 632, 135, 30);
		contentPane.add(btnLogin);

		// Iconos
		Image ico1 = new ImageIcon(this.getClass().getResource("/071-cocheazul.png")).getImage();
		Image modifiedIco1 = ico1.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
		lblIcono.setIcon(new ImageIcon(modifiedIco1));
	}

	// Metodos
	public void crearTXT(String nombre, boolean puesto) throws IOException {
		File fichero = new File("Accesos.txt");
		BufferedWriter buffer = new BufferedWriter(new PrintWriter(fichero));

		Calendar calendario = Calendar.getInstance();
		java.util.Date fecha = new Date();

		if (puesto) {

			buffer.write(nombre.toUpperCase() + "               ACCEDIO A LAS: " + calendario.get(Calendar.HOUR_OF_DAY)
					+ ":" + calendario.get(Calendar.MINUTE) + " A DIA: " + fecha.getDay() + " DEL MES: "
					+ fecha.getMonth() + "               CON PERMISOS DE ADMINISTRADOR");
			buffer.close();

		} else if (!puesto) {

			buffer.write(nombre.toUpperCase() + "               ACCEDIO A LAS: " + calendario.get(Calendar.HOUR_OF_DAY)
					+ ":" + calendario.get(Calendar.MINUTE) + " A DIA: " + fecha.getDay() + " DEL MES: "
					+ fecha.getMonth() + "               CON PERMISOS DE TRABAJADOR");
			buffer.close();

		}
	}
}
