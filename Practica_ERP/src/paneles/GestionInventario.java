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

public class GestionInventario extends JPanel {
	private JTable table;
	private boolean carga = false;

	DefaultTableModel modeloTabla = new DefaultTableModel();

	private JTextField txtIdEliminarStock;
	private JTextField txtModelo;
	private JTextField txtEficiencia;
	private JTextField txtConsumo;
	private JTextField txtEmisiones;
	private JTextField txtPrecioVenta;
	private JTextField txtPrecioCompra;
	private JTextField txtCajaCambios;
	private JTextField txtAnio;
	private JTextField txtMatricula;

	/**
	 * Create the panel.
	 */
	public GestionInventario() {

		setBackground(SystemColor.window);
		setLayout(null);

		// Labels Añadir
		JLabel lblAniadirVehiculo = new JLabel("A\u00F1adir Vehiculo");
		lblAniadirVehiculo.setForeground(SystemColor.textHighlight);
		lblAniadirVehiculo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAniadirVehiculo.setBounds(216, 97, 182, 40);
		add(lblAniadirVehiculo);

		JLabel lblModelo = new JLabel("Modelo Vehiculo:");
		lblModelo.setForeground(SystemColor.textHighlight);
		lblModelo.setFont(new Font("Arial", Font.BOLD, 16));
		lblModelo.setBounds(162, 134, 149, 35);
		add(lblModelo);

		JLabel lblEficiencia = new JLabel("Eficiencia:");
		lblEficiencia.setForeground(SystemColor.textHighlight);
		lblEficiencia.setFont(new Font("Arial", Font.BOLD, 16));
		lblEficiencia.setBounds(195, 179, 108, 15);
		add(lblEficiencia);

		JLabel lblConsumo = new JLabel("Consumo:");
		lblConsumo.setForeground(SystemColor.textHighlight);
		lblConsumo.setFont(new Font("Arial", Font.BOLD, 16));
		lblConsumo.setBounds(214, 220, 91, 14);
		add(lblConsumo);

		JLabel lblEmisiones = new JLabel("Emisiones:");
		lblEmisiones.setForeground(SystemColor.textHighlight);
		lblEmisiones.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmisiones.setBounds(195, 259, 101, 14);
		add(lblEmisiones);

		JLabel lblCajaCambios = new JLabel("Caja Cambios:");
		lblCajaCambios.setForeground(SystemColor.textHighlight);
		lblCajaCambios.setFont(new Font("Arial", Font.BOLD, 16));
		lblCajaCambios.setBounds(195, 306, 108, 14);
		add(lblCajaCambios);

		JLabel lblPrecioVenta = new JLabel("PrecioVenta:");
		lblPrecioVenta.setForeground(SystemColor.textHighlight);
		lblPrecioVenta.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioVenta.setBounds(203, 336, 108, 14);
		add(lblPrecioVenta);

		JLabel lblPrecioCompra = new JLabel("Precio Compra:");
		lblPrecioCompra.setForeground(SystemColor.textHighlight);
		lblPrecioCompra.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioCompra.setBounds(159, 369, 121, 14);
		add(lblPrecioCompra);

		JLabel lblAnio = new JLabel("A\u00F1o:");
		lblAnio.setForeground(SystemColor.textHighlight);
		lblAnio.setFont(new Font("Arial", Font.BOLD, 16));
		lblAnio.setBounds(162, 395, 121, 14);
		add(lblAnio);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setForeground(SystemColor.textHighlight);
		lblMatricula.setFont(new Font("Arial", Font.BOLD, 16));
		lblMatricula.setBounds(162, 417, 121, 14);
		add(lblMatricula);

		// Labels Mitad
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(694, 177, 228, 52);
		add(lblSotecars1);

		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(728, 216, 152, 22);
		add(lblSotecars2);

		JLabel lblListaVehiculos = new JLabel("Lista de Vehiculos");
		lblListaVehiculos.setForeground(SystemColor.textHighlight);
		lblListaVehiculos.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaVehiculos.setBounds(707, 433, 214, 40);
		add(lblListaVehiculos);

		// Labels Eliminar
		JLabel lblEliminarVehiculo = new JLabel("Eliminar Vehiculo");
		lblEliminarVehiculo.setForeground(SystemColor.textHighlight);
		lblEliminarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEliminarVehiculo.setBounds(1169, 97, 191, 40);
		add(lblEliminarVehiculo);

		JLabel lblIdVehiculo = new JLabel("ID Vehiculo:");
		lblIdVehiculo.setForeground(SystemColor.textHighlight);
		lblIdVehiculo.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdVehiculo.setBounds(1160, 184, 115, 14);
		add(lblIdVehiculo);

		// JTextFields Añadir
		txtModelo = new JTextField();
		txtModelo.setBackground(SystemColor.inactiveCaption);
		txtModelo.setBounds(308, 144, 121, 20);
		add(txtModelo);
		txtModelo.setColumns(10);

		txtEficiencia = new JTextField();
		txtEficiencia.setBackground(SystemColor.inactiveCaption);
		txtEficiencia.setColumns(10);
		txtEficiencia.setBounds(308, 179, 123, 20);
		add(txtEficiencia);

		txtConsumo = new JTextField();
		txtConsumo.setColumns(10);
		txtConsumo.setBackground(SystemColor.inactiveCaption);
		txtConsumo.setBounds(306, 220, 123, 20);
		add(txtConsumo);

		txtEmisiones = new JTextField();
		txtEmisiones.setColumns(10);
		txtEmisiones.setBackground(SystemColor.inactiveCaption);
		txtEmisiones.setBounds(306, 259, 123, 20);
		add(txtEmisiones);

		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBackground(SystemColor.inactiveCaption);
		txtPrecioVenta.setBounds(306, 336, 123, 20);
		add(txtPrecioVenta);

		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setColumns(10);
		txtPrecioCompra.setBackground(SystemColor.inactiveCaption);
		txtPrecioCompra.setBounds(306, 368, 123, 20);
		add(txtPrecioCompra);

		txtCajaCambios = new JTextField();
		txtCajaCambios.setColumns(10);
		txtCajaCambios.setBackground(SystemColor.inactiveCaption);
		txtCajaCambios.setBounds(308, 300, 123, 20);
		add(txtCajaCambios);

		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBackground(SystemColor.inactiveCaption);
		txtAnio.setBounds(309, 394, 123, 20);
		add(txtAnio);

		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBackground(SystemColor.inactiveCaption);
		txtMatricula.setBounds(309, 416, 123, 20);
		add(txtMatricula);

		// JTextFields Eliminar
		txtIdEliminarStock = new JTextField();
		txtIdEliminarStock.setColumns(10);
		txtIdEliminarStock.setBackground(SystemColor.inactiveCaption);
		txtIdEliminarStock.setBounds(1257, 184, 121, 20);
		add(txtIdEliminarStock);

		// Botones
		JButton btnAniadir = new JButton("A\u00F1adir Vehiculo");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aniadirVehiculo();
				modeloTabla.setRowCount(0);
				cargaVehiculos();
				resetTextfieldsGestionInventario();
			}
		});

		btnAniadir.setFont(new Font("Arial", Font.BOLD, 18));
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setBackground(Color.BLUE);
		btnAniadir.setBounds(259, 447, 172, 35);
		add(btnAniadir);

		JButton btnEliminar = new JButton("Eliminar Vehiculo");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				eliminarVehiculo();
				modeloTabla.setRowCount(0);
				cargaVehiculos();
				txtIdEliminarStock.setText(" ");
			}
		});

		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminar.setBackground(Color.BLUE);
		btnEliminar.setBounds(1205, 447, 177, 35);
		add(btnEliminar);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 518, 1218, 261);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Modelo", "Eficiencia", "Consumo", "Emisiones",
				"Precio_Venta", "Precio_Compra", "Caja_Cambios", "Año", "Matricula" });
		table.setModel(modeloTabla);

		modeloTabla.setRowCount(0);
		cargaVehiculos();

	}

	// Metodos
	public void cargaVehiculos() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, MODELO, EFICIENCIA_ENERGETICA, CONSUMO, EMISIONES, PRECIO_VENTA, PRECIO_COMPRA, CAJA_CAMBIOS, AÑO, MATRICULA FROM modelos");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("Modelo"),
							rs.getObject("Eficiencia_Energetica"), rs.getObject("Consumo"), rs.getObject("Emisiones"),
							rs.getObject("Precio_Venta"), rs.getObject("Precio_Compra"), rs.getObject("Caja_Cambios"),
							rs.getObject("Año"), rs.getObject("Matricula") });
				}

				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}

	public void aniadirVehiculo() {

		try {

			String modelo = txtModelo.getText();
			String eficiencia = txtEficiencia.getText();
			float consumo = Float.parseFloat(txtConsumo.getText());
			int emisiones = Integer.parseInt(txtConsumo.getText());
			int precio_venta = Integer.parseInt(txtPrecioVenta.getText());
			int precio_compra = Integer.parseInt(txtPrecioCompra.getText());
			String caja_cambios = txtCajaCambios.getText();
			String anio = txtAnio.getText();
			String matricula = txtMatricula.getText();

			String agregar = "INSERT INTO modelos (MODELO, EFICIENCIA_ENERGETICA, CONSUMO, EMISIONES, PRECIO_VENTA, PRECIO_COMPRA, CAJA_CAMBIOS, AÑO, MATRICULA) VALUES('"
					+ modelo + "', '" + eficiencia + "', '" + consumo + "', '" + emisiones + "', '" + precio_venta
					+ "', '" + precio_compra + "', '" + caja_cambios + "', '" + anio + "', '" + matricula + "');";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Vehiculo Agregado Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eliminarVehiculo() {
		int confirmar = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el vehiculo escrito?");

		if (confirmar == JOptionPane.YES_OPTION) {

			try {

				String vehiculo = (txtIdEliminarStock.getText());

				String eliminar = "DELETE FROM modelos WHERE ID = '" + vehiculo + "'";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
						"TRABAJO");
				Statement consulta = conexion.createStatement();

				consulta.executeUpdate(eliminar);

				JOptionPane.showMessageDialog(null, "Vehiculo Eliminado Correctamente");

				conexion.close();
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
				ex2.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se eliminara el vehiculo introducido");
		}
	}

	public void resetTextfieldsGestionInventario() {

		txtModelo.setText("");
		txtEficiencia.setText("");
		txtConsumo.setText("");
		txtEmisiones.setText("");
		txtPrecioVenta.setText("");
		txtPrecioCompra.setText("");
		txtCajaCambios.setText("");
		txtAnio.setText("");
		txtMatricula.setText("");

	}
}
