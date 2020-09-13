package com.actividad.negocio.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class GestionApp {

	private JFrame frmActividad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionApp window = new GestionApp();
					window.frmActividad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmActividad = new JFrame();
		frmActividad.setTitle("Actividad 2");
		frmActividad.setBounds(100, 100, 450, 300);
		frmActividad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmActividad.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gestion de Articulos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Articulos art = new Articulos();
				art.setVisible(true);
			}
		});
		btnNewButton.setBounds(28, 101, 134, 23);
		frmActividad.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gestion de Clientes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes cli = new Clientes();
				cli.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(206, 101, 145, 23);
		frmActividad.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Software de Gestión");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(28, 35, 260, 14);
		frmActividad.getContentPane().add(lblNewLabel);
		
		JTextArea txtrEsteSoftwarePermite = new JTextArea();
		txtrEsteSoftwarePermite.setLineWrap(true);
		txtrEsteSoftwarePermite.setText("Este software permite la gestion de clientes y articulos. Quedan pendientes a implementar los servicios para la facturación");
		txtrEsteSoftwarePermite.setBounds(38, 144, 371, 106);
		frmActividad.getContentPane().add(txtrEsteSoftwarePermite);
	}
}
