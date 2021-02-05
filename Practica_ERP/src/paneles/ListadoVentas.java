package paneles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
		
		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "ID Clientes", "Nombre Trabajador", "ID Vehiculo", "Modelo",
				"Precio_Venta", "Precio_Compra" });
		table.setModel(modeloTabla);
		cargarArrayListsVentas();

	}
	
public void cargarArrayListsVentas() {
		
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		Float precioLoco;
		
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ventas.ID, ventas.ID_Cliente, ventas.ID_Trabajador, ventas.Fecha, ventas.ID_Vehiculo, ventas.Modelo, ventas.Precio_Venta, ventas.Precio_Compra, trabajadores.Nombre from ventas INNER JOIN Trabajadores on ventas.ID_Trabajador = trabajadores.ID ");
				
				String idString, ventasString, ingresosString;
				
				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("ID_Cliente"),
							rs.getObject("trabajadores.Nombre"), rs.getObject("ID_Vehiculo"), rs.getObject("Modelo"),
							rs.getObject("Precio_Venta"), rs.getObject("Precio_Compra")});
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
