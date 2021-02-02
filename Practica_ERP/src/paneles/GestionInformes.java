package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
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

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionInformes extends JPanel {

	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	
	public ArrayList<Integer> idEmpleados = new ArrayList<Integer>();
	public ArrayList<String> nombres = new ArrayList<String>();
	public ArrayList<String> apellidos = new ArrayList<String>();
	public ArrayList<Long> ventas = new ArrayList<Long>();
	public ArrayList<Double> ingresos = new ArrayList<Double>();

	
	public ArrayList<Integer> idVenta=new ArrayList<>();
	public ArrayList<String> fechas=new ArrayList<>();
	/**
	 * Create the panel.
	 */
	public GestionInformes() {

		setBackground(Color.WHITE);
		setLayout(null);

		// Labels
		JLabel lblInformes = new JLabel("Informes");
		lblInformes.setForeground(SystemColor.textHighlight);
		lblInformes.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInformes.setBounds(617, 120, 108, 40);
		add(lblInformes);

		// Botones
		JButton btnInforme1 = new JButton("Generar Informe Trabajadores");
		btnInforme1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarArrayListsTrabajadores();

			}
		});
		btnInforme1.setForeground(Color.WHITE);
		btnInforme1.setFont(new Font("Arial", Font.BOLD, 18));
		btnInforme1.setBackground(Color.BLUE);
		btnInforme1.setBounds(57, 34, 310, 35);
		add(btnInforme1);

		JButton btnInforme2 = new JButton("Generar Informe2");
		btnInforme2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarArrayListsVentas();

			}
		});
		btnInforme2.setForeground(Color.WHITE);
		btnInforme2.setFont(new Font("Arial", Font.BOLD, 18));
		btnInforme2.setBackground(Color.BLUE);
		btnInforme2.setBounds(57, 80, 310, 35);
		add(btnInforme2);

		JButton btnInforme3 = new JButton("Generar Informe3");
		btnInforme3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				informe3();

			}
		});
		btnInforme3.setForeground(Color.WHITE);
		btnInforme3.setFont(new Font("Arial", Font.BOLD, 18));
		btnInforme3.setBackground(Color.BLUE);
		btnInforme3.setBounds(57, 126, 310, 35);
		add(btnInforme3);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 177, 1218, 363);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

	}

	// Metodos
	public void informe3() {

		modeloTabla.setColumnIdentifiers(new Object[] { "informe3", "DNI", "Nombre", "Apellidos", "ID:_Vehiculo",
				"Precio_Compra", "CP", "Provincia", "Poblacion", "Calle" });
		table.setModel(modeloTabla);

	}
	
	public void cargarArrayListsTrabajadores() {
		
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		
		modeloTabla.setColumnIdentifiers(new Object[] { "ID_Trabajador", "Nombre", "Apellidos", "Vehiculos_Vendidos", "Ingresos" });
		table.setModel(modeloTabla);
		
		
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ventas.ID_Trabajador, trabajadores.Nombre, trabajadores.Apellidos, count(ventas.ID_Vehiculo) AS Vehiculos_Vendidos, SUM(ventas.Precio_Venta) AS Ingresos "
								+ "FROM ventas " + "INNER JOIN trabajadores ON ventas.ID_Trabajador = trabajadores.ID "
								+ " GROUP BY ID_Trabajador" + " ORDER BY `Ingresos`  DESC ");
				
				while (rs.next()) {
					
					modeloTabla.addRow(new Object[] { rs.getObject("ID_Trabajador"), rs.getObject("Nombre"),
							rs.getObject("Apellidos"), rs.getObject("Vehiculos_Vendidos"), rs.getObject("Ingresos"), });
					
					nombres.add((String) rs.getObject("Nombre"));
					apellidos.add((String) rs.getObject("Apellidos"));
					ventas.add((Long) rs.getObject("Vehiculos_Vendidos"));
					ingresos.add((Double) rs.getObject("Ingresos"));
					
				}
				
				GenerarArchivoPDFTrabajadores();
				JOptionPane.showMessageDialog(null, "Archivo Generado");
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("Ningun error");
		}
		
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
				
				
				Document documento = new Document();
				
				try {
					
					String idString, ventasString, ingresosString;
					
					FileOutputStream ficheroPDF = new FileOutputStream("ventas.pdf");
					PdfWriter.getInstance(documento, ficheroPDF);
					documento.setMargins(10, 10, 10, 10);
					documento.open();
					
					
					Paragraph titulo = new Paragraph("Informe de trabajadores SOTECARS"
							+ "\n"
							+ "\n", FontFactory.getFont("arial", 22, Font.BOLD,BaseColor.BLUE));
					titulo.setAlignment(Element.ALIGN_CENTER);
					
					documento.add(titulo); 
					
					PdfPTable table = new PdfPTable(7);
					table.setHorizontalAlignment(Element.ALIGN_CENTER);

			        // t.setBorderColor(BaseColor.GRAY);
			        // t.setPadding(4);
			        // t.setSpacing(4);
			        // t.setBorderWidth(1);

					PdfPCell c1 = new PdfPCell(new Phrase("ID VENTA"));
				    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				    table.addCell(c1);
				        
			        c1 = new PdfPCell(new Phrase("TRABAJADOR"));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);

			        c1 = new PdfPCell(new Phrase("FECHA"));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
			        
			        c1 = new PdfPCell(new Phrase("MODELO"));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
			        
			        c1 = new PdfPCell(new Phrase("BASE IMPONIBLE"));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
			        table.setHeaderRows(1);
			        
			        c1 = new PdfPCell(new Phrase("CUOTA IVA"));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
			        table.setHeaderRows(1);
			        
			        c1 = new PdfPCell(new Phrase("TOTAL"));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
			        table.setHeaderRows(1);
			       
			        
				while (rs.next()) {
					
					table.addCell(rs.getObject("ventas.id").toString());
		        	table.addCell(rs.getObject("trabajadores.Nombre").toString());
		        	table.addCell(rs.getObject("ventas.Fecha").toString());
		        	table.addCell(rs.getObject("ventas.modelo").toString());
		        	table.addCell(rs.getObject("ventas.Precio_Venta").toString());
		        	precioLoco= Float.parseFloat(rs.getObject("ventas.Precio_Venta").toString());
		        	precioLoco= (float) (precioLoco*0.21);
		        	table.addCell(precioLoco.toString());
		        	precioLoco=(precioLoco+ Float.parseFloat(rs.getObject("ventas.Precio_Venta").toString()));
		        	table.addCell(precioLoco.toString());
		        	
					
					//ID_VENTA, ID_Trabajador, Fecha, Nombre de vehiculo, Base_Imponible, Cuota_IVA, Total

				}
				
				documento.add(table);
				documento.close();
				
			} catch (FileNotFoundException | DocumentException e) {
				e.printStackTrace();
			}
				JOptionPane.showMessageDialog(null, "Archivo Generado");
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("Ningun error");
		}
		
	}
	
	public void GenerarArchivoPDFTrabajadores() {

		Document documento = new Document();
		
		try {
			
			String idString, ventasString, ingresosString;
			
			FileOutputStream ficheroPDF = new FileOutputStream("trabajadores.pdf");
			PdfWriter.getInstance(documento, ficheroPDF);
			documento.setMargins(10, 10, 10, 10);
			documento.open();
			
			
			Paragraph titulo = new Paragraph("Informe de trabajadores SOTECARS"
					+ "\n"
					+ "\n", FontFactory.getFont("arial", 22, Font.BOLD,BaseColor.BLUE));
			titulo.setAlignment(Element.ALIGN_CENTER);
			
			documento.add(titulo); 
			
			PdfPTable table = new PdfPTable(4);
			table.setHorizontalAlignment(Element.ALIGN_CENTER);

	        // t.setBorderColor(BaseColor.GRAY);
	        // t.setPadding(4);
	        // t.setSpacing(4);
	        // t.setBorderWidth(1);

	        PdfPCell c1 = new PdfPCell(new Phrase("NOMBRE"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("APELLIDOS"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("VEHICULOS_VENDIDOS"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("INGRESOS"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        table.setHeaderRows(1);
	        
	        for(int x = 0; x < nombres.size(); x++) {
	        	
	        	ventasString = ventas.get(x).toString();
	        	ingresosString = ingresos.get(x).toString();
	        	
	        	table.addCell(nombres.get(x));
	        	table.addCell(apellidos.get(x));
	        	table.addCell(ventasString);
	        	table.addCell(ingresosString);
	        		
	        }

	        documento.add(table);
			documento.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		}
	
	public void GenerarArchivoPDFVentas() {

		Document documento = new Document();
		
		try {
			
			String idString, ventasString, ingresosString;
			
			FileOutputStream ficheroPDF = new FileOutputStream("ventas.pdf");
			PdfWriter.getInstance(documento, ficheroPDF);
			documento.setMargins(10, 10, 10, 10);
			documento.open();
			
			
			Paragraph titulo = new Paragraph("Informe de trabajadores SOTECARS"
					+ "\n"
					+ "\n", FontFactory.getFont("arial", 22, Font.BOLD,BaseColor.BLUE));
			titulo.setAlignment(Element.ALIGN_CENTER);
			
			documento.add(titulo); 
			
			PdfPTable table = new PdfPTable(4);
			table.setHorizontalAlignment(Element.ALIGN_CENTER);

	        // t.setBorderColor(BaseColor.GRAY);
	        // t.setPadding(4);
	        // t.setSpacing(4);
	        // t.setBorderWidth(1);

	        PdfPCell c1 = new PdfPCell(new Phrase("NOMBRE"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("APELLIDOS"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("VEHICULOS_VENDIDOS"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("INGRESOS"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        table.setHeaderRows(1);
	        
	        for(int x = 0; x < nombres.size(); x++) {
	        	
	        	ventasString = ventas.get(x).toString();
	        	ingresosString = ingresos.get(x).toString();
	        	
	        	table.addCell(nombres.get(x));
	        	table.addCell(apellidos.get(x));
	        	table.addCell(ventasString);
	        	table.addCell(ingresosString);
	        		
	        }

	        documento.add(table);
			documento.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		}
	
	/* Generar archivo y elegir su destino
	 * public void GenerarArchivo() {

		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showSaveDialog(GestionInformes.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				PrintWriter writer = new PrintWriter(file);

				for (int row = 0; row < table.getRowCount(); row++) {
					for (int col = 0; col < table.getColumnCount(); col++) {
						writer.print(table.getColumnName(col));
						writer.print(": ");
						writer.println(table.getValueAt(row, col));
					}
					writer.println("");
				}

				writer.close();
				System.out.println("Archivo Generado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	 */
}

