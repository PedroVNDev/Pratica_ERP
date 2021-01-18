package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class GestionEscandallos extends JPanel {
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	/**
	 * Create the panel.
	 */
	public GestionEscandallos() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(517, 70, 152, 22);
		add(lblSotecars2);
		
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(483, 31, 228, 52);
		add(lblSotecars1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 247, 620, 402);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		modeloTabla.setColumnIdentifiers(new Object[] {"ID vehiculo", "Precio de compra", "Descripcion Problemas", "Costo de problemas", "Costo total vehiculo"});
		table.setModel(modeloTabla);

		modeloTabla.setRowCount(0);
		cargaEscandallos();
		//table.setRowHeight(1, 30);
	}
	public void cargaEscandallos() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT id_vehiculo, precio_compra, gastos_vehiculo, descripcion_problemas, costo_total FROM escandallo");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("id_vehiculo"), rs.getObject("precio_compra"), rs.getObject("gastos_vehiculo"),
							rs.getObject("descripcion_problemas"), rs.getObject("costo_total")});
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
