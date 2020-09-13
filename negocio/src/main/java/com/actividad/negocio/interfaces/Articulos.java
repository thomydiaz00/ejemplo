package com.actividad.negocio.interfaces;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.actividad.negocio.services.Service;

import actividades.ejercicioDos.models.Articulo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Articulos extends JFrame {

	private JPanel contentPane;
	private JTextField Id;
	private JTextField Nombre;
	Service sv = new Service();
	private JTextField Descripcion;
	private JTextField Precio;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Articulos frame = new Articulos();
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
	public Articulos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 363);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento de Artículos");
		lblNewLabel.setBounds(54, 11, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Artículo");
		lblNewLabel_1.setBounds(25, 53, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Artículo");
		lblNewLabel_2.setBounds(25, 95, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		Id = new JTextField();
		Id.setBounds(127, 50, 246, 20);
		contentPane.add(Id);
		Id.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setBounds(127, 92, 246, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar todos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service Busqueda = new Service();
				System.out.println(Busqueda.listaArticulos);
			}
		});
		btnNewButton.setBounds(363, 230, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				
				try {
					Articulo art = new Articulo();
					art.setNombre(Nombre.getText());
					art.setPrecio(Float.valueOf(Precio.getText()));
					art.setDescipcion(Descripcion.getText());
					sv.dao.save(art);
					JOptionPane.showMessageDialog(null, "Agregado con Éxito");

					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error, inserte datos válidos");

					
				}
				
				
					
				
				
				
			}
		});
		btnNewButton_1.setBounds(10, 230, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modificar");
		btnNewButton_1_1.setBounds(127, 230, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Eliminar");
		btnNewButton_1_2.setBounds(246, 230, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Salir");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1_3.setBounds(263, 290, 89, 23);
		contentPane.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(24, 132, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		Descripcion = new JTextField();
		Descripcion.setBounds(127, 129, 246, 20);
		contentPane.add(Descripcion);
		Descripcion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setBounds(25, 170, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		Precio = new JTextField();
		Precio.setBounds(127, 167, 246, 20);
		contentPane.add(Precio);
		Precio.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(402, 49, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
