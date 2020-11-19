package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class GestionProveedor extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public GestionProveedor() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblAadirProveedor = new JLabel("A\u00F1adir Proveedor");
		lblAadirProveedor.setForeground(SystemColor.textHighlight);
		lblAadirProveedor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAadirProveedor.setBounds(107, 61, 182, 40);
		add(lblAadirProveedor);
		
		JLabel lblNombreProveedor = new JLabel("Nombre Proveedor:");
		lblNombreProveedor.setForeground(SystemColor.textHighlight);
		lblNombreProveedor.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombreProveedor.setBounds(27, 138, 149, 35);
		add(lblNombreProveedor);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setBounds(201, 148, 121, 20);
		add(textField);
		
		JLabel lblAsdads = new JLabel("asdads");
		lblAsdads.setForeground(SystemColor.textHighlight);
		lblAsdads.setFont(new Font("Arial", Font.BOLD, 16));
		lblAsdads.setBounds(88, 194, 108, 15);
		add(lblAsdads);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.inactiveCaption);
		textField_1.setBounds(201, 194, 123, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.inactiveCaption);
		textField_2.setBounds(199, 244, 123, 20);
		add(textField_2);
		
		JLabel lblAsdad = new JLabel("asdad");
		lblAsdad.setForeground(SystemColor.textHighlight);
		lblAsdad.setFont(new Font("Arial", Font.BOLD, 16));
		lblAsdad.setBounds(107, 244, 91, 14);
		add(lblAsdad);
		
		JButton btnAadirProveedor = new JButton("A\u00F1adir Proveedor");
		btnAadirProveedor.setForeground(Color.WHITE);
		btnAadirProveedor.setFont(new Font("Arial", Font.BOLD, 18));
		btnAadirProveedor.setBackground(Color.BLUE);
		btnAadirProveedor.setBounds(121, 325, 202, 35);
		add(btnAadirProveedor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 456, 1218, 261);
		add(scrollPane);
		
		JLabel labelGestionCliente6 = new JLabel("Lista de clientes");
		labelGestionCliente6.setForeground(SystemColor.textHighlight);
		labelGestionCliente6.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelGestionCliente6.setBounds(598, 397, 214, 40);
		add(labelGestionCliente6);
		
		JButton btnEliminarProveedor = new JButton("Eliminar Proveedor");
		btnEliminarProveedor.setForeground(Color.WHITE);
		btnEliminarProveedor.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminarProveedor.setBackground(Color.BLUE);
		btnEliminarProveedor.setBounds(1055, 325, 219, 35);
		add(btnEliminarProveedor);
		
		JLabel lblIdProveedor = new JLabel("ID Proveedor:");
		lblIdProveedor.setForeground(SystemColor.textHighlight);
		lblIdProveedor.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdProveedor.setBounds(1020, 148, 115, 14);
		add(lblIdProveedor);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.inactiveCaption);
		textField_3.setBounds(1148, 148, 121, 20);
		add(textField_3);
		
		JLabel lblEliminarProveedor = new JLabel("Eliminar Proveedor");
		lblEliminarProveedor.setForeground(SystemColor.textHighlight);
		lblEliminarProveedor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminarProveedor.setBounds(1003, 61, 276, 40);
		add(lblEliminarProveedor);
		
		JLabel lblNewLabel_3 = new JLabel("SOTECARS");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(585, 141, 228, 52);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("THE POWER OF DREAMS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(619, 180, 152, 22);
		add(lblNewLabel_4);

	}
}
