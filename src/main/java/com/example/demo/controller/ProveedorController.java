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

import com.example.demo.dto.Proveedor;
import com.example.demo.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	ProveedorServiceImpl ProveedorServiceImpl;
	
	@GetMapping("/Proveedor")
	public List<Proveedor> listarCProveedors(){
		return ProveedorServiceImpl.listarProveedor();
	}
	
	
	@PostMapping("/Proveedor")
	public Proveedor salvarProveedor(@RequestBody Proveedor Proveedor) {
		
		return ProveedorServiceImpl.guardarProveedor(Proveedor);
	}
	
	
	@GetMapping("/Proveedor/{id}")
	public Proveedor ProveedorXID(@PathVariable(name="id") int id) {
		
		Proveedor Proveedor_xid= new Proveedor();
		
		Proveedor_xid=ProveedorServiceImpl.ProveedorXID(id);
		
		System.out.println("Proveedor XID: "+Proveedor_xid);
		
		return Proveedor_xid;
	}
	
	@PutMapping("/Proveedor/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")int id,@RequestBody Proveedor Proveedor) {
		
		Proveedor Proveedor_seleccionado= new Proveedor();
		Proveedor Proveedor_actualizado= new Proveedor();
		
		Proveedor_seleccionado= ProveedorServiceImpl.ProveedorXID(id);
		
		Proveedor_seleccionado.setNombre(Proveedor.getNombre());
		
		Proveedor_actualizado = ProveedorServiceImpl.actualizarProveedor(Proveedor_seleccionado);
		
		System.out.println("El Proveedor actualizado es: "+ Proveedor_actualizado);
		
		return Proveedor_actualizado;
	}
	
	@DeleteMapping("/Proveedor/{id}")
	public void eleiminarProveedor(@PathVariable(name="id")int id) {
		ProveedorServiceImpl.eliminarProveedor(id);
	}
	
	
}

