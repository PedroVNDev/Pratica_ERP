package paneles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class ListadoVentas extends JPanel {
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public ListadoVentas() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 202, 1218, 363);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblListadoVentas = new JLabel("Listado Ventas");
		lblListadoVentas.setForeground(SystemColor.textHighlight);
		lblListadoVentas.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListadoVentas.setBounds(568, 136, 214, 40);
		add(lblListadoVentas);
		
		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "ID Clientes", "ID Trabajador", "ID Vehiculo", "Modelo",
				"Precio_Venta", "Precio_Compra" });
		table.setModel(modeloTabla);
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
						"SELECT ID, ID_Clientes, ID_Trabajador, ID_Vehiculo, Modelo, Precio_Venta, Precio_Compra from ventas");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("ID_Clientes"),
							rs.getObject("ID_Trabajador"), rs.getObject("ID_Vehiculo"), rs.getObject("Modelo"),
							rs.getObject("Precio_Venta"), rs.getObject("Precio_Compra")});
				}

				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}

}
