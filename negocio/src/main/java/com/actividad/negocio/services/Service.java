package com.actividad.negocio.services;
import java.util.List;

import actividades.ejercicioDos.dao.*;

public class Service {
	
	public EjDao dao = new EjDao();
	public List<Object> listaArticulos = dao.getAll("Articulo");
	public List<Object> listaClientes = dao.getAll("Cliente");
	public List<Object> listaFacturaVenta = dao.getAll("FacturaVenta");
	

}
