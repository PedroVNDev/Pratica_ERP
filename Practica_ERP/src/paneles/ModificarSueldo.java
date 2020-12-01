package paneles;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ModificarSueldo extends JPanel {
	private JTextField txtSueldo;
	private JTextField txtid;

	/**
	 * Create the panel.
	 */
	public ModificarSueldo() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBackground(SystemColor.inactiveCaption);
		txtSueldo.setBounds(829, 232, 123, 20);
		add(txtSueldo);
		
		JLabel lblNuevoSueldo = new JLabel("Nuevo sueldo:");
		lblNuevoSueldo.setForeground(SystemColor.textHighlight);
		lblNuevoSueldo.setFont(new Font("Arial", Font.BOLD, 16));
		lblNuevoSueldo.setBounds(698, 232, 135, 15);
		add(lblNuevoSueldo);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtid.setColumns(10);
		txtid.setBounds(503, 225, 96, 26);
		add(txtid);
		
		JLabel lblIndiqueElId = new JLabel("Indique el id Trabajador a reajustar salario:");
		lblIndiqueElId.setForeground(SystemColor.textHighlight);
		lblIndiqueElId.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueElId.setBounds(10, 216, 515, 40);
		add(lblIndiqueElId);
		
		JButton btnModificarSueldo = new JButton("Modificar Sueldo");
		btnModificarSueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarSueldo();
			}
		});
		btnModificarSueldo.setForeground(Color.WHITE);
		btnModificarSueldo.setFont(new Font("Arial", Font.BOLD, 18));
		btnModificarSueldo.setBackground(Color.BLUE);
		btnModificarSueldo.setBounds(624, 544, 209, 35);
		add(btnModificarSueldo);

	}
	
	public void modificarSueldo() {
		try {

			int id=Integer.parseInt(txtid.getText());
			int sueldo = Integer.parseInt(txtSueldo.getText());

			String agregar = "update trabajadores set sueldo='"+sueldo+"' where id="+id;
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/SotecarsBBDD", "TRABAJO",
					"TRABAJO");

			Statement consulta = conexion.createStatement();

			consulta.executeUpdate(agregar);

			JOptionPane.showMessageDialog(null, "Salario Modificado");

			conexion.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
