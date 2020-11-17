package controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import paneles.GestionCliente;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1299, 749);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(SystemColor.desktop);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu menu1 = new JMenu("            Gesti\u00F3n             ");
		menu1.setFont(new Font("Arial", Font.BOLD, 30));
		menu1.setForeground(Color.BLUE);
		menu1.setBackground(SystemColor.text);
		menuBar.add(menu1);

		JMenuItem menuItem1 = new JMenuItem("       Gesti\u00F3n Cliente        ");
		menuItem1.setBackground(Color.BLUE);
		menuItem1.setForeground(Color.WHITE);
		menuItem1.setFont(new Font("Arial", Font.BOLD, 26));
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GestionCliente g1 = new GestionCliente();
				nuevoPanel(g1);
			}
		});
		menu1.add(menuItem1);

		JMenuItem menuItem2 = new JMenuItem("    Gesti\u00F3n Proveedor");
		menuItem2.setFont(new Font("Arial", Font.BOLD, 26));
		menuItem2.setForeground(Color.WHITE);
		menuItem2.setBackground(Color.BLUE);
		menu1.add(menuItem2);

		JMenuItem menuItem3 = new JMenuItem("       Gesti\u00F3n Venta");
		menuItem3.setForeground(Color.WHITE);
		menuItem3.setBackground(Color.BLUE);
		menuItem3.setFont(new Font("Arial", Font.BOLD, 26));
		menu1.add(menuItem3);

		JMenu menu2 = new JMenu("Inventario                 ");
		menu2.setFont(new Font("Arial", Font.BOLD, 30));
		menu2.setForeground(Color.BLUE);
		menu2.setBackground(SystemColor.text);
		menuBar.add(menu2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		menu2.add(mntmNewMenuItem_3);

		JMenu menu3 = new JMenu("Producci\u00F3n               ");
		menu3.setFont(new Font("Arial", Font.BOLD, 30));
		menu3.setForeground(Color.BLUE);
		menu3.setBackground(SystemColor.text);
		menuBar.add(menu3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		menu3.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		menu3.add(mntmNewMenuItem_5);

		JMenu menu4 = new JMenu("Informes                              ");
		menu4.setFont(new Font("Arial", Font.BOLD, 30));
		menu4.setForeground(Color.BLUE);
		menu4.setBackground(SystemColor.text);
		menuBar.add(menu4);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		menu4.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("                 SOTECARS");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 87));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("                                      THE POWER OF DREAMS");
		lblNewLabel_4.setForeground(UIManager.getColor("MenuItem.selectionBackground"));
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.PLAIN, 40));
		contentPane.add(lblNewLabel_4, BorderLayout.SOUTH);
	
		
		Image ico2 = new ImageIcon(this.getClass().getResource("/006-user.png")).getImage();
		Image modifiedIco2 = ico2.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		menuItem1.setIcon(new ImageIcon(modifiedIco2));
		
	}

	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual);
		contentPane.repaint();
		contentPane.revalidate();
	}

}
