package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificarPoblacion extends JPanel {
	
	private JTextField txtId;
	private JTextField txtPoblacion;
	private JTextField txtProvincia;
	private JTextField txtCP;


	/**
	 * Create the panel.
	 */
	public ModificarPoblacion() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblIndiqueElId = new JLabel("Indique el CP de la Poblaci\u00F3n a modificar:");
		lblIndiqueElId.setForeground(SystemColor.textHighlight);
		lblIndiqueElId.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueElId.setBounds(10, 232, 477, 40);
		add(lblIndiqueElId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtId.setBounds(489, 241, 96, 26);
		add(txtId);
		txtId.setColumns(10);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBackground(SystemColor.inactiveCaption);
		txtPoblacion.setBounds(761, 316, 123, 20);
		add(txtPoblacion);
		
		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBackground(SystemColor.inactiveCaption);
		txtProvincia.setBounds(761, 282, 123, 20);
		add(txtProvincia);
		
		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBackground(SystemColor.inactiveCaption);
		txtCP.setBounds(761, 241, 123, 20);
		add(txtCP);
		
		JLabel lblCP = new JLabel("CP:");
		lblCP.setForeground(SystemColor.textHighlight);
		lblCP.setFont(new Font("Arial", Font.BOLD, 16));
		lblCP.setBounds(712, 241, 39, 14);
		add(lblCP);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(SystemColor.textHighlight);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 16));
		lblProvincia.setBounds(669, 282, 91, 14);
		add(lblProvincia);
		
		JLabel lblPoblacion = new JLabel("Poblaci\u00F3n:");
		lblPoblacion.setForeground(SystemColor.textHighlight);
		lblPoblacion.setFont(new Font("Arial", Font.BOLD, 16));
		lblPoblacion.setBounds(658, 309, 108, 28);
		add(lblPoblacion);
		
		JButton btnModificarPoblacion = new JButton("Modificar Poblaci\u00F3n");
		btnModificarPoblacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarPoblacion();
			}
		});
		btnModificarPoblacion.setForeground(Color.WHITE);
		btnModificarPoblacion.setFont(new Font("Arial", Font.BOLD, 18));
		btnModificarPoblacion.setBackground(Color.BLUE);
		btnModificarPoblacion.setBounds(542, 508, 209, 35);
		add(btnModificarPoblacion);

	}
	

	public void modificarPoblacion() {

		try {

			int id=Integer.parseInt(txtId.getText());
			int cp = Integer.parseInt(txtCP.getText());
			String provincia = txtProvincia.getText();
			String poblacion = txtPoblacion.getText();

			String agregar = "update Poblaciones set CP='"+cp+"', Provincia='"+provincia+"', Poblacion='"+poblacion+"' where CP="+id;
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Población Modificada");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
