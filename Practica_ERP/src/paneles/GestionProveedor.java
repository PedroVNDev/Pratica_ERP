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
	private JTextField txtPoblacion;
	private JTextField txtCalle;
	private JTextField txtProvincia;
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

		JLabel labelGestionCliente1 = new JLabel("A\u00F1adir Proveedor");
		labelGestionCliente1.setForeground(SystemColor.textHighlight);
		labelGestionCliente1.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelGestionCliente1.setBounds(75, 57, 182, 40);
		add(labelGestionCliente1);

		JLabel labelGestionCliente2 = new JLabel("Nombre Proveedor:");
		labelGestionCliente2.setForeground(SystemColor.textHighlight);
		labelGestionCliente2.setFont(new Font("Arial", Font.BOLD, 16));
		labelGestionCliente2.setBounds(23, 134, 149, 35);
		add(labelGestionCliente2);

		JLabel labelGestionCliente3 = new JLabel("CIF Proveedor: ");
		labelGestionCliente3.setForeground(SystemColor.textHighlight);
		labelGestionCliente3.setFont(new Font("Arial", Font.BOLD, 16));
		labelGestionCliente3.setBounds(56, 190, 108, 15);
		add(labelGestionCliente3);

		JButton btnAniadir = new JButton("A\u00F1adir Proveedor");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aniadirCliente();
				modeloTabla.setRowCount(0);
				cargaProveedores();
				txtNombre.setText("");
				txtCif.setText("");
				txtTipoProveedor.setText("");
			}
		});

		btnAniadir.setFont(new Font("Arial", Font.BOLD, 18));
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setBackground(Color.BLUE);
		btnAniadir.setBounds(118, 399, 172, 35);
		add(btnAniadir);

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

		JLabel labelGestionCliente4 = new JLabel("Eliminar Proveedor");
		labelGestionCliente4.setForeground(SystemColor.textHighlight);
		labelGestionCliente4.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelGestionCliente4.setBounds(1028, 57, 191, 40);
		add(labelGestionCliente4);

		JLabel labelGestionCliente5 = new JLabel("ID Proveedor:");
		labelGestionCliente5.setForeground(SystemColor.textHighlight);
		labelGestionCliente5.setFont(new Font("Arial", Font.BOLD, 16));
		labelGestionCliente5.setBounds(1019, 144, 115, 14);
		add(labelGestionCliente5);

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

		JLabel labelGestionCliente6 = new JLabel("Lista de clientes");
		labelGestionCliente6.setForeground(SystemColor.textHighlight);
		labelGestionCliente6.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelGestionCliente6.setBounds(566, 393, 214, 40);
		add(labelGestionCliente6);
		Image img1 = new ImageIcon(this.getClass().getResource("/Sotecars.png")).getImage();
		Image modifiedImage = img1.getScaledInstance(243, 124, java.awt.Image.SCALE_SMOOTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 452, 1218, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(
				new Object[] { "ID", "CIF", "Nombre", "Tipo_Proveedor", "CP", "Poblacion", "Provincia", "Calle" });
		table.setModel(modeloTabla);

		JLabel lblTelefono = new JLabel("Tipo Proveedor:");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(75, 240, 91, 14);
		add(lblTelefono);

		txtTipoProveedor = new JTextField();
		txtTipoProveedor.setColumns(10);
		txtTipoProveedor.setBackground(SystemColor.inactiveCaption);
		txtTipoProveedor.setBounds(167, 240, 123, 20);
		add(txtTipoProveedor);

		txtIdEliminar = new JTextField();
		txtIdEliminar.setColumns(10);
		txtIdEliminar.setBackground(SystemColor.inactiveCaption);
		txtIdEliminar.setBounds(1116, 144, 121, 20);
		add(txtIdEliminar);

		JLabel lblNewLabel_3 = new JLabel("SOTECARS");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(553, 137, 228, 52);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("THE POWER OF DREAMS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(587, 176, 152, 22);
		add(lblNewLabel_4);

		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(93, 277, 54, 14);
		add(lblCP);

		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(167, 276, 123, 20);
		add(txtCP);

		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(56, 337, 91, 14);
		add(lblPoblacion);

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

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(75, 369, 66, 14);
		add(lblCalle);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(56, 307, 91, 14);
		add(lblProvincia);

		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(167, 306, 123, 20);
		add(txtProvincia);

		modeloTabla.setRowCount(0);
		cargaProveedores();

	}

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
}
