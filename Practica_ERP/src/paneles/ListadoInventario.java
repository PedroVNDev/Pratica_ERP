package paneles;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListadoInventario extends JPanel {

	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public ListadoInventario() {
		setLayout(null);

		// Labels
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setForeground(SystemColor.textHighlight);
		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInventario.setBounds(610, 162, 214, 40);
		add(lblInventario);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 213, 1218, 363);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Modelo", "Eficiencia_Energetica", "Consumo", "Emisiones",
				"Precio_Venta", "Precio_Compra", "Caja_Cambios", "Año", "Matricula" });
		table.setModel(modeloTabla);
		cargaInventario();

	}

	//Metodos
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
}
