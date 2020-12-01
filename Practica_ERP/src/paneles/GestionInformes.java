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
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionInformes extends JPanel {

	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();

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
		JButton btnInforme1 = new JButton("Generar Informe Ventas");
		btnInforme1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				informeVentas();

			}
		});
		btnInforme1.setForeground(Color.WHITE);
		btnInforme1.setFont(new Font("Arial", Font.BOLD, 18));
		btnInforme1.setBackground(Color.BLUE);
		btnInforme1.setBounds(57, 34, 243, 35);
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
		btnInforme2.setBounds(57, 80, 243, 35);
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
		btnInforme3.setBounds(57, 126, 243, 35);
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
				new Object[] { "ID", "ID_Cliente", "ID_Trabajador", "Modelo", "Precio_Compra", "Precio_Venta" });
		table.setModel(modeloTabla);

		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, ID_Cliente, ID_Trabajador, Modelo, Precio_Compra, Precio_Venta FROM ventas");

				while (rs.next()) {
					modeloTabla.addRow(new Object[] { rs.getObject("ID"), rs.getObject("ID_Cliente"),
							rs.getObject("ID_Trabajador"), rs.getObject("Modelo"), rs.getObject("Precio_Compra"),
							rs.getObject("Precio_Venta") });
				}

				GenerarArchivo();
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
				System.out.println("Done!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
