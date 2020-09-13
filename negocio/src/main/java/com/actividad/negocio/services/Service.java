package com.actividad.negocio.services;
import java.util.List;

import actividades.ejercicioDos.dao.*;

public class Service {
	
	EjDao dao = new EjDao();
	public List<Object> lista = dao.getAll("Cliente");
}
