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

public class ListadoContactos extends JPanel {
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	/**
	 * Create the panel.
	 */
	public ListadoContactos() {
		setLayout(null);
		
		//Labels
		JLabel lblListaContactos = new JLabel("Lista de contactos");
		lblListaContactos.setForeground(SystemColor.textHighlight);
		lblListaContactos.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblListaContactos.setBounds(590, 117, 291, 40);
		add(lblListaContactos);
		
		//Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 177, 1218, 363);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		modeloTabla.setColumnIdentifiers(
				new Object[] { "ID", "DNI", "Nombre", "Apellidos", "ID:_Vehiculo", "Precio_Compra", "CP", "Provincia", "Poblacion", "Calle" });
		table.setModel(modeloTabla);
		cargaContactos();
	}
	
	//Metodos
	public void cargaContactos() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, DNI, Nombre, Apellidos, ID_Vehiculo, Precio_Compra, CP, Provincia, Poblacion, Calle  FROM contactos_compra");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("DNI"), rs.getObject("Nombre"),
							rs.getObject("Apellidos"), rs.getObject("ID_Vehiculo"), rs.getObject("Precio_Compra"),
							rs.getObject("CP"), rs.getObject("Provincia"), rs.getObject("Poblacion"), rs.getObject("Calle") });
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
