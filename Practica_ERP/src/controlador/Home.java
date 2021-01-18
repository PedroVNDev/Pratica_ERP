package controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paneles.GenerarEscandallo;
import paneles.GestionCliente;
import paneles.GestionFabricas;
import paneles.GestionInformes;
import paneles.GestionPersonal;
import paneles.GestionContacto;
import paneles.GestionEscandallos;
import paneles.ListaFabricas;
import paneles.ListadoInventario;
import paneles.ModificarClientes;
import paneles.ModificarContacto;
import paneles.ModificarSueldo;
import paneles.PedirPresupuesto;
import paneles.GestionInventario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import java.awt.Toolkit;

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
	public Home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 748);

		// Labels

		// MenuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(SystemColor.desktop);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		JMenu menuGestion = new JMenu("          Gesti\u00F3n        ");
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

		JMenuItem menuItemModificarCliente = new JMenuItem("      Modificar Cliente");
		menuItemModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarClientes mc = new ModificarClientes();
				nuevoPanel(mc);
			}
		});
		menuItemModificarCliente.setForeground(Color.WHITE);
		menuItemModificarCliente.setBackground(Color.BLUE);
		menuItemModificarCliente.setFont(new Font("Arial", Font.BOLD, 26));
		menuGestion.add(menuItemModificarCliente);
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

		JMenuItem menuItemModificarContacto = new JMenuItem("    Modificar Contacto");
		menuItemModificarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ModificarContacto mc = new ModificarContacto();
				nuevoPanel(mc);

			}
		});
		menuItemModificarContacto.setFont(new Font("Arial", Font.BOLD, 26));
		menuItemModificarContacto.setForeground(Color.WHITE);
		menuItemModificarContacto.setBackground(Color.BLUE);
		menuGestion.add(menuItemModificarContacto);
		menuItemGestionTrabajador.setForeground(Color.WHITE);
		menuItemGestionTrabajador.setBackground(Color.BLUE);
		menuItemGestionTrabajador.setFont(new Font("Arial", Font.BOLD, 26));
		menuGestion.add(menuItemGestionTrabajador);

		JMenu menuInventario = new JMenu("      Inventario        ");
		menuInventario.setFont(new Font("Arial", Font.BOLD, 35));
		menuInventario.setForeground(Color.BLUE);
		menuInventario.setBackground(SystemColor.text);
		menuBar.add(menuInventario);

		JMenuItem menuItemStock = new JMenuItem("       Lista de Vehiculos      ");
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

		JMenuItem menuItemAniadirVehiculo = new JMenuItem("         A\u00F1adir Veh\u00EDculo");
		menuItemAniadirVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GestionInventario g5 = new GestionInventario();
				nuevoPanel(g5);
			}
		});
		menuItemAniadirVehiculo.setForeground(Color.WHITE);
		menuItemAniadirVehiculo.setFont(new Font("Arial", Font.BOLD, 26));
		menuItemAniadirVehiculo.setBackground(Color.BLUE);
		menuInventario.add(menuItemAniadirVehiculo);
		
		JMenuItem mntmConsultarEscandallo = new JMenuItem("       Consultar Gastos");
		mntmConsultarEscandallo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionEscandallos es= new GestionEscandallos();
				nuevoPanel(es);
			}
		});
		mntmConsultarEscandallo.setForeground(Color.WHITE);
		mntmConsultarEscandallo.setFont(new Font("Arial", Font.BOLD, 26));
		mntmConsultarEscandallo.setBackground(Color.BLUE);
		menuInventario.add(mntmConsultarEscandallo);
		
		JMenuItem mntmGenerarInformeDe = new JMenuItem("        Informe de gastos");
		mntmGenerarInformeDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarEscandallo ge= new GenerarEscandallo();
				nuevoPanel(ge);
			}
		});
		mntmGenerarInformeDe.setForeground(Color.WHITE);
		mntmGenerarInformeDe.setFont(new Font("Arial", Font.BOLD, 26));
		mntmGenerarInformeDe.setBackground(Color.BLUE);
		menuInventario.add(mntmGenerarInformeDe);

		JMenu menuProduccion = new JMenu("   Producci\u00F3n      ");
		menuProduccion.setFont(new Font("Arial", Font.BOLD, 35));
		menuProduccion.setForeground(Color.BLUE);
		menuProduccion.setBackground(SystemColor.text);
		menuBar.add(menuProduccion);

		JMenuItem menuItemGestionarFabricas = new JMenuItem("     Gestionar Fabricas    ");
		menuItemGestionarFabricas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestionFabricas gfa = new GestionFabricas();
				nuevoPanel(gfa);
			}
		});
		menuItemGestionarFabricas.setForeground(Color.WHITE);
		menuItemGestionarFabricas.setBackground(Color.BLUE);
		menuItemGestionarFabricas.setFont(new Font("Arial", Font.BOLD, 26));
		menuProduccion.add(menuItemGestionarFabricas);

		JMenuItem menuItemListadoFabricas = new JMenuItem("    Listado de Fabricas");
		menuItemListadoFabricas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaFabricas gf = new ListaFabricas();
				nuevoPanel(gf);
			}
		});
		menuItemListadoFabricas.setForeground(Color.WHITE);
		menuItemListadoFabricas.setBackground(Color.BLUE);
		menuItemListadoFabricas.setFont(new Font("Arial", Font.BOLD, 26));
		menuProduccion.add(menuItemListadoFabricas);

		JMenuItem menuItemPedirPresupuesto = new JMenuItem("     Pedir Presupuesto");
		menuItemPedirPresupuesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PedirPresupuesto pp = new PedirPresupuesto();
				nuevoPanel(pp);
			}
		});
		menuItemPedirPresupuesto.setForeground(Color.WHITE);
		menuItemPedirPresupuesto.setFont(new Font("Arial", Font.BOLD, 26));
		menuItemPedirPresupuesto.setBackground(Color.BLUE);
		menuProduccion.add(menuItemPedirPresupuesto);

		JMenu menuInformes = new JMenu("        Informes       ");
		menuInformes.setFont(new Font("Arial", Font.BOLD, 35));
		menuInformes.setForeground(Color.BLUE);
		menuInformes.setBackground(SystemColor.text);
		menuBar.add(menuInformes);

		JMenuItem menuItemGestionInformes = new JMenuItem("       Gestion Informes     ");
		menuItemGestionInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GestionInformes gi = new GestionInformes();
				nuevoPanel(gi);

			}
		});
		menuInformes.add(menuItemGestionInformes);
		menuItemGestionInformes.setForeground(Color.WHITE);
		menuItemGestionInformes.setFont(new Font("Arial", Font.BOLD, 26));
		menuItemGestionInformes.setBackground(Color.BLUE);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Labels
		JLabel lblSotecars1 = new JLabel("                  SOTECARS");
		lblSotecars1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 87));
		lblSotecars1.setForeground(Color.WHITE);
		contentPane.add(lblSotecars1, BorderLayout.CENTER);

		JLabel lblSotecars2 = new JLabel("                                         THE POWER OF DREAMS");
		lblSotecars2.setForeground(UIManager.getColor("MenuItem.selectionBackground"));
		lblSotecars2.setVerticalAlignment(SwingConstants.TOP);
		lblSotecars2.setFont(new Font("Yu Gothic", Font.PLAIN, 40));
		contentPane.add(lblSotecars2, BorderLayout.SOUTH);

		JMenuItem menuItemModificarSalario = new JMenuItem("       Modificar Salario");
		menuItemModificarSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarSueldo ms = new ModificarSueldo();
				nuevoPanel(ms);
			}
		});
		menuItemModificarSalario.setFont(new Font("Arial", Font.BOLD, 26));
		menuItemModificarSalario.setForeground(Color.WHITE);
		menuItemModificarSalario.setBackground(Color.BLUE);
		menuGestion.add(menuItemModificarSalario);

	}

	// Metodos
	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual);
		contentPane.repaint();
		contentPane.revalidate();
	}

}
