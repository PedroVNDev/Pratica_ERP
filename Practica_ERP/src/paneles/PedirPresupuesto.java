package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class PedirPresupuesto extends JPanel {

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(330, 191, 136, 21);
		add(comboBox);
		
		JLabel lblIndiqueElPedido = new JLabel("Resuma el pedido para solicitar presupuesto:");
		lblIndiqueElPedido.setForeground(SystemColor.textHighlight);
		lblIndiqueElPedido.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIndiqueElPedido.setBounds(94, 339, 548, 40);
		add(lblIndiqueElPedido);
		
		JTextArea txtMensaje = new JTextArea();
		txtMensaje.setBackground(Color.LIGHT_GRAY);
		txtMensaje.setBounds(611, 339, 496, 244);
		add(txtMensaje);
		
		JButton btnEnviarCorreo = new JButton("Enviar correo");
		btnEnviarCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//enviarCorreo();
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

	}
	/*
	 * 
	 
	public void enviarCorreo() {
		 Properties propiedad = new Properties();
	        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
	        propiedad.setProperty("mail.smtp.starttls.enable", "true");
	        propiedad.setProperty("mail.smtp.port", "587");
	        propiedad.setProperty(�);
	        

	        
	        Session sesion = Session.getDefaultInstance(propiedad);
	        String correoEnvia = "xxxxxx@gmail.com";
	        String contrasena = "";
	        
	        //AQUI VA EL CORREO QUE LO RECIBE
	        //String receptor = 
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
	            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (MessagingException ex) {
	            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	}*/
}