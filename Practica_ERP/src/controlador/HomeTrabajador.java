package controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paneles.GestionCliente;
import paneles.ListadoClientes;

import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.SystemColor;
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
		getContentPane().setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1298, 745);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("                         Venta               ");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 30));
		mnNewMenu.setForeground(Color.BLUE);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("             Gestionar Ticket            ");
		mntmNewMenuItem_3.setForeground(Color.BLUE);
		mntmNewMenuItem_3.setFont(new Font("Arial", Font.BOLD, 30));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("                Informe              ");
		mnNewMenu_1.setForeground(Color.BLUE);
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 30));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("                  Listados              ");
		mnNewMenu_2.setForeground(Color.BLUE);
		mnNewMenu_2.setFont(new Font("Arial", Font.BOLD, 30));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("       Listado de clientes      ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoClientes g1 = new ListadoClientes();
				nuevoPanel(g1);
			}
		});
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		mntmNewMenuItem.setForeground(Color.BLUE);
		mntmNewMenuItem.setFont(new Font("Arial", Font.BOLD, 30));
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("  Listado de proveedores");
		mntmNewMenuItem_1.setForeground(Color.BLUE);
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.BOLD, 30));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("                Stock");
		mntmNewMenuItem_2.setForeground(Color.BLUE);
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.BOLD, 30));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("                 SOTECARS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 87));
		getContentPane().add(lblNewLabel, "name_694056379123400");
	}
	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
