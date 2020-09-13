package com.actividad.negocio.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.actividad.negocio.services.Service;

import actividades.ejercicioDos.models.Articulo;
import actividades.ejercicioDos.models.Cliente;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField Cuit;
	private JTextField Email;
	private JTextField Telefono;
	Service sv = new Service();
	private JTextField IdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 547);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento Clientes");
		lblNewLabel.setBounds(54, 11, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Cliente");
		lblNewLabel_1.setBounds(25, 53, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre ");
		lblNewLabel_2.setBounds(25, 158, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextField Id = new JTextField();
		Id.setBounds(127, 50, 246, 20);
		contentPane.add(Id);
		Id.setColumns(10);
		
		JTextField Nombre = new JTextField();
		Nombre.setBounds(127, 155, 338, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Listado de Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllClientes mostrarTodos= new AllClientes();
				mostrarTodos.setVisible(true);
			}
		});
		btnNewButton.setBounds(364, 323, 130, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				
				try {
					Cliente art = new Cliente();
					art.setNombre(Nombre.getText());
					art.setCuit(Integer.valueOf(Cuit.getText()));
					art.setTelefono(Integer.valueOf(Telefono.getText()));
					sv.dao.save(art);
					JOptionPane.showMessageDialog(null, "Agregado con Éxito");

					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error, inserte datos válidos");

					
				}
				
				
					
				
				
				
			}
		});
		btnNewButton_1.setBounds(10, 323, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modificar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service Mod = new Service();
				
				try {
					Cliente art = new Cliente();
					art = (Cliente) Mod.dao.getById(Long.valueOf(Id.getText()), Cliente.class);
					art.setNombre(Nombre.getText());
					art.setCuit(Integer.valueOf(Cuit.getText()));
					art.setEmail(Email.getText());
					art.setTelefono(Integer.valueOf(Email.getText()));

					
					sv.dao.save(art);
					JOptionPane.showMessageDialog(null, "Articulo modificado con Éxito");

					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error, inserte datos válidos");

					
				}
				
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(127, 323, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Eliminar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sv.dao.delete(Long.valueOf(Id.getText()), Cliente.class);
					JOptionPane.showMessageDialog(null, "Eliminado con Éxito");


					
				}catch(Exception noEncontrado) {
					JOptionPane.showMessageDialog(null, "No hubo coincidencias para este ID");

					
				}
			}
		});
		btnNewButton_1_2.setBounds(254, 323, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cuit");
		lblNewLabel_3.setBounds(25, 197, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(25, 237, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		
		
		JButton btnNewButton_2 = new JButton("Buscar por ID");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Service BusquedaId = new Service();
				Cliente art = new Cliente();
				try {
					art= (Cliente) BusquedaId.dao.getById(Long.valueOf(Id.getText()), Cliente.class);
					IdTxt.setText(String.valueOf(art.getIdCliente()));
					Email.setText(art.getEmail());
					Nombre.setText(art.getNombre());
					Cuit.setText(String.valueOf(art.getCuit()));
					
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
		
		
		
		Cuit = new JTextField();
		Cuit.setBounds(127, 194, 335, 20);
		contentPane.add(Cuit);
		Cuit.setColumns(10);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(127, 234, 335, 20);
		contentPane.add(Email);
		
		JLabel lblNewLabel_4_1 = new JLabel("Telefono");
		lblNewLabel_4_1.setBounds(25, 279, 46, 14);
		contentPane.add(lblNewLabel_4_1);
		
		Telefono = new JTextField();
		Telefono.setBounds(127, 276, 335, 20);
		contentPane.add(Telefono);
		Telefono.setColumns(10);
		
		IdTxt = new JTextField();
		IdTxt.setBounds(127, 118, 338, 20);
		contentPane.add(IdTxt);
		IdTxt.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Ver Facturas por ID");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_3.setBounds(364, 16, 130, 23);
		contentPane.add(btnNewButton_3);
	}
}