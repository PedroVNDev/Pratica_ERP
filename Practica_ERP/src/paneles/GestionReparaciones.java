package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class GestionReparaciones extends JPanel {
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private JTextField txtPrecioIVA;
	private JTextField txtFecha;
	private JComboBox comboEmpleados;
	private JTextArea txtAreaDescripcion;

	/**
	 * Create the panel.
	 */
	public GestionReparaciones() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblInformacionDeReparacion = new JLabel("Informacion de reparacion");
		lblInformacionDeReparacion.setForeground(SystemColor.textHighlight);
		lblInformacionDeReparacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInformacionDeReparacion.setBounds(279, 177, 400, 40);
		add(lblInformacionDeReparacion);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBackground(SystemColor.inactiveCaption);
		txtModelo.setBounds(156, 269, 121, 20);
		add(txtModelo);
		
		JLabel lblModelo = new JLabel("Modelo Vehiculo:");
		lblModelo.setForeground(SystemColor.textHighlight);
		lblModelo.setFont(new Font("Arial", Font.BOLD, 16));
		lblModelo.setBounds(10, 259, 149, 35);
		add(lblModelo);
		
		JLabel lblDescripcion = new JLabel("Materiales necesarios");
		lblDescripcion.setForeground(SystemColor.textHighlight);
		lblDescripcion.setFont(new Font("Arial", Font.BOLD, 16));
		lblDescripcion.setBounds(883, 190, 198, 19);
		add(lblDescripcion);
		
		txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setColumns(10);
		txtAreaDescripcion.setBounds(883, 220, 376, 206);
		add(txtAreaDescripcion);
		
		JLabel lblPrecioSinIva = new JLabel("Precio sin iva:");
		lblPrecioSinIva.setForeground(SystemColor.textHighlight);
		lblPrecioSinIva.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioSinIva.setBounds(513, 282, 122, 14);
		add(lblPrecioSinIva);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBackground(SystemColor.inactiveCaption);
		txtPrecio.setBounds(645, 282, 123, 20);
		add(txtPrecio);
		
		JLabel lblPrecioFinal = new JLabel("Precio final:");
		lblPrecioFinal.setForeground(SystemColor.textHighlight);
		lblPrecioFinal.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioFinal.setBounds(523, 317, 121, 14);
		add(lblPrecioFinal);
		
		txtPrecioIVA = new JTextField();
		txtPrecioIVA.setColumns(10);
		txtPrecioIVA.setBackground(SystemColor.inactiveCaption);
		txtPrecioIVA.setBounds(647, 317, 123, 20);
		add(txtPrecioIVA);
		
		JLabel lblPrecioEstimado = new JLabel("Precio estimado de las piezas");
		lblPrecioEstimado.setForeground(SystemColor.textHighlight);
		lblPrecioEstimado.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioEstimado.setBounds(890, 441, 288, 19);
		add(lblPrecioEstimado);
		
		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinnerPrecio.setBounds(1187, 441, 72, 20);
		add(spinnerPrecio);
		
	    comboEmpleados = new JComboBox();
	    comboEmpleados.setBounds(153, 317, 121, 21);
		add(comboEmpleados);
		
		JLabel lblTrabajador = new JLabel("Trabajador:");
		lblTrabajador.setForeground(SystemColor.textHighlight);
		lblTrabajador.setFont(new Font("Arial", Font.BOLD, 16));
		lblTrabajador.setBounds(51, 317, 108, 15);
		add(lblTrabajador);
		
		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(576, 106, 152, 22);
		add(lblSotecars2);
		
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(542, 67, 228, 52);
		add(lblSotecars1);
		
		JButton btnAniadir = new JButton("A\u00F1adir Reparacion");
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setFont(new Font("Arial", Font.BOLD, 18));
		btnAniadir.setBackground(Color.BLUE);
		btnAniadir.setBounds(554, 485, 214, 35);
		add(btnAniadir);
		
		JLabel lblFechaDeEntrega = new JLabel("Dias estimados para la entrega:");
		lblFechaDeEntrega.setForeground(SystemColor.textHighlight);
		lblFechaDeEntrega.setFont(new Font("Arial", Font.BOLD, 16));
		lblFechaDeEntrega.setBounds(156, 390, 280, 14);
		add(lblFechaDeEntrega);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBackground(SystemColor.inactiveCaption);
		txtFecha.setBounds(403, 390, 123, 20);
		add(txtFecha);
		
		cargandoComboBox();

	}
	
	public void cargandoComboBox() {
		Connection conexion = null;
		Statement sql = null;
		ResultSet rs = null;
		try {
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO", "TRABAJO");
				sql = conexion.createStatement();
				rs = sql.executeQuery("SELECT nombre FROM trabajadores");

				while (rs.next()) {
					comboEmpleados.addItem(rs.getObject("nombre"));
				}

				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}
	
	public void aniadirMantenimiento() {

		try {

			int id_empleado = Integer.parseInt(txtPrecio.getText());
			String descripcion = txtAreaDescripcion.getText();
			int precioTotal = Integer.parseInt(txtPrecioIVA.getText());
			String fecha = txtFecha.getText();

			String agregar = "INSERT INTO mantenimiento (id_empleado, descripcion, precio_total, fecha_entrega) VALUES('"
					+ id_empleado + "', '" + descripcion + "', '" + precioTotal + "', '" + fecha + "')";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Mantenimiento Agregado Correctamente");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
