package com.actividad.negocio;

import java.util.List;

import actividades.ejercicioDos.dao.Dao;
import actividades.ejercicioDos.dao.EjDao;
import actividades.ejercicioDos.models.Articulo;
import actividades.ejercicioDos.models.Cliente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EjDao dao = new EjDao();
       List articulos = dao.getAll("Articulo");
       System.out.println(articulos);
       
       Cliente cli = new Cliente("Thomas Diaz", 2232323,"thomydiaz@mail.com",22122212,"Vicente lopez");
       dao.save(cli);
       List clientes = dao.getAll("Cliente");
       
       System.out.println(clientes);
       
      

    }
}
