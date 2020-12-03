package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GestionCliente extends JPanel {
	private JTextField txtNombre;
	private JTextField txtDniCliente;
	private JTable table;
	private boolean carga = false;

	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JTextField txtTelefono;
	private JTextField txtIdEliminar;
	private JTextField txtCP;
	private JTextField txtPoblacion;
	private JTextField txtCalle;
	private JTextField txtProvincia;
	private JTextField txtApellidos;

	/**
	 * Create the panel.
	 */
	public GestionCliente() {

		setBackground(SystemColor.window);
		setLayout(null);

		// Labels Añadir
		JLabel lblAniadirCliente = new JLabel("A\u00F1adir Cliente");
		lblAniadirCliente.setForeground(SystemColor.textHighlight);
		lblAniadirCliente.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAniadirCliente.setBounds(62, 10, 182, 40);
		add(lblAniadirCliente);

		JLabel lblNombre = new JLabel("Nombre Cliente:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(10, 61, 149, 35);
		add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos Cliente:");
		lblApellidos.setForeground(SystemColor.textHighlight);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 16));
		lblApellidos.setBounds(10, 90, 149, 35);
		add(lblApellidos);

		JLabel lblDni = new JLabel("DNI Cliente: ");
		lblDni.setForeground(SystemColor.textHighlight);
		lblDni.setFont(new Font("Arial", Font.BOLD, 16));
		lblDni.setBounds(43, 132, 108, 15);
		add(lblDni);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(62, 173, 91, 14);
		add(lblTelefono);

		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(105, 212, 39, 14);
		add(lblCP);

		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(51, 280, 108, 28);
		add(lblPoblacion);

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(91, 318, 66, 20);
		add(lblCalle);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(62, 253, 91, 14);
		add(lblProvincia);

		// Labels en medio
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(540, 90, 228, 52);
		add(lblSotecars1);

		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(574, 129, 152, 22);
		add(lblSotecars2);

		JLabel lblListaClientes = new JLabel("Lista de clientes");
		lblListaClientes.setForeground(SystemColor.textHighlight);
		lblListaClientes.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaClientes.setBounds(553, 346, 214, 40);
		add(lblListaClientes);

		// Labels Eliminar
		JLabel lblEliminarCliente = new JLabel("Eliminar Cliente");
		lblEliminarCliente.setForeground(SystemColor.textHighlight);
		lblEliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminarCliente.setBounds(1015, 10, 191, 40);
		add(lblEliminarCliente);

		JLabel lblIdClienteEliminar = new JLabel("ID Cliente:");
		lblIdClienteEliminar.setForeground(SystemColor.textHighlight);
		lblIdClienteEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdClienteEliminar.setBounds(1002, 173, 121, 20);
		add(lblIdClienteEliminar);

		// JTextFields Añadir
		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.inactiveCaption);
		txtNombre.setBounds(156, 71, 121, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(SystemColor.inactiveCaption);
		txtApellidos.setBounds(156, 100, 121, 20);
		add(txtApellidos);

		txtDniCliente = new JTextField();
		txtDniCliente.setBackground(SystemColor.inactiveCaption);
		txtDniCliente.setColumns(10);
		txtDniCliente.setBounds(156, 132, 123, 20);
		add(txtDniCliente);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(SystemColor.inactiveCaption);
		txtTelefono.setBounds(156, 173, 123, 20);
		add(txtTelefono);

		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(154, 212, 123, 20);
		add(txtCP);

		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(154, 287, 123, 20);
		add(txtPoblacion);

		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBackground(SystemColor.inactiveCaption);
		txtCalle.setBounds(154, 321, 123, 20);
		add(txtCalle);

		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(154, 253, 123, 20);
		add(txtProvincia);

		// JTextFields Eliminar
		txtIdEliminar = new JTextField();
		txtIdEliminar.setColumns(10);
		txtIdEliminar.setBackground(SystemColor.inactiveCaption);
		txtIdEliminar.setBounds(1107, 173, 121, 20);
		add(txtIdEliminar);

		// Botones
		JButton btnAniadir = new JButton("A\u00F1adir Cliente");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aniadirCliente();
				modeloTabla.setRowCount(0);
				cargaClientes();
				resetJTextfields();

			}
		});

		btnAniadir.setFont(new Font("Arial", Font.BOLD, 18));
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setBackground(Color.BLUE);
		btnAniadir.setBounds(105, 360, 172, 35);
		add(btnAniadir);

		JButton btnEliminar = new JButton("Eliminar Cliente");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				eliminarCliente();
				modeloTabla.setRowCount(0);
				cargaClientes();
				txtIdEliminar.setText(" ");
			}
		});

		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminar.setBackground(Color.BLUE);
		btnEliminar.setBounds(1051, 360, 177, 35);
		add(btnEliminar);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 431, 1218, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Nombre", "Apellidos", "Telefono", "DNI", "CP",
				"Provincia", "Poblacion", "Calle" });
		table.setModel(modeloTabla);

		// Iconos
		Image img1 = new ImageIcon(this.getClass().getResource("/Sotecars.png")).getImage();
		Image modifiedImage = img1.getScaledInstance(243, 124, java.awt.Image.SCALE_SMOOTH);

		modeloTabla.setRowCount(0);
		cargaClientes();

	}

	// Metodos
	public void cargaClientes() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, Nombre, Apellidos, Telefono, DNI, CP, Provincia, Poblacion, Calle FROM Clientes");

				while (rs.next()) {
					modeloTabla.addRow(
							new Object[] { rs.getObject("ID"), rs.getObject("Nombre"), rs.getObject("Apellidos"),
									rs.getObject("Telefono"), rs.getObject("DNI"), rs.getObject("CP"),
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

	public void aniadirCliente() {

		try {

			String nombre = txtNombre.getText();
			String apellidos = txtApellidos.getText();
			int telefono = Integer.parseInt(txtTelefono.getText());
			String dni = txtDniCliente.getText();
			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();
			String calle = txtCalle.getText();

			String agregar = "INSERT INTO Clientes (Nombre, Apellidos, Telefono, DNI, CP, Provincia, Poblacion, Calle) VALUES('"
					+ nombre + "', '" + apellidos + "', '" + telefono + "', '" + dni + "', '" + cp + "', '" + provincia
					+ "', '" + poblacion + "', '" + calle + "')";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Cliente Agregado Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eliminarCliente() {
		int confirmar = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el cliente escrito?");

		if (confirmar == JOptionPane.YES_OPTION) {

			try {

				String cliente = (txtIdEliminar.getText());

				String eliminar = "DELETE FROM Clientes WHERE ID = '" + cliente + "'";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
						"TRABAJO");
				Statement consulta = conexion.createStatement();

				consulta.executeUpdate(eliminar);

				JOptionPane.showMessageDialog(null, "Cliente Eliminado Correctamente");

				conexion.close();
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
				ex2.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se eliminara el cliente introducido");
		}
	}

	public void resetJTextfields() {

		txtNombre.setText("");
		txtApellidos.setText("");
		txtDniCliente.setText("");
		txtTelefono.setText("");
		txtCP.setText("");
		txtProvincia.setText("");
		txtPoblacion.setText("");
		txtCalle.setText("");

	}
}
