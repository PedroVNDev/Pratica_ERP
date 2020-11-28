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
	private JTextField txtDniTrabajador;
	private JTextField txtPuesto;
	private JTextField txtSueldo;
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
	public GestionPersonal() {

		setBackground(SystemColor.window);
		setLayout(null);

		JLabel labelGestionTrabajador1 = new JLabel("A\u00F1adir Trabajador");
		labelGestionTrabajador1.setForeground(SystemColor.textHighlight);
		labelGestionTrabajador1.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelGestionTrabajador1.setBounds(202, 128, 301, 40);
		add(labelGestionTrabajador1);

		JLabel labelGestionTrabajador2 = new JLabel("Nombre Trabajador:");
		labelGestionTrabajador2.setForeground(SystemColor.textHighlight);
		labelGestionTrabajador2.setFont(new Font("Arial", Font.BOLD, 16));
		labelGestionTrabajador2.setBounds(127, 217, 162, 35);
		add(labelGestionTrabajador2);

		JLabel labelGestionTrabajador3 = new JLabel("DNI Trabajador: ");
		labelGestionTrabajador3.setForeground(SystemColor.textHighlight);
		labelGestionTrabajador3.setFont(new Font("Arial", Font.BOLD, 16));
		labelGestionTrabajador3.setBounds(156, 257, 133, 15);
		add(labelGestionTrabajador3);

		JButton btnAniadir = new JButton("A\u00F1adir Trabajador");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aniadirTrabajador();
				modeloTabla.setRowCount(0);
				cargaTrabajadores();
				txtNombre.setText("");
				txtDniTrabajador.setText("");
				txtPuesto.setText("");
			}
		});

		btnAniadir.setFont(new Font("Arial", Font.BOLD, 18));
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setBackground(Color.BLUE);
		btnAniadir.setBounds(220, 470, 206, 35);
		add(btnAniadir);

		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.inactiveCaption);
		txtNombre.setBounds(294, 227, 121, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtDniTrabajador = new JTextField();
		txtDniTrabajador.setBackground(SystemColor.inactiveCaption);
		txtDniTrabajador.setColumns(10);
		txtDniTrabajador.setBounds(294, 257, 123, 20);
		add(txtDniTrabajador);

		JLabel labelGestionTrabajador4 = new JLabel("Eliminar Trabajador");
		labelGestionTrabajador4.setForeground(SystemColor.textHighlight);
		labelGestionTrabajador4.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelGestionTrabajador4.setBounds(1123, 128, 295, 40);
		add(labelGestionTrabajador4);

		JLabel labelGestionTrabajador5 = new JLabel("ID Trabajador:");
		labelGestionTrabajador5.setForeground(SystemColor.textHighlight);
		labelGestionTrabajador5.setFont(new Font("Arial", Font.BOLD, 16));
		labelGestionTrabajador5.setBounds(1123, 217, 115, 14);
		add(labelGestionTrabajador5);

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

		JLabel labelGestionTrabajador6 = new JLabel("Lista de Trabajadores");
		labelGestionTrabajador6.setForeground(SystemColor.textHighlight);
		labelGestionTrabajador6.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelGestionTrabajador6.setBounds(669, 464, 266, 40);
		add(labelGestionTrabajador6);
		Image img1 = new ImageIcon(this.getClass().getResource("/Sotecars.png")).getImage();
		Image modifiedImage = img1.getScaledInstance(243, 124, java.awt.Image.SCALE_SMOOTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(166, 523, 1218, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(
				new Object[] { "ID", "Nombre", "DNI", "Puesto_Trabajo", "Sueldo", "CP", "Poblacion", "Provincia", "Calle" });
		table.setModel(modeloTabla);

		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setForeground(SystemColor.textHighlight);
		lblPuesto.setFont(new Font("Arial", Font.BOLD, 16));
		lblPuesto.setBounds(220, 317, 91, 14);
		add(lblPuesto);

		txtPuesto = new JTextField();
		txtPuesto.setColumns(10);
		txtPuesto.setBackground(SystemColor.inactiveCaption);
		txtPuesto.setBounds(294, 317, 123, 20);
		add(txtPuesto);

		txtIdEliminar = new JTextField();
		txtIdEliminar.setColumns(10);
		txtIdEliminar.setBackground(SystemColor.inactiveCaption);
		txtIdEliminar.setBounds(1243, 215, 121, 20);
		add(txtIdEliminar);

		JLabel lblNewLabel_3 = new JLabel("SOTECARS");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(680, 208, 228, 52);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("THE POWER OF DREAMS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(714, 247, 152, 22);
		add(lblNewLabel_4);

		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(245, 347, 54, 14);
		add(lblCP);

		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(294, 347, 123, 20);
		add(txtCP);

		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(198, 407, 100, 20);
		add(lblPoblacion);

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

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(235, 437, 76, 23);
		add(lblCalle);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(202, 378, 100, 20);
		add(lblProvincia);

		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(294, 377, 123, 20);
		add(txtProvincia);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setForeground(SystemColor.textHighlight);
		lblSueldo.setFont(new Font("Arial", Font.BOLD, 16));
		lblSueldo.setBounds(220, 287, 70, 14);
		add(lblSueldo);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBackground(SystemColor.inactiveCaption);
		txtSueldo.setBounds(294, 287, 123, 20);
		add(txtSueldo);

		modeloTabla.setRowCount(0);

		cargaTrabajadores();

	}

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
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("Nombre"),
							rs.getObject("DNI"),rs.getObject("Puesto_Trabajo"), rs.getObject("Sueldo"), rs.getObject("CP"),
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
			String dni = txtDniTrabajador.getText();
			float sueldo = Float.parseFloat(txtSueldo.getText());
			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();
			String calle = txtCalle.getText();

			String agregar = "INSERT INTO trabajadores (Nombre, DNI, Puesto_Trabajo, Sueldo, CP, Provincia, Poblacion, Calle) VALUES('"
					+ nombre + "', '" + dni + "', '" + puesto + "', '" + sueldo + "', '" + cp + "', '" + provincia + "', '" + poblacion
					+ "', '" + calle + "')";
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
}
