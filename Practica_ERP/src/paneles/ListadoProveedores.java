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

public class ListadoProveedores extends JPanel {
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	/**
	 * Create the panel.
	 */
	public ListadoProveedores() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 177, 1218, 363);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblListaDeProveedores = new JLabel("Lista de proveedores");
		lblListaDeProveedores.setForeground(SystemColor.textHighlight);
		lblListaDeProveedores.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaDeProveedores.setBounds(590, 117, 291, 40);
		add(lblListaDeProveedores);

		modeloTabla.setColumnIdentifiers(
				new Object[] { "ID", "CIF", "Nombre", "Tipo_Proveedor", "CP", "Poblacion", "Provincia", "Calle" });
		table.setModel(modeloTabla);
		cargaProveedores();
	}
	
	public void cargaProveedores() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, CIF, Nombre, Tipo_Proveedor, CP, Provincia, Poblacion, Calle FROM Proveedores");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("CIF"), rs.getObject("Nombre"),
							rs.getObject("Tipo_Proveedor"), rs.getObject("CP"), rs.getObject("Provincia"),
							rs.getObject("Poblacion"), rs.getObject("Calle") });
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
