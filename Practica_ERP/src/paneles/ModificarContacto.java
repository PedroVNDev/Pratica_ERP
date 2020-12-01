package paneles;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarContacto extends JPanel {
	private JTextField txtCalle;
	private JTextField txtPoblacion;
	private JTextField txtProvincia;
	private JTextField txtCp;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JTextField txtApellidos;
	private JTextField txtNombre;
	private JTextField txtID;

	/**
	 * Create the panel.
	 */
	public ModificarContacto() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarContacto();
			}
		});
		btnModificarCliente.setForeground(Color.WHITE);
		btnModificarCliente.setFont(new Font("Arial", Font.BOLD, 18));
		btnModificarCliente.setBackground(Color.BLUE);
		btnModificarCliente.setBounds(636, 525, 209, 35);
		add(btnModificarCliente);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setForeground(SystemColor.textHighlight);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 16));
		lblCalle.setBounds(776, 381, 66, 20);
		add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBackground(SystemColor.inactiveCaption);
		txtCalle.setBounds(839, 384, 123, 20);
		add(txtCalle);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(839, 350, 123, 20);
		add(txtPoblacion);
		
		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(736, 343, 108, 28);
		add(lblPoblacion);
		
		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(839, 316, 123, 20);
		add(txtProvincia);
		
		txtCp = new JTextField();
		txtCp.setColumns(10);
		txtCp.setBackground(SystemColor.inactiveCaption);
		txtCp.setBounds(839, 275, 123, 20);
		add(txtCp);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(SystemColor.inactiveCaption);
		txtTelefono.setBounds(841, 236, 123, 20);
		add(txtTelefono);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBackground(SystemColor.inactiveCaption);
		txtDni.setBounds(841, 195, 123, 20);
		add(txtDni);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(SystemColor.inactiveCaption);
		txtApellidos.setBounds(841, 163, 121, 20);
		add(txtApellidos);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBackground(SystemColor.inactiveCaption);
		txtNombre.setBounds(841, 134, 121, 20);
		add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre contacto:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombre.setBounds(695, 124, 149, 35);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos contacto:");
		lblApellidos.setForeground(SystemColor.textHighlight);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 16));
		lblApellidos.setBounds(695, 153, 149, 35);
		add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI contacto: ");
		lblDni.setForeground(SystemColor.textHighlight);
		lblDni.setFont(new Font("Arial", Font.BOLD, 16));
		lblDni.setBounds(728, 195, 108, 15);
		add(lblDni);
		
		JLabel lblTelefono = new JLabel("Id Vehiculo ventido");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefono.setBounds(681, 236, 150, 14);
		add(lblTelefono);
		
		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(790, 275, 39, 14);
		add(lblCP);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(747, 316, 91, 14);
		add(lblProvincia);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtID.setColumns(10);
		txtID.setBounds(517, 205, 96, 26);
		add(txtID);
		
		JLabel lblIndiqueElId = new JLabel("Indique el id Cliente a modificar:");
		lblIndiqueElId.setForeground(SystemColor.textHighlight);
		lblIndiqueElId.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueElId.setBounds(129, 192, 378, 40);
		add(lblIndiqueElId);

	}
	

	public void modificarContacto() {

		try {

			int id=Integer.parseInt(txtID.getText());
			String nombre = txtNombre.getText();
			String apellidos = txtApellidos.getText();
			int telefono = Integer.parseInt(txtTelefono.getText());
			String dni = txtDni.getText();
			int cp = Integer.parseInt(txtCp.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();
			String calle = txtCalle.getText();

			String agregar = "update contactos_compra set nombre='"+nombre+"', apellidos='"+ apellidos+"', telefono='"+telefono+"', "
					+ "DNI='"+dni+"', CP='"+cp+"', Provincia='"+provincia+"', Poblacion='"+poblacion+"', Calle='"+calle+"' where ID="+id;
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
