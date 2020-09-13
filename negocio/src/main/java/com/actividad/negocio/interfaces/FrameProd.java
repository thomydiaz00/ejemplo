package com.actividad.negocio.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class FrameProd {

	private JFrame frame;
	private JButton btnNewButton_1;
	public JLabel lblMens;
	private JButton btnNewButton_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameProd window = new FrameProd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameProd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 534, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Mostrar mensaje ext");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//al presionar nos muestra este mensaje
				JOptionPane.showMessageDialog(null, "boton de prueba");
			}
		});
		btnNewButton.setBounds(10, 11, 201, 28);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Mostrar texto en casilla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMens.setText("Olaa, acabas de modificar el texto");
				
			}
		});
		btnNewButton_1.setBounds(10, 58, 201, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblMens = new JLabel("mens");
		lblMens.setBackground(Color.WHITE);
		lblMens.setBounds(280, 62, 205, 19);
		frame.getContentPane().add(lblMens);
		
		btnNewButton_2 = new JButton("New frame");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame fr = new frame();
				fr.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 113, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}

	
}
