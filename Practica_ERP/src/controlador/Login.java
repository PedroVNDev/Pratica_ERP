package controlador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
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
		setBounds(100, 100, 824, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 66, 523);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(48, 0, 772, 58);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(738, 36, 82, 487);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(10, 465, 790, 58);
		contentPane.add(panel_3);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(261, 272, 108, 63);
		contentPane.add(lblNewLabel);

		JLabel lblContrase = new JLabel("Contrase\u00F1a:");
		lblContrase.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrase.setBounds(235, 332, 108, 63);
		contentPane.add(lblContrase);

		usuario = new JTextField();
		usuario.setBounds(363, 297, 96, 19);
		contentPane.add(usuario);
		usuario.setColumns(10);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(363, 357, 96, 19);
		contentPane.add(password);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String loginusuario = usuario.getText();
				String loginpass = password.getText();

				if (loginusuario.equals("1") && loginpass.equals("1")) {

					dispose();
					Home home = new Home();
					home.setVisible(true);

				} else {

					Login frame = new Login();
					JOptionPane.showMessageDialog(frame, "Usuario Incorrecto");
				}
			}
		});

		btnNewButton.setBounds(506, 318, 85, 21);
		contentPane.add(btnNewButton);
	}

}
