package paneles;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoInventario extends JPanel {

	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JTextField txtId;
	private JTextField txtModelo;

	/**
	 * Create the panel.
	 */
	public ListadoInventario() {
		setBackground(Color.WHITE);
		setLayout(null);

		// Labels
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setForeground(SystemColor.textHighlight);
		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblInventario.setBounds(583, 112, 214, 40);
		add(lblInventario);

		// Tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 184, 1218, 363);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] { "ID", "Modelo", "Eficiencia_Energetica", "Consumo", "Emisiones",
				"Precio_Venta", "Precio_Compra", "Caja_Cambios", "Año", "Matricula" });
		table.setModel(modeloTabla);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBackground(SystemColor.inactiveCaption);
		txtId.setBounds(270, 82, 121, 20);
		add(txtId);
		
		JLabel lblBuscarPorId = new JLabel("Buscar por ID Vehiculo:");
		lblBuscarPorId.setForeground(SystemColor.textHighlight);
		lblBuscarPorId.setFont(new Font("Arial", Font.BOLD, 16));
		lblBuscarPorId.setBounds(61, 72, 243, 35);
		add(lblBuscarPorId);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBackground(SystemColor.inactiveCaption);
		txtModelo.setBounds(1019, 82, 121, 20);
		add(txtModelo);
		
		JLabel lblBuscarPorModelo = new JLabel("Buscar por modelo Vehiculo:");
		lblBuscarPorModelo.setForeground(SystemColor.textHighlight);
		lblBuscarPorModelo.setFont(new Font("Arial", Font.BOLD, 16));
		lblBuscarPorModelo.setBounds(775, 72, 279, 35);
		add(lblBuscarPorModelo);
		
		JButton btnBuscarPorId = new JButton("Buscar por ID");
		btnBuscarPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTabla();
				cargaInventarioID();
			}
		});
		btnBuscarPorId.setForeground(Color.WHITE);
		btnBuscarPorId.setFont(new Font("Arial", Font.BOLD, 18));
		btnBuscarPorId.setBackground(Color.BLUE);
		btnBuscarPorId.setBounds(147, 122, 192, 27);
		add(btnBuscarPorId);
		
		JButton btnBuscarPorModelo = new JButton("Buscar por Modelo");
		btnBuscarPorModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTabla();
				cargaInventarioModelo();
			}
		});
		btnBuscarPorModelo.setForeground(Color.WHITE);
		btnBuscarPorModelo.setFont(new Font("Arial", Font.BOLD, 18));
		btnBuscarPorModelo.setBackground(Color.BLUE);
		btnBuscarPorModelo.setBounds(926, 125, 214, 27);
		add(btnBuscarPorModelo);
		
		JButton btnMostarTodos = new JButton("Mostar todos");
		btnMostarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTabla();
				cargaInventario();
			}
		});
		btnMostarTodos.setForeground(Color.WHITE);
		btnMostarTodos.setFont(new Font("Arial", Font.BOLD, 18));
		btnMostarTodos.setBackground(Color.BLUE);
		btnMostarTodos.setBounds(550, 574, 192, 27);
		add(btnMostarTodos);
		

	}
	
	private void limpiarTabla(){
		for (int i = 0; i < table.getRowCount(); i++) {
		modeloTabla.removeRow(i);
		i-=1;
		}
	}

	//Metodos
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
	
	public void cargaInventarioID() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		int id= Integer.parseInt(txtId.getText());
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, Modelo, Eficiencia_Energetica, Consumo, Emisiones, Precio_Venta, Precio_Compra, Caja_Cambios, Año, Matricula from modelos WHERE ID='"+id+"'");

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
	
	public void cargaInventarioModelo() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		String modelo= txtModelo.getText();
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery(
						"SELECT ID, Modelo, Eficiencia_Energetica, Consumo, Emisiones, Precio_Venta, Precio_Compra, Caja_Cambios, Año, Matricula from modelos WHERE Modelo LIKE '%"+modelo+"%'");

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
}
