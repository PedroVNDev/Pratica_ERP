package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class GestionPersonal extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public GestionPersonal() {
		setLayout(null);
		
		JLabel lblAadirTrabajador = new JLabel("A\u00F1adir Trabajador");
		lblAadirTrabajador.setForeground(SystemColor.textHighlight);
		lblAadirTrabajador.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAadirTrabajador.setBounds(64, 57, 234, 40);
		add(lblAadirTrabajador);
		
		JLabel lblNombreTrabajador = new JLabel("Nombre Trabajador:");
		lblNombreTrabajador.setForeground(SystemColor.textHighlight);
		lblNombreTrabajador.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombreTrabajador.setBounds(0, 134, 172, 35);
		add(lblNombreTrabajador);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setBounds(177, 144, 121, 20);
		add(textField);
		
		JLabel lblDniTrabajador = new JLabel("DNI Trabajador: ");
		lblDniTrabajador.setForeground(SystemColor.textHighlight);
		lblDniTrabajador.setFont(new Font("Arial", Font.BOLD, 16));
		lblDniTrabajador.setBounds(31, 190, 131, 15);
		add(lblDniTrabajador);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.inactiveCaption);
		textField_1.setBounds(177, 190, 123, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.inactiveCaption);
		textField_2.setBounds(175, 240, 123, 20);
		add(textField_2);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(83, 240, 91, 14);
		add(lblTelefono);
		
		JButton btnAadirTrabajador = new JButton("A\u00F1adir Trabajador");
		btnAadirTrabajador.setForeground(Color.WHITE);
		btnAadirTrabajador.setFont(new Font("Arial", Font.BOLD, 18));
		btnAadirTrabajador.setBackground(Color.BLUE);
		btnAadirTrabajador.setBounds(112, 321, 172, 35);
		add(btnAadirTrabajador);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 452, 1218, 261);
		add(scrollPane);
		
		JLabel lblListaDeTrabajador = new JLabel("Lista de Trabajadores");
		lblListaDeTrabajador.setForeground(SystemColor.textHighlight);
		lblListaDeTrabajador.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaDeTrabajador.setBounds(561, 392, 253, 40);
		add(lblListaDeTrabajador);
		
		JButton btnEliminarTrabajador = new JButton("Eliminar Trabajador");
		btnEliminarTrabajador.setForeground(Color.WHITE);
		btnEliminarTrabajador.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminarTrabajador.setBackground(Color.BLUE);
		btnEliminarTrabajador.setBounds(1068, 321, 177, 35);
		add(btnEliminarTrabajador);
		
		JLabel lblIdTrabajador = new JLabel("ID Trabajador:");
		lblIdTrabajador.setForeground(SystemColor.textHighlight);
		lblIdTrabajador.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdTrabajador.setBounds(1001, 144, 115, 14);
		add(lblIdTrabajador);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.inactiveCaption);
		textField_3.setBounds(1124, 144, 121, 20);
		add(textField_3);
		
		JLabel lblEliminarTrabajador = new JLabel("Eliminar Trabajador");
		lblEliminarTrabajador.setForeground(SystemColor.textHighlight);
		lblEliminarTrabajador.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminarTrabajador.setBounds(981, 57, 261, 40);
		add(lblEliminarTrabajador);
		
		JLabel lblNewLabel_3 = new JLabel("SOTECARS");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(561, 137, 228, 52);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("THE POWER OF DREAMS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(595, 176, 152, 22);
		add(lblNewLabel_4);

	}

}
