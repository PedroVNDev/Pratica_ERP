package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GestionarPoblaciones extends JPanel {
	private JTable table;
	private boolean carga = false;

	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JTextField txtIdEliminar;
	private JTextField txtCP;
	private JTextField txtPoblacion;
	private JTextField txtProvincia;

	/**
	 * Create the panel.
	 */
	public GestionarPoblaciones() {

		setBackground(SystemColor.window);
		setLayout(null);

		// Labels Añadir
		JLabel lblAniadirPoblacion = new JLabel("A\u00F1adir Poblacion");
		lblAniadirPoblacion.setForeground(SystemColor.textHighlight);
		lblAniadirPoblacion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAniadirPoblacion.setBounds(62, 30, 239, 40);
		add(lblAniadirPoblacion);

		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(103, 194, 46, 17);
		add(lblCP);

		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(49, 247, 108, 28);
		add(lblPoblacion);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(52, 221, 97, 20);
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

		JLabel lblListaClientes = new JLabel("Lista de Poblaciones");
		lblListaClientes.setForeground(SystemColor.textHighlight);
		lblListaClientes.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaClientes.setBounds(540, 354, 293, 40);
		add(lblListaClientes);

		// Labels Eliminar
		JLabel lblEliminarPoblacion = new JLabel("Eliminar Poblacion");
		lblEliminarPoblacion.setForeground(SystemColor.textHighlight);
		lblEliminarPoblacion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminarPoblacion.setBounds(1018, 30, 191, 40);
		add(lblEliminarPoblacion);

		JLabel lblIdClienteEliminar = new JLabel("CP:");
		lblIdClienteEliminar.setForeground(SystemColor.textHighlight);
		lblIdClienteEliminar.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdClienteEliminar.setBounds(1002, 173, 121, 20);
		add(lblIdClienteEliminar);

		// JTextFields Añadir
		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(145, 194, 130, 20);
		add(txtCP);

		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(145, 254, 132, 20);
		add(txtPoblacion);

		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(145, 224, 132, 20);
		add(txtProvincia);

		// JTextFields Eliminar
		txtIdEliminar = new JTextField();
		txtIdEliminar.setColumns(10);
		txtIdEliminar.setBackground(SystemColor.inactiveCaption);
		txtIdEliminar.setBounds(1107, 173, 121, 20);
		add(txtIdEliminar);

		// Botones
		JButton btnAniadir = new JButton("A\u00F1adir Poblacion");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aniadirPoblacion();
				modeloTabla.setRowCount(0);
				cargaPoblacion();
				resetJTextfields();

			}
		});

		btnAniadir.setFont(new Font("Arial", Font.BOLD, 18));
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setBackground(Color.BLUE);
		btnAniadir.setBounds(105, 384, 172, 35);
		add(btnAniadir);

		JButton btnEliminar = new JButton("Eliminar Poblacion");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				eliminarPoblacion();
				modeloTabla.setRowCount(0);
				cargaPoblacion();
				txtIdEliminar.setText("");
			}
		});

		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminar.setBackground(Color.BLUE);
		btnEliminar.setBounds(1051, 384, 177, 35);
		add(btnEliminar);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 431, 1218, 261);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "CP", "Poblacion", "Provincia" });
		table.setModel(modeloTabla);

		// Iconos
		Image img1 = new ImageIcon(this.getClass().getResource("/Sotecars.png")).getImage();
		Image modifiedImage = img1.getScaledInstance(243, 124, java.awt.Image.SCALE_SMOOTH);

		modeloTabla.setRowCount(0);
		cargaPoblacion();

	}

	// Metodos
	public void cargaPoblacion() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery("SELECT CP, Provincia, Poblacion FROM Poblaciones");

				while (rs.next()) {
					modeloTabla.addRow(
							new Object[] { rs.getObject("CP"), rs.getObject("Provincia"), rs.getObject("Poblacion") });
				}

				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}

	public void aniadirPoblacion() {

		try {

			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();

			String agregar = "INSERT INTO Poblaciones (CP, Provincia, Poblacion) VALUES('" + cp + "', '" + provincia
					+ "', '" + poblacion + "')";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Poblacion Agregada Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eliminarPoblacion() {
		int confirmar = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar la población escrita?");

		if (confirmar == JOptionPane.YES_OPTION) {

			try {

				int cp = Integer.parseInt(txtCP.getText());

				String eliminar = "DELETE FROM Poblaciones WHERE CP = '" + cp + "'";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
						"TRABAJO");
				Statement consulta = conexion.createStatement();

				consulta.executeUpdate(eliminar);

				JOptionPane.showMessageDialog(null, "Poblacion Eliminada Correctamente");

				conexion.close();
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
				ex2.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se eliminara la poblacion introducida");
		}
	}

	public void resetJTextfields() {

		txtCP.setText("");
		txtProvincia.setText("");
		txtPoblacion.setText("");

	}

}
