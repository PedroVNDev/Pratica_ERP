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
	private JTextField txtNombre;
	private JTextField txtCif;
	private JTextField txtTipoProveedor;
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
		JLabel lblAniadirProveedor = new JLabel("A\u00F1adir Proveedor");
		lblAniadirProveedor.setForeground(SystemColor.textHighlight);
		lblAniadirProveedor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAniadirProveedor.setBounds(75, 57, 182, 40);
		add(lblAniadirProveedor);

		JLabel lblNombre = new JLabel("Nombre Proveedor:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(23, 134, 149, 35);
		add(lblNombre);

		JLabel lblTelefono = new JLabel("Tipo Proveedor:");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(75, 240, 91, 14);
		add(lblTelefono);

		JLabel lblCIF = new JLabel("CIF Proveedor: ");
		lblCIF.setForeground(SystemColor.textHighlight);
		lblCIF.setFont(new Font("Arial", Font.BOLD, 16));
		lblCIF.setBounds(56, 190, 108, 15);
		add(lblCIF);

		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(93, 277, 54, 14);
		add(lblCP);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(56, 307, 91, 14);
		add(lblProvincia);

		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(56, 337, 91, 14);
		add(lblPoblacion);

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(75, 369, 66, 14);
		add(lblCalle);

		// Labels en medio
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(553, 137, 228, 52);
		add(lblSotecars1);

		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(587, 176, 152, 22);
		add(lblSotecars2);

		JLabel lblListaClientes = new JLabel("Lista de clientes");
		lblListaClientes.setForeground(SystemColor.textHighlight);
		lblListaClientes.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaClientes.setBounds(566, 393, 214, 40);
		add(lblListaClientes);

		// Labels Eliminar
		JLabel lblEliminarProveedor = new JLabel("Eliminar Proveedor");
		lblEliminarProveedor.setForeground(SystemColor.textHighlight);
		lblEliminarProveedor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminarProveedor.setBounds(1028, 57, 191, 40);
		add(lblEliminarProveedor);

		JLabel lblIdEliminar = new JLabel("ID Proveedor:");
		lblIdEliminar.setForeground(SystemColor.textHighlight);
		lblIdEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdEliminar.setBounds(1019, 144, 115, 14);
		add(lblIdEliminar);

		// JTextFields Añadir
		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.inactiveCaption);
		txtNombre.setBounds(169, 144, 121, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtCif = new JTextField();
		txtCif.setBackground(SystemColor.inactiveCaption);
		txtCif.setColumns(10);
		txtCif.setBounds(169, 190, 123, 20);
		add(txtCif);

		txtTipoProveedor = new JTextField();
		txtTipoProveedor.setColumns(10);
		txtTipoProveedor.setBackground(SystemColor.inactiveCaption);
		txtTipoProveedor.setBounds(167, 240, 123, 20);
		add(txtTipoProveedor);

		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(167, 276, 123, 20);
		add(txtCP);

		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(167, 306, 123, 20);
		add(txtProvincia);

		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(167, 336, 123, 20);
		add(txtPoblacion);

		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBackground(SystemColor.inactiveCaption);
		txtCalle.setBounds(167, 368, 123, 20);
		add(txtCalle);

		// JTextField Eliminar
		txtIdEliminar = new JTextField();
		txtIdEliminar.setColumns(10);
		txtIdEliminar.setBackground(SystemColor.inactiveCaption);
		txtIdEliminar.setBounds(1116, 144, 121, 20);
		add(txtIdEliminar);

		// Botones
		JButton btnAniadir = new JButton("A\u00F1adir Proveedor");
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
		btnAniadir.setBounds(118, 399, 172, 35);
		add(btnAniadir);

		JButton btnEliminar = new JButton("Eliminar Proveedor");
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
		btnEliminar.setBounds(1060, 321, 177, 35);
		add(btnEliminar);

		// Iconos
		Image img1 = new ImageIcon(this.getClass().getResource("/Sotecars.png")).getImage();
		Image modifiedImage = img1.getScaledInstance(243, 124, java.awt.Image.SCALE_SMOOTH);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 452, 1218, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(
				new Object[] { "ID", "CIF", "Nombre", "Tipo_Proveedor", "CP", "Poblacion", "Provincia", "Calle" });
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
						"SELECT ID, CIF, Nombre, Tipo_Proveedor, CP, Provincia, Poblacion, Calle FROM Proveedores");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("CIF"), rs.getObject("Nombre"),
							rs.getObject("Tipo_Proveedor"), rs.getObject("CP"), rs.getObject("Provincia"),
							rs.getObject("Poblacion"), rs.getObject("Calle") });
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

			String nombre = txtNombre.getText();
			String tipoproveedor = txtTipoProveedor.getText();
			String cif = txtCif.getText();
			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();
			String calle = txtCalle.getText();

			String agregar = "INSERT INTO proveedores (CIF, Nombre, Tipo_Proveedor, CP, Provincia, Poblacion, Calle) VALUES('"
					+ nombre + "', '" + tipoproveedor + "', '" + cif + "', '" + cp + "', '" + provincia + "', '"
					+ poblacion + "', '" + calle + "')";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Proveedor Agregado Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eliminarCliente() {
		int confirmar = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el cliente escrito?");

		if (confirmar == JOptionPane.YES_OPTION) {

			try {

				String proveedor = (txtIdEliminar.getText());

				String eliminar = "DELETE FROM proveedores WHERE ID = '" + proveedor + "'";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
						"TRABAJO");
				Statement consulta = conexion.createStatement();

				consulta.executeUpdate(eliminar);

				JOptionPane.showMessageDialog(null, "Proveedor Eliminado Correctamente");

				conexion.close();
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
				ex2.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se eliminara el proveedor introducido");
		}
	}

	public void resetTextfieldsGestionProveedor() {

		txtNombre.setText("");
		txtCif.setText("");
		txtTipoProveedor.setText("");
		txtCP.setText("");
		txtProvincia.setText("");
		txtPoblacion.setText("");
		txtCalle.setText("");
	}
}
