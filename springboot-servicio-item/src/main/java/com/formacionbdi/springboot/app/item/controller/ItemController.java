package com.formacionbdi.springboot.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("ServiceRestTemplate") //Calificador que se utiliza para identificar la interfaz que se quiere inyectar, conflicto que se creo alk tener dos clases que implementan la misma interfaz ItemServiceFeing y ItemServiceImpl
	private ItemService itemServioce;
	
	@GetMapping("/item")
	public List<Item> listar(){
		return itemServioce.findAll();
	}
	
	@GetMapping("/item/detalle/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemServioce.findById(id, cantidad);
	}

}
