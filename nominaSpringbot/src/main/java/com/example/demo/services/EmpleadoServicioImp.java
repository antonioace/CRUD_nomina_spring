package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmpleadoDAO;
import com.example.demo.interfaces.IServicio;
import com.example.demo.model.Empleado;
@Service
public class EmpleadoServicioImp implements IServicio<Empleado,String> {
	
@Autowired
EmpleadoDAO empleadoDAO;

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(String id) {
		return empleadoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
	return empleadoDAO.findAll();
	}
	@Transactional()
	@Override
	public void save(Empleado t) {
		// TODO Auto-generated method stub
		empleadoDAO.save(t);
	}
	
	
	@Transactional()
	@Override
	public void deleteById(String id) {
		empleadoDAO.deleteById(id);
		
	}

}
