package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pieza;


public interface IPiezaService {

	//Metodos del CRUD
		public List<Pieza> listarPieza(); //Listar All 
		
		public Pieza guardarPieza(Pieza Pieza);	//Guarda un Pieza CREATE
		
		public Pieza PiezaXID(int id); //Leer datos de un Pieza READ
		
		public Pieza actualizarPieza(Pieza Pieza); //Actualiza datos del Pieza UPDATE
		
		public void eliminarPieza(int id);// Elimina el Pieza DELETE
	
}
