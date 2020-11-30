package paneles;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GestionFabricas extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	
	/**
	 * Create the panel.
	 */
	public GestionFabricas() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setBounds(168, 151, 121, 20);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.inactiveCaption);
		textField_1.setBounds(168, 186, 123, 20);
		add(textField_1);
		
		JLabel lblDni = new JLabel("DNI Cliente: ");
		lblDni.setForeground(SystemColor.textHighlight);
		lblDni.setFont(new Font("Arial", Font.BOLD, 16));
		lblDni.setBounds(55, 186, 108, 15);
		add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre Cliente:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(22, 141, 149, 35);
		add(lblNombre);
		
		JLabel lblAadirFabrica = new JLabel("A\u00F1adir Fabrica");
		lblAadirFabrica.setForeground(SystemColor.textHighlight);
		lblAadirFabrica.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAadirFabrica.setBounds(74, 64, 182, 40);
		add(lblAadirFabrica);
		
		JButton btnAadirFabrica = new JButton("A\u00F1adir Fabrica");
		btnAadirFabrica.setForeground(Color.WHITE);
		btnAadirFabrica.setFont(new Font("Arial", Font.BOLD, 18));
		btnAadirFabrica.setBackground(Color.BLUE);
		btnAadirFabrica.setBounds(117, 414, 172, 35);
		add(btnAadirFabrica);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.inactiveCaption);
		textField_2.setBounds(166, 227, 123, 20);
		add(textField_2);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(74, 227, 91, 14);
		add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.inactiveCaption);
		textField_3.setBounds(166, 266, 123, 20);
		add(textField_3);
		
		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(117, 266, 39, 14);
		add(lblCP);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.inactiveCaption);
		textField_4.setBounds(168, 307, 123, 20);
		add(textField_4);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(72, 313, 91, 14);
		add(lblProvincia);
		
		JLabel lblListaDeFabrica = new JLabel("Lista de Fabrica");
		lblListaDeFabrica.setForeground(SystemColor.textHighlight);
		lblListaDeFabrica.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaDeFabrica.setBounds(565, 400, 214, 40);
		add(lblListaDeFabrica);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 485, 1218, 261);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnEliminarFabrcia = new JButton("Eliminar Fabrica");
		btnEliminarFabrcia.setForeground(Color.WHITE);
		btnEliminarFabrcia.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminarFabrcia.setBackground(Color.BLUE);
		btnEliminarFabrcia.setBounds(1063, 414, 177, 35);
		add(btnEliminarFabrcia);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(SystemColor.inactiveCaption);
		textField_5.setBounds(1115, 151, 121, 20);
		add(textField_5);
		
		JLabel lblIdClienteEliminar = new JLabel("ID Cliente:");
		lblIdClienteEliminar.setForeground(SystemColor.textHighlight);
		lblIdClienteEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdClienteEliminar.setBounds(1018, 151, 115, 14);
		add(lblIdClienteEliminar);
		
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(552, 144, 228, 52);
		add(lblSotecars1);
		
		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(586, 183, 152, 22);
		add(lblSotecars2);
		
		JLabel lblEliminarFabrica = new JLabel("Eliminar Fabrica");
		lblEliminarFabrica.setForeground(SystemColor.textHighlight);
		lblEliminarFabrica.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminarFabrica.setBounds(1018, 64, 233, 40);
		add(lblEliminarFabrica);
		
		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Nombre", "Telefono", "DNI", "Domicilio" ,"CP", "Poblacion", "Provincia" });
		table.setModel(modeloTabla);
		cargaFabricas();

	}
	
	public void cargaFabricas() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT  FROM Fabricas");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject(""), rs.getObject(""),
							rs.getObject("Telefono"), rs.getObject(""), rs.getObject("CP"), rs.getObject("Provincia"), rs.getObject("Poblacion"), rs.getObject("Calle") });
				}

				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}

}
