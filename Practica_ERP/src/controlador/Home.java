package controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import paneles.GestionCliente;
import paneles.GestionFabricas;
import paneles.GestionPersonal;
import paneles.GestionContacto;
import paneles.ListaFabricas;
import paneles.ListadoInventario;
import paneles.ModificarClientes;
import paneles.ModificarSueldo;
import paneles.PedirPresupuesto;
import paneles.GestionInventario;

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
import javax.swing.JButton;

public class Home extends JFrame {

	private JPanel contentPane;
	private static Home frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Home();
					frame.setVisible(true);
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
		setBounds(100, 100, 1300, 748);

		// MenuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(SystemColor.desktop);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu menuGestion = new JMenu("          Gesti\u00F3n             ");
		menuGestion.setFont(new Font("Arial", Font.BOLD, 35));
		menuGestion.setForeground(Color.BLUE);
		menuGestion.setBackground(SystemColor.text);
		menuBar.add(menuGestion);

		JMenuItem menuItemGestionCliente = new JMenuItem("A\u00F1adir/Eliminar Clientes");
		menuItemGestionCliente.setBackground(Color.BLUE);
		menuItemGestionCliente.setForeground(Color.WHITE);
		menuItemGestionCliente.setFont(new Font("Arial", Font.BOLD, 26));
		menuItemGestionCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GestionCliente g1 = new GestionCliente();
				nuevoPanel(g1);
			}
		});
		menuGestion.add(menuItemGestionCliente);

		JMenuItem menuItemGestionContacto = new JMenuItem("A\u00F1adir/Eliminar Contacto");
		menuItemGestionContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GestionContacto g2 = new GestionContacto();
				nuevoPanel(g2);
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("      Modificar Cliente");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarClientes mc= new ModificarClientes();
				nuevoPanel(mc);
			}
		});
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(Color.BLUE);
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.BOLD, 26));
		menuGestion.add(mntmNewMenuItem_1);
		menuItemGestionContacto.setFont(new Font("Arial", Font.BOLD, 26));
		menuItemGestionContacto.setForeground(Color.WHITE);
		menuItemGestionContacto.setBackground(Color.BLUE);
		menuGestion.add(menuItemGestionContacto);

		JMenuItem menuItemGestionTrabajador = new JMenuItem("A\u00F1adir/Eliminar trabajador");
		menuItemGestionTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GestionPersonal g3 = new GestionPersonal();
				nuevoPanel(g3);

			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("    Modificar Contacto");
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.BOLD, 26));
		mntmNewMenuItem_2.setForeground(Color.WHITE);
		mntmNewMenuItem_2.setBackground(Color.BLUE);
		menuGestion.add(mntmNewMenuItem_2);
		menuItemGestionTrabajador.setForeground(Color.WHITE);
		menuItemGestionTrabajador.setBackground(Color.BLUE);
		menuItemGestionTrabajador.setFont(new Font("Arial", Font.BOLD, 26));
		menuGestion.add(menuItemGestionTrabajador);

		JMenu menuInventario = new JMenu("          Inventario          ");
		menuInventario.setFont(new Font("Arial", Font.BOLD, 35));
		menuInventario.setForeground(Color.BLUE);
		menuInventario.setBackground(SystemColor.text);
		menuBar.add(menuInventario);

		JMenuItem menuItemStock = new JMenuItem("               Stock             ");
		menuItemStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListadoInventario g4 = new ListadoInventario();
				nuevoPanel(g4);
			}
		});
		menuItemStock.setForeground(Color.WHITE);
		menuItemStock.setBackground(Color.BLUE);
		menuItemStock.setFont(new Font("Arial", Font.BOLD, 26));
		menuInventario.add(menuItemStock);

		JMenuItem menuItem5 = new JMenuItem("     A\u00F1adir Veh\u00EDculo");
		menuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GestionInventario g5 = new GestionInventario();
				nuevoPanel(g5);
			}
		});
		menuItem5.setForeground(Color.WHITE);
		menuItem5.setFont(new Font("Arial", Font.BOLD, 26));
		menuItem5.setBackground(Color.BLUE);
		menuInventario.add(menuItem5);

		JMenu menu3 = new JMenu("     Producci\u00F3n        ");
		menu3.setFont(new Font("Arial", Font.BOLD, 35));
		menu3.setForeground(Color.BLUE);
		menu3.setBackground(SystemColor.text);
		menuBar.add(menu3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("     Gestionar Fabricas    ");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionFabricas gfa = new GestionFabricas();
				nuevoPanel(gfa);
			}
		});
		mntmNewMenuItem_4.setForeground(Color.WHITE);
		mntmNewMenuItem_4.setBackground(Color.BLUE);
		mntmNewMenuItem_4.setFont(new Font("Arial", Font.BOLD, 26));
		menu3.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("    Listado de Fabricas");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaFabricas gf= new ListaFabricas();
				nuevoPanel(gf);
			}
		});
		mntmNewMenuItem_5.setForeground(Color.WHITE);
		mntmNewMenuItem_5.setBackground(Color.BLUE);
		mntmNewMenuItem_5.setFont(new Font("Arial", Font.BOLD, 26));
		menu3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("     Pedir Presupuesto");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PedirPresupuesto pp= new PedirPresupuesto();
				nuevoPanel(pp);
			}
		});
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setFont(new Font("Arial", Font.BOLD, 26));
		mntmNewMenuItem.setBackground(Color.BLUE);
		menu3.add(mntmNewMenuItem);

		JMenu menu4 = new JMenu("Informes                              ");
		menu4.setFont(new Font("Arial", Font.BOLD, 35));
		menu4.setForeground(Color.BLUE);
		menu4.setBackground(SystemColor.text);
		menuBar.add(menu4);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		menu4.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("                  SOTECARS");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 87));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

		JLabel lblNewLabel_4 = new JLabel("                                         THE POWER OF DREAMS");
		lblNewLabel_4.setForeground(UIManager.getColor("MenuItem.selectionBackground"));
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.PLAIN, 40));
		contentPane.add(lblNewLabel_4, BorderLayout.SOUTH);

		// Iconos
		Image ico1 = new ImageIcon(this.getClass().getResource("/006-user.png")).getImage();
		Image modifiedIco1 = ico1.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		menuItemGestionCliente.setIcon(new ImageIcon(modifiedIco1));

		Image ico2 = new ImageIcon(this.getClass().getResource("/050-protect.png")).getImage();
		Image modifiedIco2 = ico2.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		menuItemGestionContacto.setIcon(new ImageIcon(modifiedIco2));

		Image ico3 = new ImageIcon(this.getClass().getResource("/036-suitcase.png")).getImage();
		Image modifiedIco3 = ico3.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		menuItemGestionTrabajador.setIcon(new ImageIcon(modifiedIco3));
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("       Modificar Salario");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarSueldo ms= new ModificarSueldo();
				nuevoPanel(ms);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Arial", Font.BOLD, 26));
		mntmNewMenuItem_3.setForeground(Color.WHITE);
		mntmNewMenuItem_3.setBackground(Color.BLUE);
		menuGestion.add(mntmNewMenuItem_3);

	}

	// Metodos
	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual);
		contentPane.repaint();
		contentPane.revalidate();
	}

}
