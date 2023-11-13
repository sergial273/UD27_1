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

import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {
	
	@Autowired
	PiezaServiceImpl PiezaServiceImpl;
	
	@GetMapping("/Piezas")
	public List<Pieza> listarCPiezas(){
		return PiezaServiceImpl.listarPieza();
	}
	
	
	@PostMapping("/Piezas")
	public Pieza salvarPieza(@RequestBody Pieza Pieza) {
		
		return PiezaServiceImpl.guardarPieza(Pieza);
	}
	
	
	@GetMapping("/Piezas/{id}")
	public Pieza PiezaXID(@PathVariable(name="id") int id) {
		
		Pieza Pieza_xid= new Pieza();
		
		Pieza_xid=PiezaServiceImpl.PiezaXID(id);
		
		System.out.println("Pieza XID: "+Pieza_xid);
		
		return Pieza_xid;
	}
	
	@PutMapping("/Piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")int id,@RequestBody Pieza Pieza) {
		
		Pieza Pieza_seleccionado= new Pieza();
		Pieza Pieza_actualizado= new Pieza();
		
		Pieza_seleccionado= PiezaServiceImpl.PiezaXID(id);
		
		Pieza_seleccionado.setNombre(Pieza.getNombre());
		
		Pieza_actualizado = PiezaServiceImpl.actualizarPieza(Pieza_seleccionado);
		
		System.out.println("El Pieza actualizado es: "+ Pieza_actualizado);
		
		return Pieza_actualizado;
	}
	
	@DeleteMapping("/Piezas/{id}")
	public void eleiminarPieza(@PathVariable(name="id")int id) {
		PiezaServiceImpl.eliminarPieza(id);
	}
	
	
}
