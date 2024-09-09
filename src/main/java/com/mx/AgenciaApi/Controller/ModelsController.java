package com.mx.AgenciaApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.AgenciaApi.Domain.Models;
import com.mx.AgenciaApi.Service.ModelServ;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path="Modelos")
@CrossOrigin
public class ModelsController {

	@Autowired
	ModelServ modelsServ;
	
	@GetMapping("Listar")
	public List<Models> modelsList() {
		return modelsServ.list();
	}
	
	@PostMapping("Guardar")
	public ResponseEntity<?> saveModel(@RequestBody Models model) {
		//TODO: process POST request
		
		if(modelsServ.save(model)==null) {
			return new ResponseEntity<String>("El modelo o marca ya existe",HttpStatus.OK);
		}
		
		return new ResponseEntity<Models>(model,HttpStatus.CREATED);
	}
	
	@PostMapping("Guardar2")
	public ResponseEntity<?> saveModel2(@RequestBody Models model) {
		//TODO: process POST request
		String resp=modelsServ.save2(model);
		if(!resp.equals("ok")) {
			return new ResponseEntity<String>(resp,HttpStatus.OK);
		}
		
		return new ResponseEntity<Models>(model,HttpStatus.CREATED);
	}
	@PostMapping("Editar")
	public ResponseEntity<?> editModel(@RequestBody Models model) {
		
		String message=modelsServ.edit(model);
		
		if (!message.equals("ok")) {
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		
		return new ResponseEntity<Models>(model, HttpStatus.CREATED);
		
	}
	
	@PostMapping("Borrar")
	public String Delete(@RequestBody Models model) {
		//TODO: process POST request
		
		if(modelsServ.delete(model)) {
			return "Se a eliminado correctamente";
		}
		
		return "No se encontro el registro a eliminar";
	}
	
}
