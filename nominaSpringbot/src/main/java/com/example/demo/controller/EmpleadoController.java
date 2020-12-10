package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.EmpleadoDAO;
import com.example.demo.model.Empleado;
import com.example.demo.services.EmpleadoServicioImp;
@Controller
public class EmpleadoController {
	
	@Autowired
	EmpleadoServicioImp eDAO;
	
	
	
	 @GetMapping({"/","/index"})
	    public String list(Model model){
model.addAttribute("list", eDAO.findAll());
	       return "index";
	    }
	 
	 @RequestMapping(value="/form", method=RequestMethod.POST)
	 public String guardar(@Validated Empleado empleado, BindingResult result,Model model) {

		 eDAO.save(empleado);
		
		 return "redirect:index";
		 
		 
	 }
	 
	 @RequestMapping(value="/form/")
	 public String crear(Model model) {
		 Empleado empleado=new Empleado();
		 model.addAttribute("empleado", empleado);
		
		 return "form";
		 
	 }
	 
	 
	 @RequestMapping(value="/form/{id}")
	 public String editar(@PathVariable(value="id") String codigo,Model model) {
		Empleado empleado=eDAO.findById(codigo);
		model.addAttribute("empleado",empleado);
		
		 return "form";
		 
	 }
	 
	 @RequestMapping(value="/eliminar/{id}")
	 public String eliminar(@PathVariable(value="id") String codigo,Model model) {
		Empleado empleado=eDAO.findById(codigo);
	eDAO.deleteById(codigo);
		
		 return "redirect:/index";
		 
	 }

	 
}
