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
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextPane;

public class GestionInventario extends JPanel {
	private boolean carga = false;

	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JTextField txtModelo;
	private JTextField txtConsumo;
	private JTextField txtEmisiones;
	private JTextField txtPrecioVenta;
	private JTextField txtPrecioCompra;
	private JTextField txtAnio;
	private JTextField txtMatricula;
	private JComboBox cbCambios;
	private JComboBox cbEficiencias;

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
		lblAniadirVehiculo.setBounds(559, 123, 281, 40);
		add(lblAniadirVehiculo);

		JLabel lblModelo = new JLabel("Modelo Vehiculo:");
		lblModelo.setForeground(SystemColor.textHighlight);
		lblModelo.setFont(new Font("Arial", Font.BOLD, 16));
		lblModelo.setBounds(7, 289, 149, 35);
		add(lblModelo);

		JLabel lblEficiencia = new JLabel("Eficiencia:");
		lblEficiencia.setForeground(SystemColor.textHighlight);
		lblEficiencia.setFont(new Font("Arial", Font.BOLD, 16));
		lblEficiencia.setBounds(61, 334, 108, 15);
		add(lblEficiencia);

		JLabel lblConsumo = new JLabel("Consumo:");
		lblConsumo.setForeground(SystemColor.textHighlight);
		lblConsumo.setFont(new Font("Arial", Font.BOLD, 16));
		lblConsumo.setBounds(61, 374, 91, 14);
		add(lblConsumo);

		JLabel lblEmisiones = new JLabel("Emisiones:");
		lblEmisiones.setForeground(SystemColor.textHighlight);
		lblEmisiones.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmisiones.setBounds(51, 414, 98, 15);
		add(lblEmisiones);

		JLabel lblCajaCambios = new JLabel("Caja Cambios:");
		lblCajaCambios.setForeground(SystemColor.textHighlight);
		lblCajaCambios.setFont(new Font("Arial", Font.BOLD, 16));
		lblCajaCambios.setBounds(510, 274, 121, 19);
		add(lblCajaCambios);

		JLabel lblPrecioVenta = new JLabel("PrecioVenta:");
		lblPrecioVenta.setForeground(SystemColor.textHighlight);
		lblPrecioVenta.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioVenta.setBounds(523, 312, 108, 14);
		add(lblPrecioVenta);

		JLabel lblPrecioCompra = new JLabel("Precio Compra:");
		lblPrecioCompra.setForeground(SystemColor.textHighlight);
		lblPrecioCompra.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioCompra.setBounds(510, 347, 121, 14);
		add(lblPrecioCompra);

		JLabel lblAnio = new JLabel("A\u00F1o:");
		lblAnio.setForeground(SystemColor.textHighlight);
		lblAnio.setFont(new Font("Arial", Font.BOLD, 16));
		lblAnio.setBounds(575, 382, 134, 19);
		add(lblAnio);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setForeground(SystemColor.textHighlight);
		lblMatricula.setFont(new Font("Arial", Font.BOLD, 16));
		lblMatricula.setBounds(542, 420, 134, 23);
		add(lblMatricula);

		// Labels Mitad
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(537, 50, 228, 52);
		add(lblSotecars1);

		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(571, 89, 152, 22);
		add(lblSotecars2);

		// JTextFields Añadir
		txtModelo = new JTextField();
		txtModelo.setBackground(SystemColor.inactiveCaption);
		txtModelo.setBounds(153, 299, 121, 20);
		add(txtModelo);
		txtModelo.setColumns(10);

		txtConsumo = new JTextField();
		txtConsumo.setColumns(10);
		txtConsumo.setBackground(SystemColor.inactiveCaption);
		txtConsumo.setBounds(151, 375, 123, 20);
		add(txtConsumo);

		txtEmisiones = new JTextField();
		txtEmisiones.setColumns(10);
		txtEmisiones.setBackground(SystemColor.inactiveCaption);
		txtEmisiones.setBounds(151, 414, 123, 20);
		add(txtEmisiones);

		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBackground(SystemColor.inactiveCaption);
		txtPrecioVenta.setBounds(642, 312, 123, 20);
		add(txtPrecioVenta);

		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setColumns(10);
		txtPrecioCompra.setBackground(SystemColor.inactiveCaption);
		txtPrecioCompra.setBounds(644, 347, 123, 20);
		add(txtPrecioCompra);

		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBackground(SystemColor.inactiveCaption);
		txtAnio.setBounds(644, 384, 123, 20);
		add(txtAnio);

		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBackground(SystemColor.inactiveCaption);
		txtMatricula.setBounds(642, 424, 123, 20);
		add(txtMatricula);

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
		btnAniadir.setBounds(553, 542, 214, 35);
		add(btnAniadir);

		cbCambios = new JComboBox();
		cbCambios.setBounds(642, 275, 123, 21);
		add(cbCambios);
		cbCambios.addItem("");
		cbCambios.addItem("Manual");
		cbCambios.addItem("Automatico");

		cbEficiencias = new JComboBox();
		cbEficiencias.setBounds(153, 334, 121, 21);
		add(cbEficiencias);
		cbEficiencias.addItem("SELECCIONA");
		cbEficiencias.addItem("0");
		cbEficiencias.addItem("ECO");
		cbEficiencias.addItem("B");
		cbEficiencias.addItem("C");
		
		JLabel lblCaracteristicasVehiculo = new JLabel("Caracteristicas Vehiculo");
		lblCaracteristicasVehiculo.setForeground(SystemColor.textHighlight);
		lblCaracteristicasVehiculo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCaracteristicasVehiculo.setBounds(276, 207, 400, 40);
		add(lblCaracteristicasVehiculo);
		
		JLabel lblProblemasHayados = new JLabel("Problemas Hayados");
		lblProblemasHayados.setForeground(SystemColor.textHighlight);
		lblProblemasHayados.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProblemasHayados.setBounds(964, 117, 400, 40);
		add(lblProblemasHayados);
		
		JLabel lblDescripcionProblema = new JLabel("Descripcion Problema");
		lblDescripcionProblema.setForeground(SystemColor.textHighlight);
		lblDescripcionProblema.setFont(new Font("Arial", Font.BOLD, 16));
		lblDescripcionProblema.setBounds(880, 220, 198, 19);
		add(lblDescripcionProblema);
		
		JLabel lblPrecioDeReparacion = new JLabel("Precio estimado de reparacion");
		lblPrecioDeReparacion.setForeground(SystemColor.textHighlight);
		lblPrecioDeReparacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioDeReparacion.setBounds(887, 471, 288, 19);
		add(lblPrecioDeReparacion);
		
		JSpinner spinner_1_1_3 = new JSpinner();
		spinner_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner_1_1_3.setBounds(1184, 471, 72, 20);
		add(spinner_1_1_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(880, 257, 453, 153);
		add(textPane);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Modelo", "Eficiencia", "Consumo", "Emisiones",
				"Precio_Venta", "Precio_Compra", "Caja_Cambios", "Año", "Matricula" });

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
			String eficiencia = (String) cbEficiencias.getSelectedItem();
			float consumo = Float.parseFloat(txtConsumo.getText());
			float emisiones = Float.parseFloat(txtConsumo.getText());
			float precio_venta = Float.parseFloat(txtPrecioVenta.getText());
			float precio_compra = Float.parseFloat(txtPrecioCompra.getText());
			String caja_cambios = (String) cbCambios.getSelectedItem();
			int anio = Integer.parseInt(txtAnio.getText());
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

	public void resetTextfieldsGestionInventario() {

		txtModelo.setText("");
		txtConsumo.setText("");
		txtEmisiones.setText("");
		txtPrecioVenta.setText("");
		txtPrecioCompra.setText("");
		txtAnio.setText("");
		txtMatricula.setText("");

	}
}
