package paneles;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestionEscandallos extends JPanel {
	private JTable table;
	DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public GestionEscandallos() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblSotecars2 = new JLabel("THE POWER OF DREAMS");
		lblSotecars2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSotecars2.setBounds(517, 70, 152, 22);
		add(lblSotecars2);
		
		JLabel lblSotecars1 = new JLabel("SOTECARS");
		lblSotecars1.setForeground(Color.BLUE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 41));
		lblSotecars1.setBackground(Color.WHITE);
		lblSotecars1.setBounds(483, 31, 228, 52);
		add(lblSotecars1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(517, 189, 136, 21);
		add(comboBox);
		
		JLabel lblIndiqueElVehiculo = new JLabel("Indique el vehiculo a consultar");
		lblIndiqueElVehiculo.setForeground(SystemColor.textHighlight);
		lblIndiqueElVehiculo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueElVehiculo.setBounds(405, 130, 453, 40);
		add(lblIndiqueElVehiculo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 247, 620, 402);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modeloTabla.setColumnIdentifiers(new Object[] {"ID vehiculo", "Precio de compra", "Descripcion Problemas", "Costo de problemas", "Costo total vehiculo"});
		table.setModel(modeloTabla);

		modeloTabla.setRowCount(0);

	}
}
