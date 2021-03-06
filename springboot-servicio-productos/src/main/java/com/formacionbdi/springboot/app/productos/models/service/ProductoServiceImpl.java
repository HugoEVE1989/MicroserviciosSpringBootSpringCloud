package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.productos.models.dao.ProductoDAO;
import com.formacionbdi.springboot.app.productos.models.entity.Producto;

@Service //Se registra como componente de spring
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Override
	@Transactional(readOnly = true) //Para marcar como una transaccion de intercambio de datos sincronizada con la bd
	public List<Producto> findAll() {
		return (List<Producto>) productoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDAO.findById(id).orElse(null);  //si no existe el producto con .orElse especificamos que regrese null
	}

}
