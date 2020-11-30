package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ModificarClientes extends JPanel {
	private JTextField txtId;
	private JTextField txtCalle;
	private JTextField txtPoblacion;
	private JTextField txtProvincia;
	private JTextField txtCP;
	private JTextField txtTelefono;
	private JTextField txtDniCliente;
	private JTextField txtApellidos;
	private JTextField txtNombre;

	/**
	 * Create the panel.
	 */
	public ModificarClientes() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblIndiqueElId = new JLabel("Indique el id Cliente a modificar:");
		lblIndiqueElId.setForeground(SystemColor.textHighlight);
		lblIndiqueElId.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueElId.setBounds(48, 232, 378, 40);
		add(lblIndiqueElId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtId.setBounds(436, 245, 96, 26);
		add(txtId);
		txtId.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBackground(SystemColor.inactiveCaption);
		txtCalle.setBounds(758, 424, 123, 20);
		add(txtCalle);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(758, 390, 123, 20);
		add(txtPoblacion);
		
		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(758, 356, 123, 20);
		add(txtProvincia);
		
		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(758, 315, 123, 20);
		add(txtCP);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(SystemColor.inactiveCaption);
		txtTelefono.setBounds(760, 276, 123, 20);
		add(txtTelefono);
		
		txtDniCliente = new JTextField();
		txtDniCliente.setColumns(10);
		txtDniCliente.setBackground(SystemColor.inactiveCaption);
		txtDniCliente.setBounds(760, 235, 123, 20);
		add(txtDniCliente);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(SystemColor.inactiveCaption);
		txtApellidos.setBounds(760, 203, 121, 20);
		add(txtApellidos);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBackground(SystemColor.inactiveCaption);
		txtNombre.setBounds(760, 174, 121, 20);
		add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre Cliente:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(614, 164, 149, 35);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos Cliente:");
		lblApellidos.setForeground(SystemColor.textHighlight);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 16));
		lblApellidos.setBounds(614, 193, 149, 35);
		add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI Cliente: ");
		lblDni.setForeground(SystemColor.textHighlight);
		lblDni.setFont(new Font("Arial", Font.BOLD, 16));
		lblDni.setBounds(647, 235, 108, 15);
		add(lblDni);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(666, 276, 91, 14);
		add(lblTelefono);
		
		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(709, 315, 39, 14);
		add(lblCP);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(666, 356, 91, 14);
		add(lblProvincia);
		
		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(655, 383, 108, 28);
		add(lblPoblacion);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(695, 421, 66, 20);
		add(lblCalle);
		
		JButton btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.setForeground(Color.WHITE);
		btnModificarCliente.setFont(new Font("Arial", Font.BOLD, 18));
		btnModificarCliente.setBackground(Color.BLUE);
		btnModificarCliente.setBounds(555, 565, 209, 35);
		add(btnModificarCliente);

	}
	

	public void modificarCliente() {

		try {

			int id=Integer.parseInt(txtId.getText());
			String nombre = txtNombre.getText();
			String apellidos = txtApellidos.getText();
			int telefono = Integer.parseInt(txtTelefono.getText());
			String dni = txtDniCliente.getText();
			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();
			String calle = txtCalle.getText();

			String agregar = "update Clientes set nombre='"+nombre+"', apellidos='"+ apellidos+"', telefono='"+telefono+"', "
					+ "DNI='"+dni+"', CP='"+cp+"', Provincia='"+provincia+", Poblacion='"+poblacion+"', Calle='"+calle+"' where ID="+id;
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Cliente Modificado");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
