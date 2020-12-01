package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestionInformes extends JPanel {

	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	/**
	 * Create the panel.
	 */
	public GestionInformes() {
		
			setBackground(Color.WHITE);
			setLayout(null);
			
			//Labels
			JLabel lblInformes = new JLabel("Informes");
			lblInformes.setForeground(SystemColor.textHighlight);
			lblInformes.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblInformes.setBounds(610, 162, 214, 40);
			add(lblInformes);
			
			
			

		}
		
		//Metodos
		public void cargaClientes() {
			
			//Tabla
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(56, 213, 1218, 363);
			add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Nombre", "Telefono", "DNI", "Domicilio" ,"CP", "Poblacion", "Provincia" });
			table.setModel(modeloTabla);
			cargaClientes();
			
			Connection conexion = null;
			Statement sql = null;
			ResultSet rs = null;
			try {
				try {
					conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
					sql = conexion.createStatement();
					rs = sql.executeQuery(
							"SELECT ID, Nombre, Telefono, DNI, CP, Provincia, Poblacion, Calle FROM Clientes");

					while (rs.next()) {
						modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("Nombre"),
								rs.getObject("Telefono"), rs.getObject("DNI"), rs.getObject("CP"),
								rs.getObject("Provincia"), rs.getObject("Poblacion"), rs.getObject("Calle") });
					}

					conexion.close();
				} catch (SQLException e) {
					System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
				}
			} finally {
				System.out.println("Ningun error");
			}
		}

	public void crearTXT(String nombre, boolean puesto) throws IOException {
		File fichero = new File("Accesos.txt");
		BufferedWriter buffer = new BufferedWriter(new PrintWriter(fichero));

		Calendar calendario = Calendar.getInstance();
		java.util.Date fecha = new Date();

		if (puesto) {

			buffer.write(nombre.toUpperCase() + "               ACCEDIO A LAS: " + calendario.get(Calendar.HOUR_OF_DAY)
					+ ":" + calendario.get(Calendar.MINUTE) + " A DIA: " + fecha.getDay() + " DEL MES: "
					+ fecha.getMonth() + "               CON PERMISOS DE ADMINISTRADOR");
			buffer.close();

		} else if (!puesto) {

			buffer.write(nombre.toUpperCase() + "               ACCEDIO A LAS: " + calendario.get(Calendar.HOUR_OF_DAY)
					+ ":" + calendario.get(Calendar.MINUTE) + " A DIA: " + fecha.getDay() + " DEL MES: "
					+ fecha.getMonth() + "               CON PERMISOS DE TRABAJADOR");
			buffer.close();

		}
	}

}
