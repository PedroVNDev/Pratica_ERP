package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class PedirPresupuesto extends JPanel {
	private JTextArea txtMensaje;
	JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public PedirPresupuesto() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblIndiqueLaFabrica = new JLabel("Indique la fabrica:");
		lblIndiqueLaFabrica.setForeground(SystemColor.textHighlight);
		lblIndiqueLaFabrica.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueLaFabrica.setBounds(91, 176, 214, 40);
		add(lblIndiqueLaFabrica);
		
		comboBox = new JComboBox();
		comboBox.setBounds(330, 191, 136, 21);
		add(comboBox);
		
		JLabel lblIndiqueElPedido = new JLabel("Resuma el pedido para solicitar presupuesto:");
		lblIndiqueElPedido.setForeground(SystemColor.textHighlight);
		lblIndiqueElPedido.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueElPedido.setBounds(94, 339, 548, 40);
		add(lblIndiqueElPedido);
		
		txtMensaje = new JTextArea();
		txtMensaje.setBackground(Color.LIGHT_GRAY);
		txtMensaje.setBounds(611, 339, 496, 244);
		add(txtMensaje);
		
		JButton btnEnviarCorreo = new JButton("Enviar correo");
		btnEnviarCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enviarCorreo();
				txtMensaje.setText("");
			}
		});
		btnEnviarCorreo.setForeground(Color.WHITE);
		btnEnviarCorreo.setFont(new Font("Arial", Font.BOLD, 18));
		btnEnviarCorreo.setBackground(Color.BLUE);
		btnEnviarCorreo.setBounds(836, 621, 177, 35);
		add(btnEnviarCorreo);
		
		JLabel lblNewLabel = new JLabel("*Nota aclaratoria*");
		lblNewLabel.setBounds(663, 157, 148, 13);
		add(lblNewLabel);
		
		JLabel lblEstaFuncionalidadAutomatiza = new JLabel("Esta funcionalidad automatiza el envio de un correo para solicitar un presupuesto");
		lblEstaFuncionalidadAutomatiza.setBounds(663, 180, 428, 13);
		add(lblEstaFuncionalidadAutomatiza);
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
				rs = sql.executeQuery(
						"SELECT Nombre FROM fabricas");

				while (rs.next()) {
					comboBox.addItem(rs.getObject("Nombre"));
				}
				
				conexion.close();
			} catch (SQLException e) {
				System.out.println("ERROR AL EJECUTAR LA SENTENCIA SQL");
			}
		} finally {
			System.out.println("Ningun error");
		}
	}
	 
	public void enviarCorreo() {
		 Properties propiedad = new Properties();
	        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
	        propiedad.setProperty("mail.smtp.starttls.enable", "true");
	        propiedad.setProperty("mail.smtp.port", "587");
	        propiedad.setProperty("mail.smtp.auth", "true");

	        Session sesion = Session.getDefaultInstance(propiedad);
	        String correoEnvia = "sotecars@gmail.com";
	        String contrasena = "Sotecars69";
	        
	        //AQUI VA EL CORREO QUE LO RECIBE
	        String receptor ="pedrovicentenavas@gmail.com";
	        String asunto = "PETICION DE PRESUPUESTO";
	        String mensaje= txtMensaje.getText();
	        
	        MimeMessage mail = new MimeMessage(sesion);
	        
	        try {
	            mail.setFrom(new InternetAddress (correoEnvia));
	            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
	            mail.setSubject(asunto);
	            mail.setText(mensaje);
	            
	            Transport transportar = sesion.getTransport("smtp");
	            transportar.connect(correoEnvia,contrasena);
	            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
	            transportar.close();
	            
	            JOptionPane.showMessageDialog(null, "Listo, revise su correo");
	            
	        } catch (AddressException ex) {
	        } catch (MessagingException ex) {
	        }
	        
	}
}
