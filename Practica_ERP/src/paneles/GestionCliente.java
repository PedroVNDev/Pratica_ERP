package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;

public class GestionCliente extends JPanel {
	private JTextField textFieldGestionCliente1;
	private JTextField textFieldGestionCliente2;
	private JTextField textFieldGestionCliente3;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public GestionCliente() {
		setBackground(SystemColor.window);
		setLayout(null);
		
		JLabel labelGestionCliente1 = new JLabel("A\u00F1adir Cliente");
		labelGestionCliente1.setForeground(SystemColor.textHighlight);
		labelGestionCliente1.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelGestionCliente1.setBounds(27, 11, 182, 40);
		add(labelGestionCliente1);
		
		JLabel labelGestionCliente2 = new JLabel("ID Cliente:");
		labelGestionCliente2.setForeground(SystemColor.textHighlight);
		labelGestionCliente2.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelGestionCliente2.setBounds(29, 65, 84, 14);
		add(labelGestionCliente2);
		
		JLabel labelGestionCliente3 = new JLabel("DNI Cliente: ");
		labelGestionCliente3.setForeground(SystemColor.textHighlight);
		labelGestionCliente3.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelGestionCliente3.setBounds(29, 90, 84, 14);
		add(labelGestionCliente3);
		
		JButton botonGestionCliente1 = new JButton("A\u00F1adir Cliente");
		botonGestionCliente1.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonGestionCliente1.setForeground(SystemColor.text);
		botonGestionCliente1.setBackground(SystemColor.desktop);
		botonGestionCliente1.setBounds(39, 127, 150, 23);
		add(botonGestionCliente1);
		
		textFieldGestionCliente1 = new JTextField();
		textFieldGestionCliente1.setBackground(SystemColor.inactiveCaption);
		textFieldGestionCliente1.setBounds(123, 62, 86, 20);
		add(textFieldGestionCliente1);
		textFieldGestionCliente1.setColumns(10);
		
		textFieldGestionCliente2 = new JTextField();
		textFieldGestionCliente2.setBackground(SystemColor.inactiveCaption);
		textFieldGestionCliente2.setColumns(10);
		textFieldGestionCliente2.setBounds(123, 87, 86, 20);
		add(textFieldGestionCliente2);
		
		JLabel labelGestionCliente4 = new JLabel("Eliminar Cliente");
		labelGestionCliente4.setForeground(SystemColor.textHighlight);
		labelGestionCliente4.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelGestionCliente4.setBounds(436, 11, 191, 40);
		add(labelGestionCliente4);
		
		JLabel labelGestionCliente5 = new JLabel("ID Cliente:");
		labelGestionCliente5.setForeground(SystemColor.textHighlight);
		labelGestionCliente5.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelGestionCliente5.setBounds(458, 76, 84, 14);
		add(labelGestionCliente5);
		
		textFieldGestionCliente3 = new JTextField();
		textFieldGestionCliente3.setForeground(SystemColor.desktop);
		textFieldGestionCliente3.setBackground(SystemColor.inactiveCaption);
		textFieldGestionCliente3.setColumns(10);
		textFieldGestionCliente3.setBounds(541, 73, 86, 20);
		add(textFieldGestionCliente3);
		
		JButton botonGestionCliente2 = new JButton("Eliminar Cliente");
		botonGestionCliente2.setForeground(Color.WHITE);
		botonGestionCliente2.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonGestionCliente2.setBackground(Color.BLACK);
		botonGestionCliente2.setBounds(462, 127, 150, 23);
		add(botonGestionCliente2);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaptionBorder);
		table.setBounds(29, 200, 592, 173);
		add(table);
		
		JLabel labelGestionCliente6 = new JLabel("Lista Clientes");
		labelGestionCliente6.setForeground(SystemColor.textHighlight);
		labelGestionCliente6.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelGestionCliente6.setBounds(244, 149, 167, 40);
		add(labelGestionCliente6);
		
		JLabel labelGestionCliente7 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/Sotecars.png")).getImage();
		Image modifiedImage = img1.getScaledInstance(100, 60, java.awt.Image.SCALE_SMOOTH);
		labelGestionCliente7.setIcon(new ImageIcon(modifiedImage));
		labelGestionCliente7.setBounds(267, 11, 109, 108);
		add(labelGestionCliente7);
		
		
	}
}
