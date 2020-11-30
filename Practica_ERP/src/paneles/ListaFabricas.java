package paneles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;


public class ListaFabricas extends JPanel {
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public ListaFabricas() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 243, 1113, 384);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblListaDeFabricas = new JLabel("Lista de fabricas");
		lblListaDeFabricas.setForeground(SystemColor.textHighlight);
		lblListaDeFabricas.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaDeFabricas.setBounds(568, 193, 214, 40);
		add(lblListaDeFabricas);
		
		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Nombre", "Producto", "Email", "Telefono" ,"CP", "Provincia", "Poblacion", "Calle" });
		table.setModel(modeloTabla);
		cargaFabricas();

	}
	
	public void cargaFabricas() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT * FROM Fabricas");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("Nombre"),
							rs.getObject("Producto"), rs.getObject("Email"), rs.getObject("Telefono"), rs.getObject("CP"), rs.getObject("Provincia"), rs.getObject("Poblacion"), rs.getObject("Calle") });
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
