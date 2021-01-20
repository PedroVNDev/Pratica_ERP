package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class GestionReparaciones extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setBounds(156, 269, 121, 20);
		add(textField);
		
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
		
		JTextArea txtProblemas = new JTextArea();
		txtProblemas.setColumns(10);
		txtProblemas.setBounds(883, 220, 376, 206);
		add(txtProblemas);
		
		JLabel lblPrecioSinIva = new JLabel("Precio sin iva:");
		lblPrecioSinIva.setForeground(SystemColor.textHighlight);
		lblPrecioSinIva.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioSinIva.setBounds(513, 282, 122, 14);
		add(lblPrecioSinIva);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.inactiveCaption);
		textField_1.setBounds(645, 282, 123, 20);
		add(textField_1);
		
		JLabel lblPrecioFinal = new JLabel("Precio final:");
		lblPrecioFinal.setForeground(SystemColor.textHighlight);
		lblPrecioFinal.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioFinal.setBounds(523, 317, 121, 14);
		add(lblPrecioFinal);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.inactiveCaption);
		textField_2.setBounds(647, 317, 123, 20);
		add(textField_2);
		
		JLabel lblPrecioEstimado = new JLabel("Precio estimado de las piezas");
		lblPrecioEstimado.setForeground(SystemColor.textHighlight);
		lblPrecioEstimado.setFont(new Font("Arial", Font.BOLD, 16));
		lblPrecioEstimado.setBounds(890, 441, 288, 19);
		add(lblPrecioEstimado);
		
		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinnerPrecio.setBounds(1187, 441, 72, 20);
		add(spinnerPrecio);
		
		JComboBox cbEficiencias = new JComboBox();
		cbEficiencias.setBounds(153, 317, 121, 21);
		add(cbEficiencias);
		
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
		
		JButton btnAniadir = new JButton("A\u00F1adir Contacto");
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.inactiveCaption);
		textField_3.setBounds(403, 390, 123, 20);
		add(textField_3);

	}
}
