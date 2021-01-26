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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionReparaciones extends JPanel {
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private JTextField txtFecha;
	private JTextArea txtAreaDescripcion;
	private JTextField txtId;
	private JSpinner spinnerPrecio;

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
		
		JLabel lblModelo = new JLabel("ID Vehiculo:");
		lblModelo.setForeground(SystemColor.textHighlight);
		lblModelo.setFont(new Font("Arial", Font.BOLD, 16));
		lblModelo.setBounds(51, 259, 149, 35);
		add(lblModelo);
		
		JLabel lblDescripcion = new JLabel("Materiales necesarios");
		lblDescripcion.setForeground(SystemColor.textHighlight);
		lblDescripcion.setFont(new Font("Arial", Font.BOLD, 16));
		lblDescripcion.setBounds(883, 190, 198, 19);
		add(lblDescripcion);
		
		txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setBackground(Color.LIGHT_GRAY);
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
		
		JLabel lblPrecioEstimado = new JLabel("Precio estimado de las piezas");
		lblPrecioEstimado.setForeground(SystemColor.textHighlight);
		lblPrecioEstimado.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioEstimado.setBounds(890, 441, 288, 19);
		add(lblPrecioEstimado);
		
		spinnerPrecio = new JSpinner();
		spinnerPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinnerPrecio.setBounds(1187, 441, 72, 20);
		add(spinnerPrecio);
		
		JLabel lblTrabajador = new JLabel("Id trabajador:");
		lblTrabajador.setForeground(SystemColor.textHighlight);
		lblTrabajador.setFont(new Font("Arial", Font.BOLD, 16));
		lblTrabajador.setBounds(38, 317, 108, 15);
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
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirMantenimiento();
			}
		});
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
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBackground(SystemColor.inactiveCaption);
		txtId.setBounds(156, 317, 123, 20);
		add(txtId);

	}
	
	
	public void aniadirMantenimiento() {

		try {
			Calendar fecha2 = new GregorianCalendar();
			int mes=fecha2.get(Calendar.MONTH);
			int id_empleado = Integer.parseInt(txtId.getText());
			Float precio= Float.parseFloat(txtPrecio.getText());
			String descripcion = txtAreaDescripcion.getText();
			Float precioTotal = (float) (((precio*0.21)+precio)+Integer.parseInt(spinnerPrecio.getValue().toString()));
			String fecha = txtFecha.getText() +" dias a partir de: "+fecha2.get(Calendar.DAY_OF_MONTH)+ "-"+ (mes+1) +"-"+fecha2.get(Calendar.YEAR);

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
;