package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class GestionarVenta extends JPanel {
	private JTextField txtIdVehiculoVendido;
	private JTextField txtIdTrabajador;
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private static float precio_Compra;
	private static float precio_Venta;
	private static String modelo;
	private JTextField txtIdCliente;

	/**
	 * Create the panel.
	 */
	public GestionarVenta() {
		setBackground(Color.WHITE);
		setLayout(null);

		// Labels
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setForeground(SystemColor.textHighlight);
		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInventario.setBounds(596, 40, 214, 40);
		add(lblInventario);

		JLabel lblIdDeVehculo = new JLabel("Id de veh\u00EDculo vendido:");
		lblIdDeVehculo.setForeground(SystemColor.textHighlight);
		lblIdDeVehculo.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdDeVehculo.setBounds(395, 462, 183, 27);
		add(lblIdDeVehculo);

		JLabel lblIdDelTrabajador = new JLabel("Id del trabajador que ha gestionado la venta:");
		lblIdDelTrabajador.setForeground(SystemColor.textHighlight);
		lblIdDelTrabajador.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdDelTrabajador.setBounds(234, 503, 423, 27);
		add(lblIdDelTrabajador);

		// JTextFields
		txtIdVehiculoVendido = new JTextField();
		txtIdVehiculoVendido.setBounds(596, 468, 129, 19);
		add(txtIdVehiculoVendido);
		txtIdVehiculoVendido.setColumns(10);

		txtIdTrabajador = new JTextField();
		txtIdTrabajador.setBounds(596, 509, 129, 19);
		add(txtIdTrabajador);
		txtIdTrabajador.setColumns(10);

		JButton btnGenerarTiket = new JButton("Generar tiket ");
		btnGenerarTiket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cargaVenta();
				insertarVenta();

			}
		});
		btnGenerarTiket.setForeground(Color.WHITE);
		btnGenerarTiket.setFont(new Font("Arial", Font.BOLD, 18));
		btnGenerarTiket.setBackground(Color.BLUE);
		btnGenerarTiket.setBounds(520, 589, 172, 35);
		add(btnGenerarTiket);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 88, 1218, 363);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Modelo", "Eficiencia_Energetica", "Consumo", "Emisiones",
				"Precio_Venta", "Precio_Compra", "Caja_Cambios", "Año", "Matricula" });
		table.setModel(modeloTabla);

		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(596, 545, 129, 19);
		add(txtIdCliente);

		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setForeground(SystemColor.textHighlight);
		lblIdCliente.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdCliente.setBounds(489, 540, 89, 27);
		add(lblIdCliente);
		cargaInventario();

	}

	public void cargaInventario() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, Modelo, Eficiencia_Energetica, Consumo, Emisiones, Precio_Venta, Precio_Compra, Caja_Cambios, Año, Matricula from modelos");

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

	public void cargaVenta() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		int idvehiculo = Integer.parseInt(txtIdVehiculoVendido.getText());
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT Modelo, Precio_Venta, Precio_Compra from modelos where ID = " + idvehiculo);

				while (rs.next()) {
					modelo = (String) rs.getObject("modelo");
					precio_Venta = (Float) rs.getObject("precio_Venta");
					precio_Compra = (Float) rs.getObject("precio_Compra");
				}

				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}

	public void insertarVenta() {

		try {

			int idCliente = Integer.parseInt(txtIdCliente.getText());
			int idVehiculo = Integer.parseInt(txtIdVehiculoVendido.getText());
			int idTrabajador = Integer.parseInt(txtIdTrabajador.getText());

			String agregar = "INSERT INTO ventas (ID_Cliente, ID_Trabajador, Modelo, Precio_Compra, Precio_Venta) VALUES('"
					+ idCliente + "', '" + idTrabajador + "', '" + modelo + "', '" + precio_Compra + "', '"
					+ precio_Venta + "')";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Venta Agregada Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void resetTextFields() {

		txtIdCliente.setText("");
		txtIdTrabajador.setText("");
		txtIdVehiculoVendido.setText("");
	}

}
