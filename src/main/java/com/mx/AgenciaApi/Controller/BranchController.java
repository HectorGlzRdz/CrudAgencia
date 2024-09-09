package com.mx.AgenciaApi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.AgenciaApi.Domain.Branches;
import com.mx.AgenciaApi.Service.BranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path="Marca")
@CrossOrigin
public class BranchController {
	
	@Autowired
	BranchService brnchServ;
	//http://localhost:9000/Marca/Listar	
	@GetMapping("Listar")
	public List<Branches> Lst() {
		return brnchServ.branchesList();
	}
	
	@PostMapping("Guardar")
	public ResponseEntity<?> saver(@RequestBody Branches branch) {
		//TODO: process POST request
		String var=brnchServ.save(branch);
		System.out.println(var);
		if(var.equals("ok"))
			return new ResponseEntity<Branches>(branch , HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(var,HttpStatus.OK);
	}
	
	
	@GetMapping("Buscar")
	public Branches srch(@RequestBody Branches branch) {
		return brnchServ.search(branch.getId());
	}
	
	@PostMapping("Editar")
	public ResponseEntity<?> edit(@RequestBody Branches branch) {
		//TODO: process POST request
		
		boolean result=brnchServ.delete(branch.getId());
		if(result)
			return new ResponseEntity<Branches>(branch,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("No se ha guardado",HttpStatus.OK);
	}
	
	@PostMapping("Borrar")
	public String postMethodName(@RequestBody Branches branch) {
		//TODO: process POST request
		
		boolean result=brnchServ.delete(branch.getId());
		
		if(result)
			return "Se ha eliminado";
		else
			return "Fallo la eliminacion";
	}
	
	
	
	

}
