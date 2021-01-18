package paneles;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;

public class GenerarEscandallo extends JPanel {
	JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public GenerarEscandallo() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(416, 211, 136, 21);
		add(comboBox);
		
		JLabel lblIndiqueElVehiculo = new JLabel("Indique el vehiculo a consultar");
		lblIndiqueElVehiculo.setForeground(SystemColor.textHighlight);
		lblIndiqueElVehiculo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueElVehiculo.setBounds(304, 152, 453, 40);
		add(lblIndiqueElVehiculo);
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
				rs = sql.executeQuery("SELECT modelo FROM modelos");

				while (rs.next()) {
					comboBox.addItem(rs.getObject("modelo"));
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
