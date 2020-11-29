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
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class GestionarVenta extends JPanel {
	private JTextField txtIdComprar;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public GestionarVenta() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton btnGenerarTiket = new JButton("Generar tiket ");
		btnGenerarTiket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventaVehiculo();
			}
		});
		btnGenerarTiket.setForeground(Color.WHITE);
		btnGenerarTiket.setFont(new Font("Arial", Font.BOLD, 18));
		btnGenerarTiket.setBackground(Color.BLUE);
		btnGenerarTiket.setBounds(553, 552, 172, 35);
		add(btnGenerarTiket);
		
		txtIdComprar = new JTextField();
		txtIdComprar.setBounds(596, 468, 129, 19);
		add(txtIdComprar);
		txtIdComprar.setColumns(10);
		
		JLabel lblIdDeVehculo = new JLabel("Id de veh\u00EDculo vendido:");
		lblIdDeVehculo.setForeground(SystemColor.textHighlight);
		lblIdDeVehculo.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdDeVehculo.setBounds(395, 462, 183, 27);
		add(lblIdDeVehculo);
		
		textField = new JTextField();
		textField.setBounds(596, 509, 129, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblIdDelTrabajador = new JLabel("Id del trabajador que ha gestionado la venta:");
		lblIdDelTrabajador.setForeground(SystemColor.textHighlight);
		lblIdDelTrabajador.setFont(new Font("Arial", Font.BOLD, 16));
		lblIdDelTrabajador.setBounds(234, 503, 423, 27);
		add(lblIdDelTrabajador);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 85, 1136, 329);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	
	public void ventaVehiculo() {

			try {

				String vehiculo = (txtIdComprar.getText());

				String eliminar = "DELETE FROM modelos WHERE ID = '" + vehiculo + "'";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
						"TRABAJO");
				Statement consulta = conexion.createStatement();

				consulta.executeUpdate(eliminar);

				
				
				
				JOptionPane.showMessageDialog(null, "Ticket generado Correctamente");

				conexion.close();
			} catch (Exception ex2) {
				JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
				ex2.printStackTrace();
			}

	} 
	

	public void ficheroTickets() {
			Connection conexion = null;
			Statement sql = null;
			ResultSet rs = null;
			String modelo="";
			float precio_compra=0;
			float precio_venta=0;
			
			java.util.Date fecha = new Date();
			int dia=fecha.getDay();
			int mes=fecha.getMonth();
			
				try {
					conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
					sql = conexion.createStatement();
					rs = sql.executeQuery(
							"SELECT ID, Modelo, Eficiencia_Energetica, Consumo, Emisiones, Precio_Venta, Precio_Compra, Caja_Cambios, Año, Matricula from modelos");

					while (rs.next()) {
								modelo=(String) rs.getObject("Modelo");
								precio_venta=(float) rs.getObject("Precio_Venta"); 
								precio_compra=(float) rs.getObject("Precio_Compra"); 
					}

					conexion.close();
				} catch (SQLException e) {
					System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
				}
	}
}
