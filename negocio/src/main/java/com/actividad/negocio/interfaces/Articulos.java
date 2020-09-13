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
import javax.swing.JSeparator;

public class Articulos extends JFrame {

	private JPanel contentPane;
	private JTextField Id;
	private JTextField Nombre;
	Service sv = new Service();
	private JTextField Descripcion;
	private JTextField Precio;
	private JTextField IdTxt;


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
		setBounds(100, 100, 532, 520);
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
		lblNewLabel_2.setBounds(25, 158, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		Id = new JTextField();
		Id.setBounds(127, 50, 246, 20);
		contentPane.add(Id);
		Id.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setBounds(127, 155, 338, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar todos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service Busqueda = new Service();
				System.out.println(Busqueda.listaArticulos);
			}
		});
		btnNewButton.setBounds(372, 285, 111, 23);
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
		btnNewButton_1.setBounds(10, 285, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modificar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service Mod = new Service();
				
				try {
					Articulo art = new Articulo();
					art = (Articulo) Mod.dao.getById(Long.valueOf(Id.getText()), Articulo.class);
					art.setNombre(Nombre.getText());
					art.setPrecio(Float.valueOf(Precio.getText()));
					art.setDescipcion(Descripcion.getText());
					sv.dao.save(art);
					JOptionPane.showMessageDialog(null, "Articulo modificado con Éxito");

					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error, inserte datos válidos");

					
				}
				
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(127, 285, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Eliminar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sv.dao.delete(Long.valueOf(Id.getText()), Articulo.class);
					JOptionPane.showMessageDialog(null, "Eliminado con Éxito");


					
				}catch(Exception noEncontrado) {
					JOptionPane.showMessageDialog(null, "No hubo coincidencias para este ID");

					
				}
			}
		});
		btnNewButton_1_2.setBounds(253, 285, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(25, 197, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		Descripcion = new JTextField();
		Descripcion.setBounds(127, 197, 338, 20);
		contentPane.add(Descripcion);
		Descripcion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setBounds(25, 237, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		Precio = new JTextField();
		Precio.setBounds(127, 234, 338, 20);
		contentPane.add(Precio);
		Precio.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Buscar por ID");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Service BusquedaId = new Service();
				Articulo art = new Articulo();
				try {
					art= (Articulo) BusquedaId.dao.getById(Long.valueOf(Id.getText()), Articulo.class);
					IdTxt.setText(String.valueOf(art.getId_articulo()));
					Descripcion.setText(art.getDescipcion());
					Nombre.setText(art.getNombre());
					Precio.setText(String.valueOf(art.getPrecio()));
					
				}catch(Exception noEncontrado) {
					JOptionPane.showMessageDialog(null, "No hubo coincidencias para este ID");

				}
				
				
			}
		});
		btnNewButton_2.setBounds(383, 49, 111, 23);
		contentPane.add(btnNewButton_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(35, 78, 430, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setBounds(25, 121, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		IdTxt = new JTextField();
		IdTxt.setBounds(127, 118, 338, 20);
		contentPane.add(IdTxt);
		IdTxt.setColumns(10);
	}
}
