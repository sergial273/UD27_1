package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {
	
	@Autowired
	SuministraServiceImpl SuministraServiceImpl;
	
	@GetMapping("/Suministra")
	public List<Suministra> listarCSuministras(){
		return SuministraServiceImpl.listarSuministra();
	}
	
	
	@PostMapping("/Suministra")
	public Suministra salvarSuministra(@RequestBody Suministra Suministra) {
		
		return SuministraServiceImpl.guardarSuministra(Suministra);
	}
	
	
	@GetMapping("/Suministra/{id}")
	public Suministra SuministraXID(@PathVariable(name="id") int id) {
		
		Suministra Suministra_xid= new Suministra();
		
		Suministra_xid=SuministraServiceImpl.SuministraXID(id);
		
		System.out.println("Suministra XID: "+Suministra_xid);
		
		return Suministra_xid;
	}
	
	@PutMapping("/Suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name="id")int id,@RequestBody Suministra Suministra) {
		
		Suministra Suministra_seleccionado= new Suministra();
		Suministra Suministra_actualizado= new Suministra();
		
		Suministra_seleccionado= SuministraServiceImpl.SuministraXID(id);
		
		Suministra_seleccionado.setPieza(Suministra.getPieza());
		Suministra_seleccionado.setProveedor(Suministra.getProveedor());
		Suministra_seleccionado.setPrecio(Suministra.getPrecio());
		
		Suministra_actualizado = SuministraServiceImpl.actualizarSuministra(Suministra_seleccionado);
		
		System.out.println("El Suministra actualizado es: "+ Suministra_actualizado);
		
		return Suministra_actualizado;
	}
	
	@DeleteMapping("/Suministra/{id}")
	public void eleiminarSuministra(@PathVariable(name="id")int id) {
		SuministraServiceImpl.eliminarSuministra(id);
	}
	
	
}

