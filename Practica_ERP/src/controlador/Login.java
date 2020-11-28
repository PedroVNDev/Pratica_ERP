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
	private JTextField usuario;
	private JTextField password;
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
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/071-cocheazul.png")));
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

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(684, 435, 108, 63);
		contentPane.add(lblNewLabel);

		JLabel lblContrase = new JLabel("Contrase\u00F1a:");
		lblContrase.setFont(new Font("Arial", Font.PLAIN, 18));
		lblContrase.setBounds(657, 525, 108, 63);
		contentPane.add(lblContrase);

		usuario = new JTextField();
		usuario.setFont(new Font("Arial", Font.BOLD, 18));
		usuario.setBounds(785, 454, 135, 30);
		contentPane.add(usuario);
		usuario.setColumns(10);

		password = new JTextField();
		password.setFont(new Font("Arial", Font.BOLD, 18));
		password.setColumns(10);
		password.setBounds(785, 538, 135, 30);
		contentPane.add(password);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String loginusuario = usuario.getText();
				String loginpass = password.getText();
				boolean puesto = false;
				// si es true es admin, si es false es trabajador

				if (loginpass.equals("1")) {

					dispose();
					Home home = new Home();
					home.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					home.setUndecorated(true);
					home.setVisible(true);
					puesto= true;
					
				}else  if (loginpass.equals("2")) {

					dispose();
					HomeTrabajador home2 = new HomeTrabajador();
					home2.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					home2.setUndecorated(true);
					home2.setVisible(true);
					puesto= false;

				} else{

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

		btnNewButton.setBounds(749, 632, 135, 30);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("*Nota aclaratoria*");
		lblNewLabel_1.setBounds(443, 294, 129, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				" la contrase\u00F1a para tabajadores ser\u00E1 1, la contrase\u00F1a para administradores ser\u00E1 2");
		lblNewLabel_2.setBounds(440, 325, 560, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("SOTECARS");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_3.setBounds(684, 133, 228, 52);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("THE POWER OF DREAMS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(719, 172, 152, 22);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(583, 454, 64, 80);
		contentPane.add(lblNewLabel_5);

		Image ico1 = new ImageIcon(this.getClass().getResource("/071-cocheazul.png")).getImage();
		Image modifiedIco1 = ico1.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_5.setIcon(new ImageIcon(modifiedIco1));
	}
	
	public void crearTXT( String nombre, boolean puesto) throws IOException {
		File fichero= new File("Accesos.txt");
		BufferedWriter buffer= new BufferedWriter(new PrintWriter(fichero));
		
		Calendar calendario = Calendar.getInstance();
		java.util.Date fecha = new Date();
		
		if (puesto) {
		
			buffer.write(nombre.toUpperCase()+ "               ACCEDIO A LAS: "
					+ calendario.get(Calendar.HOUR_OF_DAY)+":"
					+ calendario.get(Calendar.MINUTE)+
					" A DIA: " +fecha.getDay()+" DEL MES: "+ fecha.getMonth()+ "               CON PERMISOS DE ADMINISTRADOR");
			buffer.close();
			
		}else if(!puesto) { 
			
			
			buffer.write(nombre.toUpperCase()+ "               ACCEDIO A LAS: "
					+ calendario.get(Calendar.HOUR_OF_DAY)+":"
					+ calendario.get(Calendar.MINUTE)+
					" A DIA: " +fecha.getDay()+" DEL MES: "+ fecha.getMonth() + "               CON PERMISOS DE TRABAJADOR");
			buffer.close();
			
		}
	}
}
