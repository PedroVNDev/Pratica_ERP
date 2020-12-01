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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GestionFabricas extends JPanel {
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtCP;
	private JTextField txtProvincia;
	private JTextField txtEliminar;
	private JTextField txtProducto;
	private JTextField txtPoblacion;
	private JTextField txtCalle;

	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public GestionFabricas() {
		setBackground(Color.WHITE);
		setLayout(null);

		// Labels Añadir
		JLabel lblAadirFabrica = new JLabel("A\u00F1adir Fabrica");
		lblAadirFabrica.setForeground(SystemColor.textHighlight);
		lblAadirFabrica.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAadirFabrica.setBounds(74, 64, 182, 40);
		add(lblAadirFabrica);

		JLabel lblNombre = new JLabel("Nombre Fabrica:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(22, 141, 149, 35);
		add(lblNombre);

		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setForeground(SystemColor.textHighlight);
		lblProducto.setFont(new Font("Arial", Font.BOLD, 16));
		lblProducto.setBounds(70, 180, 91, 20);
		add(lblProducto);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmail.setBounds(100, 212, 56, 15);
		add(lblEmail);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(74, 242, 91, 14);
		add(lblTelefono);

		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(115, 272, 39, 14);
		add(lblCP);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(72, 304, 91, 14);
		add(lblProvincia);

		JLabel lblPoblacion = new JLabel("Poblacion:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(72, 335, 91, 14);
		add(lblPoblacion);

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(95, 367, 61, 14);
		add(lblCalle);

		// Labels en medio
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

		JLabel lblListaDeFabrica = new JLabel("Lista de Fabrica");
		lblListaDeFabrica.setForeground(SystemColor.textHighlight);
		lblListaDeFabrica.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaDeFabrica.setBounds(565, 400, 214, 40);
		add(lblListaDeFabrica);

		// Labels eliminar
		JLabel lblFabricaEliminar = new JLabel("ID Fabrica:");
		lblFabricaEliminar.setForeground(SystemColor.textHighlight);
		lblFabricaEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		lblFabricaEliminar.setBounds(1018, 151, 115, 14);
		add(lblFabricaEliminar);

		// JTextFiedls
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBackground(SystemColor.inactiveCaption);
		txtNombre.setBounds(168, 151, 121, 20);
		add(txtNombre);

		txtProducto = new JTextField();
		txtProducto.setColumns(10);
		txtProducto.setBackground(SystemColor.inactiveCaption);
		txtProducto.setBounds(168, 180, 121, 20);
		add(txtProducto);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBackground(SystemColor.inactiveCaption);
		txtEmail.setBounds(166, 211, 123, 20);
		add(txtEmail);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(SystemColor.inactiveCaption);
		txtTelefono.setBounds(166, 242, 123, 20);
		add(txtTelefono);

		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(166, 271, 123, 20);
		add(txtCP);

		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(166, 303, 123, 20);
		add(txtProvincia);

		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(168, 334, 123, 20);
		add(txtPoblacion);

		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBackground(SystemColor.inactiveCaption);
		txtCalle.setBounds(168, 366, 123, 20);
		add(txtCalle);

		// JTextFields Eliminar
		txtEliminar = new JTextField();
		txtEliminar.setColumns(10);
		txtEliminar.setBackground(SystemColor.inactiveCaption);
		txtEliminar.setBounds(1115, 151, 121, 20);
		add(txtEliminar);

		// Botones
		JButton btnAadirFabrica = new JButton("A\u00F1adir Fabrica");
		btnAadirFabrica.setForeground(Color.WHITE);
		btnAadirFabrica.setFont(new Font("Arial", Font.BOLD, 18));
		btnAadirFabrica.setBackground(Color.BLUE);
		btnAadirFabrica.setBounds(117, 414, 172, 35);
		add(btnAadirFabrica);

		JButton btnEliminarFabrcia = new JButton("Eliminar Fabrica");
		btnEliminarFabrcia.setForeground(Color.WHITE);
		btnEliminarFabrcia.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminarFabrcia.setBackground(Color.BLUE);
		btnEliminarFabrcia.setBounds(1063, 414, 177, 35);
		add(btnEliminarFabrcia);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 485, 1218, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(
				new Object[] { "ID", "Nombre", "Producto", "Email", "Telefono", "CP", "Provincia", "Poblacion", "Calle" });
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
				rs = sql.executeQuery("SELECT * FROM Fabricas");

				while (rs.next()) {
					modeloTabla
							.addRow(new Object[] { rs.getObject("ID"), rs.getObject("Nombre"), rs.getObject("Producto"),
									rs.getObject("Email"), rs.getObject("Telefono"), rs.getObject("CP"),
									rs.getObject("Provincia"), rs.getObject("Poblacion"), rs.getObject("Calle") });
				}

				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}
	
	public void aniadirFabrica() {

		try {

			String nombre = txtNombre.getText();
			String producto = txtProducto.getText();
			String email = txtEmail.getText();
			int telefono = Integer.parseInt(txtTelefono.getText());
			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();
			String calle = txtCalle.getText();

			String agregar = "INSERT INTO Fabricas (Nombre, Producto, Email, Telefono, CP, Provincia, Poblacion, Calle) VALUES('"
					+ nombre + "', '" + producto + "', '" + email + "', '" + telefono + "', '" + cp + "', '" + provincia
					+ "', '" + poblacion + "', '" + calle + "')";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Fabrica Agregada Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eliminarCliente() {
		int confirmar = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar la fabrica escrita?");

		if (confirmar == JOptionPane.YES_OPTION) {

			try {

				String fabrica = (txtEliminar.getText());

				String eliminar = "DELETE FROM Fabricas WHERE ID = '" + fabrica + "'";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
						"TRABAJO");
				Statement consulta = conexion.createStatement();

				consulta.executeUpdate(eliminar);

				JOptionPane.showMessageDialog(null, "Fabrica Eliminada Correctamente");

				conexion.close();
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
				ex2.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se eliminara la fabrica introducida");
		}
	}

}
