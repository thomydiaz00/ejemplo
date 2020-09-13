package com.actividad.negocio.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.actividad.negocio.services.Service;

import actividades.ejercicioDos.models.Cliente;

public class AllClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllClientes frame = new AllClientes();
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
	public AllClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		agregarFila();
		table_1.setBounds(59, 74, 541, 298);
		contentPane.add(table_1);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(105, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(191, 49, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(324, 49, 84, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(486, 49, 46, 14);
		contentPane.add(lblPrecio);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllClientes a = new AllClientes();
				a.setVisible(true);
			}
		});
		btnNewButton.setBounds(270, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
		
		
	public void agregarFila() {
				Service cargarClientes = new Service();
				
				try {
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					Cliente art = new Cliente();
					Object rowData[]= new Object[4];
					for(int i = 0; i< cargarClientes.listaClientes.size();i++) {
						art=(Cliente) cargarClientes.listaClientes.get(i);
						rowData[0]= art.getIdCliente();
						rowData[1]= art.getNombre();
						rowData[2]= art.getCuit();
						rowData[3]= art.getTelefono();
						model.addRow(rowData);
					}
					

				}catch(Exception ex) {
					
				}
				
			}

}
