package com.moto_service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto_service.entidades.Moto;
import com.moto_service.servicios.MotoService;



@RestController
@RequestMapping("/moto")
public class MotoControlador {
	@Autowired
	private MotoService motoService;
	
	@GetMapping
	public ResponseEntity <List<Moto>> listarMotos(){
		List<Moto>moto = motoService.getAll();
		if(moto.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(moto);	
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity <Moto>obtenerMoto(@PathVariable("id") int id){
		
		Moto carro =motoService.getMotoById(id);
		if(carro==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(carro);
		
	}
	
	
	@PostMapping
	public ResponseEntity <Moto> guardarMoto(@RequestBody Moto moto ){
		Moto nuevaMoto =motoService.save(moto);
		return  ResponseEntity.ok(nuevaMoto);
	}
	
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity <List<Moto>> listarMotosPorUsuarioId(@PathVariable("id") int id){
		List <Moto> moto=motoService.byUsuarioId(id);
		if(moto.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(moto);
	}
	
	
}
