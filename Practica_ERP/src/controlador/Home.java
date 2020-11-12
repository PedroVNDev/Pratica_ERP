package controlador;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLUE);
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 450, 21);
		add(menuBar);
		
		JMenu menu1 = new JMenu("Gestion");
		menu1.setBackground(Color.YELLOW);
		menuBar.add(menu1);
		
		JMenuItem menuItemGestion1 = new JMenuItem("Agregar");
		menu1.add(menuItemGestion1);
		
		JMenuItem menuItemGestion2 = new JMenuItem("Eliminar");
		menu1.add(menuItemGestion2);
		
		JMenu menu2 = new JMenu("Inventario");
		menuBar.add(menu2);
		
		JMenu mnNewMenu = new JMenu("Produccion");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Informes");
		menuBar.add(mnNewMenu_1);
		
		

	}
}
