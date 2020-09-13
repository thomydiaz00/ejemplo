package com.actividad.negocio.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.actividad.negocio.services.Service;

import actividades.ejercicioDos.models.Articulo;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;

public class AllArticulos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllArticulos frame = new AllArticulos();
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
	public AllArticulos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		agregarFila();
		table_2.setBounds(59, 74, 541, 298);
		contentPane.add(table_2);
		
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
				AllArticulos a = new AllArticulos();
				a.setVisible(true);
			}
		});
		btnNewButton.setBounds(270, 11, 89, 23);
		contentPane.add(btnNewButton);
	}
		
		
	public void agregarFila() {
				Service cargarArticulos = new Service();
				
				try {
					DefaultTableModel model = (DefaultTableModel) table_2.getModel();
					Articulo art = new Articulo();
					Object rowData[]= new Object[4];
					for(int i = 0; i< cargarArticulos.listaArticulos.size();i++) {
						art=(Articulo) cargarArticulos.listaArticulos.get(i);
						rowData[0]= art.getId_articulo();
						rowData[1]= art.getNombre();
						rowData[2]= art.getDescipcion();
						rowData[3]= art.getPrecio();
						model.addRow(rowData);
					}
					

				}catch(Exception ex) {
					
				}
				
			}
    }
		


