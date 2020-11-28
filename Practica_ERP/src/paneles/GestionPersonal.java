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

public class GestionPersonal extends JPanel {

	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtSueldo;
	private JTextField txtPuesto;
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
	public GestionPersonal() {

		setBackground(SystemColor.window);
		setLayout(null);

		// Labels Añadir
		JLabel lblAniadirTrabajador = new JLabel("A\u00F1adir Trabajador");
		lblAniadirTrabajador.setForeground(SystemColor.textHighlight);
		lblAniadirTrabajador.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAniadirTrabajador.setBounds(202, 128, 301, 40);
		add(lblAniadirTrabajador);

		JLabel lblNombre = new JLabel("Nombre Trabajador:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(127, 217, 162, 35);
		add(lblNombre);

		JLabel lblDni = new JLabel("DNI Trabajador: ");
		lblDni.setForeground(SystemColor.textHighlight);
		lblDni.setFont(new Font("Arial", Font.BOLD, 16));
		lblDni.setBounds(156, 257, 133, 15);
		add(lblDni);

		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setForeground(SystemColor.textHighlight);
		lblSueldo.setFont(new Font("Arial", Font.BOLD, 16));
		lblSueldo.setBounds(220, 287, 70, 14);
		add(lblSueldo);

		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setForeground(SystemColor.textHighlight);
		lblPuesto.setFont(new Font("Arial", Font.BOLD, 16));
		lblPuesto.setBounds(220, 317, 91, 14);
		add(lblPuesto);

		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(245, 347, 54, 14);
		add(lblCP);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(202, 378, 100, 20);
		add(lblProvincia);

		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(198, 407, 100, 20);
		add(lblPoblacion);

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(235, 437, 76, 23);
		add(lblCalle);

		// Labels en medio
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(680, 208, 228, 52);
		add(lblSotecars1);

		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(714, 247, 152, 22);
		add(lblSotecars2);

		JLabel lblListaTrabajadores = new JLabel("Lista de Trabajadores");
		lblListaTrabajadores.setForeground(SystemColor.textHighlight);
		lblListaTrabajadores.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaTrabajadores.setBounds(669, 464, 266, 40);
		add(lblListaTrabajadores);

		// Labels Eliminar
		JLabel lblEliminar = new JLabel("Eliminar Trabajador");
		lblEliminar.setForeground(SystemColor.textHighlight);
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminar.setBounds(1123, 128, 295, 40);
		add(lblEliminar);

		JLabel lblIdEliminar = new JLabel("ID Trabajador:");
		lblIdEliminar.setForeground(SystemColor.textHighlight);
		lblIdEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdEliminar.setBounds(1123, 217, 115, 14);
		add(lblIdEliminar);

		// JTextFields Añadir
		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.inactiveCaption);
		txtNombre.setBounds(294, 227, 121, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBackground(SystemColor.inactiveCaption);
		txtDni.setColumns(10);
		txtDni.setBounds(294, 257, 123, 20);
		add(txtDni);

		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBackground(SystemColor.inactiveCaption);
		txtSueldo.setBounds(294, 287, 123, 20);
		add(txtSueldo);

		txtPuesto = new JTextField();
		txtPuesto.setColumns(10);
		txtPuesto.setBackground(SystemColor.inactiveCaption);
		txtPuesto.setBounds(294, 317, 123, 20);
		add(txtPuesto);

		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(294, 347, 123, 20);
		add(txtCP);

		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(294, 377, 123, 20);
		add(txtProvincia);

		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(294, 407, 123, 20);
		add(txtPoblacion);

		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBackground(SystemColor.inactiveCaption);
		txtCalle.setBounds(294, 439, 123, 20);
		add(txtCalle);

		// JTextField Eliminar
		txtIdEliminar = new JTextField();
		txtIdEliminar.setColumns(10);
		txtIdEliminar.setBackground(SystemColor.inactiveCaption);
		txtIdEliminar.setBounds(1243, 215, 121, 20);
		add(txtIdEliminar);

		// Botones
		JButton btnAniadir = new JButton("A\u00F1adir Trabajador");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aniadirTrabajador();
				modeloTabla.setRowCount(0);
				cargaTrabajadores();
				resetTextfieldsGestionPersonal();
			}
		});

		btnAniadir.setFont(new Font("Arial", Font.BOLD, 18));
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setBackground(Color.BLUE);
		btnAniadir.setBounds(220, 470, 206, 35);
		add(btnAniadir);

		JButton btnEliminar = new JButton("Eliminar Trabajador");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				eliminarTrabajador();
				modeloTabla.setRowCount(0);
				cargaTrabajadores();
				txtIdEliminar.setText(" ");
			}
		});

		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminar.setBackground(Color.BLUE);
		btnEliminar.setBounds(1123, 470, 217, 35);
		add(btnEliminar);

		// Iconos
		Image img1 = new ImageIcon(this.getClass().getResource("/Sotecars.png")).getImage();
		Image modifiedImage = img1.getScaledInstance(243, 124, java.awt.Image.SCALE_SMOOTH);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(166, 523, 1218, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Nombre", "DNI", "Puesto_Trabajo", "Sueldo", "CP",
				"Poblacion", "Provincia", "Calle" });
		table.setModel(modeloTabla);

		modeloTabla.setRowCount(0);
		cargaTrabajadores();

	}

	//Metodos
	public void cargaTrabajadores() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, Nombre, DNI, Puesto_Trabajo, Sueldo, CP, Provincia, Poblacion, Calle FROM trabajadores");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("Nombre"), rs.getObject("DNI"),
							rs.getObject("Puesto_Trabajo"), rs.getObject("Sueldo"), rs.getObject("CP"),
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

	public void aniadirTrabajador() {

		try {

			String nombre = txtNombre.getText();
			String puesto = txtPuesto.getText();
			String dni = txtDni.getText();
			float sueldo = Float.parseFloat(txtSueldo.getText());
			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();
			String calle = txtCalle.getText();

			String agregar = "INSERT INTO trabajadores (Nombre, DNI, Puesto_Trabajo, Sueldo, CP, Provincia, Poblacion, Calle) VALUES('"
					+ nombre + "', '" + dni + "', '" + puesto + "', '" + sueldo + "', '" + cp + "', '" + provincia
					+ "', '" + poblacion + "', '" + calle + "')";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Trabajador Agregado Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eliminarTrabajador() {
		int confirmar = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el trabajador escrito?");

		if (confirmar == JOptionPane.YES_OPTION) {

			try {

				String trabajador = (txtIdEliminar.getText());

				String eliminar = "DELETE FROM trabajadores WHERE ID = '" + trabajador + "'";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
						"TRABAJO");
				Statement consulta = conexion.createStatement();

				consulta.executeUpdate(eliminar);

				JOptionPane.showMessageDialog(null, "Trabajador Eliminado Correctamente");

				conexion.close();
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
				ex2.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se eliminara el trabajador introducido");
		}
	}

	public void resetTextfieldsGestionPersonal() {

		txtNombre.setText("");
		txtDni.setText("");
		txtSueldo.setText("");
		txtPuesto.setText("");
		txtCP.setText("");
		txtProvincia.setText("");
		txtPoblacion.setText("");
		txtCalle.setText("");

	}
}
