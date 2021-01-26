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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionInformes extends JPanel {

	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();

	private static String nombreTrabajador;
	private static String apellidoTrabajor;

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

				informeVentas();

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

				informe2();

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
	public void informeVentas() {

		modeloTabla.setRowCount(0);
		modeloTabla.setColumnIdentifiers(
				new Object[] { "ID_Trabajador", "Nombre", "Apellidos", "Vehiculos_Vendidos", "Ingresos" });
		table.setModel(modeloTabla);

		String nombre;
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
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
				}

				
				GenerarArchivo();
				JOptionPane.showMessageDialog(null, "Archivo Generado");
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("Ningun error");
		}

	}

	public void informe2() {

		modeloTabla.setColumnIdentifiers(new Object[] { "informe2", "DNI", "Nombre", "Apellidos", "ID_Vehiculo",
				"Precio_Compra", "CP", "Provincia", "Poblacion", "Calle" });
		table.setModel(modeloTabla);

	}

	public void informe3() {

		modeloTabla.setColumnIdentifiers(new Object[] { "informe3", "DNI", "Nombre", "Apellidos", "ID:_Vehiculo",
				"Precio_Compra", "CP", "Provincia", "Poblacion", "Calle" });
		table.setModel(modeloTabla);

	}

	public void GenerarArchivo() {

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
	
	public void GenerarArchivoHTML() {

		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showSaveDialog(GestionInformes.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fileChooser.getSelectedFile();
				PrintWriter writer = new PrintWriter(file);
				
				int idEmpleado = 1;
				String nombre = "Pedro";
				String apellidos = "Vicente";
				float ventas = 1000;
				float ingresos = 200;

				
				writer.print("<!DOCTYPE html>\r\n" + 
						"<html lang=\"en\">\r\n" + 
						"\r\n" + 
						"<head>\r\n" + 
						"    <meta charset=\"UTF-8\">\r\n" + 
						"    <title>Document</title>\r\n" + 
						"    <link href=\"css/bootstrap.css\" rel=\"stylesheet\" />\r\n" + 
						"    <style>\r\n" + 
						"        @import url(http://fonts.googleapis.com/css?family=Bree+Serif);\r\n" + 
						"        body,\r\n" + 
						"        h1,\r\n" + 
						"        h2,\r\n" + 
						"        h3,\r\n" + 
						"        h4,\r\n" + 
						"        h5,\r\n" + 
						"        h6 {\r\n" + 
						"            font-family: 'Bree Serif', serif;\r\n" + 
						"        }\r\n" + 
						"    </style>\r\n" + 
						"    <div class=\"container\">\r\n" + 
						"        <div class=\"row\">\r\n" + 
						"\r\n" + 
						"            <div class=\"col-xs-6\">\r\n" + 
						"                <h1>\r\n" + 
						"                    <a href=\" \"><img alt=\"\" src=\"image/logo.png\" /> SOTECARS</a>\r\n" + 
						"                </h1>\r\n" + 
						"            </div>\r\n" + 
						"            <div class=\"col-xs-6 text-right\">\r\n" + 
						"                <div class=\"panel panel-default\">\r\n" + 
						"                    <div class=\"panel-heading\">\r\n" + 
						"                        <h4>EMPLEADO GESTOR:\r\n" + 
						"                            <a href=\"#\">SOTECARS</a>\r\n" + 
						"                        </h4>\r\n" + 
						"                        <h4>CIF:\r\n" + 
						"                            <a href=\"#\">B45324321</a>\r\n" + 
						"                        </h4>\r\n" + 
						"                    </div>\r\n" + 
						"                    <div class=\"panel-body\">\r\n" + 
						"                        <h4>Sotecars S.L\r\n" + 
						"                            <a href=\"#\"></a>\r\n" + 
						"                        </h4>\r\n" + 
						"                    </div>\r\n" + 
						"                </div>\r\n" + 
						"            </div>\r\n" + 
						"\r\n" + 
						"            <hr />\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"            <h1 style=\"text-align: center;\">TRABAJADORES SOTECARS</h1>\r\n" + 
						"\r\n" + 
						"            <div class=\"row\">\r\n" + 
						"                <div class=\"col-xs-12\">\r\n" + 
						"                    <div class=\"panel panel-default\">\r\n" + 
						"                        <div class=\"panel-heading\">\r\n" + 
						"                            <h4> <a href=\"#\">30</a> de <a href=\"#\">abril</a> de <a href=\"#\">2020</a>\r\n" + 
						"\r\n" + 
						"                            </h4>\r\n" + 
						"                        </div>\r\n" + 
						"\r\n" + 
						"                    </div>\r\n" + 
						"                </div>\r\n" + 
						"\r\n" + 
						"            </div>\r\n" + 
						"            <pre></pre>\r\n" + 
						"            <table class=\"table table-bordered\">\r\n" + 
						"                <thead>\r\n" + 
						"                    <tr>\r\n" + 
						"                        <th style=\"text-align: center;\">\r\n" + 
						"                            <h4>Id Trabajador</h4>\r\n" + 
						"                        </th>\r\n" + 
						"                        <th style=\"text-align: center;\">\r\n" + 
						"                            <h4>Nombre</h4>\r\n" + 
						"                        </th>\r\n" + 
						"                        <th style=\"text-align: center;\">\r\n" + 
						"                            <h4>Apellidos</h4>\r\n" + 
						"                        </th>\r\n" + 
						"                        <th style=\"text-align: center;\">\r\n" + 
						"                            <h4>Vehiculos vendidos</h4>\r\n" + 
						"                        </th>\r\n" + 
						"                        <th style=\"text-align: center;\">\r\n" + 
						"                            <h4>Ingresos</h4>\r\n" + 
						"                        </th>\r\n" + 
						"\r\n" + 
						"                    </tr>\r\n" + 
						"                </thead>\r\n" + 
						"                <tbody>\r\n" + 
						"\r\n" + 
						"                    <tr>\r\n" + 
						"                        <td style=\" text-align: center; \">" + idEmpleado + " </td>\r\n" + 
						"                        <td class=\" text-align: center; \">" + nombre + " </td>\r\n" + 
						"                        <td class=\" text-align: center; \">" + apellidos + " </td>\r\n" + 
						"                        <td class=\" text-align: center; \">" + ventas + " </td>\r\n" + 
						"                        <td class=\" text-align: center; \">" + ingresos + " </td>\r\n" + 
						"\r\n" + 
						"                    </tr>\r\n" + 
						"                    <tr>\r\n" + 
						"                        <td>&nbsp;</td>\r\n" + 
						"                        <td>\r\n" + 
						"                            <a href=\"#\"></a>\r\n" + 
						"                        </td>\r\n" + 
						"                        <td class=\"text-right\"></td>\r\n" + 
						"                        <td class=\"text-right \"></td>\r\n" + 
						"                        <td class=\"text-right \"></td>\r\n" + 
						"                    </tr>\r\n" + 
						"\r\n" + 
						"                </tbody>\r\n" + 
						"            </table>\r\n" + 
						"            <pre></pre>\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"            <div class=\"row\">\r\n" + 
						"                <div class=\"col-xs-4\">\r\n" + 
						"                    <h1>\r\n" + 
						"                        <a href=\" \"><img alt=\"\" src=\"image/qr.png\" /></a>\r\n" + 
						"                    </h1>\r\n" + 
						"                </div>\r\n" + 
						"                <div class=\"col-xs-8\">\r\n" + 
						"\r\n" + 
						"                    <div class=\"panel panel-info\" style=\"text-align: center;\">\r\n" + 
						"                        <h6> \"LA ALTERACI&Oacute;N, FALSIFICACI&Oacute;N O COMERCIALIZACI&Oacute;N ILEGAL DE ESTE DOCUMENTO ESTA PENADO POR LA LEY\"</h6>\r\n" + 
						"                    </div>\r\n" + 
						"\r\n" + 
						"                </div>\r\n" + 
						"            </div>\r\n" + 
						"\r\n" + 
						"        </div>\r\n" + 
						"    </div>\r\n" + 
						"\r\n" + 
						"</head>\r\n" + 
						"\r\n" + 
						"<body>\r\n" + 
						"\r\n" + 
						"</body>\r\n" + 
						"\r\n" + 
						"</html>");
				

				writer.close();
				System.out.println("Archivo Generado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
}
