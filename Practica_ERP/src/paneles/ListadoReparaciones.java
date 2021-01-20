package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListadoReparaciones extends JPanel {
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	/**
	 * Create the panel.
	 */
	public ListadoReparaciones() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 261, 1218, 261);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "Empleado ", "Materiales necesarios", "Presupuesto", "Fecha de entrega" });
		table.setModel(modeloTabla);
		table.setRowHeight(1, 2);

		modeloTabla.setRowCount(0);
		cargaReparaciones();
		
		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(661, 125, 152, 22);
		add(lblSotecars2);
		
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(627, 86, 228, 52);
		add(lblSotecars1);

	}
	
	public void cargaReparaciones() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT id_empleado, descripcion, precio_total, fecha_entrega FROM mantenimiento");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("id_empleado"), rs.getObject("descripcion"), rs.getObject("precio_total"),
							rs.getObject("fecha_entrega") });
				}

				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("Ningun error");
		}
	}
}
