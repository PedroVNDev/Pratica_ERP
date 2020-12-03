package controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paneles.GestionCliente;
import paneles.GestionInformes;
import paneles.GestionarVenta;
import paneles.ListadoClientes;
import paneles.ListadoInventario;
import paneles.ListadoVentas;
import paneles.ListadoContactos;

import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeTrabajador extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeTrabajador frame = new HomeTrabajador();
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/descarga.jpg")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeTrabajador() {
		setResizable(false);
		getContentPane().setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 735);

		// MenuBar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuVenta = new JMenu("                  Venta                  ");
		menuVenta.setFont(new Font("Arial", Font.BOLD, 35));
		menuVenta.setForeground(Color.BLUE);
		menuBar.add(menuVenta);

		JMenuItem menuItemGestionTicket = new JMenuItem("             Gestionar Ticket            ");
		menuItemGestionTicket.setBackground(Color.BLUE);
		menuItemGestionTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionarVenta gv = new GestionarVenta();
				nuevoPanel(gv);
			}
		});
		menuItemGestionTicket.setForeground(Color.WHITE);
		menuItemGestionTicket.setFont(new Font("Arial", Font.BOLD, 30));
		menuVenta.add(menuItemGestionTicket);

		JMenu menuInforme = new JMenu("              Informe            ");
		menuInforme.setForeground(Color.BLUE);
		menuInforme.setFont(new Font("Arial", Font.BOLD, 35));
		menuBar.add(menuInforme);

		JMenuItem menuItemInforme = new JMenuItem("     Gestion Informes     ");
		menuItemInforme.setBackground(Color.BLUE);
		menuItemInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GestionInformes gi = new GestionInformes();
				nuevoPanel(gi);

			}
		});
		menuInforme.add(menuItemInforme);
		menuItemInforme.setForeground(Color.WHITE);
		menuItemInforme.setFont(new Font("Arial", Font.BOLD, 30));

		JMenu menuListados = new JMenu("                  Listados              ");
		menuListados.setForeground(Color.BLUE);
		menuListados.setFont(new Font("Arial", Font.BOLD, 35));
		menuBar.add(menuListados);

		JMenuItem menuItemListadoClientes = new JMenuItem("       Listado de Clientes      ");
		menuItemListadoClientes.setBackground(Color.BLUE);

		menuItemListadoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoClientes g1 = new ListadoClientes();
				nuevoPanel(g1);
			}
		});
		menuItemListadoClientes.setForeground(Color.WHITE);
		menuItemListadoClientes.setFont(new Font("Arial", Font.BOLD, 30));
		menuListados.add(menuItemListadoClientes);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JMenuItem menuItemListadoProveedores = new JMenuItem("       Listado de Contactos      ");
		menuItemListadoProveedores.setBackground(Color.BLUE);
		menuItemListadoProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoContactos listado = new ListadoContactos();
				nuevoPanel(listado);
			}
		});
		menuItemListadoProveedores.setForeground(Color.WHITE);
		menuItemListadoProveedores.setFont(new Font("Arial", Font.BOLD, 30));
		menuListados.add(menuItemListadoProveedores);

		JMenuItem menuItemStock = new JMenuItem("       Listado de Vehiculos");
		menuItemStock.setBackground(Color.BLUE);
		menuItemStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListadoInventario g4 = new ListadoInventario();
				nuevoPanel(g4);
			}
		});
		menuItemStock.setForeground(Color.WHITE);
		menuItemStock.setFont(new Font("Arial", Font.BOLD, 30));
		menuListados.add(menuItemStock);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("       Listado de Ventas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoVentas lv= new ListadoVentas();
				nuevoPanel(lv);
			}
		});
		mntmNewMenuItem.setFont(new Font("Arial", Font.BOLD, 30));
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setBackground(Color.BLUE);
		menuListados.add(mntmNewMenuItem);
		getContentPane().setLayout(new CardLayout(0, 0));

		// Labels
		JLabel lblSotecars1 = new JLabel("                  SOTECARS");
		lblSotecars1.setForeground(Color.WHITE);
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 87));
		getContentPane().add(lblSotecars1, "name_694056379123400");
	}

	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
