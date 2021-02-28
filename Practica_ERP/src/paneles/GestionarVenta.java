package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class GestionarVenta extends JPanel {
	private JTextField txtIdVehiculoVendido;
	private JTextField txtIdTrabajador;
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private static float precio_Compra;
	private static float precio_Venta;
	private static String modelo;
	private static String fechaVentas;
	private JTextField txtIdCliente;
	
	private static int idCliente;
	private static int idVehiculo;
	private static int idTrabajador;
	private static String nombre;

	/**
	 * Create the panel.
	 */
	public GestionarVenta() {
		setBackground(Color.WHITE);
		setLayout(null);

		// Labels
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setForeground(SystemColor.textHighlight);
		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInventario.setBounds(596, 40, 214, 40);
		add(lblInventario);

		JLabel lblIdDeVehculo = new JLabel("Id de veh\u00EDculo vendido:");
		lblIdDeVehculo.setForeground(SystemColor.textHighlight);
		lblIdDeVehculo.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdDeVehculo.setBounds(395, 462, 183, 27);
		add(lblIdDeVehculo);

		JLabel lblIdDelTrabajador = new JLabel("Id del trabajador que ha gestionado la venta:");
		lblIdDelTrabajador.setForeground(SystemColor.textHighlight);
		lblIdDelTrabajador.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdDelTrabajador.setBounds(234, 503, 423, 27);
		add(lblIdDelTrabajador);

		// JTextFields
		txtIdVehiculoVendido = new JTextField();
		txtIdVehiculoVendido.setBounds(596, 468, 129, 19);
		add(txtIdVehiculoVendido);
		txtIdVehiculoVendido.setColumns(10);

		txtIdTrabajador = new JTextField();
		txtIdTrabajador.setBounds(596, 509, 129, 19);
		add(txtIdTrabajador);
		txtIdTrabajador.setColumns(10);

		JButton btnGenerarTiket = new JButton("Generar tiket ");
		btnGenerarTiket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargaVenta();
				insertarVenta();
				generarFactura();
			}
		});
		btnGenerarTiket.setForeground(Color.WHITE);
		btnGenerarTiket.setFont(new Font("Arial", Font.BOLD, 18));
		btnGenerarTiket.setBackground(Color.BLUE);
		btnGenerarTiket.setBounds(520, 589, 172, 35);
		add(btnGenerarTiket);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 88, 1218, 363);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Modelo", "Eficiencia_Energetica", "Consumo", "Emisiones",
				"Precio_Venta", "Precio_Compra", "Caja_Cambios", "Año", "Matricula" });
		table.setModel(modeloTabla);

		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(596, 545, 129, 19);
		add(txtIdCliente);

		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setForeground(SystemColor.textHighlight);
		lblIdCliente.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdCliente.setBounds(489, 540, 89, 27);
		add(lblIdCliente);
		cargaInventario();
		
		Calendar fecha2 = new GregorianCalendar();
		int mes=fecha2.get(Calendar.MONTH);
		fechaVentas = +fecha2.get(Calendar.DAY_OF_MONTH)+ "-"+ (mes+1) +"-"+fecha2.get(Calendar.YEAR);
		System.out.println(fechaVentas);

	}
	
	public void generarFactura() {
		Float precioIVA;
		Float precioTotal;
		

		try {
			Document documento = new Document();

			try {

				String idString, ventasString, ingresosString;

				FileOutputStream ficheroPDF = new FileOutputStream("Factura.pdf");
				PdfWriter.getInstance(documento, ficheroPDF);
				documento.setMargins(0, 0, 200, 0);
				documento.open();
				
				String ruta = "imagenes//SotecarsMediana.png";
			    Image sotecars = Image.getInstance(ruta);
			    
			    String ruta2 = "imagenes//SotecarsOpacidad.png";
			    Image sotecars2 = Image.getInstance(ruta2);
			    
			    float x = (PageSize.A4.getWidth() - sotecars.getScaledWidth()) / 2;
			    float y = (PageSize.A4.getHeight() - sotecars.getScaledHeight()) / 2;
			    sotecars.setAbsolutePosition(x, 690);
			    
			    float x2 = (PageSize.A4.getWidth() - sotecars2.getScaledWidth()) / 2;
			    float y2 = (PageSize.A4.getHeight() - sotecars2.getScaledHeight()) / 2;
			    sotecars2.setAbsolutePosition(x2, y2);
			    
			    documento.add(sotecars);
			    documento.add(sotecars2);
			    
				Paragraph titulo = new Paragraph("Factura"
						+ "\n"
						+ "\n", FontFactory.getFont("arial", 22, Font.BOLD,BaseColor.BLACK));
				titulo.setAlignment(Element.ALIGN_CENTER);

				documento.add(titulo); 
				
				Date date = new Date();
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int year  = localDate.getYear();
				int month = localDate.getMonthValue();
				int day   = localDate.getDayOfMonth();

				Paragraph fecha = new Paragraph("Factura generada en " + date + "\n\n\n", FontFactory.getFont("arial", 12, Font.BOLD));
				fecha.setAlignment(Element.ALIGN_CENTER);

				documento.add(fecha);
				
				Paragraph lineas = new Paragraph("__________________________________________________________________"
						+ "\n"
						+ "\n", FontFactory.getFont("arial", 16, Font.BOLD,BaseColor.BLACK));
				lineas.setAlignment(Element.ALIGN_CENTER);

				documento.add(lineas); 

				PdfPTable table = new PdfPTable(5);
				table.setHorizontalAlignment(Element.ALIGN_CENTER);

				// t.setBorderColor(BaseColor.GRAY);
				// t.setPadding(4);
				// t.setSpacing(4);
				// t.setBorderWidth(1);

				PdfPCell c1 = new PdfPCell(new Phrase("CLIENTE", FontFactory.getFont("arial", 11, Font.BOLD)));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setPadding(5);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("TRABAJADOR", FontFactory.getFont("arial", 11, Font.BOLD)));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setPadding(5);
				table.addCell(c1);


				c1 = new PdfPCell(new Phrase("MODELO", FontFactory.getFont("arial", 11, Font.BOLD)));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setPadding(5);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("PRECIO BRUTO", FontFactory.getFont("arial", 11, Font.BOLD)));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setPadding(5);
				table.addCell(c1);
				table.setHeaderRows(1);
				
				c1 = new PdfPCell(new Phrase("PRECIO TOTAL", FontFactory.getFont("arial", 11, Font.BOLD)));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setPadding(5);
				table.addCell(c1);
				table.setHeaderRows(1);


				
					String auxiliar= idCliente+" ";
					PdfPCell c2 = new PdfPCell();
					c2 = new PdfPCell(new Phrase(auxiliar, FontFactory.getFont("arial", 11)));
					c2.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					System.out.println(nombre);

					PdfPCell c3 = new PdfPCell();
					c3 = new PdfPCell(new Phrase(buscaNombre(idTrabajador), FontFactory.getFont("arial", 11)));
					c3.setHorizontalAlignment(Element.ALIGN_CENTER);

					PdfPCell c4 = new PdfPCell();
					c4 = new PdfPCell(new Phrase(modelo, FontFactory.getFont("arial", 11)));
					c4.setHorizontalAlignment(Element.ALIGN_CENTER);

					String auxiliar2=precio_Venta+" ";
					PdfPCell c5 = new PdfPCell();
					c5 = new PdfPCell(new Phrase(auxiliar2, FontFactory.getFont("arial", 11)));
					c5.setHorizontalAlignment(Element.ALIGN_CENTER);


					precioIVA= (float) (precio_Venta*0.21);

					precioTotal = (float) (precioIVA + precio_Venta);

					PdfPCell c7 = new PdfPCell();
					c7 = new PdfPCell(new Phrase(precioIVA.toString(), FontFactory.getFont("arial", 11)));
					c7.setHorizontalAlignment(Element.ALIGN_CENTER);

					table.addCell(c2);
					table.addCell(c3);
					table.addCell(c4);
					table.addCell(c5);
					table.addCell(c7);

				documento.add(table);

				documento.close();

			} catch (DocumentException | IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Archivo Generado");
		} finally {
			System.out.println("Ningun error");
		}

	}
	
	public String buscaNombre(int id) {
		String nombre="";
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT Nombre from trabajadores where id='"+id+"'");
				nombre=(String) rs.getObject("ID");
				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
		return nombre;
		
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

	public void cargaVenta() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		int idvehiculo = Integer.parseInt(txtIdVehiculoVendido.getText());
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT Modelo, Precio_Venta, Precio_Compra from modelos where ID = " + idvehiculo);

				while (rs.next()) {
					modelo = (String) rs.getObject("modelo");
					precio_Venta = (Float) rs.getObject("precio_Venta");
					precio_Compra = (Float) rs.getObject("precio_Compra");
				}

				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}

	public void insertarVenta() {

		try {

			idCliente = Integer.parseInt(txtIdCliente.getText());
			idVehiculo = Integer.parseInt(txtIdVehiculoVendido.getText());
			idTrabajador = Integer.parseInt(txtIdTrabajador.getText());
			
			
			nombre= buscaNombre(idTrabajador);
			System.out.println(fechaVentas);
			
			String agregar = "INSERT INTO ventas (ID_Cliente, ID_Trabajador, ID_Vehiculo, Modelo, Precio_Compra, Precio_Venta, Fecha) VALUES("
					+ idCliente + ", " + idTrabajador + ", " + idVehiculo + ", '" + modelo + "', " + precio_Compra
					+ ", '" + precio_Venta + "', " + fechaVentas +  ");";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");
			

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Venta Agregada Correctamente");

			conexion.close();
			
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void resetTextFields() {

		txtIdCliente.setText("");
		txtIdTrabajador.setText("");
		txtIdVehiculoVendido.setText("");
	}

}
