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

public class GestionProveedor extends JPanel {

	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtID_Vehiculo;
	private JTextField txtPrecio_Compra;
	private JTextField txtCP;
	private JTextField txtProvincia;
	private JTextField txtPoblacion;
	private JTextField txtCalle;

	private JTextField txtIdEliminar;
	private JTable table;
	private boolean carga = false;

	DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public GestionProveedor() {

		setBackground(SystemColor.window);
		setLayout(null);

		// Labels Añadir
		JLabel lblAniadirContacto = new JLabel("A\u00F1adir Contacto");
		lblAniadirContacto.setForeground(SystemColor.textHighlight);
		lblAniadirContacto.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAniadirContacto.setBounds(75, 10, 328, 40);
		add(lblAniadirContacto);

		JLabel lblDNI = new JLabel("DNI Contacto: ");
		lblDNI.setForeground(SystemColor.textHighlight);
		lblDNI.setFont(new Font("Arial", Font.BOLD, 16));
		lblDNI.setBounds(43, 54, 139, 15);
		add(lblDNI);

		JLabel lblNombre = new JLabel("Nombre Contacto:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(10, 74, 172, 35);
		add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos Contacto:");
		lblApellidos.setForeground(SystemColor.textHighlight);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 16));
		lblApellidos.setBounds(10, 105, 172, 35);
		add(lblApellidos);

		JLabel lblIdVehiculo = new JLabel("ID Vehiculo:");
		lblIdVehiculo.setForeground(SystemColor.textHighlight);
		lblIdVehiculo.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdVehiculo.setBounds(63, 151, 96, 14);
		add(lblIdVehiculo);

		JLabel lblPrecio_Compra = new JLabel("Precio_Compra:");
		lblPrecio_Compra.setForeground(SystemColor.textHighlight);
		lblPrecio_Compra.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecio_Compra.setBounds(22, 181, 131, 14);
		add(lblPrecio_Compra);

		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(104, 206, 66, 14);
		add(lblCP);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(75, 231, 106, 20);
		add(lblProvincia);

		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(63, 273, 96, 22);
		add(lblPoblacion);

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(104, 312, 55, 16);
		add(lblCalle);

		// Labels en medio
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(553, 90, 228, 52);
		add(lblSotecars1);

		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(587, 129, 152, 22);
		add(lblSotecars2);

		JLabel lblListaClientes = new JLabel("Lista de Contactos");
		lblListaClientes.setForeground(SystemColor.textHighlight);
		lblListaClientes.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaClientes.setBounds(566, 346, 214, 40);
		add(lblListaClientes);

		// Labels Eliminar
		JLabel lblEliminarProveedor = new JLabel("Eliminar Contacto");
		lblEliminarProveedor.setForeground(SystemColor.textHighlight);
		lblEliminarProveedor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminarProveedor.setBounds(972, 10, 265, 40);
		add(lblEliminarProveedor);

		JLabel lblIdEliminar = new JLabel("ID Contacto:");
		lblIdEliminar.setForeground(SystemColor.textHighlight);
		lblIdEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdEliminar.setBounds(972, 186, 139, 20);
		add(lblIdEliminar);

		// JTextFields Añadir

		txtDni = new JTextField();
		txtDni.setBackground(SystemColor.inactiveCaption);
		txtDni.setColumns(10);
		txtDni.setBounds(171, 53, 121, 20);
		add(txtDni);

		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.inactiveCaption);
		txtNombre.setBounds(171, 84, 121, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(SystemColor.inactiveCaption);
		txtApellidos.setBounds(171, 114, 121, 20);
		add(txtApellidos);

		txtID_Vehiculo = new JTextField();
		txtID_Vehiculo.setColumns(10);
		txtID_Vehiculo.setBackground(SystemColor.inactiveCaption);
		txtID_Vehiculo.setBounds(169, 150, 123, 20);
		add(txtID_Vehiculo);

		txtPrecio_Compra = new JTextField();
		txtPrecio_Compra.setColumns(10);
		txtPrecio_Compra.setBackground(SystemColor.inactiveCaption);
		txtPrecio_Compra.setBounds(169, 176, 123, 20);
		add(txtPrecio_Compra);

		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(169, 200, 123, 20);
		add(txtCP);

		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(169, 234, 123, 20);
		add(txtProvincia);

		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(169, 277, 123, 20);
		add(txtPoblacion);

		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBackground(SystemColor.inactiveCaption);
		txtCalle.setBounds(171, 312, 123, 20);
		add(txtCalle);

		// JTextField Eliminar
		txtIdEliminar = new JTextField();
		txtIdEliminar.setColumns(10);
		txtIdEliminar.setBackground(SystemColor.inactiveCaption);
		txtIdEliminar.setBounds(1101, 186, 121, 20);
		add(txtIdEliminar);

		// Botones
		JButton btnAniadir = new JButton("A\u00F1adir Contacto");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aniadirCliente();
				modeloTabla.setRowCount(0);
				cargaProveedores();
				resetTextfieldsGestionProveedor();
			}
		});

		btnAniadir.setFont(new Font("Arial", Font.BOLD, 18));
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setBackground(Color.BLUE);
		btnAniadir.setBounds(104, 360, 214, 35);
		add(btnAniadir);

		JButton btnEliminar = new JButton("Eliminar Contacto");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				eliminarCliente();
				modeloTabla.setRowCount(0);
				cargaProveedores();
				txtIdEliminar.setText(" ");
			}
		});

		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminar.setBackground(Color.BLUE);
		btnEliminar.setBounds(1028, 352, 209, 35);
		add(btnEliminar);

		// Iconos
		Image img1 = new ImageIcon(this.getClass().getResource("/Sotecars.png")).getImage();
		Image modifiedImage = img1.getScaledInstance(243, 124, java.awt.Image.SCALE_SMOOTH);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 405, 1218, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "DNI", "Nombre", "Apellidos", "ID_Vehiculo",
				"Precio_Compra", "CP", "Poblacion", "Provincia", "Calle" });
		table.setModel(modeloTabla);

		modeloTabla.setRowCount(0);
		cargaProveedores();

	}

	// Metodos
	public void cargaProveedores() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, DNI, Nombre, Apellidos, ID_Vehiculo, Precio_Compra, CP, Provincia, Poblacion, Calle FROM contactos_compra");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("DNI"), rs.getObject("Nombre"),
							rs.getObject("Apellidos"), rs.getObject("ID_Vehiculo"), rs.getObject("Precio_Compra"),
							rs.getObject("CP"), rs.getObject("Provincia"), rs.getObject("Poblacion"),
							rs.getObject("Calle") });
				}

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("Ningun error");
		}
	}

	public void aniadirCliente() {

		try {

			String dni = txtDni.getText();
			String nombre = txtNombre.getText();
			String apellidos = txtID_Vehiculo.getText();
			int idvehiculo = Integer.parseInt(txtID_Vehiculo.getText());
			int precio_compra = Integer.parseInt(txtPrecio_Compra.getText());
			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();
			String calle = txtCalle.getText();

			String agregar = "INSERT INTO contacto_compra (DNI, Nombre, Apellidos, ID_Vehiculo, Precio_Compra, CP, Provincia, Poblacion, Calle) VALUES('"
					+ dni + "', '" + nombre + "', '" + apellidos + "', '" + idvehiculo + "', '" + precio_compra + "', '"
					+ cp + "', '" + provincia + "', '" + poblacion + "', '" + calle + "')";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Contacto Agregado Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eliminarCliente() {
		int confirmar = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el contacto escrito?");

		if (confirmar == JOptionPane.YES_OPTION) {

			try {

				String contacto = (txtIdEliminar.getText());

				String eliminar = "DELETE FROM contactos_compra WHERE ID = '" + contacto + "'";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
						"TRABAJO");
				Statement consulta = conexion.createStatement();

				consulta.executeUpdate(eliminar);

				JOptionPane.showMessageDialog(null, "Contacto Eliminado Correctamente");

				conexion.close();
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
				ex2.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se eliminara el contacto introducido");
		}
	}

	public void resetTextfieldsGestionProveedor() {

		txtDni.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtID_Vehiculo.setText("");
		txtPrecio_Compra.setText("");
		txtCP.setText("");
		txtProvincia.setText("");
		txtPoblacion.setText("");
		txtCalle.setText("");
	}
}
