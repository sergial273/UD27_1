package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDAO;
import com.example.demo.dto.Pieza;

@Service
public class PiezaServiceImpl implements IPiezaService {
	
	@Autowired
	IPiezaDAO iPiezaDAO;

	@Override
	public List<Pieza> listarPieza() {
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza curso) {
		return iPiezaDAO.save(curso);
	}

	@Override
	public Pieza PiezaXID(int id) {
		return iPiezaDAO.findById(id).get();
	}

	@Override
	public Pieza actualizarPieza(Pieza curso) {
		return iPiezaDAO.save(curso);
	}

	@Override
	public void eliminarPieza(int id) {
		iPiezaDAO.deleteById(id);
	}

}
